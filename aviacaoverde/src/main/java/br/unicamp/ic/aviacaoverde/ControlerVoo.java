package br.unicamp.ic.aviacaoverde;

import java.util.List;
import java.util.Stack;

public class ControlerVoo implements Controler {

	private Voo voo;
	
	public ControlerVoo() {
		voo = new Voo();
	}

	@Override
	public void adicionarParaReservas(Reserva reserva) {
		voo.adicionarParaListaEspera(reserva);
	}

	@Override
	public void adicionarParaListaEspera(Reserva reserva) {
		voo.adicionarParaListaEspera(reserva);
	}

	@Override
	public Reserva buscarReserva(Integer idPassageiro) {
		return voo.buscarReserva(idPassageiro);
	}

	@Override
	public boolean existeReserva(Integer idPassageiro) {
		return voo.existeReserva(idPassageiro);
	}

	@Override
	public String getNumero() {
		return voo.getNumero();
	}

	@Override
	public void setNumero(String numero) {
		voo.setNumero(numero);
	}

	@Override
	public Aeronave getAeronave() {
		return voo.getAeronave();
	}

	@Override
	public void setAeronave(Aeronave aeronave) {
		voo.setAeronave(aeronave);
	}

	@Override
	public Rota getRota() {
		return voo.getRota();
	}

	@Override
	public void setRota(Rota rota) {
		voo.setRota(rota);
	}

	@Override
	public List<Reserva> getReservas() {
		return voo.getReservas();
	}

	@Override
	public void setReservas(List<Reserva> reservas) {
		voo.setReservas(reservas);
	}

	@Override
	public Stack<Reserva> getListaDeEspera() {
		return voo.getListaDeEspera();
	}

	@Override
	public void setListaDeEspera(Stack<Reserva> listaDeEspera) {
		voo.setListaDeEspera(listaDeEspera);
	}

}
