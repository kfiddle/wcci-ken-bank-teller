public class Account {
    private String accountNumber;
    private String accountType;
    private double accountBalance;


    public Account(String id, String type, double balance) {
        accountNumber = id;
        accountType = type;
        accountBalance = balance;
    }

    public Account() {

    }

    public String getAccountNumber() {
        return accountNumber;
    }
    public String getAccountType(){
        return accountType;
    }
    public double getBalance() {
        return accountBalance;
    }


    public void deposit (double funds) {
        accountBalance += funds;
    }
    public boolean validWithdrawAmount(float amount){
        if (amount > accountBalance){
            return false;
        } return true;
    }

    public void withdraw(double funds) {
        accountBalance -= funds;
    }

    public String toString() {
        return String.format("%s                   %s                    :$%.2f", accountNumber, accountType, accountBalance);
    }
}
