package conta.model;

public class Conta {
//	Atributos do objeto
	private int numero;
	private int agencia;
	private int tipo;
	private String titular;
	private float saldo;

	public Conta(int numero, int agencia, int tipo, String titular, float saldo) {
		this.numero = numero;
		this.agencia = agencia;
		this.tipo = tipo;
		this.titular = titular;
		this.saldo = saldo;
	}

//	 get retorno a informação 
	public int getNumero() {
		return numero;
	}

//	set estamos inserindo uma informação no atributo
	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public void visualizar() {

		System.out.println("\n************************************************************");
		System.out.println("Numero: " + this.numero);
		System.out.println("****************************************************************");
		System.out.println("Agencia: " + this.agencia);
		System.out.println("****************************************************************");
		System.out.println("Tipo: " + this.tipo);
		System.out.println("****************************************************************");
		System.out.println("Titular: " + this.titular);
		System.out.println("****************************************************************");
		System.out.println("Saldo: " + this.saldo);

	}

}

