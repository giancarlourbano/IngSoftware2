
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo Articulo</title>

    </head>
    
    <body  background= 'images\sfondo.gif'>
        
        <form action="s05" enctype="multipart/form-data" method="POST" >
        <h1>Descripcion del articulo</h1>
        Nombre:<input type="text" name="nombre"  />
        <br>Descripcion: <br><input type="text" name="descripcion" rows="4" cols="20" 
         >
        
        <br>Precio base: <input type="text" name="precio">
        <br><input type="file" name="imagen"  />
        <br><input type="submit" value="Registrar">
        </form>
    </body>
</html>
