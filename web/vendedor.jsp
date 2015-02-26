
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vendedor</title>
        <!-- Include meta tag to ensure proper rendering and touch zooming -->
<meta name="viewport" content="width=device-width, initial-scale=1">


    </head>
    <body background= 'images\sfondo.gif'>
    <center>
        <h1>Bienvenido Vendedor</h1>
        <table> 
        <form action="s02" method="POST" >
            
            <tr>
                <td colspan="1">DNI: </td>  
                <td colspan="1"><input type="text" maxlength="8" name="dni"></td>
            </tr>
            <tr>
                <td>Nombre y Apellido:</td>   <td><input type="text" name="nombre"></td>
            </tr>
            <tr>
                <td>Nombre de usuario:</td>   <td><input type="text" name="user"></td>
            </tr>
            <tr>
                <td>Password:</td>   <td><input type="password" name="clave"></td>
             
            <tr>
                <td></td>
                <td><input type="submit" value="Registrar">
                <input type="reset" value="Borrar"></td>
                
            </tr>  
            
         
         
         <br>
         <br>
         
        </form>
        </table>
        ¿Ya esta registrado?
         <br><input type="button" onclick="location.href='loginV.jsp'" value="Ingresar">
    </center>
    </body>
</html>
