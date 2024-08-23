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

public class Biblioteca {
    private HashMap<Integer, Libro> libros;
    private HashMap<Integer, Usuario> usuarios;

    public Biblioteca() {
        this.libros = new HashMap<>();
        this.usuarios = new HashMap<>();
    }

    public void agregarLibro(Libro libro) {
        libros.put(libro.getId(), libro);
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.put(usuario.getId(), usuario);
    }

    public void prestarLibro(int usuarioId, int libroId) {
        Usuario usuario = usuarios.get(usuarioId);
        Libro libro = libros.get(libroId);
        if (usuario != null && libro != null) {
            usuario.prestarLibro(libro);
        } else {
            System.out.println("Usuario o libro no encontrado.");
        }
    }

    public void devolverLibro(int usuarioId, int libroId) {
        Usuario usuario = usuarios.get(usuarioId);
        Libro libro = libros.get(libroId);
        if (usuario != null && libro != null) {
            usuario.devolverLibro(libro);
        } else {
            System.out.println("Usuario o libro no encontrado.");
        }
    }
}
