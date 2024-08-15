// TASK 3
import java.util.Scanner;
class BankAccount{
    private double balance;

    public BankAccount(double initialBalance){
        if (initialBalance < 0) {
            System.out.println("Initial Balance can't be negative. Setting Initial balance to Rs 0.");
            this.balance = 0;
        }
        else{
            this.balance = initialBalance;
        }
    }

    public double getBalance(){
        return balance;
    }

    public boolean withdraw(double amount){
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
        }
        if (amount > balance) {
            System.out.println("Insufficient fund for withdrawal.");
            return false;
        }
        else{
            balance -= amount;
            System.out.println("Withdrawal of Rs " + amount + " Succesfull.");
            return true;
        }
    }

    public boolean deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return false;
        } else {
            balance += amount;
            System.out.println("Deposit of RS " + amount + " successful.");
            return true;
        }
    }
}
public class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to the ATM Machine");

        boolean exit = false;
        while (!exit) {
            displayMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    performWithdrawal();
                    break;
                case 2:
                    performDeposit();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Thank you for using the ATM. Goodbye");
                    break;
                default:
                    System.out.println("Invalid choice. Please select between 1-4.");
            }
        }

        scanner.close();
    }

    private void displayMenu() {
        System.out.println("\nPlease choose an option:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    private int getUserChoice() {
        System.out.print("Enter choice: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number between 1-4.");
            scanner.next();
            System.out.print("Enter choice: ");
        }
        return scanner.nextInt();
    }

    private void performWithdrawal() {
        System.out.print("Enter amount to withdraw: ");
        double amount = getValidAmount();
        account.withdraw(amount);
    }

    private void performDeposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = getValidAmount();
        account.deposit(amount);
    }

    private void checkBalance() {
        System.out.println("Your current balance is: Rs " + account.getBalance());
    }

    private double getValidAmount() {
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid amount. Please enter a valid number.");
            scanner.next();
            System.out.print("Enter amount: ");
        }
        double amount = scanner.nextDouble();
        if (amount <= 0) {
            System.out.println("Amount must be greater than zero.");
            return getValidAmount();
        }
        return amount;
    }

    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(10000.0);
        ATM atmMachine = new ATM(userAccount);
        atmMachine.start();
    }
}
