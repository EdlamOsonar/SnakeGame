package com.gatosoft.snake;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class MainWindow implements WindowListener {
	
	private SnakeManager jFrame;
	
	public MainWindow(SnakeManager jFrame) {
		this.jFrame = jFrame;
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		jFrame.endGame();
		this.jFrame.dispose();
	}

	@Override
	public void windowClosed(WindowEvent e) {
		//not implemented
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

}
