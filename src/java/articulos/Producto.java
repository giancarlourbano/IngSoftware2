package articulos;

import java.sql.*;
import java.io.*;
import java.util.*;

public class Producto {

    private int codigo;
    private String nombre;
    private String desc;
    private float precio;
    private InputStream foto;
    //
  //  private String classFor="com.mysql.jdbc.Driver";
  //  private String url="jdbc:mysql://localhost/BDProductos";
  //  private String usuario="root";
  //  private String clave="fredy";

    public Producto buscarProductoCodigo(int codigo){
        Producto pro=null;
        Connection cn=null;
        PreparedStatement pr=null;
        ResultSet rs=null;
        String sql="SELECT * FROM articulos WHERE id=?";
        try{
         //   Class.forName(classFor);
         //   cn=DriverManager.getConnection(url, usuario,clave);
            cn = Conexion.getConexion();
            pr=cn.prepareStatement(sql);
            pr.setInt(1, codigo);
            rs=pr.executeQuery();
            while(rs.next()){
                pro=new Producto();
                pro.setCodigo(codigo);
                pro.setNombre(rs.getString("nombre"));
                pro.setDesc(rs.getString("descripcion"));
                pro.setPrecio(rs.getFloat("precio"));
                pro.setFoto(rs.getBinaryStream("imagen"));
                break;
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            try{
                rs.close();
                pr.close();
                cn.close();
            }catch(Exception ex){

            }
        }
        return pro;
    }
    
    public boolean actualizarProducto(int creditos,int id)  {
        Connection cn=null;
        PreparedStatement pr = null;
        ResultSet rs=null;
        float precio=0.0f;
        
        try {
        //    Class.forName(classFor);
         //   cn=DriverManager.getConnection(url, usuario,clave);
            cn = Conexion.getConexion();
            
            String select="select precio from articulos where id="+id;
            pr=cn.prepareStatement(select);
            rs=pr.executeQuery();
            while(rs.next()){
                precio=rs.getFloat("precio");
            }
            float suma=precio+creditos;
            String sql = "update articulos set precio="+suma+" where id="+id;
            pr = cn.prepareStatement(sql);
            pr.executeUpdate();
            


        } catch (Exception ex) {
            return false;
        } finally {
            cn=null;
            pr = null;
            rs=null;
        }
        return true;
    }


    public Vector<Producto> buscarProducto(){
        Vector<Producto> vecPro=new Vector<Producto>();
        Connection cn=null;
        PreparedStatement pr=null;
        ResultSet rs=null;
        String sql="SELECT * FROM articulos ORDER BY nombre";
        try{
         //   Class.forName(classFor);
        //    cn=DriverManager.getConnection(url, usuario,clave);
            cn = Conexion.getConexion();
            pr=cn.prepareStatement(sql);
            rs=pr.executeQuery();
            while(rs.next()){
                Producto pro=new Producto();
                pro.setCodigo(rs.getInt("id"));
                pro.setNombre(rs.getString("nombre"));
                pro.setDesc(rs.getString("descripcion"));
                pro.setPrecio(rs.getFloat("precio"));
                pro.setFoto(rs.getBinaryStream("imagen"));
                vecPro.add(pro);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            try{
                rs.close();
                pr.close();
                cn.close();
            }catch(Exception ex){

            }
        }
        return vecPro;
    }


    public byte[] obtenImagenProducto(int idProducto)  {
        Connection cn=null;
        ResultSet rs = null;
        PreparedStatement pr = null;
        byte[] buffer = null;
        try {
        //    Class.forName(classFor);
         //   cn=DriverManager.getConnection(url, usuario,clave);
            cn = Conexion.getConexion();
            String sql = "select imagen from articulos where id = ?";
            pr = cn.prepareStatement(sql);
            pr.setInt(1, idProducto);
            rs = pr.executeQuery();
            while (rs.next()){
                Blob bin = rs.getBlob("imagen");
                if (bin != null) {
                    InputStream inStream = bin.getBinaryStream();
                    int size = (int) bin.length();
                    buffer = new byte[size];
                    int length = -1;
                    int k = 0;
                    try {
                        inStream.read(buffer, 0, size);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        } catch (Exception ex) {
            return null;
        } finally {
            cn=null;
            rs = null;
            pr = null;
        }
        return buffer;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public InputStream getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(InputStream foto) {
        this.foto = foto;
    }

}
