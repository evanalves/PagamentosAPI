package com.pagamentos.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Descricao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double valor;
	private LocalDateTime dataHora;
	private String estabelecimento;
	private Long nsu;
	private Integer codigoAutorizacao;
	private String status;

	public Descricao() {
		// TODO Auto-generated constructor stub
	}

	public Descricao(Long id, Double valor, LocalDateTime dataHora, String estabelecimento, Long nsu,
			Integer codigoAutorizacao, String status) {
		super();
		this.id = id;
		this.valor = valor;
		this.dataHora = dataHora;
		this.estabelecimento = estabelecimento;
		this.nsu = nsu;
		this.codigoAutorizacao = codigoAutorizacao;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public String getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(String estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public Long getNsu() {
		return nsu;
	}

	public void setNsu(Long nsu) {
		this.nsu = nsu;
	}

	public Integer getCodigoAutorizacao() {
		return codigoAutorizacao;
	}

	public void setCodigoAutorizacao(Integer codigoAutorizacao) {
		this.codigoAutorizacao = codigoAutorizacao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Descricao other = (Descricao) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Descricao [id=" + id + ", valor=" + valor + ", dataHora=" + dataHora + ", estabelecimento="
				+ estabelecimento + ", nsu=" + nsu + ", codigoAutorizacao=" + codigoAutorizacao + ", status=" + status
				+ "]";
	}

}
