import java.util.Collection;
import java.util.Scanner;

public class BankingApp {
    Scanner in = new Scanner(System.in);

    static float validMoneyAmount(Scanner input) {
        float money = 0;
        while (!input.hasNextFloat()) {
            System.out.println("Please enter a valid amount.");
            input = new Scanner(System.in);
        }
        money = input.nextFloat();
        return money;
    }

    static int validInteger(Scanner input, int range) {
        int response = 0;
        while (!input.hasNextInt()) {
            System.out.println("come on now...just a number.");
            input = new Scanner(System.in);
        }
        response = input.nextInt();

        while (response > range) {
            System.out.println("nice try. That's not an option I can deal with.");
            response = input.nextInt();
        }
        return response;
    }

    public void displayMainMenu() {
        System.out.println();
        System.out.println("Please choose from the following. You may press...\n 1 to deposit\n 2 to withdraw\n 3 to close an account\n 4 to exit.\n");
    }


    public void go() {
        int reply = 0;
        String accountChoice = "";
        Bank bank = new Bank();
        Account checking = new Account("12345", "checking", 5000);
        Account savings = new Account("98765", "savings", 54.83);
        bank.openNewAccount(checking);
        bank.openNewAccount(savings);


        // main loop

        while (true) {
            bank.displayAllAccounts();
            displayMainMenu();
            reply = validInteger(in, 4);
            if (reply == 4) {
                System.out.println("thanks.see ya.");
                System.exit(0);
            } else {

                if (reply == 1) {
                    System.out.println("Into which account would you like to make a deposit? Enter the account number.");
                } else if (reply == 2) {
                    System.out.println("From which account would you like to withdraw? Enter the account number.");
                } else if (reply == 3) {
                    System.out.println("Which account would you like to close? Enter the account number.");
                }
            }
            bank.displayAllAccounts();
            Scanner input = new Scanner(System.in);
            accountChoice = input.nextLine();

            while (!bank.isValidAccountID(accountChoice)) {
                System.out.println("That's not a valid account number. Enter again please.");
                accountChoice = in.nextLine();
            }

            if (reply == 1) {
                System.out.println("How much would you like to deposit?");
                float amount = validMoneyAmount(in);
                bank.accounts.get(accountChoice).deposit(amount);
            } else if (reply == 2) {
                System.out.println("Who much would you like to withdraw?");
                float amount = validMoneyAmount(in);
                while (!bank.accounts.get(accountChoice).validWithdrawAmount(amount)) {
                    System.out.println("Sorry. That's more than you have available. Try again.");
                }
                bank.accounts.get(accountChoice).withdraw(amount);
            } else if (reply == 3) {
                System.out.println("Are you sure about this? Type 'yes' to confirm.");
                Scanner closing = new Scanner(System.in);
                String confirmed = closing.nextLine();
                if (confirmed.equalsIgnoreCase("yes")) {
                    bank.closeAccount(accountChoice);

                }
            }
        }


    }


    public static void main(String[] args) {
        BankingApp banking = new BankingApp();
        banking.go();

    }


}