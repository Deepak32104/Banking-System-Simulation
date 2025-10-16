import java.util.*;

class Account {
    private String name;
    private int accountNumber;
    private double balance;

    public Account(String name, int accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getName() { return name; }
    public int getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid or Insufficient balance.");
        }
    }

    public void transfer(Account receiver, double amount) {
        if (amount > 0 && amount <= balance) {
            this.balance -= amount;
            receiver.balance += amount;
            System.out.println("Transferred " + amount + " to " + receiver.getName());
        } else {
            System.out.println("Transfer failed. Insufficient balance.");
        }
    }

    public void display() {
        System.out.println("Account: " + accountNumber + " | Name: " + name + " | Balance: " + balance);
    }
}

public class BankingSystem {
    static Scanner sc = new Scanner(System.in);
    static HashMap<Integer, Account> accounts = new HashMap<>();
    static int nextAccount = 1001;

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Banking System Menu ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. View All Accounts");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

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
                    transfer();
                    break;
                case 5:
                    viewAccounts();
                    break;
                case 6:
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } while (choice != 6);
    }

    static void createAccount() {
        System.out.print("Enter name: ");
        String name = sc.next();
        System.out.print("Enter initial deposit: ");
        double amount = sc.nextDouble();
        Account acc = new Account(name, nextAccount++, amount);
        accounts.put(acc.getAccountNumber(), acc);
        System.out.println("Account created successfully! Account No: " + acc.getAccountNumber());
    }

    static void deposit() {
        System.out.print("Enter account number: ");
        int accNo = sc.nextInt();
        Account acc = accounts.get(accNo);
        if (acc != null) {
            System.out.print("Enter amount: ");
            double amt = sc.nextDouble();
            acc.deposit(amt);
        } else {
            System.out.println("Account not found!");
        }
    }

    static void withdraw() {
        System.out.print("Enter account number: ");
        int accNo = sc.nextInt();
        Account acc = accounts.get(accNo);
        if (acc != null) {
            System.out.print("Enter amount: ");
            double amt = sc.nextDouble();
            acc.withdraw(amt);
        } else {
            System.out.println("Account not found!");
        }
    }

    static void transfer() {
        System.out.print("Enter sender account number: ");
        int from = sc.nextInt();
        System.out.print("Enter receiver account number: ");
        int to = sc.nextInt();
        System.out.print("Enter amount: ");
        double amt = sc.nextDouble();

        Account sender = accounts.get(from);
        Account receiver = accounts.get(to);

        if (sender != null && receiver != null) {
            sender.transfer(receiver, amt);
        } else {
            System.out.println("Invalid account number(s).");
        }
    }

    static void viewAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found!");
        } else {
            System.out.println("\n--- Account Details ---");
            for (Account acc : accounts.values()) {
                acc.display();
            }
        }
    }
}
