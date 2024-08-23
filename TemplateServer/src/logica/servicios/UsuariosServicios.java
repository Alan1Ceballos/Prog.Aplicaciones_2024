/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.servicios;

import Persistencia.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import logica.Clases.Usuario;

/**
 *
 * @author LucasCiceri
 */
public class UsuariosServicios {

    public UsuariosServicios() {
    }

    private Connection conexion = new ConexionDB().getConexion();

    public Usuario getUser(String email) throws SQLException {
        try {
            Usuario resultado = new Usuario();
            PreparedStatement status = conexion.prepareStatement("SELECT * FROM usuarios");
            ResultSet rs = status.executeQuery();
            while (rs.next()) {
                String mail = rs.getString("email");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String password = rs.getString("password");
                if (mail.equals(email)) {
                    resultado = new Usuario(mail, nombre, apellido, password);
                };
            }
            rs.close();
            return resultado;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<Usuario> getUsers() {
        ArrayList<Usuario> resultado = new ArrayList<Usuario>();

        try {
            PreparedStatement status = conexion.prepareStatement("SELECT * FROM usuarios");
            ResultSet rs = status.executeQuery();
            while (rs.next()) {
                resultado.add(new Usuario(rs.getString("nombre"), rs.getString("apellido"), rs.getString("email")));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return resultado;
    }

    public boolean validateEmail(String email) {

        try {
            PreparedStatement status = conexion.prepareStatement("SELECT email FROM usuarios WHERE email = ?");
            status.setString(1, email);

            ResultSet set = status.executeQuery();
            boolean existe = set.next();

            set.close();
            return existe;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

    }

    public void insertarUsuarios(String nombre, String apellido, String email) {

        try {
            PreparedStatement status = conexion.prepareCall("INSERT INTO usuarios (nombre, apellido, email, password) VALUES (?,?,?,?)");
            status.setString(1, nombre);
            status.setString(2, apellido);
            status.setString(3, email);
            status.setString(4, "DEFAULT");

            int filasInsertadas = status.executeUpdate();

            if (filasInsertadas > 0) {
                System.out.println("Nuevo Usuario creado");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void actualizarDatosUsuario(String nombre, String apellido, String email) {
        try {
            PreparedStatement status = conexion.prepareCall("UPDATE usuarios SET nombre = ?, apellido = ? WHERE email = ?");
            status.setString(1, nombre);
            status.setString(2, apellido);
            status.setString(3, email);

            int filasActualizadas = status.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("Usuario actualizado");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void eliminarDatosUsuario(String email) {

        try {
            PreparedStatement status = conexion.prepareStatement("DELETE FROM usuarios WHERE email = ?");
            status.setString(1, email);

            int filasEliminadas = status.executeUpdate();

            if (filasEliminadas > 0) {
                System.out.println("Usuario eliminado");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
