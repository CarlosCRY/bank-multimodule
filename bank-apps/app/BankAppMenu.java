package org.ies.tierno.banco.app;

import org.ies.tierno.banco.model.Account;
import org.ies.tierno.banco.model.Bank;
import org.ies.tierno.banco.readers.BankReader;

import java.util.Scanner;

public class BankAppMenu {
    private final Scanner scanner;
    private final BankReader bankReader;

    public BankAppMenu(Scanner scanner, BankReader bankReader) {
        this.scanner = scanner;
        this.bankReader = bankReader;
    }

    public void run() {
        Bank bank = bankReader.read();

        int option;
        do {
            System.out.println("\nComandos disponibles:");
            System.out.println("1. Cuentas existentes.");
            System.out.println("2. Buscar cuenta por IBAN.");
            System.out.println("3. Buscar cuentas de cliente.");
            System.out.println("4. Ingresar dinero.");
            System.out.println("5. Sacar dinero.");
            System.out.println("6. Control cuentas cliente.");
            System.out.println("7. Encontrar cliente de cuenta.");
            System.out.println("8. Transferencia bancaria.");
            System.out.println("9. Salir del programa.\n");
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    bank.allInfo();
                    break;
                case 2:
                    System.out.println("\nIntroduzca el IBAN:\n");
                    Account account = bank.findAccount(scanner.nextLine());
                    if (account == null) {
                        System.out.println("\nNo existe la cuenta\n");
                    } else {
                        account.showInfo();
                    }
                    break;
                case 3:
                    System.out.println("\nIntroduzca el NIF del cliente:\n");
                    bank.searchNifAccounts(scanner.nextLine());
                    break;
                case 4:
                    System.out.println("\nIntroduzca el IBAN:\n");
                    account = bank.findAccount(scanner.nextLine());
                    if (account == null) {
                        System.out.println("\nNo existe la cuenta\n");
                    } else {
                        System.out.println("\nIntroduzca la cantidad que quiere ingresar:\n");
                        account.deposit(scanner.nextDouble());
                        scanner.nextLine();
                        account.showInfo();
                    }
                    break;
                case 5:
                    System.out.println("\nIntroduzca el IBAN:\n");
                    account = bank.findAccount(scanner.nextLine());
                    if (account == null) {
                        System.out.println("\nNo existe la cuenta\n");
                    } else {
                        System.out.println("\nIntroduzca la cantidad que quiere ingresar:\n");
                        account.withdraw(scanner.nextDouble());
                        scanner.nextLine();
                        account.showInfo();
                    }
                    break;
                case 6:
                    System.out.println("\nIntroduzca el NIF del cliente:\n");
                    System.out.println(bank.countNIFAccounts(scanner.nextLine() + "\n"));
                    break;
                case 7:
                    System.out.println("\nIntroduzca el IBAN de la cuenta:\n");
                    bank.searchIbanClient(scanner.nextLine()).showInfo();
                    break;
                case 8:
                    System.out.println("\nIntroduzca el IBAN de la cuenta de origen:\n");
                    String iban1 = scanner.nextLine();
                    System.out.println("\nIntroduzca el IBAN de la cuenta receptora:\n");
                    String iban2 = scanner.nextLine();
                    System.out.println("\nIntroduzca la cantidad a transferir:\n");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    bank.transferIban (iban1, iban2, amount);
                    break;
                case 9:
                    System.out.println("\nFinalizando programa");
                    break;
                default:
                    System.out.println("\nComando no válido\n");
            }
        } while (option != 9);
    }
}
