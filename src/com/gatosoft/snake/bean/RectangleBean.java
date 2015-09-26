/**
 * RectangleBean.java Sep 23, 2015
 *
 * Copyright 2015 GATOSOFT.
 * 
 */
package com.gatosoft.snake.bean;

import com.gatosoft.snake.helper.Constants;

/**
 * The Class RectangleBean.
 * 
 * @author <a href="famalde@gmail.com">Fernando Arnoso</a>
 */
public class RectangleBean {
    private int posX;
    private int posY;
    private int width;
    private int height;

    
    public RectangleBean(int posX, int posY) {
    	this.width = Constants.SNAKE_PART_WIDTH;
    	this.height = Constants.SNAKE_PART_HEIGHT;
		this.posX = posX;
		this.posY = posY;
	}

	public RectangleBean() {
	}

	/**
     * Obtiene pos x.
     * 
     * @return pos x
     */
    public int getPosX() {
        return this.posX;
    }

    /**
     * Establece pos x.
     * 
     * @param posX
     *            nuevo pos x
     */
    public void setPosX(final int posX) {
        this.posX = posX;
    }

    /**
     * Obtiene pos y.
     * 
     * @return pos y
     */
    public int getPosY() {
        return this.posY;
    }

    /**
     * Establece pos y.
     * 
     * @param posY
     *            nuevo pos y
     */
    public void setPosY(final int posY) {
        this.posY = posY;
    }

    /**
     * Obtiene width.
     * 
     * @return width
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * Establece width.
     * 
     * @param width
     *            nuevo width
     */
    public void setWidth(final int width) {
        this.width = width;
    }

    /**
     * Obtiene height.
     * 
     * @return height
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * Establece height.
     * 
     * @param height
     *            nuevo height
     */
    public void setHeight(final int height) {
        this.height = height;
    }

}
