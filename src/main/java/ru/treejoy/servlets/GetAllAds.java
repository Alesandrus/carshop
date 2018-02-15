package ru.treejoy.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.treejoy.dao.CarAdDAO;
import ru.treejoy.dao.daofactory.DAOFactory;
import ru.treejoy.model.ad.CarAd;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Сервлет, отвечающий за получение всех объявления.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 11.02.2018
 */
public class GetAllAds extends HttpServlet {
    /**
     * Логгер.
     */
    private static final Logger LOGGER = LogManager.getLogger(Logger.class.getName());

    /**
     * Отправка JSON со списком всех объявлений.
     *
     * @param req  запрос.
     * @param resp ответ.
     * @throws ServletException .
     * @throws IOException      .
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String brand = req.getParameter("brand");
        String model = req.getParameter("model");
        String foto = req.getParameter("foto");
        String today = req.getParameter("today");

        long brandID = 0;
        if (brand != null && !brand.isEmpty()) {
            brandID = Long.parseLong(brand);
        }
        long modelID = 0;
        if (model != null && !model.isEmpty()) {
            modelID = Long.parseLong(model);
        }
        boolean onlyWithFoto = false;
        if (foto != null && foto.equals("on")) {
            onlyWithFoto = true;
        }
        boolean isToday = false;
        if (today != null && today.equals("on")) {
            isToday = true;
        }

        Integer factoryID = (Integer) getServletContext().getAttribute("factoryID");
        DAOFactory daoFactory = DAOFactory.getDAOFactory(factoryID);
        List<CarAd> ads = new ArrayList<>();
        if (daoFactory != null) {
            CarAdDAO carAdDAO = daoFactory.getCarAdDAO();
            ads = carAdDAO.getAllFromFilter(brandID, modelID, onlyWithFoto, isToday);
        }
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, ads);
    }
}
