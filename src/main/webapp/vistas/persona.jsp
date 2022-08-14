
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Datos</title>
    <jsp:include page="/templates/head.jsp"/>
</head>
<body style="background: lightblue">
<br>
<br>
<div class="container">
    <div class="row">
        <h3 style="color: white ; text-align: center;">Listado de Personas</h3>
    </div>

</div>
<div CLASS="container mt-5">
    <div class="row">
        <div class="col-12">
            <!--<c:if test="${param['result']}">
                <p><c:out value="${param['message']}"></c:out></p>
            </c:if>-->
            <div class="card">
                <div class="card-header"  style="background: lightskyblue; border-top: 0">
                    <div class="row">
                        <div class="col-6">Personas</div>
                        <div class="col-6 text-end">
                            <a href="añadir" class="btn btn-outline-success btn-sm">Registrar Nueva persona</a>
                        </div>
                    </div>
                </div>
                <div class="card-body">
                    <table class="table table-sm table-hover datatable">
                        <thead>
                        <tr>
                            <td>#</td>
                            <td>Name</td>
                            <td>Surname</td>
                            <td>Curp</td>
                            <td>Birthday</td>
                            <td>Acciones</td>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="persona" items="${personas}" varStatus="status">
                            <tr>
                                <td>
                                    <c:out value="${status.count}"></c:out>
                                </td>
                                <td>
                                    <c:out value="${persona.name}"></c:out>
                                </td>
                                <td>
                                    <c:out value="${persona.surname}"></c:out>
                                </td>
                                <td>
                                    <c:out value="${persona.curp}"></c:out>
                                </td>
                                <td>
                                    <c:out value="${persona.birthday}"></c:out>
                                </td>
                                <td>
                                    <a href="editar?id=${persona.id}" class="btn btn-success btn-sm"><i data-feather="edit"></i></a>
                                    <form action="persona" method="post">
                                        <input type="hidden" name="id" value="${persona.id}">
                                        <button type="submit" class="btn btn-danger btn-sm"> <i data-feather="trash-2"></i></button>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

        </div>

    </div>
    <jsp:include page="/templates/footer.jsp"/>

</div>
<script>
    $(document).ready(() => {
        $('.datatable').DataTable({
            language: {
                url: 'https://cdn.datatables.net/plug-ins/1.11.5/i18n/es-MX.json',
            },
        });
        document.getElementById("loaderDiv").style.display = "none";
    })
    feather.replace();
</script>
</body>
</html>
