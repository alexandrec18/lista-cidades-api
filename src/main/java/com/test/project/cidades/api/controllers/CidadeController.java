package com.test.project.cidades.api.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.project.cidades.api.dtos.CidadeDto;
import com.test.project.cidades.api.entities.Cidade;
import com.test.project.cidades.api.response.Response;
import com.test.project.cidades.api.services.CidadeService;

@RestController
@RequestMapping("api/cidades")
@CrossOrigin(origins="*")
public class CidadeController {
	
	@Autowired
	private CidadeService cidadeService;
	
	public CidadeController() {
		
	}

	/*
	 * Retorna a cidade pelo ibgeId
	 * 
	 * @param ibgeId
	 * @return ResponseEntity<Response<EmpresaDto>>
	 */
	@GetMapping(value = "/ibgeId/{ibgeId}")
	public ResponseEntity<Response<CidadeDto>> buscarPorIbgeId(@PathVariable("ibgeId") Long ibgeId){
		
		Response<CidadeDto> response = new Response<CidadeDto>();
		Optional<Cidade> cidade = cidadeService.buscaPorIbgeId(ibgeId);
		
		if(!cidade.isPresent()) {
			response.getErrors().add("Cidade não encontrada para o ibgeId" + ibgeId);
			return ResponseEntity.badRequest().body(response);
		}
		
		response.setData(this.converterCidadeDto(cidade.get()));
		return ResponseEntity.ok(response);		
	}
	
	private CidadeDto converterCidadeDto(Cidade cidade) {
		CidadeDto cidadeDto = new CidadeDto();
		cidadeDto.setId(cidade.getId());
		cidadeDto.setIbgeId(cidade.getIbgeId());
		
		return cidadeDto;
	}
}
