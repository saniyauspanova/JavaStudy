package Main;

import Helpers.CSVReader;
import Helpers.CustomFileReader;
import Helpers.JSONReader;
import Models.Client;
import Models.ClientTransaction;

public class Main {

    public static void main(String[] args) {
        CustomFileReader reader = new CSVReader();
        CustomFileReader jsonReader = new JSONReader();
        var clients = reader
                .read("F://Clients.csv", Client.class.getSimpleName())
                .stream().map(s -> (Client)s)
                .toList();
        var transactions = jsonReader
                .read("F://Transactions.json", ClientTransaction.class.getSimpleName())
                .stream().map(s -> (ClientTransaction)s)
                .toList();

        clients.forEach(c -> System.out.printf("%d, %s \n", c.Id, c.Name));
        transactions.forEach(t -> System.out.printf("%d,%d, %s \n", t.Id, t.ClientId, t.CreateDate.toString()));
    }
}
