package ru.treejoy.servlets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.treejoy.dao.UserDAO;
import ru.treejoy.dao.daofactory.DAOFactory;
import ru.treejoy.exceptions.CreateEmailException;
import ru.treejoy.exceptions.CreateLoginException;
import ru.treejoy.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Сервлет, отвечающий за регистрацию пользователя.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 11.02.2018
 */
public class SignUp extends HttpServlet {
    /**
     * Логгер.
     */
    private static final Logger LOGGER = LogManager.getLogger(Logger.class.getName());

    /**
     * Перенаправление запроса на страницу регистрации.
     *
     * @param req  запрос.
     * @param resp ответ.
     * @throws ServletException .
     * @throws IOException      .
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/SignUp.jsp");
        dispatcher.forward(req, resp);
    }

    /**
     * Регистрация пользователя.
     *
     * @param req  запрос.
     * @param resp ответ.
     * @throws ServletException .
     * @throws IOException      .
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);
        int factoryID = (Integer) getServletContext().getAttribute("factoryID");
        DAOFactory daoFactory = DAOFactory.getDAOFactory(factoryID);
        if (daoFactory != null) {
            UserDAO userDAO = daoFactory.getUserDAO();
            try {
                userDAO.create(user);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/Successcreate.jsp");
                requestDispatcher.forward(req, resp);
            } catch (CreateLoginException e) {
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/Failcreatelogin.jsp");
                requestDispatcher.forward(req, resp);
            } catch (CreateEmailException e) {
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/Failcreateemail.jsp");
                requestDispatcher.forward(req, resp);
            } catch (Exception e) {
                LOGGER.error(e.getMessage(), e);
            }
        }
    }
}
