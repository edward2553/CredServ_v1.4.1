<%@page import="com.credserv.entidades.Usuario"%>

<%
    HttpSession ss = (HttpSession) request.getSession();
    Usuario usuario = (Usuario) ss.getAttribute("usuario");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

    </head>
    <body>
        <a href="MenuPrincipal.jsp"></a>

        <nav class="navbar">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar_title" href="Datos_servicio.jsp">Serviteca CredServ</a>
                </div>
                <ul class="nav">
                    <li class="active"><a class="navbar_item" href="Datos_servicio.jsp">Inicio</a></li>
                    <TABLE border="0" cellpadding="0" cellspacing="0" class="lineaHorizontal"> 
                        <TR><TD bgcolor="#000000" width="2"></TD> 
                            <TD width="5"></TD> 
                            <TD width="*"><BR></TD></TR> 
                    </TABLE>
                    <li class="nav-item dropdown">
                        <a class="dropdown-toggle navbar_item" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Opciones
                        </a>
                        <!-- deplegable de opciones -->
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <button <%=usuario.getNivel() == 2 ? "hidden" : ""%> 
                                class="dropdown-item" onclick="location.href = '../parametrizaciones/Operadores.jsp'">Parametrizaciones</button>
                                <a class="dropdown-item" href="../informes/informes.jsp">Informes</a>

                            <a class="dropdown-item" href="../costeoYfacturacion/costeoYfacturacion.jsp">Costeo y facturación</a>
                            <a class="dropdown-item" href="../servicios/Datos_cliente.jsp">Servicios</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#" id="nombreUsuario"><%=usuario.getPrimerNombre()%> <%=usuario.getPrimerApellido()%></a>
                        </div>
                    </li>
                    <TABLE border="0" cellpadding="0" cellspacing="0" class="lineaHorizontal"> 
                        <TR><TD bgcolor="#000000" width="2"></TD> 
                            <TD width="5"></TD> 
                            <TD width="*"><BR></TD></TR> 
                    </TABLE>
                    <li>
                        <form action="../cerrar_session" method="post">
                            <input class="btn btn-danger btn-sm" type="submit" value="cerrar session"> 
                        </form>
                    </li>
                </ul>
            </div>
        </nav>
    </body>
</html>