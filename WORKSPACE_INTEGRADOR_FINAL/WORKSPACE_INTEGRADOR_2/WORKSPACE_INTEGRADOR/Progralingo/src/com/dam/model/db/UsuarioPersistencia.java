package com.dam.model.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.dam.model.data.Usuario;

public class UsuarioPersistencia {

    private AccesoDB acceso;

    public UsuarioPersistencia() {
        acceso = new AccesoDB();
    }

    public int registrarUsuario(Usuario usuario) {
        int res = 0;
        String query = "INSERT INTO " + UsuarioContract.NOM_TABLA + " ("
                + UsuarioContract.COL_NOMBRE + ", " + UsuarioContract.COL_CONTRASEÑA + ") VALUES (?, ?)";

        try (Connection con = acceso.getConexion();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setString(1, usuario.getNombre());
            pstmt.setString(2, usuario.getContraseña());
            res = pstmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            res = -1;
        }
        return res;
    }

    public String validarUsuario(Usuario user) {
        String query = "SELECT " + UsuarioContract.COL_NOMBRE  + ", " + UsuarioContract.COL_CONTRASEÑA + " FROM " + UsuarioContract.NOM_TABLA 
                + " WHERE " + UsuarioContract.COL_NOMBRE + " = ?";
        
        String resultado = "";
        
        try (Connection con = acceso.getConexion();
             PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setString(1, user.getNombre());
            
            try (ResultSet rslt = stmt.executeQuery()) {
                if (rslt.next()) {
                    String pwd = rslt.getString(UsuarioContract.COL_CONTRASEÑA);
                    
                    if (pwd.equals(user.getContraseña())) {
                        resultado = "Acceso permitido";
                    } else {
                        resultado = "Contraseña incorrecta";
                    }
                } else {
                    resultado = "El usuario no se encuentra en la base de datos";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultado = "ERROR: Póngase en contacto con el Politecnico";
        }
        return resultado;
    }

    public int actualizarContrasena(String nombreUsuario, String antiguaContrasena, String nuevaContrasena) {
        int res = 0;
        String querySelect = "SELECT " + UsuarioContract.COL_CONTRASEÑA + " FROM " + UsuarioContract.NOM_TABLA
                + " WHERE " + UsuarioContract.COL_NOMBRE + " = ?";
        String queryUpdate = "UPDATE " + UsuarioContract.NOM_TABLA + " SET " + UsuarioContract.COL_CONTRASEÑA + " = ?"
                + " WHERE " + UsuarioContract.COL_NOMBRE + " = ?";

        try (Connection con = acceso.getConexion();
             PreparedStatement pstmtSelect = con.prepareStatement(querySelect);
             PreparedStatement pstmtUpdate = con.prepareStatement(queryUpdate)) {

            pstmtSelect.setString(1, nombreUsuario);
            try (ResultSet rslt = pstmtSelect.executeQuery()) {
                if (rslt.next()) {
                    String currentPassword = rslt.getString(UsuarioContract.COL_CONTRASEÑA);
                    if (currentPassword.equals(antiguaContrasena)) {
                        pstmtUpdate.setString(1, nuevaContrasena);
                        pstmtUpdate.setString(2, nombreUsuario);
                        res = pstmtUpdate.executeUpdate();
                    } else {
                        res = -1;  // Contraseña antigua incorrecta
                    }
                } else {
                    res = -2;  // Usuario no encontrado
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            res = -3;  // Error en la actualización
        }
        return res;
    }
}
