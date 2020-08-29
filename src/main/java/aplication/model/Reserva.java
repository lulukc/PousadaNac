package aplication.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Reserva implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Quarto quarto;

	private Date dataEntrada;
	private Date dataSaida;
	private Integer quantidadePessoas;
	private Double valorTotal;

	public Reserva(Quarto quarto, Date dataEntrada, Date dataSaida, Integer quantidadePessoas) {
		super();
		this.quarto = quarto;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.quantidadePessoas = quantidadePessoas;
		valorTotal = 0.0;
	}

	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Integer getQuantidadePessoas() {
		return quantidadePessoas;
	}

	public void setQuantidadePessoas(Integer quantidadePessoas) {
		this.quantidadePessoas = quantidadePessoas;
	}

	public Double getValorTotal() {
		Long dias = calcularDias();
		valorTotal = dias * quarto.getValorDiaria();
		return valorTotal;
	}

	private Long calcularDias() {
		Long direfenca = dataSaida.getTime() - dataEntrada.getTime();
		return direfenca / 1000 / 60 / 60 / 24;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sb.append("Reserva");
		sb.append("\n");
		sb.append("numero da reserava: ");
		sb.append(id);
		sb.append(", numero do quarto: ");
		sb.append(quarto.getNumero());
		sb.append(", categoria do quarto: ");
		sb.append(quarto.getCategoria());
		sb.append("\n");
		sb.append("data entrada: ");
		sb.append(sdf.format(dataEntrada));
		sb.append(", data saida: ");
		sb.append(sdf.format(dataSaida));
		sb.append(", quantidade pessoas: ");
		sb.append(quantidadePessoas);
		sb.append("\n");
		sb.append("numero de dias: ");
		sb.append(calcularDias());
		sb.append(", valor total da reserva: R$");
		sb.append(String.format("%.2f", getValorTotal()));

		return sb.toString();
	}

}
