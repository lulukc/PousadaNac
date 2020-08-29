package aplication.model;

import java.util.ArrayList;
import java.util.List;

public class Pousada {

	private List<Reserva> reservas;

	public Pousada() {
		reservas = new ArrayList<Reserva>();
	}

	public void adicionarReserva(Reserva reserva) {
		reservas.add(reserva);
	}

	public void removeReserva(Reserva reserva) {
		reservas.remove(reserva);
	}

	public List<Reserva> getReserva() {
		return reservas;
	}
}
