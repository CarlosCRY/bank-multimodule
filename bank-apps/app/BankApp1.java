package org.ies.tierno.banco.app;

import org.ies.tierno.banco.model.Account;
import org.ies.tierno.banco.model.Bank;
import org.ies.tierno.banco.readers.BankReader;

import java.util.Scanner;

public class BankApp1 {
    private final Scanner scanner;
    private final BankReader bankReader;

    public BankApp1 (Scanner scanner, BankReader bankReader) {
        this.scanner = scanner;
        this.bankReader = bankReader;
    }

    public void run() {
        Bank bank = bankReader.read();

        System.out.println("\nIntroduzca el IBAN de la cuenta 1\n");
        Account account1 = bank.findAccount(scanner.nextLine());

        if (account1 == null) {
            System.out.println("\nLa cuenta no existe.\n");
        } else {
            System.out.println("\n¿Cuanto quiere depositar?\n");
            bank.depositIban (account1.getIban(), scanner.nextDouble());
        }

        System.out.println("\nIntroduzca el IBAN de la cuenta 1\n");
        Account account2 = bank.findAccount(scanner.nextLine());

        if (account2 == null) {
            System.out.println("\nLa cuenta no existe.\n");
        } else {
            System.out.println("\n¿Cuanto quiere extraer?\n");
            account2.withdraw(scanner.nextDouble());
        }

        if (account1 != null && account2 != null) {
            System.out.println("\nIntroduzca la cantidad que quiere transferir:");
            bank.transferIban(account1.getIban(), account2.getIban(), scanner.nextDouble());
        }

        if (account1 != null) {
            account1.showInfo();
        }
        if (account2 != null) {
            account2.showInfo();
        }
    }
}
