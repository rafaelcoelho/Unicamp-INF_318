package br.unicamp.ic.aviacaoverde;

import java.util.Scanner;

public class Principal {

	private final Scanner scanner;

	private ControlerVoo voo;
	private int opcao;

	public Principal() {
		super();
		scanner = new Scanner(System.in);
	}

	public static void main(String[] args) {
		Principal principal = new Principal();
		principal.iniciarSistema();
	}

	private void iniciarSistema() {
		criarVoo();

		while (opcao != 4) {
			mostrarMenu();
			opcao = scanner.nextInt();
			executaOperacao();
		}
	}

	private void mostrarMenu() {
		System.out.println("Aviação Verde");
		System.out.println();
		System.out.println("Escolha uma opção");
		System.out.println("1. Reserva");
		System.out.println("2. Consulta de Reservas");
		System.out.println("3. Imprimir");
		System.out.println("4. Encerrar");
	}

	private void executaOperacao() {
		switch (opcao) {
		case 1:
			reservar();
			break;
		case 2:
			consultarReserva();
			break;
		case 3:
			imprimir();
			break;
		case 4:
			encerrar();
			break;
		default:
			System.err.println("Operação Inválida!");
			break;
		}
	}

	private void reservar() {
		Integer idPassageiro = solicitarIdPassageiro();
		String numeroVoo = solicitarNumeroVoo();

		if (!validarDados(idPassageiro, numeroVoo, false)) {
			return;
		}

		Passageiro passageiro = criarPassageiro(idPassageiro);
		Reserva reserva = new Reserva();
		reserva.setPassageiro(passageiro);
		int capacidadeTotal = voo.getAeronave().getCapacidadeTotal();

		if (voo.getReservas().size() < capacidadeTotal) {
			reserva.setConfirmada(true);
			voo.adicionarParaReservas(reserva);
			System.out.println("Reserva efetuada com sucesso!");
		} else {
			voo.adicionarParaListaEspera(reserva);
			System.out.println("Este voo está lotado, a reserva foi adicionada à lista de espera.");
		}
	}
	private void consultarReserva() {
		Integer idPassageiro = solicitarIdPassageiro();
		String numeroVoo = solicitarNumeroVoo();

		if (!validarDados(idPassageiro, numeroVoo, true)) {
			return;
		}

		Reserva reserva = voo.buscarReserva(idPassageiro);
		Rota rota = voo.getRota();

		System.out.println("Dados da reserva:");
		System.out.println("Voo: " + voo.getNumero());
		System.out.println("Origem: " + rota.getOrigem().getNomeCidade());
		System.out.println("Destino: " + rota.getDestino().getNomeCidade());

		String escalas = rota.getEscalas().size() > 0 ? Integer.toString(rota.getEscalas().size()) : "Não";
		System.out.println("Escalas: " + escalas);

		Passageiro passageiro = reserva.getPassageiro();
		System.out.println("Id do Passageiro: " + passageiro.getId());
		System.out.println("Nome do Passageiro: " + passageiro.getNome());

		String statusReserva = reserva.isConfirmada() ? "Confirmada" : "Na Lista de Espera";
		System.out.println("Status da Reserva: " + statusReserva);
		System.out.println();
	}

	private void imprimir() {
		System.out.println("Passageiros do voo " + voo.getNumero() + ":");

		for (Reserva reserva : voo.getReservas()) {
			System.out.println("Passageiro: " + reserva.getPassageiro().getNome());
			System.out.println("Status da Reserva: Confirmada");
			System.out.println();
		}

		for (Reserva reserva : voo.getListaDeEspera()) {
			System.out.println("Passageiro: " + reserva.getPassageiro().getNome());
			System.out.println("Status da Reserva: Na Lista de Espera");
			System.out.println();
		}
	}

	private void encerrar() {
		System.out.println("Pedidos encerrados.");
		System.out.println("O voo partiu com " + voo.getReservas().size() + " passageiros");

		boolean lotado = voo.getReservas().size() == voo.getAeronave().getCapacidadeTotal();
		System.out.println("A aeronave estava " + (lotado ? "loatada" : "com assentos desocupados"));
	}

	private Integer solicitarIdPassageiro() {
		System.out.println("Informe o número de identificação do passageiro");
		return scanner.nextInt();
	}

	private String solicitarNumeroVoo() {
		System.out.println("Informe o número do voo");
		return scanner.next();
	}

	private boolean validarDados(Integer idPassageiro, String numeroVoo, boolean passageiroExistente) {
		if (!numeroVoo.equals("AD4032")) {
			System.err.println("Número de voo inválido");
			return false;
		}

		if (passageiroExistente) {
			if (!voo.existeReserva(idPassageiro)) {
				System.err.println("Não existe uma reserva para esse passageiro neste voo");
				return false;
			}
		} else {
			if (voo.existeReserva(idPassageiro)) {
				System.err.println("Já existe uma reserva para esse passageiro neste voo");
				return false;
			}
		}

		return true;
	}

	private void criarVoo() {
		voo = new ControlerVoo();
		voo.setNumero("AD4032");
		voo.setAeronave(criarAeronave());
		voo.setRota(criarRota());
	}

	private Aeronave criarAeronave() {
		Aeronave aeronave = new Aeronave();
		aeronave.setCapacidadeTotal(30);
		return aeronave;
	}

	private Rota criarRota() {
		Rota rota = new Rota();
		rota.setOrigem(criarAeroporto("Campinas"));
		rota.setDestino(criarAeroporto("Campo Grande"));
		return rota;
	}

	private Aeroporto criarAeroporto(String nomeCidade) {
		Aeroporto aeroporto = new Aeroporto();
		aeroporto.setNomeCidade(nomeCidade);
		return aeroporto;
	}

	private Passageiro criarPassageiro(Integer idPassageiro) {
		System.out.println("Informe o nome do passageiro");
		String nome = scanner.next();

		Passageiro passageiro = new Passageiro();
		passageiro.setId(idPassageiro);
		passageiro.setNome(nome);

		return passageiro;
	}

}
