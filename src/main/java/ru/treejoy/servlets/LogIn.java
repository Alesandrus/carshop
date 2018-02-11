package ru.treejoy.servlets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.treejoy.dao.UserDAO;
import ru.treejoy.dao.daofactory.DAOFactory;
import ru.treejoy.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Сервлет, отвечающий за аутентификацию пользователя.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 11.02.2018
 */
public class LogIn extends HttpServlet {
    /**
     * Логгер.
     */
    private static final Logger LOGGER = LogManager.getLogger(Logger.class.getName());

    /**
     * Аутентификация пользователя.
     *
     * @param req  запрос.
     * @param resp ответ.
     * @throws ServletException .
     * @throws IOException      .
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        int factoryID = (Integer) getServletContext().getAttribute("factoryID");
        DAOFactory daoFactory = DAOFactory.getDAOFactory(factoryID);
        User user = null;
        if (daoFactory != null) {
            UserDAO userDAO = daoFactory.getUserDAO();
            user = userDAO.getByLoginAndPassword(login, password);
            session.setAttribute("user", user);
        }
        if (user == null) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/Notfound.jsp");
            dispatcher.forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath());
        }
    }
}