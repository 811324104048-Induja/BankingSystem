import java.util.*;

class Account {

    int accNo;
    String name;
    double balance;

    Account(int accNo, String name, double balance) {
        this.accNo = accNo;
        this.name = name;
        this.balance = balance;
    }
}

public class Bankingsystem{

    // Account Number -> Account Object
    static LinkedHashMap<Integer, Account> accounts = new LinkedHashMap<>();

    static Scanner sc = new Scanner(System.in);


    public static void createAccount() {

        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        sc.nextLine();

        if (accounts.containsKey(accNo)) {
            System.out.println("Account already exists!");
            return;
        }

        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        if (balance < 0) {
            System.out.println("Invalid Balance!");
            return;
        }

        Account newAccount = new Account(accNo, name, balance);

        accounts.put(accNo, newAccount);

        System.out.println("Account created successfully!");
    }

 
    public static void deposit() {

        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        if (!accounts.containsKey(accNo)) {
            System.out.println("Account Not Found!");
            return;
        }

        Account acc = accounts.get(accNo);

        System.out.print("Enter Deposit Amount: ");
        double amount = sc.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid Amount!");
            return;
        }

        acc.balance = acc.balance + amount;

        System.out.println("Amount Deposited Successfully!");
        System.out.println("Updated Balance: " + acc.balance);
    }

  
    public static void withdraw() {

        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        if (!accounts.containsKey(accNo)) {
            System.out.println("Account Not Found!");
            return;
        }

        Account acc = accounts.get(accNo);

        System.out.print("Enter Withdrawal Amount: ");
        double amount = sc.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid Amount!");
        }
        else if (amount > acc.balance) {
            System.out.println("Insufficient Balance!");
        }
        else {
            acc.balance = acc.balance - amount;

            System.out.println("Amount Withdrawn Successfully!");
            System.out.println("Remaining Balance: " + acc.balance);
        }
    }

    
    public static void checkBalance() {

        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        if (!accounts.containsKey(accNo)) {
            System.out.println("Account Not Found!");
            return;
        }

        Account acc = accounts.get(accNo);

        System.out.println("\n----- ACCOUNT DETAILS -----");
        System.out.println("Account Number : " + acc.accNo);
        System.out.println("Account Holder : " + acc.name);
        System.out.println("Balance        : " + acc.balance);
    }

    
    public static void viewAccounts() {

        if (accounts.isEmpty()) {
            System.out.println("No accounts available!");
            return;
        }

        System.out.println("\n===== ALL ACCOUNT DETAILS =====");

        // LinkedHashMap maintains insertion order
        for (Account acc : accounts.values()) {

            System.out.println("-----------------------------");
            System.out.println("Account Number : " + acc.accNo);
            System.out.println("Account Holder : " + acc.name);
            System.out.println("Balance        : " + acc.balance);
        }
    }

 
    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== BANKING SYSTEM =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. View All Accounts");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    createAccount();
                    break;

                case 2:
                    deposit();
                    break;

                case 3:
                    withdraw();
                    break;

                case 4:
                    checkBalance();
                    break;

                case 5:
                    viewAccounts();
                    break;

                case 6:
                    System.out.println("Thank you for using Banking System!");
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}