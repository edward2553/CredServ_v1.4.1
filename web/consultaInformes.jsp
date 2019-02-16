<%-- 
    Document   : consultaInformes
    Created on : 15/02/2019, 08:09:13 PM
    Author     : edwar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
        
            String noombrePDF = request.getParameter("nombreInforme");
        %>
        
         
        <script>
            window.open("archivos_informes/<%=noombrePDF%>");
            location='Informes/consultar_informe.jsp';
        </script>

            
        
    </body>
</html>
