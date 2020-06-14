package com.company;

import java.util.Scanner;

public class Usuario {
    private String nombre;
    private String apellido;
    private int dni;
    private int edad;
    Scanner reader;

    public Usuario() {
        this.reader = new Scanner(System.in);
    }

    public void crearUsuario() {
        System.out.println("Ingrese los datos correspondientes: ");
        boolean verificacion = false;

        while(true) {
            do {
                if (verificacion) {
                    return;
                }

                System.out.println("Nombre:");
                this.nombre = this.reader.next();
                System.out.println(this.nombre.makeConcatWithConstants<invokedynamic>(this.nombre));
                System.out.println("Apellido");
                this.apellido = this.reader.next();
                System.out.println(this.apellido.makeConcatWithConstants<invokedynamic>(this.apellido));
                System.out.println("DNI");
                this.dni = this.reader.nextInt();
                System.out.println(this.dni.makeConcatWithConstants<invokedynamic>(this.dni));
                System.out.println("Edad");
                this.edad = this.reader.nextInt();
                System.out.println(this.edad.makeConcatWithConstants<invokedynamic>(this.edad));
                verificacion = true;
                if (this.nombre.equals(this.apellido)) {
                    System.out.println("El nombre y el apellido coinciden, vuelva a ingresar los valores");
                    verificacion = false;
                }

                if (this.edad < 18) {
                    System.out.println("No pudimos registrarte, debes ser mayor de edad para hacerlo");
                    verificacion = false;
                }

                if (this.edad > 85) {
                    System.out.println("Por seguridad las personas mayores de 85 años no pueden registrarse en nuestra empresa");
                    verificacion = false;
                }

                if (this.nombre.length() <= 2 || this.apellido.length() <= 2) {
                    System.out.println("Hay valores en su nombre o apellido que no son correctos");
                    verificacion = false;
                }

                if (this.nombre.length() > 15 || this.apellido.length() > 15) {
                    System.out.println("Hay valores en su nombre o apellido que no son correctos");
                    verificacion = false;
                }
            } while(this.dni >= 30000000 && this.dni <= 70000000);

            System.out.println("Los valores ingresados del DNI, no son validos");
            verificacion = false;
        }
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return this.dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String toString() {
        return " Nombre: " + this.nombre + " Apellido: " + this.apellido + " Dni:" + this.dni + " Edad:" + this.edad;
    }
}
