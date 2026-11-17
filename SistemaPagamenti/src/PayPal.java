public class PayPal extends Pagamento{
    private double pagamentoImmediato;

    public PayPal(double pagamentoImmediato, double importo) {
        super(importo);
        this.pagamentoImmediato = pagamentoImmediato;
    }

    @Override 
    public void paga(){
        double x = getSaldo() - pagamentoImmediato;
        setSaldo(x);
    }


    // ciao
}
