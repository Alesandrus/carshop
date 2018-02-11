package ru.treejoy.utils;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * Класс для изменения размеров изображения.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 11.02.2018
 */
public class ImageReSizer {
    /**
     * Изменение размеров изображения.
     *
     * @param targetWidth  значение ширины.
     * @param targetHeight значение высоты.
     * @param src          буферизированное изображение.
     * @return буферизированное изображение.
     */
    public BufferedImage resize(int targetWidth, int targetHeight,
                                BufferedImage src) {
        double scaleW = (double) targetWidth / (double) src.getWidth();
        double scaleH = (double) targetHeight / (double) src.getHeight();

        double scale = scaleW < scaleH ? scaleW : scaleH;

        BufferedImage result = new BufferedImage((int) (src.getWidth() * scale),
                (int) (src.getHeight() * scale), BufferedImage.TYPE_INT_RGB);

        Graphics2D g2d = result.createGraphics();
        g2d.drawImage(src, 0, 0, result.getWidth(), result.getHeight(), null);
        g2d.dispose();

        return result;
    }
}
