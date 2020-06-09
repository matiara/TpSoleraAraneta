package com.company;

import java.util.Scanner;

public class Usuario {
    private String nombre;
    private String apellido;
    private int dni;
    private int edad;

    public Usuario(String nombre, String apellido, int dni, int edad){
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
    }

    Scanner reader = new Scanner(System.in);

    /// SE LE PIDE AL USUARIO QUE INGRESE LOS VALORES PARA CREAR EL USUARIO | DEJÉ QUE MUESTRE LOS VALORES QUE INGRESA PARA PODER VER SI ESTAN CORRECTOS

    /// VALIDACIONES: en caso de que no se cumplan las validaciones se le asigna un 0 a la variable verificacion para que no salga del bucle.

    public void crearUsuaruio(){
        System.out.println("Ingrese los datos correspondientes: ");
        int verificacion =0;

        while(verificacion == 0){

        System.out.println("Nombre:");
        this.nombre = reader.next();
        System.out.println("" +this.nombre);

        System.out.println("Apellido");
        this.apellido = reader.next();
        System.out.println("" + this.apellido);

        System.out.println("DNI");
        this.dni = reader.nextInt();
        System.out.println("" + this.dni);

        System.out.println("Edad");
        this.edad = reader.nextInt();
        System.out.println("" + this.edad);

        verificacion = 1;

        if(nombre.equals(apellido)){
            System.out.println("El nombre y el apellido coinciden, vuelva a ingresar los valores");
            verificacion = 0;
        }

        if(edad <18){
            System.out.println("No pudimos registrarte, debes ser mayor de edad para hacerlo");
            verificacion = 0;
        }
        if(edad >85){
            System.out.println("Por seguridad las personas mayores de 85 años no pueden registrarse en nuestra empresa");
            verificacion = 0;
        }
        if(nombre.length() <= 2 || apellido.length() <= 2){
            System.out.println("Hay valores en su nombre o apellido que no son correctos");
            verificacion = 0;
        }
        if(nombre.length() > 15 || apellido.length() > 15){
            System.out.println("Hay valores en su nombre o apellido que no son correctos");
            verificacion = 0;
        }
        if(dni <30000000 || dni> 70000000){
            System.out.println("Los valores ingresados del DNI, no son validos");
            verificacion = 0;
        }


        }
    }















///------------------------- GETS AND SETS -----------------------------------------
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return " Nombre: " + nombre +
                " Apellido: " + apellido +
                " Dni:" + dni +
                " Edad:" + edad;
    }

    ///-------------------------------------------------------------------------------------











}
