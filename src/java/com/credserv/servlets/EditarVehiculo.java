/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.credserv.servlets;

import com.credserv.entidades.EntidadVehiculo;
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
@WebServlet(name = "EditarVehiculo", urlPatterns = {"/EditarVehiculo"})
public class EditarVehiculo extends HttpServlet {

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

        ServiciosParametrizacionesDAO dao = new ServiciosParametrizacionesDAO();

        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYY");

        Calendar calendario = new GregorianCalendar();
        int hora, minutos, segundos;
        hora = calendario.get(Calendar.HOUR_OF_DAY);
        minutos = calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND);

        LogAuditoriaDAO logDao = new LogAuditoriaDAO();
        LogAuditoria auditoria;

        try {
            int IDVehiculo = Integer.parseInt(request.getParameter("txtAutomotor"));
            String NombreVehiculo = request.getParameter("txtNombreAutomotor");
            EntidadVehiculo vehiculo = new EntidadVehiculo(NombreVehiculo, IDVehiculo);
            camposDebug obj_campos = new camposDebug();
            String CambioRealizado2 = "";

            if (!obj_campos.es_letras(NombreVehiculo)) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Error: no puede ingresar numeros en campo nombre del vehículo');");
                out.println("location='parametrizaciones/prm_vehiculos.jsp';");
                out.println("</script>");
                CambioRealizado2 = "ERROR: Ingreso numeros en campo nombre";
            } else if (obj_campos.espacioBlanco(NombreVehiculo)) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Error: ingrese un nombre para el vehículo');");
                out.println("location='parametrizaciones/prm_vehiculos.jsp';");
                out.println("</script>");
                CambioRealizado2 = "ERROR: No ingreso un nombre para el vehiculo";
            } else if (obj_campos.caracteresRaros(NombreVehiculo.toCharArray(), 0)) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Error: No puede ingresar caracteres extraños en campo nombre del vehículo');");
                out.println("location='parametrizaciones/prm_vehiculos.jsp';");
                out.println("</script>");
                CambioRealizado2 = "ERROR: No puede ingresar caracteres extraños en campo nombre del vehículo";
            } else {
                if (!dao.EditarVehiculo(vehiculo)) {

                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Error: nombre del vehículo ya existe');");
                    out.println("location='parametrizaciones/prm_vehiculos.jsp';");
                    out.println("</script>");
                    CambioRealizado2 = "ERROR: El nombre del vehículo ya existe";
                } else {
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Vehículo editado correctamente');");
                    out.println("location='parametrizaciones/prm_vehiculos.jsp';");
                    out.println("</script>");
                    CambioRealizado2 = "Editó el Vehiculo (" + NombreVehiculo + ")";
                }

            }

            int IdUsuario = Integer.parseInt(request.getParameter("IdUsuario"));
            String Modulo = "Vehiculo";
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
