import java.util.ArrayList;

public class User {
    private String fullName;
    private String username;
    private String pin;
    private double balance;
    private String accountNumber;
    private ArrayList<String> transactions;

    public User(String fullName, String username, String pin, double initialDeposit) {
        this.fullName = fullName;
        this.username = username;
        this.pin = pin;
        this.balance = initialDeposit;
        this.accountNumber = "SA" + System.currentTimeMillis() % 100000000;
        this.transactions = new ArrayList<>();
        this.transactions.add("Initial Deposit: +" + String.format("%.2f", initialDeposit) + " BDT");
    }

    public String getFullName() { return fullName; }
    public String getUsername() { return username; }
    public String getPin() { return pin; }
    public double getBalance() { return balance; }
    public String getAccountNumber() { return accountNumber; }
    public ArrayList<String> getTransactions() { return transactions; }

    public void setPin(String newPin) { this.pin = newPin; }
    public void setBalance(double balance) { this.balance = balance; }

    public void addTransaction(String record) {
        transactions.add(record);
    }
}
