<%-- 
    Document   : index
    Created on : 11/08/2018, 04:09:48 PM
    Author     : edwar
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, minimun-scale=1.0"/>
        <link href="css/estilosIndex.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>Pagina Principal</title>
    </head>
    <body>
        <br><br>
    <center>
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 ">
                <img src="imagenes/iconoPrincipal.jpg" class="img-responsive logo">
            </div>
        </div>
    </center>


    <center>
        <div class="container-fluid">    
            <form action="IniciarSesion" method="post">

                <%
                    String mensaje = (String) request.getAttribute("mensaje");
                %>
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
                        <center>
                            <h1>Iniciar sesión</h1>
                            <br/>


                        </center>
                    </div>

                </div>

                <div class="row text-left" >
                    <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
                        <a class="mensajeError" id="mensajeError"><%=mensaje != null ? mensaje : ""%></a>
                    </div>
                </div>
                <br>


                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">

                        <div class="input-group-lg ">
                            <input type="email" class="form-control" aria-label="Large"
                                   aria-describedby="inputGroup-sizing-sm" placeholder="Email" name="txtEmail">
                        </div>
                        <br>
                        <div class="input-group-lg ">
                            <input type="password" class="form-control" aria-label="Large"
                                   aria-describedby="inputGroup-sizing-sm" placeholder="Password" name="txtClave">
                        </div>
                        <br>
                        <div class="input-group-lg ">
                            <button  class="btn btn-danger loginButton" name="btn_login">Entrar</button>
                        </div>

                    </div>
                    <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
                        <!--SLIDER -->
                        <div id="carouselExampleControls" class="carousel slide carousel-position" data-ride="carousel">
                            <div class="carousel-inner">
                                <div class="carousel-item active">
                                    <img class="d-block w-100" src="imagenes/sliderLogin/automotriz1.jpg" alt="First slide">
                                </div>
                                <div class="carousel-item">
                                    <img class="d-block w-100" src="imagenes/sliderLogin/automotriz2.jpg" alt="Second slide">
                                </div>
                                <div class="carousel-item">
                                    <img class="d-block w-100" src="imagenes/sliderLogin/automotriz3.jpg" alt="Third slide">
                                </div>
                            </div>
                            <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
                                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                <span class="sr-only">Previous</span>
                            </a>
                            <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
                                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                <span class="sr-only">Next</span>
                            </a>
                        </div>
                        <!-- END SLIDER -->
                    </div>
                </div>
            </form>
        </div>
    </center>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
