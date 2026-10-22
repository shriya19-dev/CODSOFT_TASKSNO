package CodSoftATMInterface;
import java.util.Scanner;

public class ATM {

    private BankAccount account;
    private Scanner sc;

    public ATM(BankAccount account) {
        this.account = account;
        this.sc = new Scanner(System.in);
    }

    public void start() {

        int choice;

        System.out.println("================================");
        System.out.println("          WELCOME TO ATM");
        System.out.println("================================");

        do {
            System.out.println("\n1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.println("Invalid input! Enter a number from 1 to 4.");
                sc.next();
                System.out.print("Enter your choice: ");
            }

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;

                case 2:
                    depositMoney();
                    break;

                case 3:
                    withdrawMoney();
                    break;

                case 4:
                    System.out.println("Thank you for using our ATM!");
                    break;

                default:
                    System.out.println("Invalid choice! Please select 1-4.");
            }

        } while (choice != 4);

        sc.close();
    }

    private void checkBalance() {
        System.out.printf("Current balance: Rs. %.2f%n",
                account.getBalance());
    }

    private void depositMoney() {
        System.out.print("Enter amount to deposit: ");

        if (!sc.hasNextDouble()) {
            System.out.println("Invalid input! Enter a valid amount.");
            sc.next();
            return;
        }

        double amount = sc.nextDouble();

        if (account.deposit(amount)) {
            System.out.printf("Rs. %.2f deposited successfully.%n", amount);
            checkBalance();
        } else {
            System.out.println("Deposit failed! Enter a positive valid amount.");
        }
    }

    private void withdrawMoney() {
        System.out.print("Enter amount to withdraw: ");

        if (!sc.hasNextDouble()) {
            System.out.println("Invalid input! Enter a valid amount.");
            sc.next();
            return;
        }

        double amount = sc.nextDouble();

        if (amount <= 0 || !Double.isFinite(amount)) {
            System.out.println("Withdrawal amount must be positive and valid.");
        } else if (amount > account.getBalance()) {
            System.out.println("Insufficient balance!");
        } else if (account.withdraw(amount)) {
            System.out.printf("Rs. %.2f withdrawn successfully.%n", amount);
            checkBalance();
        } else {
            System.out.println("Transaction failed!");
        }
    }

    public static void main(String[] args) {

        BankAccount account = new BankAccount(5000.00);

        ATM atm = new ATM(account);
        atm.start();
    }
}
