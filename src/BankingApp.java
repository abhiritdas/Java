import java.lang.*;
import java.util.ArrayList;
import java.util.Scanner;

public class BankingApp {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many accounts do you want to open?");
        int n = scanner.nextInt();
        BankAccount accounts[] = new BankAccount[n];
        for(int i = 0; i < n; i++) {
            accounts[i] = new BankAccount();
            System.out.println("========================");
        }
        do {
            System.out.println("Accounts:");
            for(int i = 0; i < n; i++) {
                System.out.println((i+1) + ".  " + accounts[i].user);
            }
            System.out.println("Enter Account Number to Login to:");
            int acc_number = (scanner.nextInt() - 1);
            accounts[acc_number].display_menu();
        }
        while(true);
    }
}

class BankAccount{
    double balance;
    String user;
    Scanner scanner;
    ArrayList<String> history;

    BankAccount(){
        scanner = new Scanner(System.in);
        history = new ArrayList<>();
        entry_details();
    }

    void entry_details() {
        System.out.println("Enter Account Name:");
        user = scanner.nextLine();
        System.out.println("Enter an initial balance:");
        balance = scanner.nextDouble();
    }

    void display_menu(){
        char option = '\0';

        System.out.println("\nWelcome " + user + "!");

        do{
            System.out.println("Current Balance: $" + balance);
            System.out.println("A. Transaction History");
            System.out.println("B. Deposit");
            System.out.println("C. Withdraw");
            System.out.println("E. Exit");
            System.out.println("Enter an option:");

            option = scanner.next().charAt(0);
            option = Character.toLowerCase(option);
            switch (option){
                case 'a':
                    for(int i = 0; i < history.size(); i++){
                        System.out.println((i+1) + ". " + history.get(i));
                    }
                    break;
                case 'b':
                    deposit();
                    break;
                case 'c':
                    withdraw();
                    break;
            }
        }
        while(option != 'e');
        System.out.println("Thank you " + user + "\n========================");
    }

    void deposit(){
        System.out.println("Enter an amount to deposit:");
        double d = scanner.nextDouble();
        balance += d;
        history.add("Deposited $" + d);
        System.out.println("Deposited $" + d);
        System.out.println();
    }

    void withdraw() {
        System.out.println("Enter an amount to withdraw:");
        double w = scanner.nextDouble();
        balance -= w;
        history.add("Withdrew $" + w);
        System.out.println("Withdrew $" + w);
        System.out.println();
    }

}