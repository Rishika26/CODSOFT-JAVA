import java.util.*;

class BankAccount{
    private double balance;

    public BankAccount(double initialBalance){
        this.balance = initialBalance;
    }

    public double checkBalance() {
        return balance;
    }

    public boolean deposit(double amt){
        if(amt > 0){
            balance += amt;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amt){
        if(amt > 0 && amt <= balance){
            balance -= amt;
            return true;
        }
        return false;
    }
}
class ATMInterface{
    private BankAccount userAccount;
    public ATMInterface(BankAccount account){
        this.userAccount = account;
    }

    public void displayMenu(){
        System.out.println("------------------Welcome to the ATM-------------------");
        System.out.println();
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void performTransaction(int choice, Scanner sc){
        switch (choice){
            case 1 :
                System.out.println("The balance of your account is : $"+userAccount.checkBalance());
                break;

            case 2 :
                System.out.print("Enter the amount you want to deposit - ");
                double depamt = sc.nextDouble();
                if(userAccount.deposit(depamt))
                    System.out.println("Amount deposited successfully. New balance amount - $"+userAccount.checkBalance());
                else
                    System.out.println("Invalid amount.Transaction failed!!");
                break;

            case 3 :
                System.out.print("Enter the amount you want to withdraw - ");
                double withamt = sc.nextDouble();
                if(userAccount.withdraw(withamt))
                    System.out.println("Amount withdrawn successfully. New balance amount - $"+userAccount.checkBalance());
                else
                    System.out.println("Invalid amount or insufficient balance. Transaction failed!!");
                break;

            case 4 :
                System.out.println("Thank you for using ATM.");
                System.exit(0);
                break;

            default:
                System.out.println("Invalid choice!!");
                break;
        }
    }
}
public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount b=new BankAccount(1000);
        ATMInterface atmInterface = new ATMInterface(b);

        while (true){
            atmInterface.displayMenu();
            System.out.println("Enter your choice - ");
            int choice = sc.nextInt();
            atmInterface.performTransaction(choice, sc);
        }
    }
}
