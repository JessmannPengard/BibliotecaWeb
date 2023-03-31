package com.formacom.biblioteca.Controllers;

import com.formacom.biblioteca.Models.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import static com.formacom.biblioteca.Models.Login.login;

@WebServlet(name = "loginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            request.getRequestDispatcher("login.jsp").forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombre=req.getParameter("nombre");
        String dni=req.getParameter("dni");
        Usuario usuario= login(nombre,dni);
        if (usuario!=null){
            HttpSession sesion=req.getSession(true);
            sesion.setAttribute("usuario",usuario);
            resp.sendRedirect("main");
        }else {
            req.setAttribute("msg","El usuario no existe");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }
}
