package banco.app;

import org.ies.tierno.banco.model.Account;
import org.ies.tierno.banco.model.Bank;
import org.ies.tierno.banco.readers.BankReader;

import java.util.Scanner;

public class BankApp3 {
    private final Scanner scanner;
    private final BankReader bankReader;

    public BankApp3(Scanner scanner, BankReader bankReader) {
        this.scanner = scanner;
        this.bankReader = bankReader;
    }

    public void run() {
        Bank bank = bankReader.read();

        System.out.println("\nIntroduzca el IBAN de la cuenta.\n");

        Account account = bank.findAccount(scanner.nextLine());

        if (account == null) {
            System.out.println("\nLa cuenta no existe.\n");
        } else {
            account.showInfo();
            System.out.println("\nIntroduzca el IBAN de la cuenta donde quiere transferir todo el saldo.\n");
            bank.transferIban(account.getIban(), scanner.nextLine(), account.getBalance());
            System.out.println("\nNombre del banco: " + bank.getName() + "\n");
            bank.allInfo();
        }
    }
}
