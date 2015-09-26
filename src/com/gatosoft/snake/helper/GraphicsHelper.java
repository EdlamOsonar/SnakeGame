/**
 * GraphicsHelper.java Sep 23, 2015
 *
 * Copyright 2015 GATOSOFT.
 * 
 */
package com.gatosoft.snake.helper;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

import com.gatosoft.snake.bean.RectangleBean;
import com.gatosoft.snake.enums.MoveTo;

/**
 * The Class GraphicsHelper.
 * 
 * @author <a href="famalde@gmail.com">Fernando Arnoso</a>
 */
public class GraphicsHelper {

    /**
     * Draw rect.
     * 
     * @param jFrame
     *            j frame
     * @param rectangleBean
     *            rectangle bean
     * @return the rectangle bean
     */
    public static void drawRect(final Graphics graphics , final RectangleBean rectangleBean, final Color color) {
    	graphics.setColor(color);
    	graphics.fillRect(rectangleBean.getPosX(), rectangleBean.getPosY(), rectangleBean.getWidth(),
                rectangleBean.getHeight());
        
    }

    /**
     * Move rect.
     * 
     * @param graphics
     *            graphics
     * @param rectangleBean
     *            rectangle bean
     * @param moveTo
     *            move to
     */
    public static void moveRect(final JFrame jFrame, final RectangleBean rectangleBean, final MoveTo moveTo,
            final int velocidadMovimiento) {
        
    	
        if (MoveTo.UP.equals(moveTo) && rectangleBean.getPosY() > (rectangleBean.getHeight() + (rectangleBean.getHeight() / 2))) {
            rectangleBean.setPosY(rectangleBean.getPosY() - velocidadMovimiento);
        } else if (MoveTo.DOWN.equals(moveTo) && rectangleBean.getPosY() < 440) {
            rectangleBean.setPosY(rectangleBean.getPosY() + velocidadMovimiento);
        } else if (MoveTo.LEFT.equals(moveTo) && rectangleBean.getPosX() > 0) {
            rectangleBean.setPosX(rectangleBean.getPosX() - velocidadMovimiento);
        } else if (MoveTo.RIGHT.equals(moveTo) && rectangleBean.getPosX() < 625) {
            rectangleBean.setPosX(rectangleBean.getPosX() + velocidadMovimiento);
        }

    }
}
