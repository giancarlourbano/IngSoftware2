/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;


import articulos.Producto;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SerImpimage extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     //   HttpSession sesion=request.getSession();
        response.setContentType("image/jpeg");
        Producto p = new Producto();
     //   String idProducto = String.valueOf(sesion.getAttribute("codigoProducto"));
     //  int idProd = Integer.parseInt(idProducto);
        int idProd=Integer.parseInt(request.getParameter("cod"));
        byte[] imag = p.obtenImagenProducto(idProd);
        if (imag != null) {
            ServletOutputStream out2 = response.getOutputStream();
            out2.write(imag);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
