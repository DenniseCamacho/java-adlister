import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PizzaOrderServlet", urlPatterns = "/pizza-order")
public class PizzaOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("/pizza-order.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pizzaSize = request.getParameter("pizzaSize");
        String pizzaCrust = request.getParameter("pizzaCrust");
        String pizzaSauce = request.getParameter("pizzaSauce");
        String pizzaCheese = request.getParameter("pizzaCheese");
        String[] pizzaToppings = request.getParameterValues("pizzaToppings");
        request.setAttribute("pizzaToppings", pizzaToppings);
        request.setAttribute("pizzaCheese", pizzaCheese);
        request.setAttribute("pizzaSauce", pizzaSauce);
        request.setAttribute("pizzaSize", pizzaSize);
        request.setAttribute("pizzaCrust", pizzaCrust);
        request.getRequestDispatcher("/pizza-order.jsp").forward(request, response);


    }
}
