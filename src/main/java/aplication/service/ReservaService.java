package aplication.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import aplication.dao.ReservaDao;
import aplication.model.Quarto;
import aplication.model.Reserva;

public class ReservaService {

	private ReservaDao reservaDao = new ReservaDao();
	private QuartoService quartoService = new QuartoService();
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public String criarNovaReserva(String dataEntrada, String dataSaida, Integer quantidadePessoas,
			Integer numeroQuarto) throws ParseException {

		String resposta = "";
		Date dtAgora = new Date();

		Date dtEntrada = sdf.parse(dataEntrada);
		Date dtSaida = sdf.parse(dataSaida);

		if (dtEntrada.before(dtAgora)) {
			resposta = "A data de entrada deve ser posterios a da data de hoje";
			return resposta;
		}
		Date dtEntradaMaisDois = adicionarDoisDias(dtEntrada);

		if (dtSaida.before(dtEntradaMaisDois)) {
			resposta = "A data de saida deve ser dois dias posterios a da data de entrada";
			return resposta;
		}

		Quarto quarto = quartoService.buscarQuarto(numeroQuarto);

		if (quantidadePessoas > quarto.getMaxPessoa()) {
			resposta = "Quantidade de pessoas maior que o limite do quarto";
			return resposta;
		}

		Reserva reserva = new Reserva(quarto, dtEntrada, dtSaida, quantidadePessoas);
		reservaDao.salvar(reserva);

		resposta = reserva.toString();

		return resposta;

	}

	private Date adicionarDoisDias(Date dtEntrada) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dtEntrada);
		calendar.add(Calendar.DAY_OF_MONTH, 2);
		return calendar.getTime();
	}

	public List<String> listarTodasReservas() {
		List<String> reservasString = new ArrayList<String>();
		List<Reserva> reservas = reservaDao.getList();

		for (Reserva reserva : reservas) {
			reservasString.add(reserva.toString());
		}

		return reservasString;
	}

}
