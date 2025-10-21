package graficos;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class EventoClickMouse extends JFrame implements MouseListener {

	public static void main(String[] args) {
		
		EventoClickMouse miEvento = new EventoClickMouse();
		
		
	}
	
	public EventoClickMouse() {
		
		setTitle("Evento de prueba");
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.addMouseListener(this);
		setVisible(true);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("1");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("2");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("3");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("4");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("5");
	}
	
	
	

}
