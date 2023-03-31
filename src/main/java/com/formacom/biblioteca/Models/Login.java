package com.formacom.biblioteca.Models;

import com.formacom.biblioteca.DB.Database;

import java.sql.*;

public class Login {

    public static Usuario login(String nombre, String dni){
        String consulta="select * from usuarios where nombre=? and dni=?";
        Usuario usuario=new Usuario();
        try {
            Connection conn= Database.getConnection();
            PreparedStatement stm=conn.prepareStatement(consulta);
            stm.setString(1,nombre);
            stm.setString(2,dni);
            ResultSet rs=stm.executeQuery();
            if(rs.next()){
                usuario.setIdusuario(rs.getInt("idusuario"));
                usuario.setDni(rs.getString("dni"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellidos(rs.getString("apellidos"));
                usuario.setDomicilio(rs.getString("domicilio"));
                usuario.setTelefono(rs.getString("telefono"));
                usuario.setEmail(rs.getString("email"));
                stm.close();
                conn.close();
                return usuario;
            }else{
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static Usuario register(String dni, String nombre, String apellidos, String domicilio,
                                    String telefono, String email){
        String consulta="insert into usuarios (dni,nombre, apellidos, domicilio, telefono, email) values (?,?,?,?,?,?)";
        int idUsuario;
        Connection conn=Database.getConnection();
        try {
            PreparedStatement stm=conn.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
            stm.setString(1,dni);
            stm.setString(2,nombre);
            stm.setString(3,apellidos);
            stm.setString(4,domicilio);
            stm.setString(5,telefono);
            stm.setString(6,email);
            int affectedRows=stm.executeUpdate();
            if(affectedRows>0){
                ResultSet rs=stm.getGeneratedKeys();
                Usuario usuario=null;
                if(rs.next()){
                    usuario.setIdusuario(rs.getInt("idusuario"));
                    usuario.setDni(rs.getString("dni"));
                    usuario.setNombre(rs.getString("nombre"));
                    usuario.setApellidos(rs.getString("apellidos"));
                    usuario.setDomicilio(rs.getString("domicilio"));
                    usuario.setTelefono(rs.getString("telefono"));
                    usuario.setEmail(rs.getString("email"));
                    stm.close();
                    conn.close();
                }
                return usuario;
            }else{
                System.out.println("Error en el proceso de registro");
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
