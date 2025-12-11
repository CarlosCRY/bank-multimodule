package readers;

import org.ies.tierno.banco.model.Account;
import org.ies.tierno.banco.model.Client;

import java.util.Scanner;

public class AccountReader {

    private final Scanner scanner;
    private final ClientReader clientReader;

    public AccountReader(Scanner scanner, ClientReader clientReader) {
        this.scanner = scanner;
        this.clientReader = clientReader;
    }

    public Account read() {
        System.out.println("\nIntroduzca los datos de la cuenta:");

        System.out.println("IBAN\n");
        String iban = scanner.nextLine();

        System.out.println("\nSaldo\n");
        double balance = scanner.nextDouble();
        scanner.nextLine();

        Client client = clientReader.read();

        return new Account(iban, balance, client);
    }
}
