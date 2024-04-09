package growIntern;
import java.util.Scanner;

public class SimpleBankingSystem {
	
	private static int findAccountIndex(String[] accountNumbers, int Accounts, String accountNumber) {
        for (int i = 0; i < Accounts; i++) {
            if (accountNumbers[i].equals(accountNumber)) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        final int MAX_ACCOUNTS = 50;
        String[] accountNumber = new String[MAX_ACCOUNTS];
        double[] accountBalance = new double[MAX_ACCOUNTS];
        int Accounts = 0;
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
        	System.out.println("\n----------------------------------------------------------");
            System.out.println("--------------------Simple Banking System-----------------");
            System.out.println("----------------------------------------------------------");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (Accounts < MAX_ACCOUNTS) {
                        System.out.print("Enter account number: ");
                        String accountNumbers = scanner.next();
                        accountNumber[Accounts] = accountNumbers;
                        System.out.print("Enter initial amount you want to add: ");
                        double initialBalance = scanner.nextDouble();
                        accountBalance[Accounts] = initialBalance;
                        Accounts++;
                        System.out.println("*********Account created successfully*********");
                    } else {
                        System.out.println("-----------Maximum number of accounts reached----------");
                    }
                    break;
                    
                    
                case 2:
                    System.out.print("Enter account number: ");
                    String depositaccount = scanner.next();
                    int depositIndex = findAccountIndex(accountNumber, Accounts, depositaccount);
                    if (depositIndex != -1) {
                        System.out.print("Enter amount to deposit: ");
                        double amounttodeposit = scanner.nextDouble();
                        accountBalance[depositIndex] += amounttodeposit;
                        System.out.println("*********Deposit successful. New balance: " + accountBalance[depositIndex]+"***********");
                    } else {
                        System.out.println("-------------Account not found-------------");
                    }
                    break;
                    
                    
                case 3:
                    System.out.print("Enter account number: ");
                    String withdrawaccount = scanner.next();
                    int withdraw = findAccountIndex(accountNumber, Accounts, withdrawaccount);
                    if (withdraw != -1) {
                        System.out.print("Enter amount to withdraw: ");
                        double amountToWithdraw = scanner.nextDouble();
                        if (accountBalance[withdraw] >= amountToWithdraw) {
                            accountBalance[withdraw] -= amountToWithdraw;
                            System.out.println("**********Withdrawal successful. New balance: " + accountBalance[withdraw]+"********");
                        } else {
                            System.out.println("---------------Insufficient balance------------------");
                        }
                    } else {
                        System.out.println("-------------------Account not found-----------------");
                    }
                    break;
                    
                case 4:
                    System.out.print("Enter account number: ");
                    String checkaccount = scanner.next();
                    int checkIndex = findAccountIndex(accountNumber, Accounts, checkaccount);
                    if (checkIndex != -1) {
                        System.out.println("************Balance: RS " + accountBalance[checkIndex]+"*************");
                    } else {
                        System.out.println("-------------------Account not found--------------");
                    }
                    break;
                    
                case 5:
                	System.out.println("-------------------------------------------------------");
                    System.out.println("***************Exiting........... THANKYOU************ ");
                    System.out.println("-------------------------------------------------------");
                    break;
                default:
                    System.out.println("-----------------Invalid choice. Please enter a valid option----------------");
            }
        } while (choice != 5);

        scanner.close();
    }
}

