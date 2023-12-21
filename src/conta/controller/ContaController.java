package conta.controller;

import java.util.ArrayList;

import conta.model.Conta;
import conta.repository.ContaRepository;

public class ContaController implements ContaRepository {

	private ArrayList<Conta> listasContas = new ArrayList<Conta>();
	int numero = 0;

	@Override
	public void procurarPorNumero(int numero) {
		var conta = buscarNaCollection(numero);

		if (conta != null)
			conta.visualizar();
		else
			System.out.println("\nA Conta número: " + numero + "não foi encontrada!");
	}

	@Override
	public void listarTodas() {
		for (var conta : listasContas) {
			conta.visualizar();
		}

	}

	@Override
	public void cadastrar(Conta conta) {
		listasContas.add(conta);
		System.out.println("\nA Conta número: " + conta.getNumero() + "\nfoi criada com sucesso!");

	}

	@Override
	public void atualizar(Conta conta) {
		var buscaConta = buscarNaCollection(conta.getNumero());
		if (buscaConta != null) {
			listasContas.set(listasContas.indexOf(buscaConta), conta);
			System.out.println("\nA Conta número: " + conta.getNumero() + "\nfoi atualizada com sucesso!");
		} else
			System.out.println("\nA Conta número: " + conta.getNumero() + "\nnão foi encontrada!");
	}

	@Override
	public void deletar(int numero) {
		var conta = buscarNaCollection(numero);
		if (conta != null) {
			if (listasContas.remove(conta) == true)
				System.out.println("\nA Conta número: " + numero + "\nfoi deletada com sucesso!");
		} else
			System.out.println("\nA Conta número: " + numero + "\nnão foi encontrada!");
	}

	@Override
	public void sacar(int numero, float valor) {
		var conta = buscarNaCollection(numero);

		if (conta != null) {
			if (conta.sacar(valor) == true)
				System.out.println("\nA Saque na Conta número: " + numero + "\nfoi efetuado com sucesso!");
		} else
			System.out.println("\nA Conta número: " + numero + "\nnão foi encontrada!");
	}

	@Override
	public void depositar(int numero, float valor) {
		var conta = buscarNaCollection(numero);

		if (conta != null) {
			conta.depositar(valor);
				System.out.println("\nA Déposito na Conta número: " + numero + "\nfoi efetuado com sucesso!");
		} else
			System.out.println("\nA Conta número: " + numero + "\nnão foi encontrada ou a Conta destino não é uma Conta Corrente!");
	}

	

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		var contaOrigem = buscarNaCollection(numeroOrigem);
		var contaDestino = buscarNaCollection(numeroDestino);
		
		if (contaOrigem != null && contaDestino !=null) {
			contaDestino.depositar(valor);
				System.out.println("\nA Tranferência foi efetuada com sucesso!");
		} else
			System.out.println("\nA Conta Origem e/ou Destino não foram encontradas!");
	}
	

	public int gerarNumero() {
		return ++numero;
	}

	public Conta buscarNaCollection(int numero) {
		for (var conta : listasContas) {
			if (conta.getNumero() == numero) {
				return conta;
			}
		}
		return null;
	}
}
