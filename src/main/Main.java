package main;
import clasesextra.Bronze;
import clasesextra.Gold;
import clasesextra.Silver;
import com.company.Empresa;
import com.company.Motor;
import com.company.Usuario;
import reserva.Reserva;
import json.ManejadorJson;

import javax.crypto.spec.PSource;
import java.io.Console;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Empresa empresa = new Empresa("Aerotaxi Club"); /// CREACION DE EMPRESA

        ManejadorJson manejador = new ManejadorJson(empresa);

        // empresa.cargarAviones(manejador.leerAviones);
        // empresa.cargarUsuarios(manejador.leerUsuarios);
        // empresa.cargarReservas(manejador.leerReservas);
        // Crear menu aparte

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

        /*
        reserva.toString();
        reserva.toString();
        reserva.pasarValores();
        reserva.toString();
        */

        while(!salir){
            System.out.println("1 | Registrarse");
            System.out.println("2 | Iniciar Reserva") ;
            System.out.println("3 | Cancelar Reserva");

            try {

                System.out.println("Introduce una opcion: ");
                opcion = scanner.nextInt();

                switch(opcion){
                    case 1:

                        /// PROBANDO DE CREAR UN USUARIO EN DONDE SE AGREGE A EMPRESA, Y SE LO MUESTRE.
                        Usuario nuevoUsuario = new Usuario();
                        nuevoUsuario.crearUsuario();
                        empresa.agregarUsuario(nuevoUsuario);
                       // manejador.writeUser(nuevoUsuario);
                        salir = true;
                        break;

                    case 2:

                        /// ORIGEN - DESTINO

                                    int origen = reserva.selecOrigen();
                                    int destino = reserva.selecDestino();

                                    if(origen == destino){
                                        System.out.println("El destino y el origen no pueden ser iguales");
                                    }

                                    /// IF PARA HACER TRANSFERENCIA DE LOS VALORES NUMERICOS A CIUDAD QUE PUEDA VER EL USUARIO

                                    if(origen == 1){
                                        System.out.println("Lugar de origen: Buenos Aires");
                                    }
                                    if(origen == 2){
                                        System.out.println("Lugar de origen: Santiago");
                                    }
                                    if(origen == 3){
                                        System.out.println("Lugar de origen: Cordoba");
                                    }
                                    if(origen == 4){
                                        System.out.println("Lugar de origen: Montevideo");
                                    }
                                    if(destino == 1){
                                        System.out.println("Se dirige a: Buenos aires");
                                    }

                                    if(destino == 2){
                                        System.out.println("Se dirige a: Chile");
                                    }
                                    if(destino == 3){
                                        System.out.println("Se dirige a: Cordoba");
                                    }
                                    if(destino == 4){
                                        System.out.println("Se dirige a: Montevideo");
                                    }

                                    reserva.convertirOrigen();
                                    reserva.convertirDestino();

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
                    case 3:
                        System.out.println("Cancelar Reserva");
                        break;

                        default:
                            System.out.println("Las opciones son 1,2 o 3");
                            }

                }catch(InputMismatchException ex) {
                    System.err.println("Debes introducir un numero");
                    scanner.next();
            }
        }
    }
}



