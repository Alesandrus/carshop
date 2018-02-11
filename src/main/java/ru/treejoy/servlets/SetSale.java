package ru.treejoy.servlets;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.treejoy.dao.CarAdDAO;
import ru.treejoy.dao.daofactory.DAOFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Сервлет, отвечающий за изменение статуса продажи.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 11.02.2018
 */
public class SetSale extends HttpServlet {
    /**
     * Логгер.
     */
    private static final Logger LOGGER = LogManager.getLogger(Logger.class.getName());

    /**
     * Изменение статуса.
     *
     * @param req  запрос.
     * @param resp ответ.
     * @throws ServletException .
     * @throws IOException      .
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String json = req.getParameter("param");
        JsonFactory factory = new JsonFactory();
        JsonParser parser = factory.createParser(json);
        long id = -1;
        boolean status = false;
        while (!parser.isClosed()) {
            JsonToken token = parser.nextToken();
            if (JsonToken.FIELD_NAME.equals(token)) {
                String field = parser.getCurrentName();
                parser.nextToken();
                if (field.equals("id")) {
                    id = parser.getValueAsLong();
                } else if (field.equals("status")) {
                    status = parser.getValueAsBoolean();
                }
            }
        }
        if (id != -1) {
            int factoryID = (Integer) getServletContext().getAttribute("factoryID");
            DAOFactory daoFactory = DAOFactory.getDAOFactory(factoryID);
            if (daoFactory != null) {
                CarAdDAO carAdDAO = daoFactory.getCarAdDAO();
                carAdDAO.updateStatus(id, status);
            }
        }
    }
}
