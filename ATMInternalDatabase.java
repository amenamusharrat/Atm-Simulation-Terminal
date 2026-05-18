import java.util.HashMap;

public class ATMInternalDatabase {
    private HashMap<String, User> users;
    private static ATMInternalDatabase instance;

    private ATMInternalDatabase() {
        users = new HashMap<>();
    }

    public static ATMInternalDatabase getInstance() {
        if (instance == null) {
            instance = new ATMInternalDatabase();
        }
        return instance;
    }

    public boolean userExists(String username) {
        return users.containsKey(username.toLowerCase());
    }

    public void saveUser(User user) {
        users.put(user.getUsername().toLowerCase(), user);
    }

    public User getUser(String username) {
        return users.get(username.toLowerCase());
    }
}
