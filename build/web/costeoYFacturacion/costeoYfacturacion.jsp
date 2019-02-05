
<%@page import="java.sql.ResultSet"%>
<%@page import="com.credserv.utilidades.Conexion"%>
<%@page import="com.credserv.entidades.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession ss = (HttpSession) request.getSession();
    Usuario usuario = (Usuario) ss.getAttribute("usuario");

    if (usuario == null) {
        response.sendRedirect("../index.jsp");
    } else {
%>
<!DOCTYPE html>
<html class="fontawesome-i2svg-active fontawesome-i2svg-complete">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, minimun-scale=1.0"/>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
        <link href="../css/style4.css" rel="stylesheet" type="text/css"/>
        <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js" integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ" crossorigin="anonymous"></script>
        <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js" integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY" crossorigin="anonymous"></script>
        <link href="../css/servicios.css" rel="stylesheet" type="text/css"/>
        <title>Panel de control</title>
    </head>
    <body>
        <jsp:include page="MenuPrincipal.jsp" />

        <div class="wrapper">
            <!-- Sidebar  -->
            <jsp:include page="SideBar.jsp" />
            <!-- Page Content  -->
            <div id="content">

                <nav class="navbar navbar-expand-lg navbar-light bg-light">
                    <div class="container-fluid">

                        <button type="button" id="sidebarCollapse" class="btn btn-danger">
                            <i class="fas fa-align-left"></i>
                            <span>Abrir/cerrar menú</span>
                        </button>
                        <button class="btn btn-dark d-inline-block d-lg-none ml-auto" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                            <i class="fas fa-align-justify"></i>
                        </button>

                        <!-- migas de pan -->
                        <div class="col-lg-6">
                            <div class="container-fluid">
                                <ol class="breadcrumb">
                                    <li><a href="PanelControl.jsp"class="btn-link breadcrumb_item">Inicio ></a></li>
                                    <li>Servicios ></li>
                                    <li><a href="#" class="breadcrumb_item">Registrar servicio</a></li>
                                </ol>
                            </div>    
                        </div>

                        <div class="container-fluid">
                            <div class="row">
                                <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                    <h1 style="font-size: 30px;">Servicios operado</h1>
                                </div>

                            </div>
                        </div>


                    </div>
                </nav>
                <br>
                <!-- FORMULARIO REGISTRAR SERVICIO -->

                <div class="container">
                    <div class="table-responsive ">
                        <table class="table table-hover" id="tbl-maestros">
                            <tr class="active danger" >
                                <th><center>Turno</center></th>
                            <th><center>Cedula</center></th>
                            <th><center>Nombre</center></th>
                            <th><center>Apellido</center></th>
                            <th><center>Placa</center></th>
                            <th><center>Vehículo</center></th>
                            <th><center>Servicio</center></th>
                            <th><center>Hora de entrada</center></th>
                            <th><center>Hora de salida</center></th>
                            <th><center>Fecha entrada</center></th>
                            <th><center>Precio total</center></th>
                            </tr>
                            <%
                                Conexion con = new Conexion();
                                try {
                                    ResultSet rs = con.obtenerConexion().prepareStatement("SELECT SERVICIOS_DIARIOS.ID_SERVICIO,SERVICIOS_DIARIOS.TURNO,CLIENTE.CEDULA_CONDUCTOR,CLIENTE.NOMBRE_CONDUCTOR,"
                                            + "CLIENTE.APELLIDO_CONDUCTOR,SERVICIOS_DIARIOS.PLACA_AUTOMOTOR,TIPO_VEHICULO_SERVITECA.TIPO_VEHICULO_SERVITECA,"
                                            + "TIPO_SERVICIO_SERVITECA.TIPO_SERVICIO_SERVITECA,SERVICIOS_DIARIOS.HORA_ENTRADA,SERVICIOS_DIARIOS.HORA_SALIDA,"
                                            + "SERVICIOS_DIARIOS.FECHA_ENTRADA,SERVICIOS_DIARIOS.PRECIO_TOTAL, SERVICIOS_DIARIOS.PORC_DESCUENTO,SERVICIOS_DIARIOS.TOTAL_DESCUENTO,SERVICIOS_DIARIOS.VAL_SERVICIO_INDIVIDUAL, SERVICIOS_DIARIOS.TOTAL_SIN_DESCUENTO"
                                            + " FROM SERVICIOS_DIARIOS INNER JOIN CLIENTE ON SERVICIOS_DIARIOS.CEDULA_CLIENTE = CLIENTE.CEDULA_CONDUCTOR "
                                            + "INNER JOIN TIPO_VEHICULO_SERVITECA ON SERVICIOS_DIARIOS.ID_TIPO_VEHICULO = "
                                            + "TIPO_VEHICULO_SERVITECA.ID_TIPO_VEHICULO_SERVITECA "
                                            + "INNER JOIN TIPO_SERVICIO_SERVITECA ON SERVICIOS_DIARIOS.ID_TIPO_SERVICIO = "
                                            + "TIPO_SERVICIO_SERVITECA.ID_TIPO_SERVICIO_SERVITECA ORDER BY SERVICIOS_DIARIOS.ID_SERVICIO DESC").executeQuery();
                                    int i = 0;
                                    while (rs.next()) {
                                        i++;

                            %>
                            <tr >
                                <td><center><%=rs.getString(2)%></center></td>
                            <td><center><%=rs.getString(3)%></center></td>
                            <td><center><%=rs.getString(4)%></center></td>
                            <td><center><%=rs.getString(5)%></center></td>
                            <td><center><%=rs.getString(6)%></center></td>
                            <td><center><%=rs.getString(7)%></center></td>
                            <td><center><%=rs.getString(8)%></center></td>
                            <td><center><%=rs.getString(9)%></center></td>
                            <td><center><%=rs.getString(10)%></center></td>
                            <td><center><%=rs.getString(11)%></center></td>
                            <td><center><%=rs.getString(12)%></center></td>
                            <td><button class="btn btn-link" data-toggle="modal" data-target="#<%=i%>" >Ver detalles</button></td>
                            </tr>

                            <div id="<%=i%>" class="modal fade" role="dialog">
                                <div class="modal-dialog">

                                    <!-- Modal content-->
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h4 class="modal-title">Detalles del servicio</h4>
                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        </div>
                                        <div class="modal-body">
                                            <h5>Porcentaje descuento</h5>
                                            <input type="number" class="form-control" disabled="" value="<%=rs.getDouble(13)%>" />
                                            <h5>Total descuento</h5>
                                            <input type="text" class="form-control" disabled="" value="<%=rs.getDouble(14)%>" />
                                            <h5>Valor de este servicio</h5>
                                            <input type="text" class="form-control" disabled="" value="<%=rs.getDouble(15)%>" />
                                            <h5>Valor total del servicio sin descuento</h5>
                                            <input type="text" class="form-control" disabled="" value="<%=rs.getDouble(16)%>" />
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="close" data-dismiss="modal">Listo</button>
                                        </div>
                                    </div>


                                </div>
                            </div>
                            <% }
                                } catch (Exception e) {
                                    e.getCause();
                                }
                            %>

                        </table>
                    </div>
                </div>

                <br>
            </div>
        </div>


        <!-- jQuery CDN - Slim version (=without AJAX) -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <!-- Popper.JS -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
        <!-- Bootstrap JS -->
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>

        <script type="text/javascript">
            $(document).ready(function () {
                $('#sidebarCollapse').on('click', function () {
                    $('#sidebar').toggleClass('active');
                });
            });
        </script>

    </body>
</html>
<%    }
%>