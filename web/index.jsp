<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Software 2</title>

    </head>
    <body background= 'images\sfondo.gif' >
    <center>
        <h1 >Bienvenido a la Subasta</h1>
        
        <h3>¿Como desea ingresar?</h3>
        <form action="s01" method="GET">
            <select name="tipo">
                <option name="tipo" value="vendedor">Vendedor</option>
                <option name="tipo" value="observador">Observador</option>
                <option name="tipo" value="comprador">Comprador</option>
            </select>
            <br><input type="submit" value="Entrar">
        </form>
    </center>
    </body>
</html>
