/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Administrador
 */
@MultipartConfig(maxFileSize = 1024*1024*1024)
public class Servlet05 extends HttpServlet {
        /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
        HttpSession ses=request.getSession(true);
       
        String nombre=request.getParameter("nombre");
        String desc=request.getParameter("descripcion");
        Float precio=Float.parseFloat(request.getParameter("precio"));

       String usuario=(String)ses.getAttribute("user");
        
        InputStream inputStream = null;//defino el canal de comunicacion
        Part filePart = request.getPart("imagen");
        if(filePart!=null){//verifico que me traiga algo
            //MIRO SI SE ESTAN TRALLENDO ADECUADAMENTE LOS ARCHIVOS
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());//fORMATO MIME DEL ARCHIVO
            inputStream = filePart.getInputStream();//asigno el objeto al inputStream
        }
        
        
        
        Connection conn = null;//
        String message = null;
        ResultSet rs=null;
        PreparedStatement statement=null;
        Integer dni=0;
        
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Servlet05.class.getName()).log(Level.SEVERE, null, ex);
            }
            conn=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/sw2","root","root");
            //lo siguiente cambia segun el motor
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                                
            
            String select="Select dni from usuarios where usuario='"+usuario+"'";
            statement=conn.prepareStatement(select);
            rs=statement.executeQuery();
                while(rs.next()){
                    dni=rs.getInt(1);
                }
            
            //preparamos el estamento
            String sql = "INSERT INTO articulos(nombre,descripcion,precio,imagen,usuario) "
                    + "VALUES(?,?,?,?,?)";
            statement= conn.prepareStatement(sql);
            //fetch
            statement.setString(1, nombre);
            statement.setString(2, desc);
            statement.setFloat(3, precio);
            statement.setInt(5,dni);
            
            //para insertar una foto debo hacer el sgte control
            if(inputStream!=null){
                statement.setBlob(4, inputStream);//8 significa la posicion del parametro donde se enceutra la foto
            }
            //enviar los estamentos a la BD
            statement.executeUpdate();
            
        } catch (SQLException ex) {
            message = "Error: "+ex.getMessage();
            ex.printStackTrace();
        }
        finally{
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    
                }
            }   
            //Colocar el mensaje en el ambito del request
            
            //reenviar a la pagina del mensaje
            getServletContext().getRequestDispatcher("/lista.jsp").forward(request, response);
        }
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            /*out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet05</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Servlet05 at " + message + "</h1>");
            out.println("</body>");
            out.println("</html>");*/
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
