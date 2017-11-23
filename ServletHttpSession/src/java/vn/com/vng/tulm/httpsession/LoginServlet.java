package vn.com.vng.tulm.httpsession;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) {
        // Step 1
        response.setContentType("text/html");
        
        // Step 2
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        // Step 3
        if(username.equals("admin") && password.equals("root")) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("password", password);
        }
    }
}
