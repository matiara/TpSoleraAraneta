package reserva;

import com.company.Usuario;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.spi.CalendarDataProvider;

public class Reserva {
    private int fecha;
    private Lugares origen;
    private Lugares destino;
    private int cantAcompañantes;
    private int selecAvion;
    private float costoTotal;
    private ArrayList<Usuario> listaUsuarios;
    private int dni;

    public Reserva(int fecha,Lugares origen,Lugares destino,int cantAcompañantes, int selecAvion, float costoTotal,int dni){
        this.fecha = fecha;
        this.origen = origen;
        this.destino = destino;
        this.cantAcompañantes = cantAcompañantes;
        this.selecAvion = selecAvion;
        this.costoTotal = costoTotal;
        this.listaUsuarios = new ArrayList<>();
        this.dni = dni;
    }
/*
    public Reserva(){

    }
*/

    Scanner reader = new Scanner(System.in);

    ///------------------------GETS AND SETS ------------------------------------

    public Lugares getOrigen() {
        return origen;
    }

    public Lugares getDestino() {
        return destino;
    }

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

    public int getDni() {
        return dni;
    }

    @Override
    public String toString() {
        return "Reserva | " +
                "Fecha:" + fecha +
                ", Origen:" + origen +
                ", Destino:" + destino +
                ", Cantidad acompañantes:" + cantAcompañantes +
                ", Avion seleccionado:" + selecAvion +
                ", Costo Total:" + costoTotal +
                //", pasajeros:" + pasajeros +
                ", reader:" + reader;
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

    public void indicarFecha(){
        Calendar c1 = GregorianCalendar.getInstance();
        System.out.println("Fecha actual: " +c1.getTime().toLocaleString());
        SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Ingrese la fecha que quiere realizar el vuelo");
        String sDate1 = reader.next();
        try {
            Date date1 = fecha.parse(sDate1);
            System.out.println("A usted le gustaria reservar en la fecha: " + date1);
        } catch (ParseException e) {
            System.err.println("Error al ingresar la fecha");
        }
    }


///---------------------------------------------------------------------------------------------------------------------
    //2) SELECCIONAR DESTINO Y ORIGEN.
    public int selecOrigen(){

        int check=0;
        int valorOrigen=0;

        while(check == 0){
            mostrarLugares();
            System.out.println("Ingrese el origen");
            valorOrigen = reader.nextInt();
            if (valorOrigen <1 || valorOrigen >4){
                check =0;
                System.out.println("ERROR, el valor ingresado es incorrecto, vuelva a intentarlo");
            }

            if(valorOrigen == 1){
                System.out.println("Lugar de origen: Buenos Aires");
                this.origen = Lugares.BuenoAires;
            }
            if(valorOrigen == 2){
                System.out.println("Lugar de origen: Cordoba");
                this.origen = Lugares.Cordoba;
            }
            if(valorOrigen == 3){
                System.out.println("Lugar de origen: Santiago de chile");
                this.origen = Lugares.Santiago;
            }
            if(valorOrigen == 4){
                System.out.println("Lugar de origen: Montevideo");
                this.origen = Lugares.Montevideo;
            }

            else {
                check =1;
            }

        }
        return valorOrigen;
    }

    public int selecDestino(){
        int check=0;
        int valorDestino=0;

        while(check == 0){
            mostrarLugares();
            System.out.println("Ingrese el destino");
            valorDestino = reader.nextInt();
            if (valorDestino <1 || valorDestino >=5){
                check =0;
                System.out.println("ERROR, el valor ingresado es incorrecto, vuelva a intentarlo");
            }

            if(valorDestino == 1){
                System.out.println("Se dirige a: Buenos aires");
                this.destino = Lugares.BuenoAires;
            }

            if(valorDestino == 2){
                System.out.println("Se dirige a: Cordoba");
                this.destino = Lugares.Cordoba;
            }
            if(valorDestino == 3){
                System.out.println("Se dirige a: Santiago de chile");
                this.destino = Lugares.Santiago;
            }
            if(valorDestino == 4){
                System.out.println("Se dirige a: Montevideo");
                this.destino = Lugares.Montevideo;
            }

            else {
                check =1;
            }
        }
        return valorDestino;
    }


///---------------------------------------------------------------------------------------------------------------------
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
        /// Los aviones se muestran en el main. Ahi esta el metodo.
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
            this.cantAcompañantes = selecAvion;
            System.out.println("Ustede selecciono el avion Nº: " + selecAvion);
            /// validaciones en condicion de cantidad de pasajeros en total.

        }
        return selecAvion;
    }


    //5) MOSTRAR COSTO TOTAL.
    public int obtenerDistancia(){
        //-1 si no existe destino.

        int distancia = 0;
        if(origen.equals(Lugares.BuenoAires) && destino.equals(Lugares.Santiago)){
            System.out.println("La distancia es de 1400");
            distancia = 1400;
        }
        if(origen.equals(Lugares.BuenoAires)){
            if(destino.equals(Lugares.Cordoba))
                distancia = 695;
            if(destino.equals(Lugares.Santiago))
                distancia = 1400;
            if(destino.equals(Lugares.Montevideo))
                distancia = 950;
            /*else
                distancia = -1;*/
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

    ///funcion calcular costo


    /// PRIMERO QUE MUESTRE LOS VALORES Y LOS CONFIRME
        public void mostrarValores(){
        System.out.println("Mostrando los datos de la reserva");
        System.out.println("Fecha: ");
        System.out.println("Origen: " + this.origen);
        System.out.println("Destino: " + this.destino);
        System.out.println("Cantidad de acompañantes: " + this.cantAcompañantes);
        System.out.println("Avion Seleccionado: " + this.selecAvion);
        System.out.println("Costo total: ");
    }

}
