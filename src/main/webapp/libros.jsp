<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Libros</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <h1>Libros - jstl</h1>
    <hr>
    <form method="post" class="col-6">
        <div class="form-group">
            <label for="codigo" class="form-label">Código</label>
            <input type="text" name="codigo" id="codigo" class="form-control">
        </div>
        <div class="form-group">
            <label for="titulo" class="form-label">Título</label>
            <input type="text" name="titulo" id="titulo" class="form-control">
        </div>
        <div class="form-group">
            <label for="genero" class="form-label">Género</label>
            <input type="text" name="genero" id="genero" class="form-control">
        </div>
        <div class="form-group">
            <input type="submit" value="Nuevo libro" class="btn btn-success">
        </div>
    </form>

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
            <c:forEach items="${libros}" var="libro">
                <tr>
                    <td>${libro.id}</td>
                    <td>${libro.codigo}</td>
                    <td>${libro.titulo}</td>
                    <td>${libro.genero}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
