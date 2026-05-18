public class ATMInternalScreenManager {

    public void showWelcomeScreen() {
        System.out.println("\n╔══════════════════════════════════════════╗");
        System.out.println("║          SECUREPAY ATM  v2.0             ║");
        System.out.println("║       AUTOMATED TELLER MACHINE           ║");
        System.out.println("╠══════════════════════════════════════════╣");
        System.out.println("║   [1]  Login                             ║");
        System.out.println("║   [2]  Create New Account                ║");
        System.out.println("║   [0]  Exit                              ║");
        System.out.println("╚══════════════════════════════════════════╝");
        System.out.print("  Select Option: ");
    }

    public void showMainMenu(User user) {
        System.out.println("\n╔══════════════════════════════════════════╗");
        System.out.println("║               MAIN MENU                  ║");
        System.out.println("╠══════════════════════════════════════════╣");
        System.out.printf( "║  User    : %-30s║%n", user.getFullName());
        System.out.printf( "║  Acct No : %-30s║%n", user.getAccountNumber());
        System.out.println("╠══════════════════════════════════════════╣");
        System.out.println("║   [1]  Balance Inquiry                   ║");
        System.out.println("║   [2]  Deposit Cash                      ║");
        System.out.println("║   [3]  Withdraw Cash                     ║");
        System.out.println("║   [4]  Change PIN                        ║");
        System.out.println("║   [5]  Transaction History               ║");
        System.out.println("║   [0]  Logout / Eject Card               ║");
        System.out.println("╚══════════════════════════════════════════╝");
        System.out.print("  Select Option: ");
    }
}
