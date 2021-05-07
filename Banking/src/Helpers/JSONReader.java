package Helpers;

import Models.Client;
import Models.ClientTransaction;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JSONReader extends CustomFileReader{

    @Override
    public List<Object> read(String path, String objectType) {
        List<Object> objects = new ArrayList<Object>();
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(path));
            JSONArray transactions = (JSONArray) obj;
            Iterator<JSONObject> iterator = transactions.iterator();
            while (iterator.hasNext()) {
                objects.add(createObject(iterator.next(), objectType));
            }
            return  objects;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private Object createObject(JSONObject next, String objectType) {
        if (Client.class.getSimpleName() == objectType){
            return new Client(Integer.parseInt(next.get("Id").toString()), next.get("Name").toString());
        }
        else if (ClientTransaction.class.getSimpleName() == objectType) {
            LocalDateTime dateTime = LocalDateTime.parse(next.get("CreateDate").toString()); //"2018-05-05T11:50:55"

            return new ClientTransaction(Integer.parseInt(next.get("Id").toString()), Integer.parseInt(next.get("ClientId").toString()), dateTime);
        }
        return new Object();
    }
}
