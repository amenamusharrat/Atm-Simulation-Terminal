import java.util.Scanner;

public class ATM {
    private Scanner scanner;
    private ATMInternalScreenManager screenManager;
    private ATMInternalSessionManager sessionManager;
    private ATMInternalUserManager userManager;
    private ATMInternalTransactionManager transactionManager;
    private ATMInternalAccountManager accountManager;
    private ATMInternalPINManager pinManager;

    public ATM() {
        scanner = new Scanner(System.in);
        screenManager = new ATMInternalScreenManager();
        sessionManager = new ATMInternalSessionManager(scanner);
        userManager = new ATMInternalUserManager(scanner);
        transactionManager = new ATMInternalTransactionManager(scanner);
        accountManager = new ATMInternalAccountManager();
        pinManager = new ATMInternalPINManager(scanner);
    }

    public void run() {
        boolean running = true;
        while (running) {
            screenManager.showWelcomeScreen();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    User loggedInUser = sessionManager.login();
                    if (loggedInUser != null) {
                        handleMainMenu(loggedInUser);
                    }
                    break;
                case "2":
                    userManager.register();
                    break;
                case "0":
                    System.out.println("\n[INFO] Thank you for using SECUREPAY ATM. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("[ERROR] Invalid option. Please try again.");
            }
        }
        scanner.close();
    }

    private void handleMainMenu(User user) {
        boolean sessionActive = true;
        while (sessionActive) {
            screenManager.showMainMenu(user);
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    accountManager.checkBalance(user);
                    break;
                case "2":
                    transactionManager.deposit(user);
                    break;
                case "3":
                    transactionManager.withdraw(user);
                    break;
                case "4":
                    pinManager.changePIN(user);
                    break;
                case "5":
                    accountManager.printTransactionHistory(user);
                    break;
                case "0":
                    sessionManager.logout();
                    sessionActive = false;
                    break;
                default:
                    System.out.println("[ERROR] Invalid option. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.run();
    }
}
