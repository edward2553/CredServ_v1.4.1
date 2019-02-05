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
        <link href="../css/operadores.css" rel="stylesheet" type="text/css"/>
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
                                    <li><a href="#"class="btn-link breadcrumb_item">Inicio ></a></li>
                                    <li>Parametrizaciones ></li>
                                    <li><a href="#" class="breadcrumb_item">Operadores</a></li>
                                </ol>
                            </div>    
                        </div>

                        <div class="container-fluid">
                            <div class="row">
                                <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                    <h1 style="font-size: 30px;">Parametrizar Operadores</h1>
                                </div>

                            </div>
                        </div>
                    </div>
                </nav>
                <br><br>

                <%
                     Conexion con = new Conexion();
                  ResultSet log = con.obtenerConexion().prepareStatement("SELECT * FROM USUARIO"
                            + " WHERE EMAIL = '" + usuario.getEmail() + "'").executeQuery();

                    int id = 0;
                    while (log.next()) {
                        id = log.getInt(1);
                    }
                %>

                <!-- FORMULARIO REGISTRAR SERVICIO -->
                <div class="container-fluid">

                    <div class="row">
                        <!-- TABLA DE OPERADORES -->
                        <div class="table-responsive ">

                            <table class="table table-hover" id="tbl-maestros">
                                <tr class="active danger" >
                                    <th>Primer Nombre</th>
                                    <th>Segundo Nombre</th>
                                    <th>Primer Apellido</th>
                                    <th>Segundo Apellido</th>
                                    <th>Cédula</th>
                                    <th>Edad</th>
                                    <th>Email</th>
                                    <th>Clave</th>
                                    <th>Teléfono</th>
                                    <th>Dirección</th>
                                </tr>

                                <%
                                   
                                    ResultSet rs = con.obtenerConexion().prepareStatement("SELECT * FROM USUARIO WHERE NIVEL = 2").executeQuery();
                                    int i = 0;
                                    while (rs.next()) {
                                        i++;
                                %>


                                <tr>
                                <form action="../EliminarUsuario" method="post">
                                    <input name="IdUsuario" hidden value="<%=id%>"/>
                                    <input name="idEliminar" hidden="" value="<%=rs.getInt(1)%>" />
                                    <td><%=rs.getString(2)%></td>
                                    <td><%=rs.getString(3)%></td>
                                    <td><%=rs.getString(4)%></td>
                                    <td><%=rs.getString(5)%></td>
                                    <td><%=rs.getString(6)%></td>
                                    <td><%=rs.getInt(7)%></td>
                                    <td><%=rs.getString(8)%></td>
                                    <td><%=rs.getString(9)%></td>
                                    <td><%=rs.getString(10)%></td>
                                    <td><%=rs.getString(11)%></td>
                                    <td><button  class="btn btn-danger btn-md btn-block" >Eliminar operador</button></td>
                                </form>
                                <td><button type="button" class="btn btn-primary btn-md btn-block" data-toggle="modal" data-target="#<%=i%>">Editar operador</button></td>
                                </tr> 

                                <div id="<%= i%>" class="modal fade" role="dialog">
                                    <div class="modal-dialog">

                                        <!-- Modal content-->
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h4 class="modal-title">Editar el operador</h4>
                                            </div>
                                            <form action="../EditarUsuario" method="post">
                                                 <input name="IdUsuario" hidden value="<%=id%>"/>
                                                <div class="modal-body">     
                                                    <h5>Primer nombre</h5>
                                                    <input maxlength="30" name="txtPrimerNombre" type="text" placeholder="Escriba primer nombre" class="form-control" required value="<%=rs.getString(2)%>"/>
                                                    <h5>Segundo nombre</h5>
                                                    <input name="txtSegundoNombre" type="text" placeholder="Escriba segundo nombre" class="form-control" value="<%=rs.getString(3)%>"/>
                                                    <h5>Primer pellido</h5>
                                                    <input maxlength="30" name="txtPrimerApellido" type="text"   placeholder="Escriba primer apellido" class="form-control" required value="<%=rs.getString(4)%>"/>
                                                    <h5>Segundo pellido</h5>
                                                    <input maxlength="30" name="txtSegundoApellido" type="text"   placeholder="Escriba segundo apellido" class="form-control" required value="<%=rs.getString(5)%>"/>
                                                    <h5>Cédula</h5>
                                                    <input maxlength="30" name="txtCedula" type="text" placeholder="Escriba la cedula" type="numer" class="form-control" required="" value="<%=rs.getString(6)%>"/>
                                                    <h5>Edad</h5>
                                                    <input maxlength="30" name="txtEdad" type="number" placeholder="Escriba la edad del operador" type="numer" class="form-control" required value="<%=rs.getInt(7)%>"/>
                                                    <h5>Email</h5>
                                                    <input maxlength="30" name="txtEmail" type="email" placeholder="Escriba el correo electronico" class="form-control" required value="<%=rs.getString(8)%>" readonly/>
                                                    <h5>Contraseña</h5>
                                                    <input maxlength="30" name="txtClave" type="text" placeholder="Escriba la contraseña" class="form-control" required value="<%=rs.getString(9)%>"/>
                                                    <h5>Teléfono</h5>
                                                    <input maxlength="30" name="txtTel" type="tel" type="numer" placeholder="Escriba el teléfono" class="form-control" required value="<%=rs.getString(10)%>"/>
                                                    <h5>Dirección</h5>
                                                    <input maxlength="30" name="txtDireccion" type="text" placeholder="Escriba la dirección" class="form-control" required value="<%=rs.getString(11)%>"/>
                                                    <br/>
                                                </div>
                                                <button class="form-control btn btn-danger" >Editar</button>
                                            </form>
                                            <br>
                                            <div class="modal-footer row">
                                                <button type="button" class="btn btn-md btn-info" data-dismiss="modal">Cancelar</button>
                                            </div>

                                        </div>
                                    </div>
                                </div>
                        </div>

                        <% } %>
                        </table>
                    </div>

                </div>    
                <br>
                <div class="row"> 
                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                        <button type="button" class="btn btn-danger btn-lg btn-block " data-toggle="modal" data-target="#agregarOperador" >Agregar operador</button>

                        <!-- Modal -->
                        <div id="agregarOperador" class="modal fade" role="dialog">
                               
                                <div class="modal-dialog">
                                    Modal content
                                    <div class="modal-content">

                                        <div class="modal-header">
                                            <h4 class="modal-title">Agregar un operador a la servitca</h4>
                                        </div>
                                        <form action="../InsertarUsuario" method="post">
                                             <input name="IdUsuario" hidden value="<%=id%>"/>
                                            <div class="modal-body">
                                                <h5>Primer nombre</h5>
                                                <input maxlength="30" name="txtPrimerNombre" type="text" placeholder="Escriba primer nombre" class="form-control" required/>
                                                <h5>Segundo nombre</h5>
                                                <input name="txtSegundoNombre" type="text" placeholder="Escriba segundo nombre" class="form-control" />
                                                <h5>Primer pellido</h5>
                                                <input maxlength="30" name="txtPrimerApellido" type="text"   placeholder="Escriba primer apellido" class="form-control" required/>
                                                <h5>Segundo pellido</h5>
                                                <input maxlength="30" name="txtSegundoApellido" type="text"   placeholder="Escriba segundo apellido" class="form-control" required/>
                                                <h5>Cédula</h5>
                                                <input maxlength="30" name="txtCedula" type="number" placeholder="Escriba la cedula" type="numer" class="form-control" required="" />
                                                <h5>Edad</h5>
                                                <input maxlength="30" name="txtEdad" type="number" placeholder="Escriba la edad del operador" type="numer" class="form-control" required/>
                                                <h5>Email</h5>
                                                <input maxlength="30" name="txtEmail" type="email" placeholder="Escriba el correo electronico" class="form-control" required/>
                                                <h5>Contraseña</h5>
                                                <input maxlength="30" name="txtClave" type="text" placeholder="Escriba la contraseña" class="form-control" required/>
                                                <h5>Teléfono</h5>
                                                <input maxlength="30" name="txtTel" type="tel" type="numer" placeholder="Escriba el teléfono" class="form-control" required/>
                                                <h5>Dirección</h5>
                                                <input maxlength="30" name="txtDireccion" type="text" placeholder="Escriba la dirección" class="form-control" required/>
                                                <br/>
                                            </div>
                                            <div class="modal-footer">
                                                <button class="btn btn-danger">Agregar</button>
                                                <button class="btn btn-info"  data-dismiss="modal">Cancelar</button>
                                            </div>
                                        </form>
                                    </div>

                                </div>
                        </div> 

                    </div> 
                </div>

            </div>

        </div>
        <br>
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