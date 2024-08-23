/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.Controladores;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import logica.Clases.Usuario;
import logica.Interfaces.IControladorUsuario;
import logica.servicios.UsuariosServicios;

/**
 *
 * @author LucasCiceri
 */
public class ControladorUsuario implements IControladorUsuario {

    private Map<String, Usuario> Usuarios;
    private UsuariosServicios servicioUsuarios;
    private static ControladorUsuario instancia;

    public ControladorUsuario() {
        this.servicioUsuarios = new UsuariosServicios();
    }

    public static ControladorUsuario getInstance() {
        if (instancia == null) {
            instancia = new ControladorUsuario();
        }
        return instancia;
    }

    public ArrayList<Usuario> listUsers() {
        ArrayList<Usuario> usuarios = servicioUsuarios.getUsers();
        return usuarios;
    }

    public boolean login(String email, String password) {
        try {
            Usuario usuario = (Usuario) servicioUsuarios.getUser(email);
            System.out.println("usu: " + usuario);
            if (usuario == null) {
                return false;
            } else if (password.equals(usuario.getPassword())) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            Logger.getLogger(ControladorUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public boolean crearUsuario(String nombre, String apellido, String email) {
        if (this.servicioUsuarios.validateEmail(email)) {
            JOptionPane.showMessageDialog(null, "El email ya existe. Por favor, ingresa un email diferente.", "Alerta", JOptionPane.WARNING_MESSAGE);
            return false;
        } else {
            this.servicioUsuarios.insertarUsuarios(nombre, apellido, email);
            JOptionPane.showMessageDialog(null, "Usuario creado con éxito.", "Información", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
    }

    @Override
    public boolean actualizarUsuario(String nombre, String apellido, String email) {
        if (this.servicioUsuarios.validateEmail(email)) {
            this.servicioUsuarios.actualizarDatosUsuario(nombre, apellido, email);
            JOptionPane.showMessageDialog(null, "Usuario actualizado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "El email no existe.", "Alerta", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    @Override
    public boolean eliminarUsuario(String email) {
        if (this.servicioUsuarios.validateEmail(email)) {
            this.servicioUsuarios.eliminarDatosUsuario(email);
            JOptionPane.showMessageDialog(null, "Usuario eliminado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            return true; // El email existía y fue eliminado
        } else {
            JOptionPane.showMessageDialog(null, "El email no existe.", "Alerta", JOptionPane.WARNING_MESSAGE);
            return false; // El email no existía
        }
    }

}
