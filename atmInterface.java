import java.util.Scanner;

class ATM {
    private static double balance = 2000;
    private static String transactionHistory = "";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int userId = 12345;
        int userPin = 2024;

        System.out.print("Enter User ID: ");
        int enteredId = sc.nextInt();
        System.out.print("Enter PIN: ");
        int enteredPin = sc.nextInt();

        if (enteredId == userId && enteredPin == userPin) {
            System.out.println("Login Successful!");
            atmOperations(sc);
        } else {
            System.out.println("Invalid Credentials. Try Again.");
        }
        sc.close();
    }

    private static void atmOperations(Scanner sc) {
        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Transaction History:\n" + transactionHistory);
                    break;
                case 2:
                    withdraw(sc);
                    break;
                case 3:
                    deposit(sc);
                    break;
                case 4:
                    transfer(sc);
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void withdraw(Scanner sc) {
        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();
        if (amount <= balance) {
            balance -= amount;
            transactionHistory += "Withdrawn: " + amount + "\n";
            System.out.println("Withdrawal Successful. Remaining Balance: " + balance);
        } else {
            System.out.println("Insufficient Balance.");
        }
    }

    private static void deposit(Scanner sc) {
        System.out.print("Enter amount to deposit: ");
        double amount = sc.nextDouble();
        balance += amount;
        transactionHistory += "Deposited: " + amount + "\n";
        System.out.println("Deposit Successful. Current Balance: " + balance);
    }

    private static void transfer(Scanner sc) {
        System.out.print("Enter recipient account number: ");
        int rec = sc.nextInt();
        System.out.print("Enter amount to transfer: ");
        double amount = sc.nextDouble();
        if (amount <= balance) {
            balance -= amount;
            transactionHistory += "Transferred: " + amount + " to Account: " + rec + "\n";
            System.out.println("Transfer Successful. Remaining Balance: " + balance);
        } else {
            System.out.println("Insufficient Balance.");
        }
    }
}