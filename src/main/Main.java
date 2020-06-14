package main;
import clasesextra.Bronze;
import clasesextra.Gold;
import clasesextra.Silver;
import com.company.Empresa;
import com.company.Motor;
import com.company.Usuario;
import reserva.Reserva;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Crear menu aparte

        /// CREANDO EMPRES
        System.out.println("Empresa");

        Empresa empresa = new Empresa("Aerotaxi Club"); /// CREACION DE EMPRESA
        Scanner scanner = new Scanner(System.in);

        Usuario usuario1 = new Usuario("Pepe","Rodriguez",41785749,29);
        Usuario usuario2 = new Usuario("Kiko","ZonaSur",52657845,48);

        ///CREANDO RESERVA
        Reserva reserva = new Reserva(0,null,null, 0,0,0);

        reserva.agregarUsuarios(usuario1);
        reserva.agregarUsuarios(usuario2);
        reserva.mostrarListaUsuarios();

        empresa.generarReserva(usuario1,reserva);



        ///CREANDO AVIONES
        ///--------------Bronce
        Bronze bronze1 = new Bronze(1000,150,3,400, Motor.reaccion);
        Bronze bronze2 = new Bronze(1100,150,3,400,Motor.reaccion);
        ///--------------Silver
        Silver silver1 = new Silver(1250,200,5,500,Motor.helice);
        Silver silver2 = new Silver(1250,200,5,500,Motor.helice);
        ///--------------Gold
        /// Aca hay dos tipos por que uno va a ser mas premium (tipo de interfaz).
        Gold gold1 = new Gold(1500,300,8,750,Motor.pistones);
        Gold gold2 = new Gold(1500,350,8,800,Motor.pistones);
        ///-------------------------------------------------------------------------------------------------------------
        ///AGREGANDO AVIONES A EL ARREGLO
        empresa.agregarAvion(bronze1);
        empresa.agregarAvion(bronze2);
        empresa.agregarAvion(silver1);
        empresa.agregarAvion(silver2);
        empresa.agregarAvion(gold1);
        empresa.agregarAvion(gold2);

        //empresa.mostrarArregloAviones();

        /// CREANDO MENU INTERACTIVO
        int opcion=0;
        int opcion2=0;
        int opcion3=0;
        boolean salir = false;
/*
        System.out.println("MOSTRANDO");
        reserva.toString();
        reserva.toString();
        reserva.pasarValores();
        System.out.println("");
        reserva.toString();
*/


        while(!salir){
            System.out.println("1 | Registrarse");
            System.out.println("2 | Iniciar Reserva") ;

            try {

                System.out.println("Introduce una opcion: ");
                opcion = scanner.nextInt();

                switch(opcion){
                    case 1:

                        /// PROBANDO DE CREAR UN USUARIO EN DONDE SE AGREGE A EMPRESA, Y SE LO MUESTRE.

                        //Usuario usuario1 = new Usuario("","",0,0);
                        //usuario1.crearUsuaruio();

                        empresa.agregarUsuaruio(usuario1);
                        empresa.mostrarUsuarios();
                        salir = true;
                        break;

                         case 2:
                                    System.out.println("Ingrese los valores correspondientes para realizar la reserva");

                                    ///------------------------------------ORIGEN DESTINO ------------------------------
                                    System.out.println("Indique desde donde quiere partir...");
                                    int origen = reserva.selecOrigen();
                                    System.out.println("Indique hacia donde quiere ir...");
                                    int destino = reserva.selecDestino();

                                    if(origen == destino){
                                        System.out.println("El destino y el origen no pueden ser iguales");
                                    }

                                    System.out.println("Usted quiere salir desde : " + origen + "hacia :" + destino);

                                    ///-------------------------------CANT DE ACOMPAÑANTES----------------------------
                                    System.out.println("Indique la cantidad de acompañantes que viajan con usted");
                                    reserva.putCantAcompañantes();
                                    System.out.println("La cantidad de acompañantes que indico es: " + reserva.getCantAcompañantes());

                                    ///-------------------------------SELECCIONAR AVION --------------------------------
                                    System.out.println("Seleccione el avion que mejor se adapte a sus pretenciones de vuelo");
                                    empresa.mostrarArregloAviones();
                                    reserva.selecAvion();
                                    ///-------------------------------OBTENER DISTANCIA (FALTA)-------------------------
                             /*
                             System.out.println("Obteniendo distancia");
                                    int distancia = reserva.obtenerDistancia();
                                    System.out.println("" + distancia);
                             */
                                    ///------------------------------PASAR VALORES (PRUEBA)-----------------------------
                             /*
                                    reserva.pasarValores();
                                    System.out.println("Mostrando la reserva");
                                    System.out.println("Cantidad de acompañantes: "+reserva.getCantAcompañantes());
                                    System.out.println("Avion elejido: " + reserva.getSelecAvion());
                                */
                             ///*********************************************************************************

                        default:
                            System.out.println("Las opciones son 1 o 2");

                            }
                        } catch(InputMismatchException ex) {
                System.err.println("Debes introducir un numero");
                scanner.next();

                }
            }
        }
    }



