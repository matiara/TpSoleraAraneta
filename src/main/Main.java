package main;

import com.company.Empresa;
import com.company.Usuario;
import reserva.Reserva;
import json.ManejadorJson;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    Empresa empresa = new Empresa("Aerotaxi Club"); /// CREACION DE EMPRESA
    ManejadorJson manejador = new ManejadorJson(empresa);


        /// CREANDO MENU INTERACTIVO
        int opcion=0;

        boolean salir = false;

        while( salir == false){
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
                    manejador.writeUser(nuevoUsuario);
                    salir = true;
                    break;

                    case 2:

                    ///CREANDO RESERVA
                    Reserva reserva = new Reserva();


                    ///BUSCAR DNI
                    int dniBuscado = empresa.buscarDni();
                    if (dniBuscado == 1){
                        System.out.println("Por favor ingrese lo valores para realizar la reserva");
                    }
                    if(dniBuscado == 0){
                        System.out.println("Usted no se encuentra registrado");
                        break;
                    }


                    ///FECHA
                    reserva.indicarFecha();



                    /// ORIGEN - DESTINO
                    int origen = reserva.selecOrigen();
                    int destino = reserva.selecDestino();

                    if(origen == destino){
                        System.out.println("El destino y el origen no pueden ser iguales");
                    }

                    /// CANTIDAD ACOMPAÑANTES.
                    reserva.putCantAcompañantes();
                    System.out.println("La cantidad de acompañantes es: " + reserva.getCantAcompañantes());

                    /// SELECCIONAR AVION.
                    empresa.mostrarAviones();
                    reserva.elegirAvion();

                    /// OBTENIENDO DISTANCIA.
                    System.out.println("Obteniendo distancia");
                    int distancia = reserva.obtenerDistancia();
                    System.out.println("" + distancia);

                    ///MOSTRANDO LOS DATOS DE LA RESERVA
                    int confirmar=0;
                    int check=0;

                    while (check == 0){
                        System.out.println("Los datos de la reserva son:");
                        reserva.calcularCosto(empresa.getListaAviones());
                        reserva.mostrarValores();

                        System.out.println("¿Confirmar Reserva?");
                        System.out.println("1 - SI");
                        System.out.println("2 - NO");
                        confirmar = scanner.nextInt();

                        if (confirmar == 1){
                            empresa.agregarReserva(reserva);
                            manejador.writeReserva(reserva);
                            System.out.println("Su reserva a sido cargada");
                            check = 1;
                        }
                        if(confirmar == 2){
                            System.out.println("Acaba de cancelar la reserva");
                            check = 1;
                        }

                        if (confirmar <1 || confirmar > 2){
                            check = 0;
                            System.out.println("Valor incorrecto, vuelva a ingresar el valor");
                        }
                    }

                    salir = true;
                    break;

                    case 3:
                        /// CANCELAR RESERVA:
                        empresa.eliminarReserva();





                    break;

                    default:
                        System.out.println("Las opciones son 1,2 o 3");
                        }

                }catch(InputMismatchException ex) {
                    System.err.println("Debes introducir un numero");
                    salir = true;
            }
        }
    }
}



