package ru.treejoy.utils;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * Class for changing image size.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 11.02.2018
 */
public class ImageReSizer {
    /**
     * Change image size.
     *
     * @param targetWidth  width value.
     * @param targetHeight height value.
     * @param src          buffered image.
     * @return buffered image.
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
