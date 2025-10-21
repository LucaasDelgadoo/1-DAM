package practica20;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MensajeSaludoApp extends JFrame {
	
    private JButton btnEspanol, btnIngles, btnFrances;
    private JLabel mensaje;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MensajeSaludoApp());
    }
    
    public MensajeSaludoApp() {

        setTitle("Práctica de Saludo");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnEspanol = new JButton("Español");
        btnIngles = new JButton("Inglés");
        btnFrances = new JButton("Francés");

        add(btnEspanol);
        add(btnIngles);
        add(btnFrances);
 
        mensaje = new JLabel("Pulsa un botón para saludar");
        mensaje.setPreferredSize(new Dimension(250, 30));
        add(mensaje);

        ButtonActionListener actionListener = new ButtonActionListener();
        btnEspanol.addActionListener(actionListener);
        btnIngles.addActionListener(actionListener);
        btnFrances.addActionListener(actionListener);

        
        setSize(300, 150);
        setLocationRelativeTo(null); 
        setVisible(true);
    }

    private class ButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == btnEspanol) {
            	mensaje.setText("¡Hola, buenos días!");
            	mensaje.setForeground(Color.BLUE); 
            } else if (e.getSource() == btnIngles) {
            	mensaje.setText("Hello, good morning!");
                mensaje.setForeground(Color.RED); 
            } else if (e.getSource() == btnFrances) {
            	mensaje.setText("Bonjour, bon matin!");
            	mensaje.setForeground(Color.MAGENTA); 
            }
        }
    }

  
}


