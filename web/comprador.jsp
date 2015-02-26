
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Comprador</title>

    </head>
    <body  background= 'images\sfondo.gif'>
         <h1>Bienvenido Comprador</h1>
        <form action="s02" method="POST" enctype="multipart/form-data">
            
         DNI:   <input type="text" maxlength="8" name="dni">
            <br>
         Nombre y Apellido:   <input type="text" name="nombre">
            <br>
         Nombre de usuario:   <input type="text" name="user">
            <br>
         Password:   <input type="password" name="clave">
            <br>
            
         <input type="submit" value="Registrar">
         <input type="reset" value="Borrar">
         
         <br>
         <br>
         
        </form>
        ¿Ya esta registrado?
         <br><input type="button" onclick="location.href='loginV.jsp'" value="Ingresar">
    </form
    </body>
</html>
