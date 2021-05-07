package Helpers;

import Models.Client;
import Models.ClientTransaction;

import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CSVReader extends CustomFileReader{
    @Override
    public List<Object> read(String path, String objectType) {
        List<Object> objects = new ArrayList<Object>();
        Path filePath = Paths.get(path);
        try (BufferedReader br = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)){
            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(";");
                var item = createObject(attributes, objectType);
                objects.add(item);
                line = br.readLine();
            }
            return objects;
        }
        catch (Exception ex){

        }
        return null;
    }

    private Object createObject(String[] attributes, String objectType) {
        if (Client.class.getSimpleName() == objectType){
            return new Client(Integer.parseInt(attributes[0]), attributes[1]);
        }
        else if (ClientTransaction.class.getSimpleName() == objectType) {
            LocalDateTime dateTime = LocalDateTime.parse(attributes[2]); //"2018-05-05T11:50:55"

            return new ClientTransaction(Integer.parseInt(attributes[0]), Integer.parseInt(attributes[1]), dateTime);
        }
        return new Object();
    }
}
