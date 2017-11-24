package vn.com.vng.tulm.httpsession;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException, ServletException {
        // Step 1
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        
        // Step 2
        HttpSession session = request.getSession(false);
        if(session == null) {
            writer.print("<h4 class='mt-5 ml-4'>You're not logging in!</h4>");
            request.getRequestDispatcher("index.html")
                    .include(request, response);
        } else {
            String sessionId = (String) session.getId();
            String username = (String) session.getAttribute("username");
            writer.print("<h4'>Hello " + username +
                    ", your session id is " +
                    sessionId + "</h4>");
        }
    }
}
