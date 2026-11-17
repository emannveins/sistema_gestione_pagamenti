package pagamenti;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BankTranserPayment implements PaymentStrategy {
    @Override 
    public String getName(){
        return "bonifico bancario";
    }
    @Override 
    public boolean pay(BigDecimal amount) {
        System.out.println(
            "Bonifico bancario di " + amount.setScale(2, RoundingMode.HALF_UP).toPlainString() + " € effettuato!"
        );
        return true;
    }
}
