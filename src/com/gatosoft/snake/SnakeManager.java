package com.gatosoft.snake;

/**
 * FrameTest.java Sep 23, 2015
 *
 * Copyleft 2015 GATOSOFT.
 * 
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import com.gatosoft.snake.bean.RectangleBean;
import com.gatosoft.snake.components.Snake;
import com.gatosoft.snake.enums.MoveTo;
import com.gatosoft.snake.helper.Constants;
import com.gatosoft.snake.helper.GraphicsHelper;

/**
 * The Class FrameTest.
 * 
 * @author <a href="famalde@gmail.com">Fernando Arnoso</a>
 */
public class SnakeManager extends JFrame implements Runnable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -187809241157240725L;

	/** The width. */
    private static final int ANCHO = 640;

    /** The height. */
    private static final int ALTO = 480;

    private static final int VELOCIDAD_MOVIMIENTO = 25;

    private boolean execute;
    private final Thread mainThread;

    // componentes
    Snake snake;



    /**
     * Instancia un nuevo frame test.
     */
    public SnakeManager() {
        this.setTitle("Frame Test");
        this.setBounds(100, 100, SnakeManager.ANCHO, SnakeManager.ALTO);
        this.setVisible(true);
        this.setResizable(false);
        this.setIgnoreRepaint(true);

        this.addWindowListener(new MainWindow(this));
        this.addKeyListener(getKeyListener());
        
        this.mainThread = new Thread(this);
        this.mainThread.start();

    }
    

    private void initComponents() {

        this.snake = new Snake();
        this.snake.setHeight(20);
        this.snake.setWidth(20);
        this.snake.setPosX((SnakeManager.ANCHO / 2) - 20);
        this.snake.setPosY(SnakeManager.ALTO - 30);
    }

    /**
     * {@inheritDoc}
     */
    public void run() {
        System.out.println("Start execution....");
        this.execute = true;
        
        initComponents();

        while (this.execute) {

            render();

            update();

            try {            	
            	Thread.sleep(400);
            } catch (final InterruptedException e) {
            	if(execute){
            		e.printStackTrace();
            	}else{
            		System.out.println("End execution");
            	}
            }

        }
    }

    
    public void endGame(){
    	mainThread.interrupt();
    	execute = false;
    }

    private void render() {
        Graphics g = this.getGraphics();
        
        //g.setColor(Color.BLACK);
        //g.fillRect(0, 0, 640, 480);
        GraphicsHelper.drawRect(g, this.snake, Color.BLUE);
        
        Toolkit.getDefaultToolkit().sync();

        g.dispose();

    }

//    private void update() {
//
//        final Graphics graphics = this.getGraphics();
//        for(int i = 1; i < snakeLenght; i++){
//        	int posX = heroe.getPosX() + (Constants.SNAKE_PART_WIDTH + 2);
//        	int posY = heroe.getPosY();
//        	RectangleBean rectangleBeanSon = new RectangleBean(posX, posY);
//            GraphicsHelper.drawRect(graphics, rectangleBeanSon, Color.BLUE);	
//        }
//        
//        
//        int repaintInBalckX = heroe.getPosX() + (heroe.getWidth() * snakeLenght); 
//        int repaintInBlackY = heroe.getPosY() + (heroe.getHeight() * snakeLenght);
//        RectangleBean rectangleRepaintBlack = new RectangleBean(repaintInBalckX, repaintInBlackY);
//        GraphicsHelper.drawRect(graphics, rectangleRepaintBlack, Color.BLACK);
//        
//        graphics.dispose();
//    }
    private void update() {    	
    	snake.autoMovement(this, VELOCIDAD_MOVIMIENTO);
    }
    


    private KeyListener getKeyListener() {
        final KeyListener result = new KeyListener() {

            @Override
            public void keyTyped(final KeyEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void keyReleased(final KeyEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void keyPressed(final KeyEvent e) {
//                if (KeyEvent.VK_UP == e.getExtendedKeyCode()) {
//                    GraphicsHelper.moveRect(SnakeManager.this, SnakeManager.this.snake, MoveTo.UP,
//                            VELOCIDAD_MOVIMIENTO);
//                } else if (KeyEvent.VK_DOWN == e.getExtendedKeyCode()) {
//                    GraphicsHelper.moveRect(SnakeManager.this, SnakeManager.this.snake, MoveTo.DOWN,
//                            VELOCIDAD_MOVIMIENTO);
//                } else if (KeyEvent.VK_LEFT == e.getExtendedKeyCode()) {
//                    GraphicsHelper.moveRect(SnakeManager.this, SnakeManager.this.snake, MoveTo.LEFT,
//                            VELOCIDAD_MOVIMIENTO);
//                } else if (KeyEvent.VK_RIGHT == e.getExtendedKeyCode()) {
//                    GraphicsHelper.moveRect(SnakeManager.this, SnakeManager.this.snake, MoveTo.RIGHT,
//                            VELOCIDAD_MOVIMIENTO);
//                }
                if (KeyEvent.VK_UP == e.getExtendedKeyCode()) {
                	snake.setMoveTo(MoveTo.UP);
                } else if (KeyEvent.VK_DOWN == e.getExtendedKeyCode()) {
                	snake.setMoveTo(MoveTo.DOWN);
                } else if (KeyEvent.VK_LEFT == e.getExtendedKeyCode()) {
                	snake.setMoveTo(MoveTo.LEFT);
                } else if (KeyEvent.VK_RIGHT == e.getExtendedKeyCode()) {
                	snake.setMoveTo(MoveTo.RIGHT);
                }

            }
        };
        return result;
    }

    /**
     * Metodo Main.
     * 
     * @param args
     *            argumentos de entrada
     */
    public static void main(final String[] args) {
    	new SnakeManager();
    }


}
