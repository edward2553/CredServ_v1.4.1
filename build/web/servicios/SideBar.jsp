<%
    HttpSession ss = (HttpSession) request.getSession();

    Usuario usuario = (Usuario) ss.getAttribute("usuario");

%>

<%@page import="com.credserv.entidades.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="fontawesome-i2svg-active fontawesome-i2svg-complete">
    <head>

    </head>
    <body>

        <!-- Sidebar  -->
        <nav id="sidebar">
            <div class="sidebar-header">
                <h3 style="font-size: 22px;">Inicio</h3>
                <strong class="CredServStrong">CRV</strong>
            </div>

            <ul class="list-unstyled components">
                <li  <%=usuario.getNivel() == 2 ? "hidden" : ""%> >
                    <a href="#parametrizacionesSubMenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle" >
                        <i class="fas fa-car"></i>
                        Parametrizaciones
                    </a>
                    <ul class="collapse list-unstyled" id="parametrizacionesSubMenu">
                        <li> 
                            <a href="../parametrizaciones/prmt_Descuento.jsp">Parametrizar descuento </a>
                        </li>
                        <li> 
                            <a href="../parametrizaciones/prm_precio.jsp">Parametrizar precio</a>
                        </li>
                        <li> 
                            <a href="../parametrizaciones/prm_servicio.jsp">Parametrizar servicio</a>
                        </li>
                        <li> 
                            <a href="../parametrizaciones/prm_vehiculos.jsp">Parametrizar vehículo</a>
                        </li>
                        <li> 
                            <a href="../parametrizaciones/Operadores.jsp">Parametrizar operadores </a>
                        </li>
                    </ul>
                </li> 
                <li>
                    <a href="#informesSubMenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle" >
                        <i class="fas fa-info-circle"></i>
                        Informes
                    </a>
                    <ul class="collapse list-unstyled" id="informesSubMenu">
                        <li> 
                            <a href="../Informes/informes.jsp">Realizar un informe</a>
                        </li>
                        <li> 
                            <a href="../Informes/consultar_informe.jsp">Consultar un informe</a>
                        </li>
                    </ul>
                </li>

                <li class="active">
                    <a href="#homeSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">
                        Servicios
                    </a>

                    <ul class="collapse list-unstyled" id="homeSubmenu">
                        <li>
                            <a href="../servicios/Datos_servicio.jsp">Registar servicio</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="../costeoYFacturacion/costeoYfacturacion.jsp">
                        <i class="fas fa-dollar-sign"></i>
                        Costeo y facturación
                    </a>
                </li>

            </ul>

        </nav>
    </body>
</html>
