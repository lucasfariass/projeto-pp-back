package com.example.demo.dto;

public class ConsultaDTO {
	
	private Long id;
	private Long idMedico;
	private String data;
	private String hora;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getIdMedico() {
		return idMedico;
	}
	
	public void setIdMedico(Long idMedico) {
		this.idMedico = idMedico;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	public String getHora() {
		return hora;
	}
	
	public void setHora(String hora) {
		this.hora = hora;
	}
	
}
