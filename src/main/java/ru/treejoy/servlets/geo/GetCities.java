package ru.treejoy.servlets.geo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.treejoy.dao.CountryDAO;
import ru.treejoy.dao.daofactory.DAOFactory;
import ru.treejoy.model.geo.City;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Сервлет, отвечающий за получение всех городов определенной страны.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 11.02.2018
 */
public class GetCities extends HttpServlet {
    /**
     * Логгер.
     */
    private static final Logger LOGGER = LogManager.getLogger(Logger.class.getName());

    /**
     * Отправка JSON со списком городов.
     *
     * @param req  запрос.
     * @param resp ответ.
     * @throws ServletException .
     * @throws IOException      .
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long countryID = Long.parseLong(req.getParameter("country"));
        Integer factoryID = (Integer) getServletContext().getAttribute("factoryID");
        DAOFactory daoFactory = DAOFactory.getDAOFactory(factoryID);
        List<City> cities = new ArrayList<>();
        if (daoFactory != null) {
            CountryDAO countryDAO = daoFactory.getCountryDAO();
            cities = countryDAO.getCities(countryID);
        }
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, cities);
    }
}
