/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.credserv.servlets;

import com.credserv.entidades.Cliente;
import com.credserv.entidades.LogAuditoria;
import com.credserv.entidades.Servicio;
import com.credserv.persistencia.ClienteDAO;
import com.credserv.persistencia.LogAuditoriaDAO;
import com.credserv.persistencia.ServicioDAO;
import com.credserv.utilidades.camposDebug;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.credserv.utilidades.placaDebug;
import java.util.Calendar;
import java.util.GregorianCalendar;

@WebServlet(name = "InsertarClienteYservicio", urlPatterns = {"/InsertarClienteYservicio"})
public class InsertarClienteYservicio extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Cliente cli;
        ClienteDAO Cli_dao = new ClienteDAO();
        Servicio serv;
        ServicioDAO serv_dao = new ServicioDAO();
        String select[] = request.getParameterValues("idTipoServicio");

        Date fecha = new Date();
        SimpleDateFormat formatoSimple = new SimpleDateFormat();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYY");
        
        Calendar calendario = new GregorianCalendar();
        int hora, minutos, segundos;
        hora = calendario.get(Calendar.HOUR_OF_DAY);
        minutos = calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND);

        LogAuditoriaDAO logDao = new LogAuditoriaDAO();
        LogAuditoria auditoria;
        try {

            String CambioRealizado2 = "";

            if (request.getParameter("optionRadioAutomotor") == (null) || select == null) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('ERROR: Debe seleccionar un tipo de automóvil o servicio VERIFIQUE');");
                out.println("location='servicios/Datos_servicio.jsp';");
                out.println("</script>");
                CambioRealizado2 = "ERROR: Debe Seleccionar un tipo de automóvil o servicio";
            } else {

                int cant_servicios = select.length;
                int id_servicios[] = new int[cant_servicios];
                double precio[] = new double[cant_servicios];
                double PrecioTotal = 0;
                int id_tipo_automotor = Integer.parseInt(request.getParameter("optionRadioAutomotor"));
                String duracion_hora = "";
                String duracion_min = "";
                double precio_sinDescuento;
                String cedula = request.getParameter("txtCedula");
                String turno = request.getParameter("txtTurno");
                String nombre = request.getParameter("txtNombre");
                String apellido = request.getParameter("txtApellido");
                String placa = request.getParameter("txt_placaAutomotor");
                String hora_entrada = "";
                String hora_salida = request.getParameter("horaSalida");
                // decirle a java que obtenga la fecha actual

                String fecha_entrada = formatoSimple.format(fecha);
                fecha_entrada = fecha_entrada + "W";
                String hora_militar = "";
                char[] caracteresFecha = new char[6];
                int j = 8;
                int h = 0;
                double cantServicios = 0;
                double porcentaje_descuento = 0;
                double totalDescuento = 0;

                //PROBANDO EL CAMPO NOMBRE Y APELLIDO
                //ESPACIOS EN BLANCO
                camposDebug obj_camposNombreYapellido = new camposDebug();

                if (obj_camposNombreYapellido.campo_espacioEnBlancoOnumero(nombre)) {
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Error: No se puede ingresar numeros o espacio en blanco en nombre');");
                    out.println("location='servicios/Datos_servicio.jsp';");
                    out.println("</script>");
                    CambioRealizado2 = "ERROR: No se puede ingresar numeros o espacio en blanco en nombre";
                } else if (obj_camposNombreYapellido.caracteresRaros(nombre.toCharArray(), h)) {
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Error: No escribir caracteres extraños en campo nombre');");
                    out.println("location='servicios/Datos_servicio.jsp';");
                    out.println("</script>");
                    CambioRealizado2 = "ERROR: No escribir caracteres extraños en campo nombre";
                } else if (obj_camposNombreYapellido.campo_espacioEnBlancoOnumero(apellido)) {
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Error: No se puede ingresar numeros o espacio en blanco en apellido');");
                    out.println("location='servicios/Datos_servicio.jsp';");
                    out.println("</script>");
                    CambioRealizado2 = "ERROR: No se puede ingresar numeros o espacio en blanco en apellido";
                } else if (obj_camposNombreYapellido.caracteresRaros(apellido.toCharArray(), h)) {
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Error: No escribir caracteres extraños en campo apellido');");
                    out.println("location='servicios/Datos_servicio.jsp';");
                    out.println("</script>");
                    CambioRealizado2 = "ERROR: No escribir caracteres extraños en campo apellido";
                } else if (obj_camposNombreYapellido.espacioBlanco(cedula)) {
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Error: No se puede ingresar espacios en blanco en cédula');");
                    out.println("location='servicios/Datos_servicio.jsp';");
                    out.println("</script>");
                    CambioRealizado2 = "ERROR: No se puede ingresar espacios en blanco en cédula";
                } else if (obj_camposNombreYapellido.es_letras(cedula)) {
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Error: No puede ingresar letras en campo cédula ');");
                    out.println("location='servicios/Datos_servicio.jsp';");
                    out.println("</script>");
                    CambioRealizado2 = "ERROR: No puede ingresar letras en campo cédula";
                } else if (Integer.parseInt(cedula) < 0) {
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Error: No puede ingresar numeros negativos');");
                    out.println("location='servicios/Datos_servicio.jsp';");
                    out.println("</script>");
                    CambioRealizado2 = "ERROR: No puede ingresar numeros negativos";
                } else {

                    cantServicios = serv_dao.BuscarCantidadServicios();

                    // PROBANDO EL CAMPO PLACA AUTOMOTOR
                    placaDebug obj_placa = new placaDebug();
                    if (placa.length() != 7) {
                        out.println("<script type=\"text/javascript\">");
                        out.println("alert('Error en el formato de placa de vehículo, ejemplo: abc-123');");
                        out.println("location='servicios/Datos_servicio.jsp';");
                        out.println("</script>");
                        CambioRealizado2 = "ERROR: Formato de placa de vehículo no válido, ejemplo: abc-123";
                    } else {
                        placa = placa + "00";
                        String[] letras_placa = new String[3];
                        letras_placa[0] = placa.substring(0, 1);
                        letras_placa[1] = placa.substring(1, 2);
                        letras_placa[2] = placa.substring(2, 3);
                        String guionPlaca = placa.substring(3, 4);
                        String[] numeros_placa = new String[3];
                        numeros_placa[0] = placa.substring(4, 5);
                        numeros_placa[1] = placa.substring(5, 6);
                        numeros_placa[2] = placa.substring(6, 7);

                        //chequeando si los primeros tres dijitos son letras
                        if (obj_placa.esNumero(letras_placa[0]) == true || obj_placa.esNumero(letras_placa[1]) == true || obj_placa.esNumero(letras_placa[2]) == true) {
                            out.println("<script type=\"text/javascript\">");
                            out.println("alert('Error en el formato de placa de vehículo, ejemplo: abc-123');");
                            out.println("alert('los tres primeros dígitos deben ser letras');");
                            out.println("location='servicios/Datos_servicio.jsp';");
                            out.println("</script>");
                            CambioRealizado2 = "ERROR: Los tres primeros dígitos deben ser letras";
                        }

                        if (!obj_placa.esNumero(numeros_placa[0]) || !obj_placa.esNumero(numeros_placa[1]) || !obj_placa.esNumero(numeros_placa[2])) {
                            out.println("<script type=\"text/javascript\">");
                            out.println("alert('Error en el formato de placa de vehículo, ejemplo: abc-123');");
                            out.println("alert('Los tres últimos dígitos deben ser números.');");
                            out.println("location='servicios/Datos_servicio.jsp';");
                            out.println("</script>");
                            CambioRealizado2 = "ERROR: Los tres últimos dígitos deben ser números";
                        }

                        //chequeando si está el guión 
                        if (!guionPlaca.equalsIgnoreCase("-")) {
                            out.println("<script type=\"text/javascript\">");
                            out.println("alert('Error en el formato de placa de vehículo, ejemplo: abc-123');");
                            out.println("alert('Recuerde digitar el guion que separa las letras y los números');");
                            out.println("location='servicios/Datos_servicio.jsp';");
                            out.println("</script>");
                            CambioRealizado2 = "ERROR: Recuerde digitar el guion que separa las letras y los números";
                        }

                        for (int i = 0; i < cant_servicios; i++) {
                            id_servicios[i] = Integer.parseInt(select[i]);

                            precio[i] = serv_dao.BuscarPrecio(id_servicios[i], id_tipo_automotor);
                            PrecioTotal = PrecioTotal + precio[i];

                        }
                        precio_sinDescuento = PrecioTotal;

                        //---------------------------LOGICA PARA GUARDAR LA HORA_ENTRADA EN FORMATO MILITAR-------------
                        if (fecha_entrada.length() == 18) {
                            j = 9;
                            while (h < caracteresFecha.length) {
                                if (j == 11) {
                                    j += 1;
                                }
                                caracteresFecha[h++] = fecha_entrada.charAt(j++);
                            }
                        } else {
                            while (h < caracteresFecha.length) {
                                if (j == 10) {
                                    j += 1;
                                }
                                caracteresFecha[h++] = fecha_entrada.charAt(j++);
                            }
                        }

                        char pm;
                        if (fecha_entrada.length() == 18) {
                            pm = fecha_entrada.charAt(15);
                        } else {
                            pm = fecha_entrada.charAt(14);
                        }
                        if (pm == 'P') {
                            hora_militar = Character.toString(caracteresFecha[0]) + Character.toString(caracteresFecha[1]);
                            hora_entrada = hora_militar + ":" + Character.toString(caracteresFecha[2]) + Character.toString(caracteresFecha[3]);
                            if (!hora_militar.equalsIgnoreCase("12")) {
                                hora_militar = Integer.toString(Integer.parseInt(hora_militar) + 12);
                                hora_entrada = hora_militar + ":" + Character.toString(caracteresFecha[2]) + Character.toString(caracteresFecha[3]);
                            }

                        } else {
                            hora_entrada = Character.toString(caracteresFecha[0]) + Character.toString(caracteresFecha[1]);
                            if (hora_entrada.equalsIgnoreCase("12")) {
                                hora_militar = "24";
                                hora_entrada = hora_militar + ":" + Character.toString(caracteresFecha[2]) + Character.toString(caracteresFecha[3]);
                            } else {
                                hora_entrada = Character.toString(caracteresFecha[0]) + Character.toString(caracteresFecha[1]);
                                hora_entrada += ":" + Character.toString(caracteresFecha[2]) + Character.toString(caracteresFecha[3]);
                            }
                        }
                        //---------------------------LOGICA PARA QUITAR LA HORA EN EL CAMPO FECHA_ENTRADA-------------

                        char[] fechaEntrada_char = new char[8];
                        for (int i = 0; i < 8; i++) {
                            fechaEntrada_char[i] = fecha_entrada.charAt(i);
                        }
                        fecha_entrada = "";

                        for (int i = 0; i < 8; i++) {
                            fecha_entrada += Character.toString(fechaEntrada_char[i]);
                        }
                        int id_usuario = 1;
                        int sw = 1;

                        cli = new Cliente(cedula, nombre, apellido);

//                definiedo el promedio de las horas
                        String Str_horasalida = hora_salida.substring(0, 2);
                        String Str_minutosSalida = hora_salida.substring(3, 5);
                        int int_horaSalida = Integer.parseInt(Str_horasalida + Str_minutosSalida);
                        int a = Integer.parseInt(Str_horasalida);
                        if (a == 00) {
                            int_horaSalida = 24 + Integer.parseInt(Str_minutosSalida);
                            if (Str_minutosSalida.equalsIgnoreCase("00")) {
                                int_horaSalida = 2400;
                            }
                        }
                        String int_horaEntrada = hora_entrada.substring(0, 2);
                        String int_minutosEntrada = hora_entrada.substring(3, 5);
                        int int_horaEntrada2 = Integer.parseInt(int_horaEntrada + int_minutosEntrada);

                        int resta;
                        if (int_horaEntrada2 > int_horaSalida) {
                            resta = int_horaEntrada2 - int_horaSalida;

                        } else {
                            //la resta es el total que se demora
                            resta = int_horaSalida - int_horaEntrada2;

                        }

                        int minutos_resta = 0;
                        int hora_resta = 0;
                        if (Integer.toString(resta).length() == 3) {
                            minutos_resta = Integer.parseInt(Integer.toString(resta).substring(1, 3));
                            hora_resta = Integer.parseInt(Integer.toString(resta).substring(0, 1));
                        } else if (Integer.toString(resta).length() == 2) {
                            minutos_resta = Integer.parseInt(Integer.toString(resta));
                        } else {
                            minutos_resta = resta;
                        }
                        int minutospasados = 0;
                        if (minutos_resta > 60) {
                            //cambio de logica
                            int min_hs = Integer.parseInt(Str_minutosSalida);
                            minutospasados = 60 - Integer.parseInt(hora_entrada.substring(3));
                            minutospasados += min_hs;
                            duracion_min = Integer.toString(minutospasados);

                            duracion_hora = Integer.toString(hora_resta);

                        } else if (Integer.toString(resta).length() == 2) {
                            duracion_hora = "00";
                            duracion_min = Integer.toString(minutos_resta);
                        } else if (Integer.toString(resta).length() == 1) {
                            duracion_hora = "00";
                            duracion_min = Integer.toString(resta).substring(0, 1);
                        } else {

                            duracion_hora = Integer.toString(resta).substring(0, 1);
                            duracion_min = Integer.toString(resta).substring(1);
                        }
                        //APLICANDO EL DESCUENTO
                        if (cant_servicios >= cantServicios) {
                            porcentaje_descuento = serv_dao.BuscarDescuento();
                            totalDescuento = (PrecioTotal * porcentaje_descuento) / 100;
                            PrecioTotal = PrecioTotal - totalDescuento;
                        }

                        for (int i = 0; i < cant_servicios; i++) {

                            serv = new Servicio(cedula, placa, id_tipo_automotor, id_servicios[i], hora_entrada, hora_salida, fecha_entrada, id_usuario, PrecioTotal, porcentaje_descuento, totalDescuento, precio[i], precio_sinDescuento, turno, duracion_hora, duracion_min);
                            // si el cliente existe
                            if (Cli_dao.siExisteCliente(cli)) {
                                serv_dao.insertarServicio(serv);
                            } else if (!Cli_dao.SicedulaExiste(cli)) {
                                Cli_dao.insertarCliente(cli);
                                serv_dao.insertarServicio(serv);
                            } else {
                                sw = 0;
                            }
                        }

                        if (sw == 0) {
                            out.println("<script type=\"text/javascript\">");
                            out.println("alert('ERROR: ya existe el cliente con esta cédula');");
                            out.println("location='servicios/Datos_servicio.jsp';");
                            out.println("</script>");
                        } else {
                            out.println("<script type=\"text/javascript\">");
                            out.println("alert('Éxito al ingresar servicio');");
                            out.println("location='costeoYFacturacion/costeoYfacturacion.jsp';");
                            out.println("</script>");
                            CambioRealizado2 = "Ingreso el servicio Id tipo automotor =(" + id_tipo_automotor + "), Id servicios(" + id_servicios[cant_servicios] + ")";
                        }

                    }
                }

            }

            int IdUsuario = Integer.parseInt(request.getParameter("IdUsuario"));
            String Modulo = "Insertar Cliente y Servicio";
            String CambioRealizado = CambioRealizado2;
            String FechaCambio = formatoFecha.format(fecha);
            String HoraCambio = Integer.toString(hora) + ":" + Integer.toString(minutos) + ":" + Integer.toString(segundos);

            auditoria = new LogAuditoria(IdUsuario, Modulo, CambioRealizado, FechaCambio, HoraCambio);
            logDao.insertarLog(auditoria);

        } catch (Exception e) {
            throw e;
        }

    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
