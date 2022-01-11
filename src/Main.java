
public class Main {

	public static void main(String[] args) {
		Cliente antonio = new Cliente();
		antonio.setNome("Antonio");
		
		Conta cc = new ContaCorrente(antonio);
		Conta poupanca = new ContaPoupanca(antonio);

		cc.depositar(100);
		cc.transferir(100, poupanca);
		
		cc.imprimirExtrato();
		poupanca.imprimirExtrato();
	}

}
