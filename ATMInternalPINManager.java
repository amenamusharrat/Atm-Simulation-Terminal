import java.util.Scanner;

public class ATMInternalPINManager {
    private Scanner scanner;

    public ATMInternalPINManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public boolean verifyPIN(String inputPin, String storedPin) {
        return inputPin.equals(storedPin);
    }

    public boolean isValidPIN(String pin) {
        return pin != null && pin.matches("\\d{4}");
    }

    public boolean changePIN(User user) {
        System.out.print("Enter Current PIN      : ");
        String current = scanner.nextLine().trim();

        if (!verifyPIN(current, user.getPin())) {
            System.out.println("[ERROR] Current PIN is incorrect.");
            return false;
        }

        System.out.print("Enter New 4-Digit PIN  : ");
        String newPin = scanner.nextLine().trim();

        if (!isValidPIN(newPin)) {
            System.out.println("[ERROR] PIN must be exactly 4 digits.");
            return false;
        }

        System.out.print("Confirm New PIN        : ");
        String confirmPin = scanner.nextLine().trim();

        if (!newPin.equals(confirmPin)) {
            System.out.println("[ERROR] PINs do not match.");
            return false;
        }

        user.setPin(newPin);
        System.out.println("[SUCCESS] PIN changed successfully.");
        return true;
    }
}
