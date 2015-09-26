package com.gatosoft.snake.components;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import com.gatosoft.snake.bean.RectangleBean;
import com.gatosoft.snake.enums.MoveTo;
import com.gatosoft.snake.helper.GraphicsHelper;

public class Snake extends RectangleBean {
	
	private int snakeLenght;
	private MoveTo moveTo;
	private List<RectangleBean> cola;
	
	public Snake(){
		cola = new ArrayList<RectangleBean>();
	}
	
	private void aumentarTamanho() {
		snakeLenght++;
		cola.add(new RectangleBean());
	}
	
    public void autoMovement(final JFrame jFrame, final int velocidadMovimiento){
    	GraphicsHelper.moveRect(jFrame, this, moveTo, velocidadMovimiento);
    }

	public int getLongitud() {
		return snakeLenght;
	}
	
	public MoveTo getMoveTo() {
		return moveTo;
	}
	
	public void setMoveTo(MoveTo moveTo) {
		this.moveTo = moveTo;
	}

	public List<RectangleBean> getCola() {
		return cola;
	}
	
	
}
