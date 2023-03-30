package com.formacom.biblioteca.Controllers;

import java.io.*;
import java.util.List;

import com.formacom.biblioteca.Models.Biblioteca;
import com.formacom.biblioteca.Models.Libro;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "indexServlet", value = "/main")
public class IndexServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Biblioteca biblioteca=new Biblioteca();
        List<Libro> libros = biblioteca.getAllLibros();

        try {
            request.setAttribute("libros",libros);
            request.getRequestDispatcher("index.jsp").forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }

    public void destroy() {
    }
}