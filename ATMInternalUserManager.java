import java.util.Scanner;

public class ATMInternalUserManager {
    private ATMInternalDatabase database;
    private ATMInternalPINManager pinManager;
    private Scanner scanner;

    public ATMInternalUserManager(Scanner scanner) {
        this.scanner = scanner;
        this.database = ATMInternalDatabase.getInstance();
        this.pinManager = new ATMInternalPINManager(scanner);
    }

    public User register() {
        System.out.println("\n========== NEW ACCOUNT REGISTRATION ==========");

        System.out.print("Full Name        : ");
        String fullName = scanner.nextLine().trim();
        if (fullName.isEmpty()) {
            System.out.println("[ERROR] Name cannot be empty.");
            return null;
        }

        System.out.print("Username         : ");
        String username = scanner.nextLine().trim().toLowerCase();
        if (username.isEmpty()) {
            System.out.println("[ERROR] Username cannot be empty.");
            return null;
        }
        if (database.userExists(username)) {
            System.out.println("[ERROR] Username already exists. Please choose another.");
            return null;
        }

        System.out.print("4-Digit PIN      : ");
        String pin = scanner.nextLine().trim();
        if (!pinManager.isValidPIN(pin)) {
            System.out.println("[ERROR] PIN must be exactly 4 digits.");
            return null;
        }

        System.out.print("Initial Deposit  : BDT ");
        double deposit;
        try {
            deposit = Double.parseDouble(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] Invalid amount entered.");
            return null;
        }

        if (deposit < 500) {
            System.out.println("[ERROR] Minimum initial deposit is BDT 500.");
            return null;
        }

        User newUser = new User(fullName, username, pin, deposit);
        database.saveUser(newUser);
        System.out.println("[SUCCESS] Account created successfully!");
        System.out.println("          Account Number : " + newUser.getAccountNumber());
        System.out.println("          Please login to continue.");
        return newUser;
    }
}
