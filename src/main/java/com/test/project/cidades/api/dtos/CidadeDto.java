package com.test.project.cidades.api.dtos;

public class CidadeDto {
	
	private Long id;
	private Long ibgeId;
	
	public CidadeDto() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIbgeId() {
		return ibgeId;
	}

	public void setIbgeId(Long ibgeId) {
		this.ibgeId = ibgeId;
	}
	
	@Override
	public String toString() {
		return "CidadeDto [id = " + id + ", ibgeId= " + ibgeId + "]";
	}

}
