package com.company;

import com.company.TipoAvion;
import com.company.Usuario;
import reserva.Lugares;
import reserva.Reserva;

import java.util.ArrayList;
import java.util.HashMap;


public class Empresa {
    private String nombre;
    private HashMap<Integer, Usuario> mapUsuarios;
    private ArrayList<TipoAvion> listaAviones;
    private HashMap<Integer, Reserva> mapReservas;


    /// en el map reservas se tiene que poder pasar el dni de la persona que reservó, y los valores de la reserva.



    public Empresa(String nombre){
        this.nombre = nombre;
        this.mapUsuarios = new HashMap<Integer,Usuario>();
        this.listaAviones = new ArrayList<TipoAvion>();
        this.mapReservas = new HashMap<Integer, Reserva>();
    }

    public void agregarUsuaruio(Usuario u){
        mapUsuarios.put(u.getDni(),u);
    }

    public void mostrarUsuarios(){
        System.out.println(mapUsuarios.keySet());
        System.out.println(mapUsuarios.values());
    }

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
    /// aca se tiene que atajar el dni del usuario y los valores de reserva, cada vez que se crea una nueva reserva se tiene que hacer un nuevo espacio del mapa de reservas (dni, valores de reserva)
        int selec=0;

        mapReservas.put(usuario.getDni(),reserva);

    }












}
