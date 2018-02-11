package ru.treejoy.servlets.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.treejoy.model.parts.Body;
import ru.treejoy.model.parts.Motor;
import ru.treejoy.model.parts.Transmission;
import ru.treejoy.model.parts.WheelDrive;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Слушатель сессии.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 11.02.2018
 */
public class SessionListener implements HttpSessionListener {
    /**
     * Логгер.
     */
    private static final Logger LOGGER = LogManager.getLogger(Logger.class.getName());

    /**
     * Сохранение в сессии значений типов кузова, мотора, трансмиссий, приводов.
     * @param se событие связанной с сессией.
     */
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        session.setAttribute("bodies", Body.toArrayString());
        session.setAttribute("motors", Motor.toArrayString());
        session.setAttribute("transmissions", Transmission.toArrayString());
        session.setAttribute("drives", WheelDrive.toArrayString());
    }
}
