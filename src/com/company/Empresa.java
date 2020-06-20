package com.company;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import reserva.Lugares;
import reserva.Reserva;

import java.util.ArrayList;
import java.util.HashMap;


public class Empresa {
    private String nombre;
    private HashMap<Integer, Usuario> mapUsuarios;
    private ArrayList<Avion>listaAviones;
    private HashMap<Integer, Reserva> mapReservas;

    /// en el map reservas se tiene que poder pasar el dni de la persona que reservó, y los valores de la reserva.

    public Empresa(String nombre){
        this.nombre = nombre;
        this.mapUsuarios = new HashMap<Integer,Usuario>();
        this.listaAviones = new ArrayList<>();
        //this.mapAviones = new HashMap<String, Avion>();
        this.mapReservas = new HashMap<Integer, Reserva>();
    }

    public void agregarUsuario(Usuario u){
        mapUsuarios.put(u.getDni(),u);
    }

    public void agregarAvion(Avion t){
        //mapAviones.put(t.getTipoAvion(),t);
        listaAviones.add(t);
    }

    public void agregarReserva(Reserva r){
        mapReservas.put(r.getDni(),r);
    }

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
            Avion t = new Avion(Float.parseFloat(avion.get("capCombustible").toString()),Float.parseFloat(avion.get("kmCosto").toString()),Integer.parseInt(avion.get("maxCapacidad").toString()),Float.parseFloat(avion.get("maxVelocidad").toString()),Motor.valueOf(avion.get("tipoPropulsion").toString()),avion.get("tipoAvion").toString());
            agregarAvion(t);
        }
    }

    public void inicializarReservas(JSONArray allReservas){

        for (int i = 0; i < allReservas.size(); i++) {

            JSONObject reserva = (JSONObject) allReservas.get(i);
            //tira error por que es un string 
            // Reserva r = new Reserva(Integer.parseInt(reserva.get("fecha").toString()),Lugares.valueOf(reserva.get("origen").toString()),Lugares.valueOf(reserva.get("destino").toString()),Integer.parseInt(reserva.get("canAcompañantes").toString()),Integer.parseInt(reserva.get("selecAvion").toString()),Float.parseFloat(reserva.get("costoTotal").toString()),Integer.parseInt(reserva.get("dni").toString()));
            //agregarReserva(r);

        }
    }

    ///funcion para how to convert from jsonarray to arraylist(aviones)
    ///funcion para how to convert from jsonarray to hashmap(reserva)


    public void generarReserva(Usuario usuario, Reserva reserva){
        mapReservas.put(usuario.getDni(),reserva);
    }

    public void mostrarReservas(){
        mapReservas.get(mapUsuarios.keySet());
    }

    public void eliminarReserva(Reserva r){
        mapReservas.remove(r.getDni(),r);
    }
/*
   public void mostrarAviones(){
       System.out.println("MOSTRANDO AVIONES");
       for(int i=0;i<listaAviones.size();i++){
           listaAviones.get(i).mostrarAvion();
       }
   }*/

   public void mostrarAviones(){
       int contador=1;
       for(int i=0;i<listaAviones.size();i++){
           System.out.println("Nº " + contador + " Avion: " + listaAviones.get(i).getTipoAvion());
           System.out.println("Cantidad maxima de pasajeros: " + listaAviones.get(i).getSizePasajeros());
           System.out.println("Velocidad maxima: " + listaAviones.get(i).getVelMaxima());
           System.out.println("Costo por kilometro: " + listaAviones.get(i).getCostoXkm());
           System.out.println("");
           contador++;
       }
    }


    /*
    public void eliminarReserva(int dni){

        mapReservas.remove()
    }
    */
}


