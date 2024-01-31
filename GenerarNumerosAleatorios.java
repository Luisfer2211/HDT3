import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerarNumerosAleatorios {

    public static void main(String[] args) {
        generarYGuardarNumeros();
    }

    public static void generarYGuardarNumeros() {
        String nombreArchivo = "numeros.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            Random random = new Random();

            for (int i = 0; i < 3000; i++) {
                int numero = random.nextInt(); 
                writer.write(Integer.toString(numero));
                writer.newLine();
            }

            System.out.println("Números generados y guardados en el archivo: " + nombreArchivo);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
