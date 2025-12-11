package org.ies.tierno.banco;

import org.ies.tierno.banco.app.BankAppMenu;
import org.ies.tierno.banco.readers.AccountReader;
import org.ies.tierno.banco.readers.BankReader;
import org.ies.tierno.banco.readers.ClientReader;

import java.util.Scanner;

public class BankAppMenuMain {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClientReader clientReader = new ClientReader (scanner);
        AccountReader accountReader = new AccountReader (scanner, clientReader);
        BankReader bankReader = new BankReader (scanner, accountReader);
        BankAppMenu bankApp = new BankAppMenu (scanner, bankReader);

        bankApp.run();
    }
}