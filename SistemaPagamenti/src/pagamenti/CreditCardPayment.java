package pagamenti;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CreditCardPayment implements PaymentStrategy {

    @Override
    public String getName() {
        return "carta di credito";
    }

    @Override
    public boolean pay(BigDecimal amount) {
        System.out.println(
            "Pagamento con carta di credito di " + amount.setScale(2, RoundingMode.HALF_UP).toPlainString() + " € completato!"
        );
        return true;
    }
}