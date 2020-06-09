package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Empresa {
    private String nombre;
    private HashMap<Integer, Usuario> mapUsuarios;
    private ArrayList<TipoAvion> listaAviones;

    public Empresa(String nombre){
        this.nombre = nombre;
        this.mapUsuarios = new HashMap<Integer,Usuario>();
        this.listaAviones = new ArrayList<TipoAvion>();
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










}
