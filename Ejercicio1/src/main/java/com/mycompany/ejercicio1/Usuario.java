/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio1;
/**
 *
 * @author macro
 */
import java.util.HashMap;

public class Usuario {
    private int id;
    private String nombre;
    private HashMap<Integer, Libro> librosPrestados;

    public Usuario(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.librosPrestados = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public HashMap<Integer, Libro> getLibrosPrestados() {
        return librosPrestados;
    }

    public void prestarLibro(Libro libro) {
        if (!libro.isPrestado()) {
            librosPrestados.put(libro.getId(), libro);
            libro.prestar();
        } else {
            System.out.println("El libro ya está prestado.");
        }
    }

    public void devolverLibro(Libro libro) {
        if (librosPrestados.containsKey(libro.getId())) {
            librosPrestados.remove(libro.getId());
            libro.devolver();
        } else {
            System.out.println("El usuario no tiene este libro prestado.");
        }
    }

    public void mostrarLibrosPrestados() {
        if (librosPrestados.isEmpty()) {
            System.out.println("No hay libros prestados.");
        } else {
            System.out.println("Libros prestados por " + nombre + ":");
            for (Libro libro : librosPrestados.values()) {
                System.out.println(libro.getTitulo() + " por " + libro.getAutor());
            }
        }
    }
}
