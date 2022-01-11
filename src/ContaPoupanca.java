import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ContaPoupanca extends Conta {
	private static final double RENDIMENTO_DIA = (float) 0.1;

	public ContaPoupanca(Cliente cliente) {
		super(cliente);
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Poupan�a ===");		
		super.imprimirInfosComuns();
		System.out.println(String.format("Saldo com Rendimentos: %.2f", calculaRendimentoPoupanca()));
	}

	private double calculaRendimentoPoupanca() {
		double saldo = CalcularSaldo();
		try { 
			saldo += saldo*RENDIMENTO_DIA*calculaDiasDepósito();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return saldo;
	}
	
	private int calculaDiasDepósito() throws ParseException {
		DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
        df.setLenient(false);
        Date d1 = df.parse ("10/05/2021");
   //     System.out.println (d1);
        Date d2 = df.parse (getDateTime());
     //   System.out.println (d2);
        long dt = (d2.getTime() - d1.getTime()) + 3600000; // 1 hora para compensar horário de verão
    //    System.out.println (dt / 86400000L); // passaram-se 67111 dias
		int dias =  (int) (dt / 86400000L) ;
		return dias;
	}
}
