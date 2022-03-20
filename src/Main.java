import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        Account newAccount = null;

        List<Account> accounts = new ArrayList<>();

        int c = 3;

        while (c != 0) {
            System.out.println(
                    " 1. Create an account\n" +
                            " 2. Log into account\n" +
                            " 0. Exit");

            c = s.nextInt();

            switch (c) {
                case 1:
                    newAccount = new Account();
                    System.out.println("Your card has been created\n" +
                            "Your card number: " + newAccount.makeAccountNumber());
                    System.out.println("Your card PIN:" + newAccount.makePIN());
                    accounts.add(newAccount);
                    break;
                case 2:
                    System.out.println(accounts);
                    System.out.println("Enter your card number:");
                    String cardNumber = s.next();
                    System.out.println("Enter your PIN:");
                    String pinNumber = s.next();
                    Boolean find = false;

                    for (Account a : accounts) {
                        if (a.getCardNumber().equals(cardNumber) && a.getPin().equals(pinNumber)) {
                            find = true;
                        }
                    }
                    if (find) {
                        System.out.println("You have successfully logged in!\n");

                        while (c != 3) {
                            System.out.println("1. Balance\n" +
                                    "2. Log out\n" +
                                    "0. Exit\n" +
                                    ">");
                            c = s.nextInt();
                            switch (c) {
                                case 1:
                                    System.out.println("Balance: 0");
                                    break;
                                case 2:
                                    System.out.println("You have successfully logged out!\n");
                                    c = 3;
                                    break;
                                case 3:
                                    return;
                            }
                        }
                    } else System.out.println("Wrong card number or PIN!");
                    break;
            }
        }
    }
}
