package vn.com.vng.tulm.httpsession;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        // Step 1:
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // Step 2: release session
        HttpSession session = request.getSession(false);
        if(session == null) {
            out.print("<h4 class='mt-5 ml-4'>You're not logging in!</h4>");
        } else {
            session.invalidate();
            out.print("<h4 class='mt-5 ml-4'>You are successfully logout!</h4>");
        }
        
        // Step 3:
        RequestDispatcher rd = request.getRequestDispatcher("index.html");
        rd.include(request, response);
        
        out.close();
    }
}
