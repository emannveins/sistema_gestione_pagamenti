public abstract class Pagamento {
    private double importo;
    private double saldo;
    
    public Pagamento(double importo) {
        this.importo = importo;
    }

    public abstract void paga();

    public double getImporto() {
        return importo;
    }

    public void setImporto(double importo) {
        this.importo = importo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
}
