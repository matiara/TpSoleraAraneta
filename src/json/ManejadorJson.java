package json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.company.Empresa;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



import com.company.Usuario;
import reserva.Lugares;
import reserva.Reserva;

public class ManejadorJson
{
    private JSONObject data;

    public ManejadorJson(Empresa empresa){
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("src/json/data.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            this.data = (JSONObject) obj;

            JSONArray allUsuarios = (JSONArray) this.data.get("usuarios");
            JSONArray allAviones = (JSONArray) this.data.get("aviones");
            JSONArray allReservas = (JSONArray) this.data.get("reservas");

            System.out.println("mati: " + allReservas);
            empresa.inicializarUsuarios(allUsuarios);
            //empresa.inicializarAviones(allAviones);
            empresa.inicializarReservas(allReservas);


            System.out.println("Informacion en el sistema: " + this.data);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
