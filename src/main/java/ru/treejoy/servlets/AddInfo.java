package ru.treejoy.servlets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.treejoy.dao.CarAdDAO;
import ru.treejoy.dao.daofactory.DAOFactory;
import ru.treejoy.model.ad.CarAd;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * Сервлет, отвечающий за получение информации об объявлении.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 11.02.2018
 */
public class AddInfo extends HttpServlet {
    /**
     * Логгер.
     */
    private static final Logger LOGGER = LogManager.getLogger(Logger.class.getName());

    /**
     * Получение информации об объявлении и ее сохранение в запросе.
     *
     * @param req  запрос.
     * @param resp ответ.
     * @throws ServletException .
     * @throws IOException      .
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long adId = Long.parseLong(req.getParameter("id"));
        int factoryID = (Integer) getServletContext().getAttribute("factoryID");
        DAOFactory daoFactory = DAOFactory.getDAOFactory(factoryID);
        if (daoFactory != null) {
            CarAdDAO carAdDAO = daoFactory.getCarAdDAO();
            CarAd ad = carAdDAO.getByID(adId);
            req.setAttribute("ad", ad);
            String pattern = "dd.MM.yyyy H:m";
            SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
            String created = dateFormat.format(ad.getCreated());
            req.setAttribute("created", created);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/AdInfo.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
