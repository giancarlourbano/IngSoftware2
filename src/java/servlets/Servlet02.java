/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;


import edu.ulima.sw2.Registrar_Service;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author Administrador
 */
public class Servlet02 extends HttpServlet {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/SubastaWS/Registrar.wsdl")
    private Registrar_Service service;

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
        
        String tipo=(String)ses.getAttribute("tipo");
        
        
         Integer dni=Integer.parseInt(request.getParameter("dni"));
         String nombre=request.getParameter("nombre");
         String user=request.getParameter("user");
         String clave=request.getParameter("clave");
         
         boolean rpta=registrar(dni, nombre, user, clave);
         RequestDispatcher rs=null;
         if(tipo.equalsIgnoreCase("comprador")){
             rs=request.getRequestDispatcher("/creditos");
             rs.forward(request, response);
         }else if(tipo.equalsIgnoreCase("vendedor")){
             rs=request.getRequestDispatcher("/articulo.jsp");
             rs.forward(request, response);
         }else{
             rs=request.getRequestDispatcher("/lista");
             rs.forward(request, response);
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

    private boolean registrar(java.lang.Integer dni, java.lang.String nombre, java.lang.String usuario, java.lang.String clave) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        edu.ulima.sw2.Registrar port = service.getRegistrarPort();
        return port.registrar(dni, nombre, usuario, clave);
    }



}
