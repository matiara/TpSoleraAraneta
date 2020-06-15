package json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.company.TipoAvion;
import com.company.Usuario;
import reserva.Lugares;
import reserva.Reserva;

public class ManejadorJson
{
    private JSONObject data;

    public ManejadorJson(){
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("src/json/data.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            this.data = (JSONObject) obj;

            System.out.println("Informacion en el sistema: " + this.data);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void parseEmployeeObject(JSONObject employee)
    {
        //Get employee object within list
        JSONObject employeeObject = (JSONObject) employee.get("personas");

        //Get employee first name
        String firstName = (String) employeeObject.get("nombre");
        System.out.println(firstName);

        //Get employee last name
        String lastName = (String) employeeObject.get("apellido");
        System.out.println(lastName);

        //Get employee website name
        float website = (float) employeeObject.get("edad");
        System.out.println(website);
    }



    public void writeUser(Usuario newUser)
    {
        JSONObject newUserObject = new JSONObject();
        newUserObject.put("nombre", newUser.getNombre());
        newUserObject.put("apellido", newUser.getApellido());
        newUserObject.put("edad", newUser.getEdad());
        newUserObject.put("dni", newUser.getDni());

        try (FileWriter file = new FileWriter("src/json/data.json")) {

            JSONArray currentUsers = (JSONArray) this.data.get("usuarios");
            currentUsers.add(newUserObject);
            this.data.replace("usuarios", currentUsers);
            file.write(this.data.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}