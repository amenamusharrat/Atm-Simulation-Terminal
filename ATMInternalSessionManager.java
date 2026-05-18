import java.util.Scanner;

public class ATMInternalSessionManager {
    private ATMInternalDatabase database;
    private ATMInternalPINManager pinManager;
    private Scanner scanner;
    private User activeUser;

    public ATMInternalSessionManager(Scanner scanner) {
        this.scanner = scanner;
        this.database = ATMInternalDatabase.getInstance();
        this.pinManager = new ATMInternalPINManager(scanner);
        this.activeUser = null;
    }

    public User login() {
        System.out.println("\n========== LOGIN ==========");

        System.out.print("Username : ");
        String username = scanner.nextLine().trim().toLowerCase();

        System.out.print("PIN      : ");
        String pin = scanner.nextLine().trim();

        User user = database.getUser(username);

        if (user == null) {
            System.out.println("[ERROR] Account not found.");
            return null;
        }

        if (!pinManager.verifyPIN(pin, user.getPin())) {
            System.out.println("[ERROR] Incorrect PIN. Access denied.");
            return null;
        }

        activeUser = user;
        System.out.println("[SUCCESS] Welcome, " + user.getFullName() + "!");
        return activeUser;
    }

    public void logout() {
        System.out.println("\n[INFO] Session ended. Card ejected.");
        System.out.println("       Goodbye, " + activeUser.getFullName() + "!");
        activeUser = null;
    }

    public User getActiveUser() {
        return activeUser;
    }

    public boolean isLoggedIn() {
        return activeUser != null;
    }
}
