import java.time.Instant;
import java.time.Duration;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    // Método para ejecutar una función y medir su tiempo de ejecución
    public static void exec(String nombreFuncion, Runnable funcion, FileWriter csvWriter, int n) throws IOException {
        Instant inicio = Instant.now();
        funcion.run();
        Instant fin = Instant.now();
        Duration tiempoTranscurrido = Duration.between(inicio, fin);
        long tiempoEnMicros = tiempoTranscurrido.toNanos() / 1000;
        
        // Imprime y guarda el tiempo de ejecución en microsegundos
        System.out.println("Tiempo de ejecución de " + nombreFuncion + " con n=" + n + ": " + tiempoEnMicros + " microsegundos");
        csvWriter.append(String.format("%s,%d,%d\n", nombreFuncion, n, tiempoEnMicros));
    }

    public static void main(String[] args) {
        // Diferentes valores de n para probar
        int[] ns = {10000, 100000, 1000000, 10000000, 100000000, 200000000, 300000000, 400000000, 500000000, 600000000, 700000000, 800000000, 900000000, 1000000000};

        try (FileWriter csvWriter = new FileWriter("tiempos_ejecucion.csv")) {
            // Escribe el encabezado del archivo CSV
            csvWriter.append("Funcion,n,Tiempo (microsegundos)\n");

            for (int n : ns) {
                List lista = new List(n + 1);

                // Inicializa la lista con valores secuenciales
                for (int i = 0; i < n; i++) {
                    lista.pushBack(i);
                }

                // Prueba todas las funciones de ListAPI y mide su tiempo de ejecución
                exec("pushFront", () -> lista.pushFront(2006), csvWriter, n);
                exec("topFront", () -> System.out.println("topFront: " + lista.topFront()), csvWriter, n);
                exec("popFront", lista::popFront, csvWriter, n);
                exec("pushBack", () -> lista.pushBack(777), csvWriter, n);
                exec("topBack", () -> System.out.println("topBack: " + lista.topBack()), csvWriter, n);
                exec("popBack", lista::popBack, csvWriter, n);
                exec("find", () -> System.out.println("find: " + lista.find(n - 16)), csvWriter, n);
                exec("addBefore", () -> lista.addBefore(n*(3/4), 123), csvWriter, n);
                lista.popBack(); // Elimina el último elemento para preparar la siguiente prueba
                exec("addAfter", () -> lista.addAfter(n*(3/4), 111), csvWriter, n);
                exec("erase", () -> lista.erase(n - 2), csvWriter, n);
                exec("isEmpty", () -> System.out.println("isEmpty: " + lista.isEmpty()), csvWriter, n);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}