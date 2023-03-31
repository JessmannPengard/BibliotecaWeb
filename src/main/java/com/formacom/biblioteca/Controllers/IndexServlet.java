package com.formacom.biblioteca.Controllers;

import java.io.*;
import java.util.List;

import com.formacom.biblioteca.Models.Biblioteca;
import com.formacom.biblioteca.Models.Libro;
import com.formacom.biblioteca.Models.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "indexServlet", value = "/main")
public class IndexServlet extends HttpServlet {

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession sesion=request.getSession(true);
        if (sesion.getAttribute("usuario")!=null) {

            Biblioteca biblioteca = new Biblioteca();
            List<Libro> libros = biblioteca.getAllLibros();
            Usuario usuario= (Usuario) sesion.getAttribute("usuario");
            try {
                request.setAttribute("usuario", usuario);
                request.setAttribute("libros", libros);
                request.getRequestDispatcher("libros.jsp").forward(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            }
        }else{
            response.sendRedirect("login");
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String codigo=request.getParameter("codigo");
        String titulo=request.getParameter("titulo");
        String genero=request.getParameter("genero");
        Biblioteca biblio = new Biblioteca();
        biblio.addLibro(codigo,titulo,genero);
        response.sendRedirect("main");
    }

    public void destroy() {
    }
}