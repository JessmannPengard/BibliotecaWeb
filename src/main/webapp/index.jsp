<%@ page import="com.formacom.biblioteca.Models.Libro" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Biblioteca</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <h1>Libros</h1>
    <%
        List<Libro> libroList= (List<Libro>) request.getAttribute("libros");
    %>
    <hr>

    <table class="table table-dark">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Código</th>
            <th scope="col">Título</th>
            <th scope="col">Género</th>
        </tr>
        </thead>
        <tbody>
        <%
            for (int i = 0; i < libroList.size(); i++) {
                Libro lib=libroList.get(i);
        %>
        <tr>
            <td><%=lib.getId()%></td>
            <td><%=lib.getCodigo()%></td>
            <td><%=lib.getTitulo()%></td>
            <td><%=lib.getGenero()%></td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
</body>
</html>