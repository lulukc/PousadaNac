package aplication.config;

import java.util.Arrays;

import aplication.dao.QuartoDao;
import aplication.model.Quarto;
import aplication.model.enums.Categoria;

public class Seed {

	public static void criarQuarto() {
		QuartoDao quartoDao = new QuartoDao();

		Quarto q1 = new Quarto(1, Categoria.APARTAMENTO, 2, 135.0);
		Quarto q2 = new Quarto(2, Categoria.APARTAMENTO, 2, 135.0);
		Quarto q3 = new Quarto(3, Categoria.APARTAMENTO, 2, 135.0);
		Quarto q4 = new Quarto(4, Categoria.APARTAMENTO, 2, 135.0);
		Quarto q5 = new Quarto(5, Categoria.APARTAMENTO, 2, 135.0);
		Quarto q6 = new Quarto(6, Categoria.APARTAMENTO, 2, 135.0);
		Quarto q7 = new Quarto(7, Categoria.APARTAMENTO, 2, 135.0);
		Quarto q8 = new Quarto(8, Categoria.APARTAMENTO, 2, 135.0);
		Quarto q9 = new Quarto(9, Categoria.APARTAMENTO, 2, 135.0);
		Quarto q10 = new Quarto(10, Categoria.APARTAMENTO, 2, 135.0);

		Quarto q20 = new Quarto(20, Categoria.VIP, 4, 175.0);
		Quarto q21 = new Quarto(21, Categoria.VIP, 4, 175.0);
		Quarto q22 = new Quarto(22, Categoria.VIP, 4, 175.0);
		Quarto q23 = new Quarto(23, Categoria.VIP, 4, 175.0);
		Quarto q24 = new Quarto(24, Categoria.VIP, 4, 175.0);

		quartoDao.salvarTodos(Arrays.asList(q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, q20, q21, q22, q23, q24));

	}
}
