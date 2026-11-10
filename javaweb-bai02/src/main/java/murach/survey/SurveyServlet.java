package murach.survey;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import murach.business.Survey;
import murach.business.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SurveyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String[] selectedMethods = request.getParameterValues("contactBy");
        List<String> contactMethods = new ArrayList<>();
        if (selectedMethods != null) {
            for (String method : selectedMethods) {
                contactMethods.add(contactMethodLabel(method));
            }
        }

        User user = new User(
                valueOrEmpty(request.getParameter("firstName")),
                valueOrEmpty(request.getParameter("lastName")),
                valueOrEmpty(request.getParameter("email")),
                valueOrEmpty(request.getParameter("birthDate")));

        Survey survey = new Survey(
                sourceLabel(request.getParameter("source")),
                request.getParameter("announcements") != null,
                request.getParameter("newProducts") != null,
                contactMethods);

        request.setAttribute("user", user);
        request.setAttribute("survey", survey);
        request.getRequestDispatcher("/thanks.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.sendRedirect(request.getContextPath() + "/");
    }

    private String valueOrEmpty(String value) {
        return value == null ? "" : value;
    }

    private String contactMethodLabel(String value) {
        return switch (value) {
            case "email_postal" -> "Email or postal mail";
            case "email" -> "Email only";
            case "postal" -> "Postal mail only";
            default -> value;
        };
    }

    private String sourceLabel(String value) {
        if (value == null) return "Not selected";
        return switch (value) {
            case "search" -> "Search engine";
            case "word" -> "Word of mouth";
            case "social" -> "Social Media";
            case "other" -> "Other";
            default -> value;
        };
    }
}