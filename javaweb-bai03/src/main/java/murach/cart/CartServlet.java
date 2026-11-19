package murach.cart;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

import murach.business.Cart;
import murach.business.LineItem;
import murach.business.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class CartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String CART_ATTRIBUTE = "cart";
    private static final Map<String, Product> PRODUCTS = Map.of(
            "cd1", new Product("cd1", "86 (the band) - True Life Songs and Pictures", new BigDecimal("14.95")),
            "cd2", new Product("cd2", "Paddlefoot - The first CD", new BigDecimal("12.95")),
            "cd3", new Product("cd3", "Paddlefoot - The second CD", new BigDecimal("14.95")),
            "cd4", new Product("cd4", "Joe Rut - Genuine Wood Grained Finish", new BigDecimal("14.95")));

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        showCart(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        Object lock = session.getId().intern();

        synchronized (lock) {
            Cart cart = getCart(session, lock);
            String action = request.getParameter("action");
            String id = request.getParameter("id");

            if ("add".equals(action)) {
                Product product = PRODUCTS.get(id);
                if (product != null) cart.addItem(new LineItem(product, 1));
            } else if ("update".equals(action)) {
                int quantity = parseQuantity(request.getParameter("quantity"));
                if (quantity > 0) {
                    for (LineItem item : cart.getItems()) {
                        if (item.getProduct().getCode().equals(id)) {
                            item.setQuantity(quantity);
                            break;
                        }
                    }
                }
            } else if ("remove".equals(action)) {
                Product product = PRODUCTS.get(id);
                if (product != null) cart.removeItem(new LineItem(product, 0));
            }
        }

        response.sendRedirect(request.getContextPath() + "/cart");
    }

    private void showCart(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
        HttpSession session = request.getSession();
        Object lock = session.getId().intern();

        synchronized (lock) {
            Cart cart = getCart(session, lock);
            request.setAttribute("cart", cart);
        }
        request.getRequestDispatcher("/cart.jsp").forward(request, response);
    }

    private Cart getCart(HttpSession session, Object lock) {
        synchronized (lock) {
            Object savedCart = session.getAttribute(CART_ATTRIBUTE);
            Cart cart = savedCart instanceof Cart ? (Cart) savedCart : null;
            if (cart == null) {
                cart = new Cart();
                session.setAttribute(CART_ATTRIBUTE, cart);
            }
            return cart;
        }
    }

    private int parseQuantity(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException ex) {
            return 0;
        }
    }
}