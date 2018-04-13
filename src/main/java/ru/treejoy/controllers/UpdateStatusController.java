package ru.treejoy.controllers;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.treejoy.dao.services.CarAdService;

import java.io.IOException;

/**
 * Сервлет, отвечающий за изменение статуса продажи.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 11.02.2018
 */
@Controller
@RequestMapping("/setsale")
public class UpdateStatusController {
    /**
     * Логгер.
     */
    private static final Logger LOGGER = LogManager.getLogger(Logger.class.getName());

    @Autowired
    private CarAdService carAdService;

    /**
     * Изменение статуса.
     */
    /*@Override
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
                CarAdService carAdDAO = daoFactory.getCarAdService();
                carAdDAO.updateStatus(id, status);
            }
        }
    }*/

    @PostMapping
    public void updateStatus(@RequestParam("param") String json) {
        JsonFactory factory = new JsonFactory();
        JsonParser parser;
        try {
            parser = factory.createParser(json);
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
                carAdService.updateStatus(id, status);
            }
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }

    }
}
