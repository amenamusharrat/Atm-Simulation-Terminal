public class ATMInternalAccountManager {

    public void checkBalance(User user) {
        System.out.println("\n========== BALANCE INQUIRY ==========");
        System.out.println("Account Holder   : " + user.getFullName());
        System.out.println("Account Number   : " + user.getAccountNumber());
        System.out.printf("Available Balance: BDT %.2f%n", user.getBalance());
        System.out.println("=====================================");
    }

    public void printTransactionHistory(User user) {
        System.out.println("\n========== TRANSACTION HISTORY ==========");
        System.out.println("Account : " + user.getAccountNumber());
        System.out.println("-----------------------------------------");
        if (user.getTransactions().isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            int count = 1;
            for (String tx : user.getTransactions()) {
                System.out.println(count++ + ". " + tx);
            }
        }
        System.out.println("=========================================");
    }
}
