package reserva;

import com.company.Empresa;
import com.company.Usuario;
import org.w3c.dom.ls.LSOutput;
import reserva.Lugares;

import java.util.ArrayList;
import java.util.Scanner;

public class Reserva {
    private int fecha;
    private Lugares origen;
    private Lugares destino;
    private int cantAcompañantes;
    private int selecAvion;
    private float costoTotal;
    private ArrayList<Usuario> listaUsuarios;

    public Reserva(int fecha,Lugares origen,Lugares destino,int cantAcompañantes, int selecAvion, int costoTotal){
        this.fecha = fecha;
        this.origen = origen;
        this.destino = destino;
        this.cantAcompañantes = cantAcompañantes;
        this.selecAvion = selecAvion;
        this.costoTotal = costoTotal;
        this.listaUsuarios = new ArrayList<>();
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

    ///---------------------------------------------------------------------------

    public void agregarUsuarios(Usuario u){
        listaUsuarios.add(u);
    }

    public void mostrarListaUsuarios(){
        for(int i=0;i<listaUsuarios.size();i++){
            System.out.println("Nombre: "+listaUsuarios.get(i) + "Apellido: " +listaUsuarios.get(i).getApellido() + "DNI:" + listaUsuarios.get(i).getDni() + "Edad: " + listaUsuarios.get(i).getEdad());
        }
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
    public int putCantAcompañantes(){
        int check=0;

        while(check==0){
            System.out.println("Ingrese la cantidad de acompañantes");
            this.cantAcompañantes = reader.nextInt();
            check = 1;

            if(cantAcompañantes < 0){
                System.out.println("Numero invalido");
                check=0;
            }
            if(cantAcompañantes > 7){
                System.out.println("Numero, invalido, la cantidad maxima es 7");
                check=0;
            }

        }

        return this.cantAcompañantes;
    }

    //4) SELECCIONAR EL AVION (DEBE MOSTRAR LOS POSIBLES)

    public int selecAvion(){
        /// los aviones se muestran en el main. Ahi esta el metodo.
        int selecAvion=0;
        int check=0;

        while(check==0){
            System.out.println("Seleccione el avion que desea");
            selecAvion = reader.nextInt();
            check = 1;

            if(selecAvion <0){
                System.out.println("Numero invalido");
                check=0;
            }
            if(selecAvion >5){
                System.out.println("El maximo es 5");
                check=0;
            }

            System.out.println("Ustede selecciono el avion Nº: " + selecAvion);
            /// validaciones en condicion de cantidad de pasajeros en total.

        }
        return selecAvion;
    }


    //5) MOSTRAR COSTO TOTAL.

    public int obtenerDistancia(){
       //-1 si no existe destino.

        int distancia = 0;

        if(origen.equals(Lugares.BuenoAires)){
            if(destino.equals(Lugares.Cordoba))
                distancia = 695;
            if(destino.equals(Lugares.Santiago))
                distancia = 1400;
            if(destino.equals(Lugares.Montevideo))
                distancia = 950;
            else
                distancia = -1;
        }
        else if(origen.equals(Lugares.Cordoba)){
            if(destino.equals(Lugares.Montevideo))
                distancia = 1190;
            if(destino.equals(Lugares.Santiago))
                distancia = 1050;
        }
        else if(origen.equals(Lugares.Montevideo)){
            if(destino.equals(Lugares.Santiago))
                distancia = 2100;
            else
                distancia = -1;
        }
        else if(origen.equals(Lugares.Santiago)){
            distancia = -1;
        }

        return distancia;
    }




    @Override
    public String toString() {
        return "Reserva{" +
                "fecha=" + fecha +
                ", origen=" + origen +
                ", destino=" + destino +
                ", cantAcompañantes=" + cantAcompañantes +
                ", selecAvion=" + selecAvion +
                ", costoTotal=" + costoTotal +
                //", pasajeros=" + pasajeros +
                ", reader=" + reader +
                '}';
    }


    /// PRIMERO QUE MUESTRE LOS VALORES Y LOS CONFIRME

    /// LUEGO QUE PASE LOS VALORES A LOS THIS. (PASAR VALORES A RESERVA)
    public void pasarValores(){
        //this.origen = selecOrigen(); // DA ERROR POR QUE SELEC ORIGEN DEVUELVE UN INT. HACER TRANSFERENCIA INDICANDO QUE CIUDAD ES CADA INT.
        //this.destino = selecDestino() // LO MISMO QUE ORIGEN.
        this.cantAcompañantes = putCantAcompañantes();
        this.selecAvion = selecAvion();
    }


    ///funcion calcular costo

}
