<%@page import="com.credserv.persistencia.ServicioDAO"%>
<%@page import="java.util.UUID"%>
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
        <link href="../css/panelControl.css" rel="stylesheet" type="text/css"/>
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
                                    <li><a href="../PanelControl.jsp"class="btn-link breadcrumb_item">Inicio ></a></li>
                                    <li>Servicios ></li>
                                    <li>Cliente > </li>
                                    <li><a href="#" class="breadcrumb_item">Registrar servicio</a></li>
                                </ol>
                            </div>    
                        </div>

                        <div class="container-fluid">
                            <div class="row">
                                <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                    <h1 style="font-size: 30px;">Registrar servicio</h1>
                                </div>

                                <%
                                    Conexion con = new Conexion();
                                    
                                    ResultSet log = con.obtenerConexion().prepareStatement("SELECT * FROM USUARIO"
                                            + " WHERE EMAIL = '" + usuario.getEmail() + "'").executeQuery();

                                    int id = 0;
                                    while (log.next()) {
                                        id = log.getInt(1);
                                    }
                                %>

                            </div>
                        </div>
                    </div>
                </nav>
                <br>
                <%
                    ServicioDAO serv_dao = new ServicioDAO();
                    String turnoAleatorio = UUID.randomUUID().toString().toUpperCase().substring(0, 4);

                    boolean validar = serv_dao.BuscarTurno(turnoAleatorio);

                    while (validar) {
                        turnoAleatorio = UUID.randomUUID().toString().toUpperCase().substring(0, 4);
                    }


                %>
                <div class="container-fluid">
                    <form action="../InsertarClienteYservicio" method="post">
                        <input name="IdUsuario" hidden value="<%=id%>"/>
                        <div class="row">
                            <div>Turno</div>
                            <input type="text" name="txtTurno" readonly="" class="form-control" value="<%=turnoAleatorio%>">
                        </div>
                        <br>
                        <!-- FORMULARIO REGISTRAR SERVICIO -->

                        <br>

                        <div class="row">

                            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 ">
                                <h5>Cédula</h5>
                                <input class="form-control " type="number" required="" name="txtCedula" maxlength="30">
                            </div>
                        </div>
                        <br>
                        <div class="row">
                            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                <h5>Nombre completo</h5>
                                <input class="form-control" type="text" required="" name="txtNombre" maxlength="30">
                            </div>
                        </div>
                        <br>
                        <div class="row">
                            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                <h5>Apellido completo</h5>
                                <input class="form-control" type="text" required="" name="txtApellido" maxlength="30">
                            </div>
                        </div>
                        <br>

                        <div class="row">
                            <div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
                                <h5>Placa del automotor</h5>
                                <input maxlength="7" class="form-control" type="text" required="" name="txt_placaAutomotor">
                                <div id="mensajeInfo">
                                    <p>Ejemplo: abc-123</p>
                                </div>
                            </div>

                            <div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
                                <h5>Tipo de vehículo</h5>

                                <!-- MODAL tipo de vehiculo --> 
                                <button type="button" class="btn btn-default btn-md btn-block" data-toggle="modal" data-target="#myModal">Seleccionar vehículos</button>

                                <!-- Modal -->
                                <div id="myModal" class="modal fade" role="dialog">
                                    <div class="modal-dialog">

                                        <!-- Modal content-->
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h4 class="modal-title">Seleccione los vehículos del cliente</h4>
                                            </div>
                                            <div class="modal-body">                                                

                                                <%                                                  
                                                    ResultSet rs = con.obtenerConexion().prepareStatement("select * FROM TIPO_VEHICULO_SERVITECA").executeQuery();
                                                    while (rs.next()) {

                                                %>
                                                <div class="radio">
                                                    <label><input type="radio" name="optionRadioAutomotor" class="rdBtn_automovil" value="<%=rs.getInt(1)%>" ><%=rs.getString(2)%></label>
                                                </div>
                                                <%
                                                    }
                                                %>

                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-default" data-dismiss="modal">Listo</button>
                                            </div>
                                        </div>

                                    </div>
                                </div>
                            </div>
                            <div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
                                <h5>Tipo de servicio</h5>
                                <!-- MODAL servicios -->
                                <button type="button" class="btn btn-default btn-md btn-block" data-toggle="modal" data-target="#modaServicios">Seleccionar servicios</button>

                                <!-- Modal -->
                                <div id="modaServicios" class="modal fade" role="dialog">
                                    <div class="modal-dialog">

                                        <!-- Modal content-->
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                <h4 class="modal-title">Escoja los servicios del cliente</h4>
                                            </div>


                                            <%
                                                ResultSet rs3 = con.obtenerConexion().prepareStatement("select * from TIPO_SERVICIO_SERVITECA").executeQuery();
                                                while (rs3.next()) {

                                            %>
                                            <div class="checkbox ">


                                                <div style="margin-left: 40px;">
                                                    <input type="checkbox" name="idTipoServicio" value="<%=rs3.getString(1)%>" ><label><%=rs3.getString(2)%></label>

                                                    <br>
                                                </div>
                                            </div>
                                            <%
                                                }
                                            %>


                                            <div class="modal-footer">
                                                <button type="button" name="Submit" class="btn btn-default" data-dismiss="modal">Listo</button>
                                            </div>


                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>
                        <br>
                        <div class="row">
                            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                <h5>Hora de salida</h5>
                                <input class="form-control" type="time" required="" name="horaSalida" placeholder="Escriba en formato militar" />
                            </div>
                        </div>
                        <div id="div1">

                        </div>
                        <div class="row">
                            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                <br>
                                <center>                                    
                                    <input class="btn btn-danger btn-block" name="btn_continuar" type="submit" value="Continuar">
                                </center>
                            </div>
                        </div>
                    </form>
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