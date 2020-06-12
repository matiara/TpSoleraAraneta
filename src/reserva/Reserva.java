package reserva;

import reserva.Lugares;

import java.util.Scanner;

public class Reserva {
    private int fecha;
    private Lugares origen;
    private Lugares destino;
    private int cantAcompañantes;
    private int selecAvion;
    private float costoTotal;

    public Reserva(int fecha,Lugares origen,Lugares destino,int cantAcompañantes, int selecAvion, int costoTotal){
        this.fecha = fecha;
        this.origen = origen;
        this.destino = destino;
        this.cantAcompañantes = cantAcompañantes;
        this.selecAvion = selecAvion;
        this.costoTotal = costoTotal;
    }

    Scanner reader = new Scanner(System.in);

    ///------------------------GETS AND SETS ------------------------------------

    public int getFecha() {
        return fecha;
    }

    public int getCantAcompañantes() {
        return cantAcompañantes;
    }

    public int getSelecAvion() {
        return selecAvion;
    }

    public float getCostoTotal() {
        return costoTotal;
    }

    public void mostrarLugares(){
        System.out.println("Lugares: ");
        System.out.println("Nº1 Buenos Aires");
        System.out.println("Nº2 Cordoba");
        System.out.println("Nº3 Santiago de Chile");
        System.out.println("Nº4 Montevideo");
    }



    ///--------------------------------------------------------------------------
    //1) INDICAR LA FECHA PARA REALIZAR EL VUELO.
    //2) SELECCIONAR DESTINO Y ORIGEN.


    public int selecOrigen(){
        mostrarLugares();
        int valorOrigen=0;
        System.out.println("Ingrese el origen");
        valorOrigen = reader.nextInt();

        return valorOrigen;
    }

    public int selecDestino(){
        mostrarLugares();
        int valorDestino=0;
        System.out.println("Ingrese el destino");
        valorDestino = reader.nextInt();

        return valorDestino;
    }



    //3) CANTIDAD DE ACOMPAÑANTES QUE TENDRIA.
    //4) SELECCIONAR EL AVION (DEBE MOSTRAR LOS POSIBLES)
    //5) MOSTRAR COSTO TOTAL.




}