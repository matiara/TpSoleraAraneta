package main;
import clasesextra.Bronze;
import clasesextra.Gold;
import clasesextra.Silver;
import com.company.Empresa;
import com.company.Motor;
import com.company.Usuario;
import reserva.Reserva;
import json.ManejadorJson;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Empresa empresa = new Empresa("Aerotaxi Club"); /// CREACION DE EMPRESA

        ManejadorJson manejador = new ManejadorJson(empresa);



        // empresa.cargarAviones(manejador.leerAviones);
        // empresa.cargarUsuarios(manejador.leerUsuarios);
        // empresa.cargarReservas(manejador.leerReservas);
        // Crear menu aparte

        /// CREANDO EMPRESA
        System.out.println("Empresa");

        Scanner scanner = new Scanner(System.in);

        ///CREANDO RESERVA
        Reserva reserva = new Reserva(0,null,null, 0,0,0, 0);

        reserva.mostrarListaUsuarios();

        ///CREANDO AVIONES
        ///--------------Bronce
       /* Bronze bronze1 = new Bronze(1000,150,3,400, Motor.reaccion);
        Bronze bronze2 = new Bronze(1100,150,3,400,Motor.reaccion);
        ///--------------Silver
        Silver silver1 = new Silver(1250,200,5,500,Motor.helice);
        Silver silver2 = new Silver(1250,200,5,500,Motor.helice);
        ///--------------Gold
        /// Aca hay dos tipos por que uno va a ser mas premium (tipo de interfaz).
        Gold gold1 = new Gold(1500,300,8,750,Motor.pistones);
        Gold gold2 = new Gold(1500,350,8,800,Motor.pistones);*/
        ///-------------------------------------------------------------------------------------------------------------
        ///AGREGANDO AVIONES A EL ARREGLO
      /*  empresa.agregarAvion(bronze1);
        empresa.agregarAvion(bronze2);
        empresa.agregarAvion(silver1);
        empresa.agregarAvion(silver2);
        empresa.agregarAvion(gold1);
        empresa.agregarAvion(gold2);*/

        //empresa.mostrarArregloAviones();

        /// CREANDO MENU INTERACTIVO
        int opcion=0;
        int opcion2=0;
        int opcion3=0;
        boolean salir = false;

        System.out.println("MOSTRANDO");
        reserva.toString();
        reserva.toString();
        reserva.pasarValores();
        System.out.println("");
        reserva.toString();


        while(!salir){
            System.out.println("1 | Registrarse");
            System.out.println("2 | Iniciar Reserva") ;

            try {

                System.out.println("Introduce una opcion: ");
                opcion = scanner.nextInt();

                switch(opcion){
                    case 1:

                        /// PROBANDO DE CREAR UN USUARIO EN DONDE SE AGREGE A EMPRESA, Y SE LO MUESTRE.
                        Usuario nuevoUsuario = new Usuario();
                        nuevoUsuario.crearUsuario();
                        empresa.agregarUsuario(nuevoUsuario);
                        manejador.writeUser(nuevoUsuario);
                        salir = true;
                        break;

                    case 2:
                                    /// ORIGEN - DESTINO
                                    int origen = reserva.selecOrigen();
                                    int destino = reserva.selecDestino();

                                    if(origen == destino){
                                        System.out.println("El destino y el origen no pueden ser iguales");
                                    }

                                    System.out.println("Usted quiere salir desde: " + origen + "hacia :" + destino);

                                    /// CANTIDAD ACOMPAÑANTES.
                                    reserva.putCantAcompañantes();
                                    System.out.println("La cantidad de acompañantes es: " + reserva.getCantAcompañantes());

                                    /// SELECCIONAR AVION.
                                    System.out.println("Seleccionar avion");
                                   /// empresa.mostrarArregloAviones();
                                    reserva.selecAvion();

                                    /// OBTENIENDO DISTANCIA.

                                    System.out.println("Obteniendo distancia");
                                    int distancia = reserva.obtenerDistancia();
                                    System.out.println("" + distancia);


                                    reserva.pasarValores();

                                    System.out.println("Mostrando la reserva");
                                    System.out.println("Cantidad de acompañantes: "+reserva.getCantAcompañantes());
                                    System.out.println("Avion elejido: " + reserva.getSelecAvion());


                                    /// DESPUES QUEDA ESTE CODIGO

                                    System.out.println("SALIR");
                                    salir = true;
                                    break;

                        default:
                            System.out.println("Las opciones son 1 o 2");
                            }

                }catch(InputMismatchException ex) {
                    System.err.println("Debes introducir un numero");
                    scanner.next();
            }
        }
    }
}

