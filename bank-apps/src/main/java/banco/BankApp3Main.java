package banco;

import org.ies.tierno.banco.app.BankApp3;
import org.ies.tierno.banco.readers.AccountReader;
import org.ies.tierno.banco.readers.BankReader;
import org.ies.tierno.banco.readers.ClientReader;

import java.util.Scanner;

public class BankApp3Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClientReader clientReader = new ClientReader (scanner);
        AccountReader accountReader = new AccountReader (scanner, clientReader);
        BankReader bankReader = new BankReader (scanner, accountReader);
        BankApp3 bankApp = new BankApp3 (scanner, bankReader);

        bankApp.run();
    }
}