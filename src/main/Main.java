package main;

import clasesextra.Bronze;
import clasesextra.Gold;
import clasesextra.Silver;
import com.company.Empresa;
import com.company.Motor;
import com.company.Usuario;
import java.util.InputMismatchException;
import java.util.Scanner;
import json.ManejadorJson;
import reserva.Lugares;
import reserva.Reserva;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        ManejadorJson manejador = new ManejadorJson();
        System.out.println("Empresa");
        Empresa empresa = new Empresa("Aerotaxi Club");
        Scanner scanner = new Scanner(System.in);
        Reserva reserva = new Reserva(0, (Lugares)null, (Lugares)null, 0, 0, 0);
        reserva.mostrarListaUsuarios();
        Bronze bronze1 = new Bronze(1000.0F, 150.0F, 3, 400.0F, Motor.reaccion);
        Bronze bronze2 = new Bronze(1100.0F, 150.0F, 3, 400.0F, Motor.reaccion);
        Silver silver1 = new Silver(1250.0F, 200.0F, 5, 500.0F, Motor.helice);
        Silver silver2 = new Silver(1250.0F, 200.0F, 5, 500.0F, Motor.helice);
        Gold gold1 = new Gold(1500.0F, 300.0F, 8, 750.0F, Motor.pistones);
        Gold gold2 = new Gold(1500.0F, 350.0F, 8, 800.0F, Motor.pistones);
        empresa.agregarAvion(bronze1);
        empresa.agregarAvion(bronze2);
        empresa.agregarAvion(silver1);
        empresa.agregarAvion(silver2);
        empresa.agregarAvion(gold1);
        empresa.agregarAvion(gold2);
        int opcion = false;
        int opcion2 = false;
        int opcion3 = false;
        boolean salir = false;

        while(!salir) {
            System.out.println("1 | Registrarse");
            System.out.println("2 | Iniciar Reserva");

            try {
                System.out.println("Introduce una opcion: ");
                int opcion = scanner.nextInt();
                switch(opcion) {
                case 1:
                    Usuario nuevoUsuario = new Usuario();
                    nuevoUsuario.crearUsuario();
                    empresa.agregarUsuario(nuevoUsuario);
                    manejador.writeUser(nuevoUsuario);
                    salir = true;
                    continue;
                case 2:
                    while(!salir) {
                        System.out.println("1 | OPCION");
                        System.out.println("2 | Seleccionar Origen-Destino");
                        System.out.println("3 | Cantidad Acompañantes");
                        System.out.println("4 | Seleccionar Avion");
                        System.out.println("5 | Costo Total");
                        System.out.println("6 | Pasar valores (Temporal)");
                        System.out.println("Ingrese una opcion: ");
                        int opcion2 = scanner.nextInt();
                        switch(opcion2) {
                        case 1:
                            System.out.println("ESTE ES EL SUBMENU PARTE 1");
                            break;
                        case 2:
                            int origen = reserva.selecOrigen();
                            int destino = reserva.selecDestino();
                            if (origen == destino) {
                                System.out.println("El destino y el origen no pueden ser iguales");
                            }

                            if (origen == 1) {
                            }

                            System.out.println("Usted quiere salir desde : " + origen + "hacia :" + destino);
                            break;
                        case 3:
                            reserva.putCantAcompañantes();
                            System.out.println("La cantidad de acompañantes es: " + reserva.getCantAcompañantes());
                            break;
                        case 4:
                            System.out.println("Seleccionar avion");
                            empresa.mostrarArregloAviones();
                            reserva.selecAvion();
                            break;
                        case 5:
                            System.out.println("Obteniendo distancia");
                            int distancia = reserva.obtenerDistancia();
                            System.out.println(distancia.makeConcatWithConstants<invokedynamic>(distancia));
                            break;
                        case 6:
                            reserva.pasarValores();
                            System.out.println("Mostrando la reserva");
                            System.out.println("Cantidad de acompañantes: " + reserva.getCantAcompañantes());
                            System.out.println("Avion elejido: " + reserva.getSelecAvion());
                        }
                    }
                }

                System.out.println("Las opciones son 1 o 2");
            } catch (InputMismatchException var19) {
                System.err.println("Debes introducir un numero");
                scanner.next();
            }
        }

    }
}


