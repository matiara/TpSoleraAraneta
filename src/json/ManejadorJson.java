package json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

            System.out.println("Reservas: " + allReservas);
            empresa.inicializarUsuarios(allUsuarios);
            empresa.inicializarAviones(allAviones);
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

    public void writeReserva(Reserva newReserva)
    {
        JSONObject newReservaObject = new JSONObject();
        newReservaObject.put("fecha" , newReserva.getFecha());
        newReservaObject.put("cantAcompañantes", newReserva.getCantAcompañantes());
        newReservaObject.put("selecAvion", newReserva.getSelecAvion());
        newReservaObject.put("costoTotal", newReserva.getCostoTotal());
        newReservaObject.put("origen", newReserva.getOrigen().toString());
        newReservaObject.put("destino", newReserva.getDestino().toString());
        newReservaObject.put("dni",newReserva.getDni());


        try (FileWriter file = new FileWriter("src/json/data.json")) {

            JSONArray currentReserva = (JSONArray) this.data.get("reservas");
            currentReserva.add(newReservaObject);
            this.data.replace("reservas", currentReserva);
            file.write(this.data.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeReservas(HashMap<Integer,Reserva> mapReservas){



        try (FileWriter file = new FileWriter("src/json/data.json")) {

            JSONArray currentReservas = (JSONArray) this.data.get("reservas");
            currentReservas.clear();
            for (Map.Entry<Integer, Reserva> r : mapReservas.entrySet()) {

                JSONObject newReservaObject = new JSONObject();
                newReservaObject.put("fecha" , r.getValue().getFecha());
                newReservaObject.put("cantAcompañantes", r.getValue().getCantAcompañantes());
                newReservaObject.put("selecAvion", r.getValue().getSelecAvion());
                newReservaObject.put("costoTotal", r.getValue().getCostoTotal());
                newReservaObject.put("origen", r.getValue().getOrigen().toString());
                newReservaObject.put("destino", r.getValue().getDestino().toString());
                newReservaObject.put("dni",r.getValue().getDni());
                currentReservas.add(newReservaObject);

            }
            this.data.replace("reservas", currentReservas);
            file.write(this.data.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
