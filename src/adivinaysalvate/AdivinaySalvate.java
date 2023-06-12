import java.util.Scanner;

public class AdivinaySalvate {
    private static final String[] PALABRAS = {"JAVA", "CLASE", "PROGRAMACION", "OBJETOS", "METODOS"};
    private final String palabraSeleccionada;
    private final char[] palabraAdivinada;
    private int intentosRestantes;
    private final Scanner scanner;

    public AdivinaySalvate() {
        scanner = new Scanner(System.in);
        palabraSeleccionada = seleccionarPalabra();
        palabraAdivinada = new char[palabraSeleccionada.length()];
        intentosRestantes = 6;
    }

    private String seleccionarPalabra() {
        int indice = (int) (Math.random() * PALABRAS.length);
        return PALABRAS[indice];
    }

    private void inicializarPalabraAdivinada() {
        for (int i = 0; i < palabraAdivinada.length; i++) {
            palabraAdivinada[i] = '_';
        }
    }

    boolean adivinarLetra(char letra) {
        boolean acierto = false;
        for (int i = 0; i < palabraSeleccionada.length(); i++) {
            if (palabraSeleccionada.charAt(i) == letra) {
                palabraAdivinada[i] = letra;
                acierto = true;
            }
        }
        return acierto;
    }

    private void mostrarEstadoJuego() {
        System.out.println("Palabra: " + String.valueOf(palabraAdivinada));
        System.out.println("Intentos restantes: " + intentosRestantes);
    }

    private char pedirLetra() {
        System.out.print("Ingresa una letra: ");
        return scanner.nextLine().toUpperCase().charAt(0);
    }

    public void jugar() {
        inicializarPalabraAdivinada();

        while (intentosRestantes > 0) {
            mostrarEstadoJuego();
            char letra = pedirLetra();

            if (adivinarLetra(letra)) {
                if (String.valueOf(palabraAdivinada).equals(palabraSeleccionada)) {
                    System.out.println("¡Felicidades! Has adivinado la palabra.");
                    return;
                }
            } else {
                intentosRestantes--;
                System.out.println("Letra incorrecta. Te quedan " + intentosRestantes + " intentos.");
            }
        }

        System.out.println("Has perdido. La palabra correcta era: " + palabraSeleccionada);
    }

    public static void main(String[] args) {
        AdivinaySalvate juego = new AdivinaySalvate();
        juego.jugar();
    }

    Object getPalabraAdivinada() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Object getPalabraAdivinada() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Object getPalabraAdivinada() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String getIntentosRestantes() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    int getIntentosRestantes() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String getPalabraSeleccionada() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
