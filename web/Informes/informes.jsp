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

        Conexion con = new Conexion();
        try {
            ResultSet rs = con.obtenerConexion().prepareStatement("select FECHA_ENTRADA from SERVICIOS_DIARIOS order BY FECHA_ENTRADA").executeQuery();
            String fechaInicio = "";
            String fechaFin = "";
            boolean sw = true;
            while (rs.next()) {
                if (sw == true) {
                    fechaInicio = rs.getString(1);
                }
                fechaFin = rs.getString(1);
                sw = false;
            }
            if (sw == false) {
                if (fechaInicio.length() == 7) {
                    fechaInicio = "0" + fechaInicio;
                }
                if (fechaFin.length() == 7) {
                    fechaFin = "0" + fechaFin;
                }

                char arreglofecha1[] = new char[fechaInicio.length() + 2];
                for (int i = 0; i < fechaInicio.length(); i++) {
                    arreglofecha1[i] = fechaInicio.charAt(i);
                }

                arreglofecha1[9] = arreglofecha1[7];
                arreglofecha1[8] = arreglofecha1[6];
                arreglofecha1[7] = '0';
                arreglofecha1[6] = '2';

                fechaInicio = String.valueOf(arreglofecha1);

                char arreglofecha2[] = new char[fechaFin.length() + 2];
                for (int i = 0; i < fechaFin.length(); i++) {
                    arreglofecha2[i] = fechaFin.charAt(i);
                }
                arreglofecha2[9] = arreglofecha2[7];
                arreglofecha2[8] = arreglofecha2[6];
                arreglofecha2[7] = '0';
                arreglofecha2[6] = '2';

                fechaFin = String.valueOf(arreglofecha2);
            }


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
        <link href="../css/bootstrap-datepicker.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/panelControl.css" rel="stylesheet" type="text/css"/>
        <title>Informes</title>
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
                                    <li>Informes ></li>
                                </ol>
                            </div>    
                        </div>

                        <div class="container-fluid">
                            <div class="row">
                                <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                    <h1 style="font-size: 30px;">Generar informes</h1>
                                </div>

                            </div>
                        </div>
                    </div>
                </nav>
                <br>
                <!-- EL informe debe contener: :
                    la cantidad de servicios realizados en esa fecha
                    costo total de los servicios 
                    tiempo promedio
                -->


                <div>

                </div>


                <form action="../generarInfome" method="post">
                    <div class="row">

                        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" >
                            <label>Nombre del informe </label>
                            <input style="width: 80%; left: 10px;" name="nombreInfo" class="form-control" type="text" placeholder="nombre del informe" required="">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" >
                            <label>Fecha de inicio: </label>
                            <input style="width: 80%; left: 10px;" name="fecha1" class="form-control" type="text" id="from_date" placeholder="click para seleccionar la fecha 1" required="">
                        </div>
                    </div>
                    <br>
                    <div class="row">
                        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" >
                            <label>Fecha de finalizacion :   </label>
                            <input style="width: 80%;" name="fecha2" class="form-control" type="text" id="to_date" placeholder="click para seleccionar la fecha 2" required="">                                  
                        </div>
                    </div>
                    <br>
                    <div class="row">
                        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" >
                            <input type="submit" class="form-control btn btn-danger" value="Generar">                                        
                        </div>
                    </div>
                </form>

            </div>
            <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js" integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ" crossorigin="anonymous"></script>
            <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js" integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY" crossorigin="anonymous"></script>
            <!-- jQuery CDN - Slim version (=without AJAX) -->
            <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
            <!-- Popper.JS -->
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
            <!-- Bootstrap JS -->
            <script src="../javascript/bootstrap-datepicker.min.js" type="text/javascript"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
            <script src="../javascript/bootstrap-datepicker.es.min.js" type="text/javascript"></script>
            <script type="text/javascript">





                $(document).ready(function () {
                    $('#sidebarCollapse').on('click', function () {
                        $('#sidebar').toggleClass('active');
                    });
                });
                /********* formato *****************************/
                $.fn.datepicker.dates['es'] = {
                    days: ["Domingo", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"],
                    daysShort: ["Do", "Lu", "Ma", "Mi", "Ju", "Vi", "Sa"],
                    daysMin: ["Do", "Lu", "Ma", "Mi", "Ju", "Vi", "Sa"],
                    months: ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"],
                    monthsShort: ["Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ago", "Sep", "Oct", "Nov", "Dec"]
                };
                /********* fecha Inico - Fin *****************************/
                $("#from_date").datepicker({
                    format: "dd/mm/yyyy",
                    startDate: "<%= fechaInicio%>",
                    endDate: "<%= fechaFin%>",
                    language: "es",
                    keyboardNavigation: false,
                    forceParse: false,
                    orientation: "bottom right",
                    autoclose: false
                }).on('changeDate', function (selected) {
                    var startDate = new Date(selected.date.valueOf());
                    $('#to_date').datepicker('setStartDate', startDate);
                }).on('clearDate', function (selected) {
                    $('#to_date').datepicker('setStartDate', null);
                });
                $("#to_date").datepicker({
                    format: "dd/mm/yyyy",
                    autoclose: false,
                    startDate: "<%= fechaInicio%>",
                    endDate: "<%= fechaFin%>",
                    orientation: "bottom right",
                    language: "es"
                }).on('changeDate', function (selected) {
                    var endDate = new Date(selected.date.valueOf());
                    $('#from_date').datepicker('setEndDate', endDate);
                }).on('clearDate', function (selected) {
                    $('#from_date').datepicker('setEndDate', null);
                });

            </script>

    </body>
</html>
<%          } catch (Exception e) {
            throw e;

        };
    }
%>