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
@WebServlet(name = "EditarPrecio", urlPatterns = {"/EditarPrecio"})
public class EditarPrecio extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        EntidadServiciosServiteca servicios;
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
            String Str_idServicio = request.getParameter("txtIdservicio");
            String Str_idVehiculo = request.getParameter("txtIDVehiculo");
            int int_idServicio = Integer.parseInt(Str_idServicio);
            int int_idVehiculo = Integer.parseInt(Str_idVehiculo);
            String precio = request.getParameter("txtPrecio");
            servicios = new EntidadServiciosServiteca(int_idServicio, int_idVehiculo, precio);

            String CambioRealizado2 = "";
            
            //valores negativos
            if (Integer.parseInt(precio) < 0) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Error: no puede ingresar valores negativos');");
                out.println("location='parametrizaciones/prm_precio.jsp';");
                out.println("</script>");
                CambioRealizado2 = "Intentando editar precio (Ingresó valores negativos)";
            } else {

                //precio con valores límite
                if (Integer.parseInt(precio) < 1000 || Integer.parseInt(precio) > 2000000) {
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Error: Digitar un valor entre 1.000 y 2.000.000');");
                    out.println("location='parametrizaciones/prm_precio.jsp';");
                    out.println("</script>");
                    CambioRealizado2 = "Intentando editar precio (Valor fuera del rango de 1.000 y 2.000.000)";
                } else {
                    dao.EditarPrecio(servicios);

                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Precio modificado con éxito');");
                    out.println("location='parametrizaciones/prm_precio.jsp';");
                    out.println("</script>");
                    CambioRealizado2 = "Editó el precio ("+int_idServicio+" - "+int_idVehiculo+" - "+precio+")";
                }

            }

            int IdUsuario = Integer.parseInt(request.getParameter("IdUsuario"));
            String Modulo = "Precio";
            String CambioRealizado = CambioRealizado2;
            String FechaCambio = formatoFecha.format(fecha);
            String HoraCambio = Integer.toString(hora) + ":" + Integer.toString(minutos) + ":" + Integer.toString(segundos);

            auditoria = new LogAuditoria(IdUsuario, Modulo, CambioRealizado, FechaCambio, HoraCambio);
            logDao.insertarLog(auditoria);

        } catch (NumberFormatException e) {

            out.println("<script type=\"text/javascript\">");
            out.println("alert('Error: no puede ingresar punto decimal');");
            out.println("location='parametrizaciones/prm_precio.jsp';");
            out.println("</script>");
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
