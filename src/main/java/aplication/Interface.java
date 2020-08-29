package aplication;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import aplication.service.QuartoService;
import aplication.service.ReservaService;

public class Interface {

	private static Scanner scan = new Scanner(System.in);
	private static ReservaService reservaService = new ReservaService();
	private static QuartoService quartoService = new QuartoService();
	private static String resposta;
	private static List<String> respostaLista;

	public static void iniciar() {
		boolean fecharPrograma = false;

		while (!fecharPrograma) {
			System.out.println("|**********************************************************|");
			System.out.println("|****************Escolha uma opção abaixo******************|");
			System.out.println("|**********************************************************|");
			System.out.println("|1 - Ver totas as reservas  | 2 - ver todos os quartos     |");
			System.out.println("|3 - nova reserva           | 4 - fechar programa          |");
			System.out.println("|**********************************************************|");
			System.out.println("|**********************************************************|");

			int opcaoEscolida = scan.nextInt();

			switch (opcaoEscolida) {
			case 1:
				listarTodasReservas();
				break;
			case 2:
				listarQuartosDisponiveis();
				break;
			case 3:
				novaReserva();
				break;
			case 4:
				scan.close();
				fecharPrograma = true;
				break;
			default:
				System.out.println("Por favor, selecione uma opção valida");
				break;
			}

		}
	}

	private static void listarTodasReservas() {
		System.out.println("|*****************lista das reservas***********************|");
		respostaLista = reservaService.listarTodasReservas();
		imprimirLoop();
	}

	private static void listarQuartosDisponiveis() {
		System.out.println("|*****************lista dos quartos************************|");
		respostaLista = quartoService.listarTodosQuartos();
		imprimirLoop();

	}

	private static void imprimirLoop() {
		for (String string : respostaLista) {
			System.out.println(string);
			System.out.println();
		}
		System.out.println();
	}

	private static void novaReserva() {
		System.out.println("|********************Nova Reserva**************************|");
		System.out.print("digite a data de entrada da reserva (dd/MM/yyyy): ");
		String dataEntrada = scan.next();
		System.out.print("digite a data de saida da reserva (dd/MM/yyyy): ");
		String dataSaida = scan.next();
		System.out.print("digite a quantidade de pessoas: ");
		int quantidadePessoas = scan.nextInt();
		System.out.print("digite o numero do quarto disponivel: ");
		int numeroQuarto = scan.nextInt();

		try {
			resposta = reservaService.criarNovaReserva(dataEntrada, dataSaida, quantidadePessoas, numeroQuarto);
			System.out.println(resposta);
			System.out.println();
		} catch (ParseException e) {
			System.out.println("Formado de data informado esta incorreto");
		}
		System.out.println();
	}
}
