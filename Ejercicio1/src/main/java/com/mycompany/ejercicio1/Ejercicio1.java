/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio1;

/**
 *
 * @author Jairo
 */
public class Ejercicio1 {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        // Agregar libros a la biblioteca
        Libro libro1 = new Libro(1, "1984", "George Orwell");
        Libro libro2 = new Libro(2, "El Hobbit", "J.R.R. Tolkien");
        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);

        // Agregar usuarios a la biblioteca
        Usuario usuario1 = new Usuario(1, "Juan Perez");
        Usuario usuario2 = new Usuario(2, "Maria Gomez");
        biblioteca.agregarUsuario(usuario1);
        biblioteca.agregarUsuario(usuario2);

        // Prestar libros
        biblioteca.prestarLibro(1, 1); // Juan Perez presta "1984"
        biblioteca.prestarLibro(2, 2); // Maria Gomez presta "El Hobbit"

        // Mostrar libros prestados por cada usuario
        usuario1.mostrarLibrosPrestados();
        usuario2.mostrarLibrosPrestados();

        // Devolver libros
        biblioteca.devolverLibro(1, 1); // Juan Perez devuelve "1984"
        biblioteca.devolverLibro(2, 2); // Maria Gomez devuelve "El Hobbit"

        // Mostrar libros prestados después de devolver
        usuario1.mostrarLibrosPrestados();
        usuario2.mostrarLibrosPrestados();
    }
}
