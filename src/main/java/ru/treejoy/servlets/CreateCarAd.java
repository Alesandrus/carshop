package ru.treejoy.servlets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.treejoy.model.User;
import ru.treejoy.model.parts.Body;
import ru.treejoy.model.parts.Motor;
import ru.treejoy.model.parts.Transmission;
import ru.treejoy.model.parts.WheelDrive;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CreateCarAd extends HttpServlet {
    /**
     * Логгер.
     */
    private static final Logger LOGGER = LogManager.getLogger(Logger.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/CreateCarAd.jsp");
            dispatcher.forward(req, resp);
        } else {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/SignUp.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
