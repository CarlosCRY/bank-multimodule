package banco.app;

import org.ies.tierno.banco.model.Account;
import org.ies.tierno.banco.model.Bank;
import org.ies.tierno.banco.readers.BankReader;

import java.util.Scanner;

public class BankApp2 {
    private final Scanner scanner;
    private final BankReader bankReader;

    public BankApp2 (Scanner scanner, BankReader bankReader) {
        this.scanner = scanner;
        this.bankReader = bankReader;
    }

    public void run() {
        Bank bank = bankReader.read();

        bank.allInfo();

        System.out.println("\nIntroduzca el IBAN de la cuenta de la que quiere extraer saldo.\n");

        Account account1 = bank.findAccount(scanner.nextLine());

        if (account1 == null) {
            System.out.println("\nLa cuenta no existe.\n");
        } else {
            System.out.println("\n¿Cuanto quiere extraer?\n");
            account1.withdraw(scanner.nextDouble());
        }

        System.out.println("\nIntroduzca el NIF del cliente que quiere buscar.\n");

        bank.searchNifAccounts(scanner.nextLine());

        System.out.println("\nIntroduzca el IBAN de la cuenta en la que quiere hacer el depósito\n");
        Account account2 = bank.findAccount(scanner.nextLine());

        if (account2 == null) {
            System.out.println("\nLa cuenta no existe.\n");
        } else {
            System.out.println("\n¿Cuanto quiere depositar?\n");
            bank.depositIban (account2.getIban(), scanner.nextDouble());
        }

        System.out.println("\nIntroduzca el IBAN de la cuenta de la que quiere consultar información del titular.\n");
        bank.searchIbanClient(scanner.nextLine()).showInfo();
    }
}
