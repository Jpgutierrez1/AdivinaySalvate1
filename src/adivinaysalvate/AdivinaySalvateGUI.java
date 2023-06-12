import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdivinaySalvateGUI extends JFrame {
    private final JLabel palabraLabel;
    private final JTextField letraTextField;
    private final JButton adivinarButton;
    private final JTextArea resultadoTextArea;

    private final AdivinaySalvate juego;

    public AdivinaySalvateGUI() {
        super("AdivínaySalvate");

        juego = new AdivinaySalvate();

        // interfaz
        palabraLabel = new JLabel("Palabra: ");
        letraTextField = new JTextField(1);
        adivinarButton = new JButton("Adivinar");
        resultadoTextArea = new JTextArea(10, 30);
        resultadoTextArea.setEditable(false);

        // Configuración del panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(palabraLabel, BorderLayout.NORTH);
        panel.add(resultadoTextArea, BorderLayout.CENTER);

        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(new FlowLayout());
        panelInferior.add(letraTextField);
        panelInferior.add(adivinarButton);

        panel.add(panelInferior, BorderLayout.SOUTH);

        getContentPane().add(panel);

        // Configuración de eventos
        adivinarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adivinarLetra();
            }
        });

        // Configuración de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private void adivinarLetra() {
        String letraStr = letraTextField.getText().toUpperCase();
        if (letraStr.length() > 0) {
            char letra = letraStr.charAt(0);
            boolean acierto = juego.adivinarLetra(letra);
            if (acierto) {
                if (String.valueOf(juego.getPalabraAdivinada()).equals(juego.getPalabraSeleccionada())) {
                    resultadoTextArea.setText("¡Felicidades! Has adivinado la palabra.");
                    adivinarButton.setEnabled(false);
                } else {
                    palabraLabel.setText("Palabra: " + String.valueOf(juego.getPalabraAdivinada()));
                }
            } else {
                resultadoTextArea.append("Letra incorrecta. Te quedan " + juego.getIntentosRestantes() + " intentos.\n");
                if (juego.getIntentosRestantes() == 0) {
                    resultadoTextArea.append("Has perdido. La palabra correcta era: " + juego.getPalabraSeleccionada());
                    adivinarButton.setEnabled(false);
                }
            }
            letraTextField.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                AdivinaySalvateGUI adivinaySalvateGUI = new AdivinaySalvateGUI();
            }
        });
    }
}
