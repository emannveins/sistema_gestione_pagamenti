package pagamenti;

// singola operazione effettuata
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PaymentTransaction {

    private final int id;
    private final String paymentMethod;
    private final BigDecimal amount;
    private final LocalDateTime dateTime;

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public PaymentTransaction(int id, String paymentMethod,BigDecimal amount, LocalDateTime dateTime) {

        this.id = id;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.dateTime = dateTime;
    }
    public int getId() {
        return id;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {

        return "#" + id
                + " | " + paymentMethod
                + " | " + amount.setScale(2, RoundingMode.HALF_UP).toPlainString() + " €"
                + " | " + dateTime.format(FORMATTER);
    }

}
