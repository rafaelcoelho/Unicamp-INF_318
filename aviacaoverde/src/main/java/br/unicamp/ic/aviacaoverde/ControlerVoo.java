package br.unicamp.ic.aviacaoverde;

import java.util.List;
import java.util.Stack;

public class ControlerVoo {

	private Voo voo;
	
	public ControlerVoo() {
		voo = new Voo();
	}

	
	public void adicionarParaReservas(Reserva reserva) {
		voo.adicionarParaListaEspera(reserva);
	}

	
	public void adicionarParaListaEspera(Reserva reserva) {
		voo.adicionarParaListaEspera(reserva);
	}

	
	public Reserva buscarReserva(Integer idPassageiro) {
		return voo.buscarReserva(idPassageiro);
	}

	
	public boolean existeReserva(Integer idPassageiro) {
		return voo.existeReserva(idPassageiro);
	}

	
	public String getNumero() {
		return voo.getNumero();
	}

	
	public void setNumero(String numero) {
		voo.setNumero(numero);
	}

	
	public Aeronave getAeronave() {
		return voo.getAeronave();
	}

	
	public void setAeronave(Aeronave aeronave) {
		voo.setAeronave(aeronave);
	}

	
	public Rota getRota() {
		return voo.getRota();
	}

	
	public void setRota(Rota rota) {
		voo.setRota(rota);
	}

	
	public List<Reserva> getReservas() {
		return voo.getReservas();
	}

	
	public void setReservas(List<Reserva> reservas) {
		voo.setReservas(reservas);
	}

	
	public Stack<Reserva> getListaDeEspera() {
		return voo.getListaDeEspera();
	}

	
	public void setListaDeEspera(Stack<Reserva> listaDeEspera) {
		voo.setListaDeEspera(listaDeEspera);
	}

}
