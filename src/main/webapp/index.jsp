<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <jsp:include page="templates/head.jsp"/>
</head>
<body>
<div class="container">
    <h1 style="color: dodgerblue; text-align: center"><%= "CRUD PERSONA!" %></h1>
</div>

<br/>
<div class="container">
    <div class="container">
        <div class="row">
            <div class="col-12">
                <table class="table table-sm table-hover datatable">
                    <thead>
                    <tr>
                        <td>Nombre</td>
                        <td>Apellidos</td>
                        <td>Cuatrimestre</td>
                        <td>Grupo</td>
                        <td>Ir a Crud</td>
                    </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Brayan</td>
                            <td>Reynoso Macedo</td>
                            <td>3</td>
                            <td>C</td>
                            <td><a href="persona" class="btn btn-success">Ver Registros de Personas</a></td>
                        </tr>
                    </tbody>
                </table>

            </div>
        </div>
</div>
<jsp:include page="templates/footer.jsp"/>
</body>
</html>