package murach.cart;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import murach.business.Cart;

public class CheckoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String CART_ATTRIBUTE = "cart";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
        HttpSession session = request.getSession();
        Object lock = session.getId().intern();

        synchronized (lock) {
            Object savedCart = session.getAttribute(CART_ATTRIBUTE);
            Cart cart = savedCart instanceof Cart ? (Cart) savedCart : null;
            if (cart == null) {
                cart = new Cart();
                session.setAttribute(CART_ATTRIBUTE, cart);
            }
            session.setAttribute(CART_ATTRIBUTE, cart);
        }
        request.getRequestDispatcher("/checkout.jsp").forward(request, response);
    }
}