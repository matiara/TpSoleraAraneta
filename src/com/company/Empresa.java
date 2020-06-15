package com.company;

import com.company.TipoAvion;
import com.company.Usuario;
import org.json.simple.JSONArray;
import reserva.Lugares;
import reserva.Reserva;

import java.util.ArrayList;
import java.util.HashMap;


public class Empresa {
    private String nombre;
    private HashMap<Integer, Usuario> mapUsuarios;
    private ArrayList<TipoAvion> listaAviones;
    private HashMap<Integer, Reserva> mapReservas;
    ///ingrese el numero de la persona que realizo la reserva

    /// en el map reservas se tiene que poder pasar el dni de la persona que reservó, y los valores de la reserva.

    public Empresa(String nombre){
        this.nombre = nombre;
        this.mapUsuarios = new HashMap<Integer,Usuario>();
        this.listaAviones = new ArrayList<TipoAvion>();
        this.mapReservas = new HashMap<Integer, Reserva>();
    }
    public void agregarUsuario(Usuario u){
        mapUsuarios.put(u.getDni(),u);
    }
    public void mostrarUsuarios(){
        System.out.println(mapUsuarios.keySet());
        System.out.println(mapUsuarios.values());
    }



    public void inicializarUsuarios(JSONArray allUsuarios){

        for (int i = 0; i < allUsuarios.size(); i++) {

            Object usuario = allUsuarios.get(i);
            System.out.println("hola"+ usuario.);
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
