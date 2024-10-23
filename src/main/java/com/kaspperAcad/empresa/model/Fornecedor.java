package com.kaspperAcad.empresa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "fornecedor")

public class Fornecedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	String razaoSocial;
	String nomeFantasia;
	String dtabert;
	double capitalInic;

	public Fornecedor(DadosCadastroFornecedor dados) {

		this.razaoSocial = dados.razaoSocial();
		this.nomeFantasia = dados.nomeFantasia();
		this.dtabert = dados.dtabert();
		this.capitalInic = dados.capitalInic();
	}

	public Fornecedor() {}	

	@Override
	public String toString() {
		return "Fornecedor [id=" + id + ", razaoSocial=" + razaoSocial + ", nomeFantasia=" + nomeFantasia + ", dtabert="
				+ dtabert + ", capitalInic=" + capitalInic + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getDtabert() {
		return dtabert;
	}

	public void setDtabert(String dtabert) {
		this.dtabert = dtabert;
	}

	public double getCapitalInic() {
		return capitalInic;
	}

	public void setCapitalInic(double capitalInic) {
		this.capitalInic = capitalInic;
	}

	public void atualizaDados(DadosCadastroFornecedor dados) {
		this.razaoSocial = dados.razaoSocial();
		this.nomeFantasia = dados.nomeFantasia();
		this.dtabert = dados.dtabert();
		this.capitalInic = dados.capitalInic();		
	}
}