package pagamenti;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        PaymentManager manager = PaymentManager.getInstance();

        boolean running = true;

        while (running) {

            System.out.println("\n===== SISTEMA PAGAMENTI =====");
            System.out.println("1. Seleziona metodo di pagamento");
            System.out.println("2. Effettua pagamento");
            System.out.println("3. Visualizza riepilogo");
            System.out.println("0. Esci");
            System.out.print("Scelta: ");

            String option = scanner.nextLine().trim();

            switch (option) {

                case "1":

                    System.out.println("\nSeleziona il metodo:");
                    System.out.println("1. Carta di credito");
                    System.out.println("2. PayPal");
                    System.out.println("3. Bonifico bancario");
                    System.out.print("Scelta: ");

                    String method = scanner.nextLine().trim();

                    switch (method) {

                        case "1":
                            manager.setPaymentStrategy(new CreditCardPayment());
                            break;
                        case "2":
                            manager.setPaymentStrategy(new PayPalPayment());
                            break;
                        case "3":
                            manager.setPaymentStrategy(new BankTransferPayment());
                            break;
                        default:
                            System.out.println("Metodo non valido!");
                    }

                    break;

                case "2":
                    System.out.print("Inserisci l'importo: ");
                    String input = scanner.nextLine().trim().replace(',', '.');

                    try {
                        BigDecimal amount = new BigDecimal(input);
                        manager.processPayment(amount);

                    } catch (IllegalArgumentException | IllegalStateException e) {

                        System.out.println("Errore: " + e.getMessage());
                    }

                    break;

                case "3":
                    manager.printSummary();
                    break;

                case "0":
                    running = false;
                    System.out.println("Programma terminato.");
                    break;

                default:
                    System.out.println("Scelta non valida!");
            }
        }

        scanner.close();
    }
}