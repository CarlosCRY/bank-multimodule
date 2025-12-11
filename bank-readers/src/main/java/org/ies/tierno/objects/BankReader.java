package org.ies.tierno.objects;

import org.ies.tierno.objects.Account;
import org.ies.tierno.objects.Bank;

import java.util.Scanner;

public class BankReader {

    private final Scanner scanner;
    private final AccountReader accountReader;

    public BankReader(Scanner scanner, AccountReader accountReader) {
        this.scanner = scanner;
        this.accountReader = accountReader;
    }

    public Bank read() {
        System.out.println("\nIntroduzca los datos del banco:");

        System.out.println("Nombre\n");
        String name = scanner.nextLine();

        int n;
        System.out.println("\nIntroduzca una cantidad de cuentas.\n");
        do {
            n = scanner.nextInt();
            scanner.nextLine();
            if (n <= 0) {
                System.out.println("\nNo es una cantidad válida\n");
            }
        } while (n <= 0);

        Account[] accounts = new Account[n];

        for (int i = 0; i < n; i++) {
            accounts[i] = accountReader.read();
            System.out.println("\nCuenta " + (i + 1) + " Definida.");
        }
        return new Bank(name, accounts);
    }
}
