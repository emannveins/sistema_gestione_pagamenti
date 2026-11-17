package pagamenti;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PaymentManager {

    // Unica istanza della classe
    private static final PaymentManager INSTANCE = new PaymentManager();

    // Strategia attualmente selezionata
    private PaymentStrategy currentStrategy;

    // Storico dei pagamenti
    private final List<PaymentTransaction> transactions = new ArrayList<>();

    private int nextId = 1;

     // Costruttore privato
    private PaymentManager() {
    }

    // Accesso all'unica istanza
    public static PaymentManager getInstance() {
        return INSTANCE;
    }

    // Selezione della strategia
    public void setPaymentStrategy(PaymentStrategy strategy) {
        if (strategy == null) {
            throw new IllegalArgumentException("strategia non valida!");
        }
        currentStrategy = strategy;
        System.out.println( "Modalità selezionata: " + currentStrategy.getName());
    }


     // Elaborazione del pagamento
    public boolean processPayment(BigDecimal amount) {
        if (currentStrategy == null) {
            throw new IllegalStateException( "devi prima selezionare un metodo di pagamento!" );
        }

        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {  throw new IllegalArgumentException( "L'importo deve essere maggiore di zero!"); }
        boolean successful = currentStrategy.pay(amount);

        if (successful) {
            PaymentTransaction transaction = new PaymentTransaction(
                nextId++,
                currentStrategy.getName(),
                amount,
                LocalDateTime.now()
            );
            transactions.add(transaction);
        }
        return successful;
    }




     // visualizzazione dello storico
    public void printSummary() {

        if (transactions.isEmpty()) {
            System.out.println("Nessun pagamento effettuato.");
            return;
        }

        BigDecimal total = BigDecimal.ZERO;
        System.out.println("\n========== RIEPILOGO PAGAMENTI ==========");

        for (PaymentTransaction transaction : transactions) {
            System.out.println(transaction);
            total = total.add(transaction.getAmount());
        }

        System.out.println("-----------------------------------------");
        System.out.println("Numero operazioni: " + transactions.size());
        System.out.println("Totale incassato: " + total + " €");
        System.out.println("=========================================");
    }

    public List<PaymentTransaction> getTransactions() {
        return Collections.unmodifiableList(transactions);
    }
}
