package vn.com.vng.tulm.httpsession;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws IOException, ServletException {
        // Step 1
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        HttpSession session = request.getSession(false);
        if(session == null) {
            // Step 2
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            
            session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("password", password);
            
            if(username.equals("admin") && password.equals("root")) {
                out.print("<h4 class='mt-5 ml-4'>Congraguration,"
                        + "login successful!</h4>");
                RequestDispatcher rd = request.getRequestDispatcher("index.html");
                rd.include(request, response);
            } else {
                out.print("<h4 class='text-center mt-5'>Sorry, "
                        + "wrong username or password!<h4>");
                session.invalidate();
                RequestDispatcher rd = request.getRequestDispatcher("login.html");
                rd.include(request, response);
            }
        } else {
            out.print("<h4 class='mt-5 ml-4'>Already login!</h4>");
            RequestDispatcher rd = request.getRequestDispatcher("index.html");
            rd.include(request, response);
        }
        
        out.close();
    }
}
