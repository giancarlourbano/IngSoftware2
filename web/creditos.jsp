<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Creditos</title>

    </head>
    <body  background= 'images\sfondo.gif'>
        <h1>Compra de creditos</h1>
        
        <form action="s04" method="POST">
            
            DNI: <input type="text" name="dni" maxlength="8">
            <br>Cantidad de creditos: <input type="text" name="cred">
            <br><input type="submit" value="Comprar">
            
        </form>
    </body>
</html>
