package com.formacom.biblioteca.Models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import com.formacom.biblioteca.DB.Database;

public class Biblioteca {

    public List<Libro> libros;
    public String toString() {
        return "Biblioteca{" +
                "libros=" + libros +
                '}';
    }
    public Biblioteca() {
        this.libros=new ArrayList<>();
        Connection conn= Database.getConnection();
        if(conn!=null){
            String consulta="select * from libros";
            try {
                Statement stm=conn.createStatement();
                ResultSet rs=stm.executeQuery(consulta);
                while(rs.next()){
                    Libro libro=new Libro();
                    libro.setId(rs.getInt("idlibro"));
                    libro.setCodigo(rs.getString("codigo"));
                    libro.setTitulo(rs.getString("titulo"));
                    libro.setGenero(rs.getString("genero"));
                    this.libros.add(libro);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }else{
            System.out.println("Error al conectarse a la BBDD");
        }
    }

    public void addLibro(String codigo, String titulo,String genero){
        String consulta="insert into libros (codigo,titulo,genero) values (?,?,?)";
        int idLibro;
        Connection conn=Database.getConnection();
        try {
            PreparedStatement stm=conn.prepareStatement(consulta,Statement.RETURN_GENERATED_KEYS);
            stm.setString(1,codigo);
            stm.setString(2,titulo);
            stm.setString(3,genero);
            int affectedRows=stm.executeUpdate();
            if(affectedRows>0){
                ResultSet rs=stm.getGeneratedKeys();
                if(rs.next()){
                    idLibro=rs.getInt(1);
                    Libro libro=new Libro(idLibro,codigo,titulo,genero);
                    this.libros.add(libro);
                }
            }else{
                System.out.println("Error al insertar");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeLibro(Libro libro){
        String consulta="delete from libros where idlibro =?";
        try {
            Connection conn=Database.getConnection();
            PreparedStatement stm=conn.prepareStatement(consulta);
            stm.setInt(1,libro.getId());
            int affectedRows=stm.executeUpdate();
            if(affectedRows>0){
                //libro eliminado
                this.libros.remove(libro);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Libro searchLibroByCodigo(String codigo){
        String consulta="select * from libros where codigo=?";
        try {
            Connection conn=Database.getConnection();
            PreparedStatement stm=conn.prepareStatement(consulta);
            stm.setString(1,codigo);
            ResultSet rs=stm.executeQuery();
            if(rs.next()){
                Libro libro=new Libro();
                libro.setId(rs.getInt("idlibro"));
                libro.setCodigo(rs.getString("codigo"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setGenero(rs.getString("genero"));
                return libro;
            }else{
                return  null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Libro> searchLibroByGenero(String genero){
        List<Libro> libroList=new ArrayList<>();

        for (Libro libro : this.libros) {
            if (libro.getGenero().equals(genero)) {
                libroList.add(libro);
            }
        }

        return libroList;
    }

    public List<Libro> getAllLibros(){
        List<Libro> libroList=new ArrayList<>();
        String consulta="select * from libros";
        try {
            Connection conn=Database.getConnection();
            Statement stm=conn.createStatement();
            ResultSet rs=stm.executeQuery(consulta);
            while(rs.next()){
                Libro libro=new Libro();
                libro.setId(rs.getInt("idlibro"));
                libro.setCodigo(rs.getString("codigo"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setGenero(rs.getString("genero"));
                libroList.add(libro);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  libroList;
    }

}
