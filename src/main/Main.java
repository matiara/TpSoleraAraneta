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
            System.out.println("4 | Listar Vuelos");
            System.out.println("5 | Mostrar Clientes");

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
                        System.out.println("Usted no se encuentra registrado o el valor ingresado no es correcto ");
                        break;
                    }

                    reserva.corrarborrarDNI();
                    clearScreen();
                    ///FECHA
                    reserva.indicarFecha();

                    /// ORIGEN - DESTINO
                    int origen = reserva.selecOrigen();
                    clearScreen();
                    int destino = reserva.selecDestino();
                    clearScreen();
                    if(origen == destino){
                        System.out.println("El destino y el origen no pueden ser iguales");
                        break;
                    }

                    /// CANTIDAD ACOMPAÑANTES.
                    reserva.putCantAcompañantes();
                    System.out.println("La cantidad de acompañantes es: " + reserva.getCantAcompañantes());
                    clearScreen();

                    /// SELECCIONAR AVION.
                    empresa.mostrarAviones();
                    reserva.elegirAvion();

                    if(empresa.verificarDisponibilidad(reserva) || empresa.compararPasajerosAvion(reserva)){
                        System.out.println("Este avion esta reservado o excede la capacidad");
                        break;
                    }
                    clearScreen();
                    /// OBTENIENDO DISTANCIA.
                    System.out.println("Obteniendo distancia");
                    int distancia = reserva.obtenerDistancia();
                    System.out.println("" + distancia);
                    clearScreen();

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
                        if (confirmar < 1 || confirmar > 2){
                            check = 0;
                            System.out.println("Valor incorrecto, vuelva a ingresar el valor");
                        }
                    }

                    salir = true;
                    clearScreen();
                    break;

                    case 3:
                        clearScreen();
                        empresa.eliminarReserva(manejador);
                    break;

                    case 4:
                        clearScreen();
                        empresa.listarVuelos();
                    break;

                    case 5:
                        clearScreen();
                        empresa.mostrarClientes();
                    break;

                    default:
                        System.out.println("Las opciones son 1,2,3,4,5");
                        }

                }catch(InputMismatchException ex) {
                    System.err.println("Debes introducir un numero");
                    salir = true;
            }
        }
    }
    public static void clearScreen(){
        for(int i=0; i < 80 * 300;i++){
            System.out.println("\b");
        }
    }
}



