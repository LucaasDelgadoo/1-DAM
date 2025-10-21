package juegoCirculo;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.event.*;
 
public class JuegoAPP extends JFrame{
 
	private int x, y , radio = 40;
	private int puntos = 0;
	private Color colorCirculo = Color.BLUE;
	private final Random RAND = new Random();
	private PanelJuego panel;
	
	public JuegoAPP() {
		setTitle("Juego");
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	
	
	panel = new PanelJuego();
	panel.setFocusable(true);
	
	//Listener
	panel.addMouseListener(new MouseClickListener());
	panel.addKeyListener(new TeclaCambioColorListener());
	add(panel);
	setVisible(true);
	
	}
	
	
	private class PanelJuego extends JPanel{
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(colorCirculo);
			g.fillOval(x, y, radio * 2, radio * 2);
			g.setColor(Color.black);
			g.drawString("Puntos: " + puntos, 10, 20);
		}
		
	}
	
	
	private class MouseClickListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			int mx = e.getX(), my = e.getY();
			int cx = x + radio, cy = y + radio;
			double distancia = Math.sqrt(Math.pow(mx - cx, 2)+ Math.pow(my - cy, 2));
			if (distancia <= radio) {
				puntos++;
				moverCirculo();
				if (puntos >=10) {
					JOptionPane.showMessageDialog(panel, "¡Has ganado!");
					System.exit(0);
				}
			}
		}
	}
	
	
	private class TeclaCambioColorListener extends KeyAdapter{
		
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				colorCirculo = new Color(RAND.nextInt(256), RAND.nextInt(256), RAND.nextInt(256));
				panel.repaint();
			}
		}
		
		
		
		
	}
	
	public void moverCirculo () {
		int ancho = panel.getWidth() > 0 ? panel.getWidth() : 400;
		int alto = panel.getHeight() > 0 ? panel.getHeight() : 400;
		x = RAND.nextInt(ancho - 2 * radio);
		y = RAND.nextInt(alto - 2 * radio);
		panel.repaint();
		panel.requestFocusInWindow();
	}
	
	
	public static void main(String[] args) {
		new JuegoAPP();
	}
	
	
	
	
	
	
	
}
 
 
 