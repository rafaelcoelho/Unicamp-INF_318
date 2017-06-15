package br.unicamp.ic.aviacaoverde;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Voo implements ControlerVoo {

	private String numero;
	private Aeronave aeronave;
	private Rota rota;
	private List<Reserva> reservas;
	private Stack<Reserva> listaDeEspera;
	private Map<Integer, Integer> idsReservados;
	private Map<Integer, Integer> idsListaEspera;

	public Voo() {
		super();
		reservas = new LinkedList<>();
		listaDeEspera = new Stack<>();
		idsReservados = new HashMap<>();
		idsListaEspera = new HashMap<>();
	}

	/* (non-Javadoc)
	 * @see br.unicamp.ic.aviacaoverde.ControlerVoo#adicionarParaReservas(br.unicamp.ic.aviacaoverde.Reserva)
	 */
	@Override
	public void adicionarParaReservas(Reserva reserva) {
		idsReservados.put(reserva.getPassageiro().getId(), reservas.size());
		reservas.add(reserva);
	}

	/* (non-Javadoc)
	 * @see br.unicamp.ic.aviacaoverde.ControlerVoo#adicionarParaListaEspera(br.unicamp.ic.aviacaoverde.Reserva)
	 */
	@Override
	public void adicionarParaListaEspera(Reserva reserva) {
		idsReservados.put(reserva.getPassageiro().getId(), listaDeEspera.size());
		listaDeEspera.push(reserva);
	}

	/* (non-Javadoc)
	 * @see br.unicamp.ic.aviacaoverde.ControlerVoo#buscarReserva(java.lang.Integer)
	 */
	@Override
	public Reserva buscarReserva(Integer idPassageiro) {
		Reserva reserva = null;

		if (idsReservados.containsKey(idPassageiro)) {
			int index = idsReservados.get(idPassageiro);
			reserva = reservas.get(index);
		} else {
			int index = idsListaEspera.get(idPassageiro);
			reserva = listaDeEspera.get(index);
		}

		return reserva;
	}

	/* (non-Javadoc)
	 * @see br.unicamp.ic.aviacaoverde.ControlerVoo#existeReserva(java.lang.Integer)
	 */
	@Override
	public boolean existeReserva(Integer idPassageiro) {
		return idsReservados.containsKey(idPassageiro) || idsListaEspera.containsKey(idPassageiro);
	}

	/* (non-Javadoc)
	 * @see br.unicamp.ic.aviacaoverde.ControlerVoo#getNumero()
	 */
	@Override
	public String getNumero() {
		return numero;
	}

	/* (non-Javadoc)
	 * @see br.unicamp.ic.aviacaoverde.ControlerVoo#setNumero(java.lang.String)
	 */
	@Override
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/* (non-Javadoc)
	 * @see br.unicamp.ic.aviacaoverde.ControlerVoo#getAeronave()
	 */
	@Override
	public Aeronave getAeronave() {
		return aeronave;
	}

	/* (non-Javadoc)
	 * @see br.unicamp.ic.aviacaoverde.ControlerVoo#setAeronave(br.unicamp.ic.aviacaoverde.Aeronave)
	 */
	@Override
	public void setAeronave(Aeronave aeronave) {
		this.aeronave = aeronave;
	}

	/* (non-Javadoc)
	 * @see br.unicamp.ic.aviacaoverde.ControlerVoo#getRota()
	 */
	@Override
	public Rota getRota() {
		return rota;
	}

	/* (non-Javadoc)
	 * @see br.unicamp.ic.aviacaoverde.ControlerVoo#setRota(br.unicamp.ic.aviacaoverde.Rota)
	 */
	@Override
	public void setRota(Rota rota) {
		this.rota = rota;
	}

	/* (non-Javadoc)
	 * @see br.unicamp.ic.aviacaoverde.ControlerVoo#getReservas()
	 */
	@Override
	public List<Reserva> getReservas() {
		return reservas;
	}

	/* (non-Javadoc)
	 * @see br.unicamp.ic.aviacaoverde.ControlerVoo#setReservas(java.util.List)
	 */
	@Override
	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	/* (non-Javadoc)
	 * @see br.unicamp.ic.aviacaoverde.ControlerVoo#getListaDeEspera()
	 */
	@Override
	public Stack<Reserva> getListaDeEspera() {
		return listaDeEspera;
	}

	/* (non-Javadoc)
	 * @see br.unicamp.ic.aviacaoverde.ControlerVoo#setListaDeEspera(java.util.Stack)
	 */
	@Override
	public void setListaDeEspera(Stack<Reserva> listaDeEspera) {
		this.listaDeEspera = listaDeEspera;
	}

}
