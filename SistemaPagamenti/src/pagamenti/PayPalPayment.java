package pagamenti;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PayPalPayment implements PaymentStrategy {
    @Override 
    public String getName(){
        return "PayPal";
    }
    @Override
    public boolean pay(BigDecimal amount) {
        System.out.println(
            "Pagamento tramite PayPal di "+ amount.setScale(2, RoundingMode.HALF_UP).toPlainString()+ " € completato!"
        );
        return true;
    }
   
}