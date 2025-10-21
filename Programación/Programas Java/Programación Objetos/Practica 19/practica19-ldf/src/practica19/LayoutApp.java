package practica19;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class LayoutApp {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Ejercicio de Layouts");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new BorderLayout());

        // Panel Norte con etiqueta del nombre
        JPanel panelNorte = new JPanel(new FlowLayout());
        JLabel etiquetaNombre = new JLabel("Tu Nombre y Apellidos");
        panelNorte.add(etiquetaNombre);
        frame.add(panelNorte, BorderLayout.NORTH);

        // Panel Centro con botones
        JPanel panelCentro = new JPanel(new FlowLayout());
        JButton botonAceptar = new JButton("Aceptar");
        JButton botonCancelar = new JButton("Cancelar");
        panelCentro.add(botonAceptar);
        panelCentro.add(botonCancelar);
        frame.add(panelCentro, BorderLayout.CENTER);

        // Panel Sur con etiqueta
        JPanel panelSur = new JPanel(new FlowLayout());
        JLabel etiquetaInfo = new JLabel("Ejercicio de layouts - DAM");
        panelSur.add(etiquetaInfo);
        frame.add(panelSur, BorderLayout.SOUTH);
        frame.setVisible(true);

        
	}
	
}
