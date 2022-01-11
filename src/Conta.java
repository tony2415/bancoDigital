import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 100;
	private static int SEQUENCIAL = 5000;

	protected int agencia;
	protected int numero;
	protected Cliente cliente;
	protected String data;
	protected List<Transacao> transacoes;
	//protected double saldo;


	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
		this.transacoes = new ArrayList<Transacao>();

	}

	@Override
	public void sacar(double valor) {
		Transacao saque = new Transacao(getDateTime(), valor, TipoTransacao.SAQUE);
		transacoes.add(saque);
	}
	
	@Override
	public void depositar(double valor) {
		Transacao deposito = new Transacao(getDateTime(), valor, TipoTransacao.DEPOSITO);
		transacoes.add(deposito);
		this.data = getDateTime();
	}

	public void transferir(double valor, Conta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
	}
	
	public List<Transacao> getTransacoes() {
		return transacoes;
	}

	public void setTransacoes(List<Transacao> transacoes) {
		this.transacoes = transacoes;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}
	
	public String getData() {
		return data;
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", CalcularSaldo()));
		System.out.println("Data depósito: " + this.data);
		System.out.println("Transações: " + this.transacoes.toString());

	}
	
	protected String getDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		return dateFormat.format(date);
	}
	

	@Override
	public double CalcularSaldo() {
		double saldo = 0;
		for (Transacao t : transacoes) {
			if(t.getTipo()==TipoTransacao.DEPOSITO) {
				saldo = saldo + t.getValor();
			} else if (t.getTipo()==TipoTransacao.SAQUE) {
				saldo = saldo - t.getValor();
			}
		}
		return saldo;
	}
}
