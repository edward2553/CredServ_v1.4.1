/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.credserv.servlets;

import com.credserv.entidades.LogAuditoria;
import com.credserv.entidades.Usuario;
import com.credserv.persistencia.LogAuditoriaDAO;
import com.credserv.persistencia.UsuarioDAO;
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
@WebServlet(name = "InsertarUsuario", urlPatterns = {"/InsertarUsuario"})
public class InsertarUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Usuario usu;
        UsuarioDAO dao = new UsuarioDAO();

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
            String primerNombre = request.getParameter("txtPrimerNombre");
            String segundoNombre = request.getParameter("txtSegundoNombre");
            String primerApellido = request.getParameter("txtPrimerApellido");
            String segundoApellido = request.getParameter("txtSegundoApellido");
            String identificacion = request.getParameter("txtCedula");
            int edad_int = Integer.parseInt(request.getParameter("txtEdad"));
            String email = request.getParameter("txtEmail");
            String clave = request.getParameter("txtClave");
            String telefono = request.getParameter("txtTel");
            String direccion = request.getParameter("txtDireccion");
            int nivel = 2;
            camposDebug obj_campos = new camposDebug();

            String edad = Integer.toString(edad_int);

            String CambioRealizado2 = "";

            if (dao.ValidarUsuario(email)) {
                out.println("<script type=\"text/javascript\">");
                out.println("location='parametrizaciones/Operadores.jsp';");
                out.println("alert('El operador ya existe');");
                out.println("</script>");
                CambioRealizado2 = "ERROR: El operador ya existe";
            } else {
                //nombre
                if (!obj_campos.es_letras(primerNombre)) {
                    out.println("<script type=\"text/javascript\">");
                    out.println("location='parametrizaciones/Operadores.jsp';");
                    out.println("alert('Error: No puede ingresar números como primer nombre');");
                    out.println("</script>");
                    CambioRealizado2 = "ERROR: No puede ingresar números como primer nombre";

                } else if (obj_campos.espacioBlanco(primerNombre)) {
                    out.println("<script type=\"text/javascript\">");
                    out.println("location='parametrizaciones/Operadores.jsp';");
                    out.println("alert('Error: Ingrese el primer nombre');");
                    out.println("</script>");
                    CambioRealizado2 = "ERROR: Ingrese un primer nombre";

                } else if (obj_campos.caracteresRaros(primerNombre.toCharArray(), 0)) {
                    out.println("<script type=\"text/javascript\">");
                    out.println("location='parametrizaciones/Operadores.jsp';");
                    out.println("alert('Error: No puede ingresar caracteres extraños en campo primer nombre');");
                    out.println("</script>");
                    CambioRealizado2 = "ERROR: No puede ingresar caracteres extraños en campo primer nombre";
                }
                //segundo nombre
                if (!obj_campos.es_letras(segundoNombre)) {
                    out.println("<script type=\"text/javascript\">");
                    out.println("location='parametrizaciones/Operadores.jsp';");
                    out.println("alert('Error: No puede ingresar numeros como segundo nombre');");
                    out.println("</script>");
                    CambioRealizado2 = "ERROR: No puede ingresar numeros como segundo nombre";

                    /*  } else if (obj_campos.espacioBlanco(segundoNombre)) {
                    out.println("<script type=\"text/javascript\">");
                    out.println("location='parametrizaciones/Operadores.jsp';");
                    out.println("alert('Error:ingrese un segundo nombre');");
                    out.println("</script>");
                    CambioRealizado2 = "ERROR: Ingrese un segundo nombre";*/
                } else if (obj_campos.caracteresRaros(segundoNombre.toCharArray(), 0)) {
                    out.println("<script type=\"text/javascript\">");
                    out.println("location='parametrizaciones/Operadores.jsp';");
                    out.println("alert('Error: No puede ingresar caracteres extraños en campo segundo nombre');");
                    out.println("</script>");
                    CambioRealizado2 = "ERROR: No puede ingresar caracteres extraños en campo segundo nombre";

                }
                //primer apellido
                if (!obj_campos.es_letras(primerApellido)) {
                    out.println("<script type=\"text/javascript\">");
                    out.println("location='parametrizaciones/Operadores.jsp';");
                    out.println("alert('Error: No puede ingresar numeros como primer apellido');");
                    out.println("</script>");
                    CambioRealizado2 = "ERROR: No puede ingresar numeros como primer apellido";

                } else if (obj_campos.espacioBlanco(primerApellido)) {
                    out.println("<script type=\"text/javascript\">");
                    out.println("location='parametrizaciones/Operadores.jsp';");
                    out.println("alert('Error: Ingrese un primer apellido');");
                    out.println("</script>");
                    CambioRealizado2 = "ERROR: Ingrese un primer apellido'";

                } else if (obj_campos.caracteresRaros(primerApellido.toCharArray(), 0)) {
                    out.println("<script type=\"text/javascript\">");
                    out.println("location='parametrizaciones/Operadores.jsp';");
                    out.println("alert('Error: No puede ingresar caracteres extraños en campo primer apellido');");
                    out.println("</script>");
                    CambioRealizado2 = "ERROR: No puede ingresar caracteres extraños como primer apellido";

                }
                //segundo apelldio
                if (!obj_campos.es_letras(segundoApellido)) {
                    out.println("<script type=\"text/javascript\">");
                    out.println("location='parametrizaciones/Operadores.jsp';");
                    out.println("alert('Error: No puede ingresar números como primer apellido');");
                    out.println("</script>");
                    CambioRealizado2 = "ERROR: No puede ingresar números como primer apellido";

                } else if (obj_campos.espacioBlanco(segundoApellido)) {
                    out.println("<script type=\"text/javascript\">");
                    out.println("location='parametrizaciones/Operadores.jsp';");
                    out.println("alert('Error: Ingrese un segundo apellido');");
                    out.println("</script>");
                    CambioRealizado2 = "ERROR: Ingrese un segundo apellido";

                } else if (obj_campos.caracteresRaros(segundoApellido.toCharArray(), 0)) {
                    out.println("<script type=\"text/javascript\">");
                    out.println("location='parametrizaciones/Operadores.jsp';");
                    out.println("alert('Error: No puede ingresar caracteres extraños en campo segundo apellido');");
                    out.println("</script>");
                    CambioRealizado2 = "ERROR: Ingreso caracteres extraños en campo segundo apellido";
                }
                //identificacion
                /* El campo identificacion son numeros, no letras
                if (!obj_campos.es_letras(identificacion)) {
                    out.println("<script type=\"text/javascript\">");
                    out.println("location='parametrizaciones/Operadores.jsp';");
                    out.println("alert('Error: no puede ingresar numeros como primer apellido');");
                    out.println("</script>");
                    CambioRealizado2 = "ERROR: Ingreso caracteres extraños en campo segundo apellido";
                    
                } */
                if (obj_campos.espacioBlanco(identificacion)) {
                    out.println("<script type=\"text/javascript\">");
                    out.println("location='parametrizaciones/Operadores.jsp';");
                    out.println("alert('Error: Ingrese una identificación');");
                    out.println("</script>");
                    CambioRealizado2 = "ERROR: Ingrese una identificacion";
                } else if (obj_campos.caracteresRaros(identificacion.toCharArray(), 0)) {
                    out.println("<script type=\"text/javascript\">");
                    out.println("location='parametrizaciones/Operadores.jsp';");
                    out.println("alert('Error: No puede ingresar caracteres extraños en campo identificación');");
                    out.println("</script>");
                    CambioRealizado2 = "ERROR: no puede ingresar caracteres extraños en campo identificación";
                    /*  }
                //edad
                La edad es de tipo int, esta validacion no sirve
               if (!obj_campos.es_letras(edad)) {
                    out.println("<script type=\"text/javascript\">");
                    out.println("location='parametrizaciones/Operadores.jsp';");
                    out.println("alert('Error: no puede ingresar numeros como primer apellido');");
                    out.println("</script>");*/

                }
                if (obj_campos.espacioBlanco(edad)) {
                    out.println("<script type=\"text/javascript\">");
                    out.println("location='parametrizaciones/Operadores.jsp';");
                    out.println("alert('Error: Ingrese una edad');");
                    out.println("</script>");
                    CambioRealizado2 = "ERROR: Ingrese una edad";

                } else if (obj_campos.caracteresRaros(edad.toCharArray(), 0)) {
                    out.println("<script type=\"text/javascript\">");
                    out.println("location='parametrizaciones/Operadores.jsp';");
                    out.println("alert('Error: No puede ingresar caracteres extraños en el campo edad');");
                    out.println("</script>");
                    CambioRealizado2 = "ERROR: No puede ingresar caracteres extraños en el campo edad";
                }
                //email
                if (!obj_campos.es_letras(email)) {
                    out.println("<script type=\"text/javascript\">");
                    out.println("location='parametrizaciones/Operadores.jsp';");
                    out.println("alert('Error: No puede ingresar numeros como en el campo email');");
                    out.println("</script>");
                    CambioRealizado2 = "ERROR: No puede ingresar numeros como en el campo email";

                } else if (obj_campos.espacioBlanco(email)) {
                    out.println("<script type=\"text/javascript\">");
                    out.println("location='parametrizaciones/Operadores.jsp';");
                    out.println("alert('Error: Ingrese un email');");
                    out.println("</script>");
                    CambioRealizado2 = "ERROR: Ingrese un email";

                } else if (obj_campos.caracteresRarosEceptocedula(email.toCharArray(), 0)) {
                    out.println("<script type=\"text/javascript\">");
                    out.println("location='parametrizaciones/Operadores.jsp';");
                    out.println("alert('Error: No puede ingresar caracteres extraños en campo Email');");
                    out.println("</script>");
                    CambioRealizado2 = "ERROR: No puede ingresar caracteres extraños en campo Email";
                    /*   }
                //clave
                    Validacion mala, en el campo clave se pueden ingresar numeros
               if (!obj_campos.es_letras(clave)) {
                    out.println("<script type=\"text/javascript\">");
                    out.println("location='parametrizaciones/Operadores.jsp';");
                    out.println("alert('Error: no puede ingresar numeros como primer apellido');");
                    out.println("</script>");*/

                } else if (obj_campos.espacioBlanco(clave)) {
                    out.println("<script type=\"text/javascript\">");
                    out.println("location='parametrizaciones/Operadores.jsp';");
                    out.println("alert('Error: Ingrese una clave');");
                    out.println("</script>");
                    CambioRealizado2 = "ERROR: Ingrese una clave";

                } else if (obj_campos.caracteresRaros(clave.toCharArray(), 0)) {
                    out.println("<script type=\"text/javascript\">");
                    out.println("location='parametrizaciones/Operadores.jsp';");
                    out.println("alert('Error: No puede ingresar caracteres extraños en campo clave');");
                    out.println("</script>");
                    CambioRealizado2 = "ERROR: No puede ingresar caracteres extraños en campo clave";

                    /*}
                //telefono
                    Validacion mala, el campo telefono es int
                if (!obj_campos.es_letras(telefono)) {
                    out.println("<script type=\"text/javascript\">");
                    out.println("location='parametrizaciones/Operadores.jsp';");
                    out.println("alert('Error: no puede ingresar numeros como primer apellido');");
                    out.println("</script>");*/
                } else if (obj_campos.espacioBlanco(telefono)) {
                    out.println("<script type=\"text/javascript\">");
                    out.println("location='parametrizaciones/Operadores.jsp';");
                    out.println("alert('Error: Ingrese un teléfono');");
                    out.println("</script>");
                    CambioRealizado2 = "ERROR: Ingrese un telefono";

                } else if (obj_campos.caracteresRaros(telefono.toCharArray(), 0)) {
                    out.println("<script type=\"text/javascript\">");
                    out.println("location='parametrizaciones/Operadores.jsp';");
                    out.println("alert('Error: No puede ingresar caracteres extraños en campo teléfono');");
                    out.println("</script>");
                    CambioRealizado2 = "ERROR: No puede ingresar caracteres extraños en campo teléfono";
                }
                //direccion
              
                /*En la direccion se pueden ingresar numeros
                if (!obj_campos.es_letras(direccion)) {
                    out.println("<script type=\"text/javascript\">");
                    out.println("location='parametrizaciones/Operadores.jsp';");
                    out.println("alert('Error: no puede ingresar numeros como primer apellido');");
                    out.println("</script>");
                }*/ 
                else if (obj_campos.espacioBlanco(direccion)) {
                    out.println("<script type=\"text/javascript\">");
                    out.println("location='parametrizaciones/Operadores.jsp';");
                    out.println("alert('Error: Ingrese una dirección');");
                    out.println("</script>");
                    CambioRealizado2 = "ERROR: Ingrese una direccion";
                } else if (obj_campos.caracteresRaros(direccion.toCharArray(), 0)) {
                    out.println("<script type=\"text/javascript\">");
                    out.println("location='parametrizaciones/Operadores.jsp';");
                    out.println("alert('Error: No puede ingresar caracteres extraños en campo dirección');");
                    out.println("</script>");
                    CambioRealizado2 = "ERROR: No puede ingresar caracteres extraños en campo dirección";
                }
                usu = new Usuario(primerNombre, segundoNombre, primerApellido, segundoApellido, identificacion, edad_int,
                        email, clave, telefono, direccion, nivel);
                dao.insertarOperador(usu);
                out.println("<script type=\"text/javascript\">");
                out.println("location='parametrizaciones/Operadores.jsp';");
                out.println("alert('Operador ingresado exitosamente');");
                out.println("</script>");
                CambioRealizado2 = "Ingreso un operador ("+email+")";
            }

            int IdUsuario = Integer.parseInt(request.getParameter("IdUsuario"));
            String Modulo = "Operadores";
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
