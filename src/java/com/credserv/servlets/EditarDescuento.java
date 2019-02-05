/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.credserv.servlets;

import com.credserv.entidades.LogAuditoria;
import com.credserv.entidades.descuento;
import com.credserv.persistencia.DescuentoDao;
import com.credserv.persistencia.LogAuditoriaDAO;
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
@WebServlet(name = "EditarDescuento", urlPatterns = {"/EditarDescuento"})
public class EditarDescuento extends HttpServlet {

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

        LogAuditoriaDAO logDao = new LogAuditoriaDAO();
        LogAuditoria auditoria;

        try {
            String CambioRealizado2 = "";
            
            String cantServicios = request.getParameter("cant_servicios");
            String porc_descuento = request.getParameter("porcentaje_descuento");
            if (cantServicios.equalsIgnoreCase("")) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('digite la cantidad de servicios');");
                out.println("location='parametrizaciones/prmt_Descuento.jsp';");
                out.println("</script>");
                CambioRealizado2 = "Intententando editar la cantidad de servicios (Campo vacío)";
            }
            if (porc_descuento.equalsIgnoreCase("")) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('digite un  porcentaje para el descuento');");
                out.println("location='parametrizaciones/prmt_Descuento.jsp';");
                out.println("</script>");
                CambioRealizado2 = "Intententando editar el descuento (Campo vacío)";
            }
            int cantServ2 = Integer.parseInt(cantServicios);
            int porcDescuento2 = Integer.parseInt(porc_descuento);
            if (cantServ2 <= -1 || cantServ2 >= 11) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('CANTIDAD DE SERVICIO PARA EL DESCUENTO: "
                        + "no puede ser negativo, no puede ser mayor a 10');");
                out.println("location='parametrizaciones/prmt_Descuento.jsp';");
                out.println("</script>");
                CambioRealizado2 = "Intententando editar el descuento (Valor negativo)";
            } else if (porcDescuento2 < 0 || porcDescuento2 > 100) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Porcentaje del descuento no válido');");
                out.println("location='parametrizaciones/prmt_Descuento.jsp';");
                out.println("</script>");
                CambioRealizado2 = "Intententando editar el descuento (Porcentaje no válido)";
            } else {
                descuento desc = new descuento(cantServ2, porcDescuento2);
                DescuentoDao descDao = new DescuentoDao();

                if (descDao.EditarDescuento(desc)) {
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Descuento actualizado con éxito');");
                    out.println("location='parametrizaciones/prmt_Descuento.jsp';");
                    out.println("</script>");
                    CambioRealizado2 = "Editó el descuento ("+cantServ2+" - "+porc_descuento+")";

                }
            }

            int IdUsuario = Integer.parseInt(request.getParameter("IdUsuario"));
            String Modulo = "Descuento";
            String CambioRealizado = CambioRealizado2;
            String FechaCambio = formatoFecha.format(fecha);
            String HoraCambio = Integer.toString(hora) + ":" + Integer.toString(minutos) + ":" + Integer.toString(segundos);

            auditoria = new LogAuditoria(IdUsuario, Modulo, CambioRealizado, FechaCambio, HoraCambio);
            logDao.insertarLog(auditoria);

        } catch (Exception e) {
            e.getCause();
            System.out.println(e);
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
