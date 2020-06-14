package json;

import com.company.Usuario;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ManejadorJson {
    private JSONObject data;

    public ManejadorJson() {
        JSONParser jsonParser = new JSONParser();

        try {
            FileReader reader = new FileReader("src/json/data.json");

            try {
                Object obj = jsonParser.parse(reader);
                this.data = (JSONObject)obj;
                System.out.println("Informacion en el sistema: " + this.data);
            } catch (Throwable var6) {
                try {
                    reader.close();
                } catch (Throwable var5) {
                    var6.addSuppressed(var5);
                }

                throw var6;
            }

            reader.close();
        } catch (FileNotFoundException var7) {
            var7.printStackTrace();
        } catch (IOException var8) {
            var8.printStackTrace();
        } catch (ParseException var9) {
            var9.printStackTrace();
        }

    }

    private static void parseEmployeeObject(JSONObject employee) {
        JSONObject employeeObject = (JSONObject)employee.get("personas");
        String firstName = (String)employeeObject.get("nombre");
        System.out.println(firstName);
        String lastName = (String)employeeObject.get("apellido");
        System.out.println(lastName);
        float website = (Float)employeeObject.get("edad");
        System.out.println(website);
    }
 
    public void writeUser(Usuario newUser) {
        JSONObject newUserObject = new JSONObject();
        newUserObject.put("nombre", newUser.getNombre());
        newUserObject.put("apellido", newUser.getApellido());
        newUserObject.put("edad", newUser.getEdad());
        newUserObject.put("dni", newUser.getDni());

        try {
            FileWriter file = new FileWriter("src/json/data.json");

            try {
                JSONArray currentUsers = (JSONArray)this.data.get("usuarios");
                currentUsers.add(newUserObject);
                this.data.replace("usuarios", currentUsers);
                file.write(this.data.toJSONString());
                file.flush();
            } catch (Throwable var7) {
                try {
                    file.close();
                } catch (Throwable var6) {
                    var7.addSuppressed(var6);
                }

                throw var7;
            }

            file.close();
        } catch (IOException var8) {
            var8.printStackTrace();
        }

    }
   
}
