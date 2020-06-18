package com.company;

import com.company.Avion;
import com.company.Usuario;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import reserva.Lugares;
import reserva.Reserva;

import java.util.HashMap;


public class Empresa {
    private String nombre;
    private HashMap<Integer, Usuario> mapUsuarios;
    private HashMap<Integer, Avion> mapAviones;
    private HashMap<Integer, Reserva> mapReservas;

    /// en el map reservas se tiene que poder pasar el dni de la persona que reservó, y los valores de la reserva.

    public Empresa(String nombre){
        this.nombre = nombre;
        this.mapUsuarios = new HashMap<Integer,Usuario>();
        this.mapAviones = new HashMap<Integer, Avion>();
        this.mapReservas = new HashMap<Integer, Reserva>();
    }
    public void agregarUsuario(Usuario u){
        mapUsuarios.put(u.getDni(),u);
    }
    public void agregarAvionn(Avion t){ mapAviones.put(t.getTipoAvion(),t); }
    public void agregarReserva(Reserva r){ mapReservas.put(r.getDni(),r); }


    public void mostrarUsuarios(){
        System.out.println(mapUsuarios.keySet());
        System.out.println(mapUsuarios.values());
    }



    public void inicializarUsuarios(JSONArray allUsuarios){

        for (int i = 0; i < allUsuarios.size(); i++) {

            JSONObject usuario = (JSONObject) allUsuarios.get(i);
            Usuario e = new Usuario(usuario.get("nombre").toString(),usuario.get("apellido").toString(), Integer.parseInt(usuario.get("edad").toString()),Integer.parseInt(usuario.get("dni").toString()));
            agregarUsuario(e);

        }
    }
    public void inicializarAviones(JSONArray allAviones){

        for (int i = 0; i < allAviones.size(); i++) {

            JSONObject avion= (JSONObject) allAviones.get(i);
            Avion t = new Avion(Float.parseFloat(avion.get("capConbustible").toString()),Float.parseFloat(avion.get("Costokm").toString()),Integer.parseInt(avion.get("maxCapacity").toString()),Float.parseFloat(avion.get("velMaxima").toString()),Motor.valueOf(avion.get("motor").toString()),Integer.parseInt(avion.get("tipoAvion").toString()));
            agregarAvionn(t);

        }
    }

    public void inicializarReservas(JSONArray allReservas){

        for (int i = 0; i < allReservas.size(); i++) {

            JSONObject reserva = (JSONObject) allReservas.get(i);
            Reserva r = new Reserva(Integer.parseInt(reserva.get("fecha").toString()),Lugares.valueOf(reserva.get("origen").toString()),Lugares.valueOf(reserva.get("destino").toString()),Integer.parseInt(reserva.get("canAcompañantes").toString()),Integer.parseInt(reserva.get("selecAvion").toString()),Float.parseFloat(reserva.get("costoTotal").toString()),Integer.parseInt(reserva.get("dni").toString()));
            agregarReserva(r);

        }
    }





    ///funcion para how to convert from jsonarray to arraylist(aviones)
    ///funcion para how to convert from jsonarray to hashmap(reserva)


    /*
    public void agregarAvion(Avion avion){
        listaAviones.add(avion);
    }

    public void mostrarArregloAvion(){
        int cont=0;
        for(int i=0;i<Avion.size();i++){
            System.out.println("Nº" +cont + Avion.get(i).toString());
            cont++;
        }
    }*/

    public void generarReserva(Usuario usuario, Reserva reserva){
        mapReservas.put(usuario.getDni(),reserva);
    }

    public void mostrarReservas(){
        mapReservas.get(mapUsuarios.keySet());
    }

}





    ///funcion para how to convert from jsonarray to arraylist(aviones)
    ///funcion para how to convert from jsonarray to hashmap(reserva)



    public void agregarAvion(TipoAvion avion){
        listaAviones.add(avion);
    }

    public void mostrarArregloAviones(){
        int cont=0;
        for(int i=0;i<listaAviones.size();i++){
            System.out.println("Nº" +cont + listaAviones.get(i).toString());
            cont++;
        }
    }

    public void generarReserva(Usuario usuario, Reserva reserva){
        mapReservas.put(usuario.getDni(),reserva);
    }

    public void mostrarReservas(){
        mapReservas.get(mapUsuarios.keySet());
    }

}
