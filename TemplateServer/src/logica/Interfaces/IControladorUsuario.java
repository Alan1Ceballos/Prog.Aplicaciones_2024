/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.Interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import logica.Clases.Usuario;

/**
 *
 * @author LucasCiceri
 */
public interface IControladorUsuario {

    public abstract ArrayList<Usuario> listUsers();

    public abstract boolean login(String email, String password);
    
    public abstract boolean crearUsuario(String nombre, String apellido, String email);
    
    public abstract boolean actualizarUsuario(String nombre, String apellido, String email);
    
    public abstract boolean eliminarUsuario(String email);

}
