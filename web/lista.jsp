<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="articulos.*"%>

<%
            String mensaje = "";
            if (request.getParameter("men") != null) {
                mensaje = request.getParameter("men");
            }

            Producto pro = new Producto();
            // pro=pro.obtenImagenProducto(Integer.parseInt(request.getParameter("cod")));
            //    byte[] imag = pro.obtenImagenProducto(Integer.parseInt(request.getParameter("cod")));

%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-language" content="es">
        <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7">
        <title>Registro Productos</title>
    </head>

    <body  background= 'images\sfondo.gif'>
        
        <center>
            <h1><i>Lista de articulos</i></h1>
            

            
                            <%
for (Producto temp : pro.buscarProducto()) {
            %>
            <form action="s06" method="POST">
            <table width="203" border="6">
                <tr>
                    <td  align="center">Imagen</td>
                    <td align="center">Nombre</td>
                    <td >Precio</td>
                </tr>
            <tbody border="6">
                <tr>
                        <td ><img src="SerImpimage?cod=<%= temp.getCodigo()%>" width="150" height="160"></td>
                        <input type="text" value="<%=temp.getCodigo()%>" name="id" hidden="true">

                        <td align="center" ><%= temp.getNombre()%></td>
                        <td align="center"><%= temp.getPrecio()%></td>
                        <td align="center"><input type="text" name="suma"><input type="submit" value="subastar"></td>
                </tr>
                    </tbody>
            </table>
                        
            </form>
                <%}%>
                <p align="center"><input type="button" value="SALIR" onclick="location.href='index.jsp'">
            </p>
        </center>
    </body>
</html>
