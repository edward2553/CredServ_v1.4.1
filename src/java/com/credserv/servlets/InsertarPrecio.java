/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.credserv.servlets;

import com.credserv.entidades.EntidadServiciosServiteca;
import com.credserv.entidades.LogAuditoria;
import com.credserv.persistencia.LogAuditoriaDAO;
import com.credserv.persistencia.ServiciosParametrizacionesDAO;
import com.credserv.utilidades.camposDebug;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author crist
 */
@WebServlet(name = "InsertarPrecio", urlPatterns = {"/InsertarPrecio"})
public class InsertarPrecio extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYY");

        Calendar calendario = new GregorianCalendar();
        int hora, minutos, segundos;
        hora = calendario.get(Calendar.HOUR_OF_DAY);
        minutos = calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND);
        EntidadServiciosServiteca servicios;

        camposDebug obj_placa = new camposDebug();

        LogAuditoriaDAO logDao = new LogAuditoriaDAO();
        LogAuditoria auditoria;

        String CambioRealizado2 = "";

        try {
            ServiciosParametrizacionesDAO dao = new ServiciosParametrizacionesDAO();
            String IDServicio = request.getParameter("selectServicio");
            String IDVehiculo = request.getParameter("selectVehiculo");

            if (IDServicio.equalsIgnoreCase("Elija un tipo de servicio") || IDVehiculo.equalsIgnoreCase("Elija un tipo de vehiculo")) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Error: Recuerde elegir una opción de vehículos y servicio');");
                out.println("location='parametrizaciones/prm_precio.jsp';");
                out.println("</script>");
                CambioRealizado2 = "Intententando insertar un precio (Elegir una opción)";
            } else {
                int IdServicio = Integer.parseInt(IDServicio);
                int IdVehiculo = Integer.parseInt(IDVehiculo);
                String precio = request.getParameter("txtPrecio");
                servicios = new EntidadServiciosServiteca(IdServicio, IdVehiculo, precio);

                //valores negativos
                if (Integer.parseInt(precio) < 0) {
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Error: No puede ingresar valores negativos');");
                    out.println("location='parametrizaciones/prm_precio.jsp';");
                    out.println("</script>");

                    CambioRealizado2 = "Intententando insertar un precio (Valores negativos)";

                } else {
                    //precio con valores límite
                    if (Integer.parseInt(precio) < 1000 || Integer.parseInt(precio) > 2000000) {
                        out.println("<script type=\"text/javascript\">");
                        out.println("alert('Error: Digitar un valor entre 1.000 y 2.000.000');");
                        out.println("location='parametrizaciones/prm_precio.jsp';");
                        out.println("</script>");

                        CambioRealizado2 = "Intententando insertar un precio (Valor fuera del limite 1.000 y 2.000.000)";
                    } else {
                        if (dao.existeServicioServiteca(IdServicio, IdVehiculo)) {
                            out.println("<script type=\"text/javascript\">");
                            out.println("alert('Error: precio ya existe');");
                            out.println("location='parametrizaciones/prm_precio.jsp';");
                            out.println("</script>");

                            CambioRealizado2 = "Intententando insertar un precio (Ya existente)";

                        } else {
                            out.println("<script type=\"text/javascript\">");
                            out.println("alert('Precio del nuevo servicio agregado con éxito');");
                            out.println("location='parametrizaciones/prm_precio.jsp';");
                            out.println("</script>");
                            dao.insertarServiciosServiteca(servicios);
                            CambioRealizado2 = "Inserto precio del nuevo servicio (" + IdServicio + " - " + IdVehiculo + " - " + precio + ")";
                        }
                    }
                }
            }

            int IdUsuario = Integer.parseInt(request.getParameter("IdUsuario"));
            String Modulo = "Precio";
            String CambioRealizado = CambioRealizado2;
            String FechaCambio = formatoFecha.format(fecha);
            String HoraCambio = Integer.toString(hora) + ":" + Integer.toString(minutos) + ":" + Integer.toString(segundos);

            auditoria = new LogAuditoria(IdUsuario, Modulo, CambioRealizado, FechaCambio, HoraCambio);
            logDao.insertarLog(auditoria);

        } catch (NumberFormatException ex) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Error: revise el campo precio por favor');");
            out.println("alert('Recuerde que no se puede ingresar caracteres extraños, letras ni decimales');");
            out.println("location='parametrizaciones/prm_precio.jsp';");
            out.println("</script>");
            CambioRealizado2 = "Intententando insertar un precio (Ingreso punto decimal)";
            ex.getCause();
            ex.getMessage();
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
