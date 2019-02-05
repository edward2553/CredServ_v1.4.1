<%@page import="com.credserv.utilidades.Conexion"%>
<%@page import="java.sql.ResultSet"%>
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
                                    <li><a href="PanelControl.jsp"class="btn-link breadcrumb_item">Inicio ></a></li>
                                    <li>Servicios ></li>
                                    <li><a href="#" class="breadcrumb_item">Parametrizar servicio</a></li>
                                </ol>
                            </div>    
                        </div>

                        <div class="container-fluid">
                            <div class="row">
                                <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                    <h1 style="font-size: 30px;">Parametrizar servicio</h1>
                                </div>

                            </div>
                        </div>


                    </div>
                </nav>
                <br>
                <!-- FORMULARIO REGISTRAR SERVICIO -->
                <%Conexion con = new Conexion();%>

                <%
                    ResultSet log = con.obtenerConexion().prepareStatement("SELECT * FROM USUARIO"
                            + " WHERE EMAIL = '" + usuario.getEmail() + "'").executeQuery();

                    int id = 0;
                    while (log.next()) {
                        id = log.getInt(1);
                    }
                %>

                <div class="row ">
                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                        <h4 style="left:20px;">Agregar servicios</h4>
                    </div>                 
                </div>    

                <br>

                <div class="container">

                    <div class="row ">
                        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                            <form  method="post" action="../InsertarServicio">
                                <input name="IdUsuario" hidden value="<%=id%>"/>
                                <h6>Ingrese el nombre del servicio</h6>
                                <input name="txtServicio" class="form-control"/>
                                <br>
                                <button class="btn btn-default btnInsertaparametrizaciounes" >Insertar Servicio</button>
                            </form>
                        </div>
                    </div>
                    <br>

                </div>
                <br/>
                <br/>

                <center>
                    <h1>Servicio</h1>
                </center>

                <table class="table table-hover table-condensed table-bordered">
                    <tr><td>Servicios</td><td>Acciones</td></tr>
                    <%

                        ResultSet rs3 = con.obtenerConexion().prepareStatement("SELECT * FROM TIPO_SERVICIO_SERVITECA ORDER BY ID_TIPO_SERVICIO_SERVITECA ASC").executeQuery();

                        int j = 1;

                        while (rs3.next()) {
                            j += 2;

                    %>
                    <tr>
                    <form action="../EliminarServicios" method="post">             
                        <input name="IdUsuario" hidden value="<%=id%>"/>
                        <input name="idEliminarServicio" hidden="" value="<%= rs3.getInt(1)%>" />
                        <input name="txtServicio" hidden="" value="<%=rs3.getString(2)%>" />
                        
                        <td><%=rs3.getString(2)%></td>
                        <td><input type="submit" class="btn btn-danger btn-md btn-block" value="Eliminar servicio" /></td> 
                        <td><button type="button" class="btn btn-primary btn-md btn-block" data-toggle="modal" data-target="#<%= j%>">Editar servicio</button></a></td>
                    </form>
                    <form action="../EditarServicio" method="post">
                        <input name="IdUsuario" hidden value="<%=id%>"/>
                        <!--- modal EDITAR precio -->
                        <div id="<%= j%>" class="modal fade" role="dialog">
                            <div class="modal-dialog">

                                <!-- Modal content-->
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h4 class="modal-title">Editar el nombre del servicio</h4>
                                    </div>
                                    <div class="modal-body">                                                
                                        <div  class="row">
                                            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                                <h4>Servicio</h4>
                                                <input type="text" hidden="" name="txtIdservicio" class="form-control" value="<%=rs3.getString(1)%>" readonly/>                      
                                                <input type="text" name="txtNombreServicio" class="form-control" value="<%=rs3.getString(2)%>"/>                      
                                            </div>
                                        </div>
                                        <br/>
                                        <input type="submit" class="form-control" value="Editar" />
                                        <br>
                                        <div class="modal-footer row">
                                            <button type="button" class="btn btn-md btn-default" data-dismiss="modal">cancelar</button>
                                        </div>

                                    </div>
                                </div>
                                </form>
                                </tr>

                                <%}%>
                                </table>

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
                        <%
                            }
                        %>