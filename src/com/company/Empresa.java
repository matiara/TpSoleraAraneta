package com.company;

import com.sun.source.tree.BreakTree;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import reserva.Lugares;
import reserva.Reserva;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Empresa {
    private String nombre;
    private HashMap<Integer, Usuario> mapUsuarios;
    private ArrayList<Avion>listaAviones;
    private HashMap<Integer, Reserva> mapReservas;

    Scanner reader = new Scanner(System.in);

    public ArrayList<Avion> getListaAviones() {
        return listaAviones;
    }

    public Empresa(String nombre){
        this.nombre = nombre;
        this.mapUsuarios = new HashMap<>();
        this.listaAviones = new ArrayList<>();
        this.mapReservas = new HashMap<>();
    }

    ///AGREGAR USUARIO | AVION | RESERVA

    public void agregarUsuario(Usuario u){
        mapUsuarios.put(u.getDni(),u);
    }

    public void agregarAvion(Avion t){
        listaAviones.add(t);
    }

    public void agregarReserva(Reserva r){
        mapReservas.put(r.getDni(),r);
    }

    /// INICIALIZAR EN JSON

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
            Avion t = new Avion(Float.parseFloat(avion.get("capCombustible").toString()),Float.parseFloat(avion.get("kmCosto").toString()),Integer.parseInt(avion.get("maxCapacidad").toString()),Float.parseFloat(avion.get("maxVelocidad").toString()),Motor.valueOf(avion.get("tipoPropulsion").toString()),avion.get("tipoAvion").toString(),Integer.parseInt(avion.get("id").toString()),Integer.parseInt(avion.get("tarifa").toString()),avion.get("wifi").toString(),avion.get("catering").toString());
            agregarAvion(t);
        }
    }

    public void inicializarReservas(JSONArray allReservas){

        for (int i = 0; i < allReservas.size(); i++) {

            JSONObject reserva = (JSONObject) allReservas.get(i);
            Reserva r = new Reserva(reserva.get("fecha").toString(),Lugares.valueOf(reserva.get("origen").toString()), Lugares.valueOf(reserva.get("destino").toString()),Integer.parseInt(reserva.get("cantAcompañantes").toString()),Integer.parseInt(reserva.get("selecAvion").toString()),Float.parseFloat(reserva.get("costoTotal").toString()),Integer.parseInt(reserva.get("dni").toString()));
            agregarReserva(r);

        }
    }

    ///MOSTRAR USUARIOS | AVIONES | RESERVA
    public void mostrarReservas(){
        mapReservas.get(mapUsuarios.keySet());
    }

    public void mostrarAviones(){
        int contador=1;
        for(int i=0;i<listaAviones.size();i++){
            System.out.println("Nº " + contador + " Avion: " + listaAviones.get(i).getTipoAvion());
            System.out.println("Cantidad maxima de pasajeros: " + listaAviones.get(i).getSizePasajeros());
            System.out.println("Velocidad maxima: " + listaAviones.get(i).getVelMaxima());
            System.out.println("Costo por kilometro: " + listaAviones.get(i).getCostoXkm());
            System.out.println("Wifi:" + listaAviones.get(i).getWifi());
            System.out.println("Catering:" + listaAviones.get(i).getCatering());
            System.out.println(" ");
            contador++;
        }
    }

    public void mostrarUsuarios(){
        System.out.println(mapUsuarios.keySet());
        System.out.println(mapUsuarios.values());
    }

    /// GENERAR RESERVA
    public void generarReserva(Usuario usuario, Reserva reserva){
        mapReservas.put(usuario.getDni(),reserva);
    }

    /// INGRESAR DNI
    public int ingresarDni(){
        int check=0;
        int dniBuscado=0;

        System.out.println("Ingrese el dni del usuario");
        dniBuscado = reader.nextInt();
        if(dniBuscado <30000000 || dniBuscado> 70000000){
            System.out.println("Los valores ingresados del DNI, no son validos");
            check = 0;
        }
        else{
            check = 1;
        }

        while (check == 0){
            System.out.println("Vuelva a intentarlo");
            dniBuscado =reader.nextInt();
        }
        return dniBuscado;
    }

    ///BUSCAR DNI
    public int buscarDni(){
        System.out.println("BUSCANDO DNI");
        int dniBuscado = ingresarDni();
        int buscado=0;

        for (Integer key : mapUsuarios.keySet()) {
            if(dniBuscado == key){
                buscado = 1;
            }
            else{
                buscado = 0;
            }
        }

        return buscado;
    }


/// ELIMINAR RESERVA
    public void eliminarReserva(){
        boolean verificar = verificarFecha();

        System.out.println("Ingrese su dni");
        int dniBuscado = buscarDni();
        System.out.println("El DNI BUSCADO DA: " + dniBuscado);

        if(dniBuscado == 1){
            if(verificar == false){
                System.out.println("No puede cancelar un vuelo, el mismo dia ");

            }
            else{
                System.out.println("Reserva cancelada");
                mapReservas.remove(dniBuscado);
                for (Map.Entry<Integer, Reserva> r : mapReservas.entrySet()) {

                    System.out.println(" Value: " + r.getValue().getFecha());

                }
            }
        }


    }

    public boolean verificarFecha(){

        /// Para poder obtener la fecha del dia actual.
        Calendar c1 = GregorianCalendar.getInstance();
        boolean flag = false;
        SimpleDateFormat fecha = new SimpleDateFormat("dd-MM-yyyy");

        System.out.println("Fecha actual: " +fecha.format(c1.getTime()));

        for (Map.Entry<Integer, Reserva> r : mapReservas.entrySet()) {

            System.out.println(" Value: " + r.getValue().getFecha());

            if(fecha.equals(r.getValue().getFecha())){

            }
            else{
                flag = true;
            }


        }
        return flag;
    }


    public boolean verificarDisponibilidad(Reserva reserva){
        boolean flag = false;
        for (Map.Entry<Integer, Reserva> r : mapReservas.entrySet()) {

            System.out.println("Key: "+r.getKey() + " Value: " + r.getValue());
            if(reserva.getFecha().equals(r.getValue().getFecha()) && reserva.getSelecAvion() == r.getValue().getSelecAvion()){
                flag = true;
                break;
            }
        }
        return flag;
        }


    ///LISTAR TODOS LOS VUELOS PROGRAMADOS EN UNA FECHA
    public void listarVuelos(){
        int i =0;
        SimpleDateFormat fecha = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("Ingrese la fecha que quiere ver: ");
        String sDate1 = reader.next();
        try {
            Date date1 = fecha.parse(sDate1);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("LA FEHCA QUE QUIERE VER ES: " +sDate1);

        for (Map.Entry<Integer, Reserva> r : mapReservas.entrySet()) {

            System.out.println(" Value: " + r.getValue().getFecha());
            if(sDate1.equals(r.getValue().getFecha())){
                ///aca hay que mostrar todoo

            }
            else{
                System.out.println("No hay reservas en ese dia");
            }

        }

    }

    public void mostrarClientes(){
        System.out.println("LOS VALORES DE LOS USUARIOS SON: ");
        for (Map.Entry<Integer, Usuario> u : mapUsuarios.entrySet()) {
            System.out.println("" + u.getValue());

        }
    }




}





























