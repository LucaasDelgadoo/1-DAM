package practica19;
import javax.swing.*;
import java.awt.*;

public class LayoutVentana {

	public LayoutVentana() {
		
		layoutVentana();
		
	}
	
	public void layoutVentana() {
		
		JFrame frame = new JFrame("FlowLayout");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container contenido = frame.getContentPane();

		contenido.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 25));

		contenido.add(new JButton("Botón 1"));
		contenido.add(new JButton("Botón 2"));
		contenido.add(new JButton("Botón 3"));
		contenido.add(new JButton("Botón 4 con nombre largo"));
		contenido.add(new JButton("5"));

		frame.setPreferredSize(new Dimension(400, 180));
		frame.pack();
		frame.setVisible(true);

		
	}
		
}
	

