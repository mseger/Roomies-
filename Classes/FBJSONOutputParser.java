import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: mseger
 * Date: 12/17/12
 * Time: 1:39 AM
 * To change this template use File | Settings | File Templates.
 */
public class FBJSONOutputParser {

    String source;

    public FBJSONOutputParser(String toReadFrom){
        source = toReadFrom;
    }

    public LinkedList<Connection> parseFBfriendList(){
        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader(source));

            // turn the output glob of text into a JSON object
            JSONObject jsonObject = (JSONObject) obj;

            // parse out an array of JSON objects
            JSONArray data = (JSONArray) jsonObject.get("data");

            // iterate through each of the JSON objects, make a new Connection, add to a List
            LinkedList<Connection> connectionList = new LinkedList<Connection>();
            for(int i=0; i<data.size(); i++){
                // parse out the individual friends' names + FB IDs
                JSONObject individual = (JSONObject) data.get(i);
                String name = (String) individual.get("name");
                String id = (String) individual.get("id");

                // create a Connection, add to my list of Connections
                Connection toAdd = new Connection(name, id);
                connectionList.add(toAdd);
            }
            return connectionList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
 }
