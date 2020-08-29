package aplication.service;

import java.util.ArrayList;
import java.util.List;

import aplication.dao.QuartoDao;
import aplication.model.Quarto;

public class QuartoService {

	private QuartoDao quartoDao = new QuartoDao();

	public Quarto buscarQuarto(Integer numeroQuarto) {
		Quarto quarto = quartoDao.encontrar(numeroQuarto);
		return quarto;
	}

	public List<String> listarTodosQuartos() {
		List<String> reservasString = new ArrayList<String>();
		List<Quarto> quartos = quartoDao.getList();

		for (Quarto quarto : quartos) {
			reservasString.add(quarto.toString());
		}

		return reservasString;
	}
}
