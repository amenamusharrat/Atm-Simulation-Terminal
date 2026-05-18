import java.util.Scanner;

public class ATMInternalTransactionManager {
    private Scanner scanner;

    public ATMInternalTransactionManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public void deposit(User user) {
        System.out.println("\n========== CASH DEPOSIT ==========");
        System.out.printf("Current Balance  : BDT %.2f%n", user.getBalance());
        System.out.print("Deposit Amount   : BDT ");

        double amount;
        try {
            amount = Double.parseDouble(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] Invalid amount entered.");
            return;
        }

        if (amount < 100) {
            System.out.println("[ERROR] Minimum deposit amount is BDT 100.");
            return;
        }

        user.setBalance(user.getBalance() + amount);
        user.addTransaction("Deposit    : +" + String.format("%.2f", amount) + " BDT");
        System.out.printf("[SUCCESS] BDT %.2f deposited.%n", amount);
        System.out.printf("          New Balance : BDT %.2f%n", user.getBalance());
    }

    public void withdraw(User user) {
        System.out.println("\n========== CASH WITHDRAWAL ==========");
        System.out.printf("Current Balance  : BDT %.2f%n", user.getBalance());
        System.out.print("Withdraw Amount  : BDT ");

        double amount;
        try {
            amount = Double.parseDouble(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] Invalid amount entered.");
            return;
        }

        if (amount < 100) {
            System.out.println("[ERROR] Minimum withdrawal amount is BDT 100.");
            return;
        }

        if (amount % 100 != 0) {
            System.out.println("[ERROR] Amount must be a multiple of 100.");
            return;
        }

        if (amount > user.getBalance()) {
            System.out.println("[ERROR] Insufficient funds.");
            return;
        }

        user.setBalance(user.getBalance() - amount);
        user.addTransaction("Withdrawal : -" + String.format("%.2f", amount) + " BDT");
        System.out.printf("[SUCCESS] BDT %.2f dispensed.%n", amount);
        System.out.printf("          Remaining Balance : BDT %.2f%n", user.getBalance());
    }
}
