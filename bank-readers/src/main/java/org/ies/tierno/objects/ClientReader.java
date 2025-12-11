package org.ies.tierno.objects;

import org.ies.tierno.objects.Client;

import java.util.Scanner;

public class ClientReader {

    private final Scanner scanner;

    public ClientReader (Scanner scanner) {
        this.scanner = scanner;
    }

    public Client read() {
        System.out.println("\nIntroduzca los datos del cliente:");

        System.out.println("NIF\n");
        String nif = scanner.nextLine();

        System.out.println("\nNombre\n");
        String name = scanner.nextLine();

        System.out.println("\nApellidos\n");
        String surname = scanner.nextLine();

        return new Client(nif, name, surname);
    }
}