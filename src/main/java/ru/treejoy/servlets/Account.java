package ru.treejoy.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.treejoy.dao.CarAdDAO;
import ru.treejoy.dao.daofactory.DAOFactory;
import ru.treejoy.model.User;
import ru.treejoy.model.ad.CarAd;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Сервлет, отвечающий за получение всех объявлений залогинившегося пользователя.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 11.02.2018
 */
public class Account extends HttpServlet {
    /**
     * Логгер.
     */
    private static final Logger LOGGER = LogManager.getLogger(Logger.class.getName());

    /**
     * Проверяет залогинин ли пользователь.
     *
     * @param req  запрос.
     * @param resp ответ.
     * @throws ServletException .
     * @throws IOException      .
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/Account.jsp");
            dispatcher.forward(req, resp);
        } else {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/SignUp.jsp");
            dispatcher.forward(req, resp);
        }
    }

    /**
     * Отправка JSON со списком объявлений пользователя.
     *
     * @param req  запрос.
     * @param resp ответ.
     * @throws ServletException .
     * @throws IOException      .
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            long id = user.getId();
            int factoryID = (Integer) getServletContext().getAttribute("factoryID");
            DAOFactory daoFactory = DAOFactory.getDAOFactory(factoryID);
            if (daoFactory != null) {
                CarAdDAO carAdDAO = daoFactory.getCarAdDAO();
                List<CarAd> ads = carAdDAO.getAllByUserId(id);
                ObjectMapper mapper = new ObjectMapper();
                PrintWriter writer = resp.getWriter();
                mapper.writeValue(writer, ads);
            }
        } else {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/SignUp.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
