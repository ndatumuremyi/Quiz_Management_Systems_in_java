/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sevletsdemo;

/**
 *
 * @author Kwizera
 */
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
          
@WebServlet("/test")
public class TestServlet extends HttpServlet
{
    // process "get" requests from clients

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException
    {
response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // send HTML page to client
        out.println("<html>");
        out.println("<head><title>A Test Servlet</title></head>");
        out.println("<body>");
        out.println("<h1>Test</h1>");
        out.println("<p>Simple servlet for testing.</p>");
        out.println("</body></html>");
    }
    public static void main(String[] args) {
        TestServlet servletes=new TestServlet();
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        try {
            servletes.doGet(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(TestServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
 
}

