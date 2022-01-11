
public class Transacao {
	private static int SEQUENCIA = 0; 
	private int numero;
	private String data;
	private double valor;
	private TipoTransacao tipo;
	
	public Transacao(String data, double valor, TipoTransacao tipo) {
		super();
		this.numero = SEQUENCIA++;
		this.data = data;
		this.valor = valor;
		this.tipo = tipo;
	}
	
	public TipoTransacao getTipo() {
		return tipo;
	}

	public void setTipo(TipoTransacao tipo) {
		this.tipo = tipo;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Transacao [numero=" + numero + ", data=" + data + ", valor=" + valor + ", tipo=" + tipo + "]";
	}
}
