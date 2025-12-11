package banco;

import org.ies.tierno.banco.app.BankApp1;
import org.ies.tierno.banco.readers.AccountReader;
import org.ies.tierno.banco.readers.BankReader;
import org.ies.tierno.banco.readers.ClientReader;

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