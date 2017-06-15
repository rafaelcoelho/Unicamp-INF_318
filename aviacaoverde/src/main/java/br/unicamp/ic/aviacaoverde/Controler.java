package br.unicamp.ic.aviacaoverde;

import java.util.List;
import java.util.Stack;

public interface Controler {

	void adicionarParaReservas(Reserva reserva);

	void adicionarParaListaEspera(Reserva reserva);

	Reserva buscarReserva(Integer idPassageiro);

	boolean existeReserva(Integer idPassageiro);

	String getNumero();

	void setNumero(String numero);

	Aeronave getAeronave();

	void setAeronave(Aeronave aeronave);

	Rota getRota();

	void setRota(Rota rota);

	List<Reserva> getReservas();

	void setReservas(List<Reserva> reservas);

	Stack<Reserva> getListaDeEspera();

	void setListaDeEspera(Stack<Reserva> listaDeEspera);

}