/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.credserv.servlets;

import com.credserv.utilidades.Conexion;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.io.OutputStream;
import com.credserv.entidades.Informes;
import com.credserv.persistencia.informesDao;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author edwar
 */
@WebServlet(name = "pdf", urlPatterns = {"/pdf"})
public class pdf extends HttpServlet {

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
        response.setContentType("application/pdf");
        OutputStream out = response.getOutputStream();

        try {

            try {

                Conexion con = new Conexion();
                Informes obj_inf = new Informes("", 0, 0);
                informesDao inf_dao = new informesDao();
                String fecha1 = request.getParameter("fecha1");
                String fecha2 = request.getParameter("fecha2");
                if (fecha1.length() == 10) {
                    fecha1 = fecha1.substring(0, 6);
                    fecha1 += fecha1.substring(8);
                } else {
                    fecha1 = fecha1.substring(1, 6);
                    fecha1 += fecha1.substring(8);
                }

                if (fecha2.length() == 10) {
                    fecha2 = fecha2.substring(0, 6);
                    fecha2 += fecha2.substring(8);
                } else {
                    fecha2 = fecha2.substring(1, 6);
                    fecha2 += fecha2.substring(8);
                }

                //programando el pdf
                Document documento = new Document();
                PdfWriter.getInstance(documento, out);
                System.out.print(documento.toString());

                String ruta = "C:\\Users\\edwar\\Desktop\\programacion\\java_netbeans\\CredServ\\CredServ_v1.3\\informes";
                FileOutputStream archivo = new FileOutputStream(ruta + ".pdf");
                PdfWriter.getInstance(documento, archivo);
                
                //abrimokls el documento para llenarlo de contenido
                documento.open();

                //titulo
                Paragraph titulo1 = new Paragraph();
                Font fontTitulo = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD, BaseColor.BLACK);
                titulo1.add(new Phrase("Informe Serviteca CredServ", fontTitulo));
                titulo1.setAlignment(Element.ALIGN_CENTER);
                titulo1.add(new Phrase(Chunk.NEWLINE));
                titulo1.add(new Phrase(Chunk.NEWLINE));
                documento.add(titulo1);

                //informe del  hasta: 
                Paragraph txt_RangoFecha = new Paragraph();
                Font fontRangoFecha = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.NORMAL, BaseColor.BLACK);
                txt_RangoFecha.add(new Phrase("Informe del: " + fecha1 + "   hasta: " + fecha2, fontRangoFecha));
                txt_RangoFecha.setAlignment(Element.ALIGN_CENTER);
                txt_RangoFecha.add(new Phrase(Chunk.NEWLINE));
                txt_RangoFecha.add(new Phrase(Chunk.NEWLINE));
                txt_RangoFecha.add(new Phrase(Chunk.NEWLINE));
                documento.add(txt_RangoFecha);

                //tabla
                PdfPTable tabla = new PdfPTable(4);
                PdfPCell celda1 = new PdfPCell(new Paragraph("fecha de entrada", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.BLACK)));
                PdfPCell celda2 = new PdfPCell(new Paragraph("servicios", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.BLACK)));
                PdfPCell celda3 = new PdfPCell(new Paragraph("precios", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.BLACK)));
                PdfPCell celda4 = new PdfPCell(new Paragraph("duracion", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.BLACK)));

                tabla.addCell(celda1);
                tabla.addCell(celda2);
                tabla.addCell(celda3);
                tabla.addCell(celda4);

                obj_inf.setDuracionTotal(inf_dao.obtenerDuracion(fecha1, fecha2));
                obj_inf.setPrecioTotal(inf_dao.obtenerPrecioTotal(fecha1, fecha2));
                obj_inf.setTotalServicios(inf_dao.obtenerTotalServicios(fecha1, fecha2));

                ResultSet consulta = con.obtenerConexion().prepareStatement("SELECT * FROM TIPO_SERVICIO_SERVITECA C JOIN SERVICIOS_DIARIOS SD ON C.ID_TIPO_SERVICIO_SERVITECA = SD.ID_TIPO_SERVICIO where FECHA_ENTRADA BETWEEN '" + fecha1 + "' AND '" + fecha2 + "'"
                        + "order by SD.FECHA_ENTRADA").executeQuery();

                while (consulta.next()) {

                    tabla.addCell(consulta.getString(11));
                    tabla.addCell(consulta.getString(2));
                    tabla.addCell(Integer.toString(consulta.getInt(13)));
                    tabla.addCell(consulta.getString(19) + ":" + consulta.getString(18));

                }
                documento.add(tabla);

                Paragraph txt_resumen = new Paragraph();
                Font font_Total_servicios = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.NORMAL, BaseColor.BLACK);
                txt_resumen.add(new Phrase("Cantidad de servicios: " + obj_inf.getTotalServicios() + "                  Costo total: " + obj_inf.getPrecioTotal() + "                  Duración promedio: " + obj_inf.getDuracionTotal(), font_Total_servicios));
                txt_resumen.setAlignment(Element.ALIGN_LEFT);
                txt_resumen.add(new Phrase(Chunk.NEWLINE));
                documento.add(txt_resumen);

                //-------------------METODO O FORMA PARA INSERTAR EL INFORME EN LA BD--------
                documento.close();
            } catch (Exception ex) {
                ex.getCause();
                ex.getMessage();
            }

        } finally {
            out.close();

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
