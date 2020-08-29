package aplication.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import aplication.model.enums.Categoria;

@Entity
public class Quarto {

	@Id
	private Integer numero;
	private Categoria categoria;
	private Integer maxPessoa;
	private Double valorDiaria;

	public Quarto(Integer numero, Categoria categoria, Integer maxPessoa, Double valorDiaria) {
		this.numero = numero;
		this.categoria = categoria;
		this.maxPessoa = maxPessoa;
		this.valorDiaria = valorDiaria;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Integer getMaxPessoa() {
		return maxPessoa;
	}

	public void setMaxPessoa(Integer maxPessoa) {
		this.maxPessoa = maxPessoa;
	}

	public Double getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(Double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Quarto");
		sb.append("\n");
		sb.append("Numero: ");
		sb.append(numero);
		sb.append(", categoria: ");
		sb.append(categoria);
		sb.append("\n");
		sb.append("maximo de pessoa: ");
		sb.append(maxPessoa);
		sb.append(", valor Diaria: R$");
		sb.append(String.format("%.2f", valorDiaria));

		return sb.toString();
	}
}
