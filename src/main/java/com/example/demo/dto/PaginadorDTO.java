package com.example.demo.dto;

import java.util.List;

public class PaginadorDTO<T> {
	
	private List<T> conteudo;
	private Long totalRegistro;
	
	public List<T> getConteudo() {
		return conteudo;
	}
	
	public void setConteudo(List<T> conteudo) {
		this.conteudo = conteudo;
	}
	
	public Long getTotalRegistro() {
		return totalRegistro;
	}
	
	public void setTotalRegistro(Long totalRegistro) {
		this.totalRegistro = totalRegistro;
	}

}
