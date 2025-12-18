package org.ies.tierno.objects;

import org.ies.tierno.objects.app.BankApp1;
import org.ies.tierno.objects.AccountReader;
import org.ies.tierno.objects.BankReader;
import org.ies.tierno.objects.ClientReader;

import java.util.Scanner;

public class BankApp1Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClientReader clientReader = new ClientReader (scanner);
        AccountReader accountReader = new AccountReader (scanner, clientReader);
        BankReader bankReader = new BankReader (scanner, accountReader);
        BankApp1 bankApp = new BankApp1 (scanner, bankReader);

        bankApp.run();
    }
}