import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CounterServlet", urlPatterns = "/count")
public class CounterServlet extends HttpServlet {
    private int counter = 0;
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        counter += 1;
        if(req.getParameter("reset") != null) {
            counter = 0;
            resp.sendRedirect("/count");
        } else {
            resp.getWriter().println("<h1>You have viewed : "+ counter + " times</h1>");
        }
    }

}
