import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bank {
    HashMap<String, Account> accounts = new HashMap<String, Account>();


    public void displayAllAccounts() {
        System.out.println(" Account Number:          Account Type:           Available Balance:");
        int i = 1;
        while (i <= accounts.size()) {
            for (Map.Entry<String, Account> entry : accounts.entrySet()) {
                System.out.println(i + "-  " + entry.getValue());
                i++;
            }
        }
    }


    public Collection<Account> getAllAccounts() {
        return accounts.values();
    }

    public void openNewAccount(Account account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public boolean isValidAccountID(String enteredNumber){
        if (!accounts.containsKey(enteredNumber)) {
            return false;
        } return true;
    }
    public Account getAccount(String id) {
        return accounts.get(id);
    }

    public void closeAccount(String accountNumber) {
        accounts.remove(accountNumber);
    }


}
