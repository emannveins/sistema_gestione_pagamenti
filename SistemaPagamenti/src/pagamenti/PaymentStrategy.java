package pagamenti;
import java.math.BigDecimal;

public interface PaymentStrategy {
    String getName();
    boolean pay(BigDecimal amount);
}