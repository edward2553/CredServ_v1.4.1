/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.credserv.servlets;

import com.credserv.entidades.EntidadServicio;
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
@WebServlet(name = "InsertarServicio", urlPatterns = {"/InsertarServicio"})
public class InsertarServicio extends HttpServlet {

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
            String nombre = request.getParameter("txtServicio");
            int h = 0;
            EntidadServicio servicio = new EntidadServicio(nombre.toUpperCase());
            camposDebug obj_placa = new camposDebug();
            
            String CambioRealizado2 = "";
            
            if (obj_placa.campo_espacioEnBlancoOnumero(nombre)) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Error: Nombre del servicio no puede ser un número o espacios en blanco');");
                out.println("location='parametrizaciones/prm_servicio.jsp';");
                out.println("</script>");
                CambioRealizado2 = "ERROR: Nombre del servicio no puede ser un numero o espacios en blanco";
            } else if (obj_placa.caracteresRaros(nombre.toCharArray(), h)) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Error: no puede ingresar caracteres extraños');");
                out.println("location='parametrizaciones/prm_servicio.jsp';");
                out.println("</script>");
                CambioRealizado2 = "ERROR: No puede ingresar caracteres extraños";
            } else if (dao.existeServicio(servicio) == true) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Error: el servicio ya existe');");
                out.println("location='parametrizaciones/prm_servicio.jsp';");
                out.println("</script>");
                CambioRealizado2 = "ERROR: El servicio ya existe";
            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('El servicio fué agregado con éxito');");
                out.println("location='parametrizaciones/prm_servicio.jsp';");
                out.println("</script>");
                dao.insertarServicio(servicio);
                CambioRealizado2 = "Insertó un nuevo servicio ("+nombre+")";
            }


            int IdUsuario = Integer.parseInt(request.getParameter("IdUsuario"));
            String Modulo = "Servicio";
            String CambioRealizado = CambioRealizado2;
            String FechaCambio = formatoFecha.format(fecha);
            String HoraCambio = Integer.toString(hora) + ":" + Integer.toString(minutos) + ":" + Integer.toString(segundos);

            auditoria = new LogAuditoria(IdUsuario, Modulo, CambioRealizado, FechaCambio, HoraCambio);
            logDao.insertarLog(auditoria);

        } catch (Exception e) {
            e.getMessage();
            e.getCause();
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
