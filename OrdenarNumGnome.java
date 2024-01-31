import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class OrdenarNumGnome {

    public static void main(String[] args) {
        // Leer datos del archivo y ordenar
        medirTiempoOrdenamiento("numeros.txt");

        // Leer datos de un arreglo ya ordenado y volver a ordenar
        medirTiempoOrdenamiento("numeros_ordenados.txt");
    }

    public static void medirTiempoOrdenamiento(String archivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            int[] numeros = new int[3000];
            int i = 0;

            // Leer datos del archivo y almacenar en el arreglo
            while ((linea = reader.readLine()) != null && i < 3000) {
                numeros[i++] = Integer.parseInt(linea);
            }

            // Medir el tiempo antes de ordenar
            long tiempoInicio = System.currentTimeMillis();

            // Ordenar el arreglo con Gnome Sort
            gnomeSort(numeros);

            // Medir el tiempo después de ordenar
            long tiempoFin = System.currentTimeMillis();
            long tiempoTotal = tiempoFin - tiempoInicio;

            System.out.println("Tiempo para ordenar " + i + " números: " + tiempoTotal + " milisegundos");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void gnomeSort(int[] arr) {
        int index = 0;

        while (index < arr.length) {
            if (index == 0 || arr[index] >= arr[index - 1]) {
                index++;
            } else {
                // Intercambiar elementos y retroceder
                int temp = arr[index];
                arr[index] = arr[index - 1];
                arr[index - 1] = temp;
                index--;
            }
        }
    }
}
