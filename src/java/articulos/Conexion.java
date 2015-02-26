/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package articulos;
import java.sql.*;
public class Conexion {
    public static Connection getConexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost/sw2";
            String usuario="root";
            String clave="root";
            return DriverManager.getConnection(url,usuario,clave);
        }catch(SQLException ex){
            ex.printStackTrace();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
