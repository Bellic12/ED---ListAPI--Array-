import java.time.Instant;
import java.time.Duration;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void exec(String nombreFuncion, Runnable funcion, FileWriter csvWriter, int n) throws IOException {
        Instant inicio = Instant.now();
        funcion.run();
        Instant fin = Instant.now();
        Duration tiempoTranscurrido = Duration.between(inicio, fin);
        long tiempoEnNanos = tiempoTranscurrido.toNanos();
        long tiempoEnMicros = tiempoEnNanos / 1000;
        System.out.println("Tiempo de ejecución de " + nombreFuncion + " con n=" + n + ": " + tiempoEnMicros + " microsegundos");
        csvWriter.append(nombreFuncion + "," + n + "," + tiempoEnMicros + "\n");
    }

    public static void main(String[] args) {
        int[] ns = {1000, 10000, 100000, 1000000, 10000000, 100000000, 200000000, 300000000, 400000000, 500000000, 600000000, 700000000, 800000000, 900000000, 1000000000}; // Diferentes valores de n para probar

        try (FileWriter csvWriter = new FileWriter("tiempos_ejecucion.csv")) {
            csvWriter.append("Funcion,n,Tiempo (microsegundos)\n");

            for (int n : ns) {
                ListAPI lista = new ListAPI(n + 1);

                // Inicializa la lista con valores aleatorios.
                for (int i = 0; i < n; i++) {
                    lista.pushBack(i);
                }

                // Prueba todas las funciones de ListAPI.
                exec("pushFront", () -> lista.pushFront(2006), csvWriter, n);
                exec("topFront", () -> System.out.println("topFront: " + lista.topFront()), csvWriter, n);
                exec("popFront", () -> lista.popFront(), csvWriter, n);
                exec("pushBack", () -> lista.pushBack(777), csvWriter, n);
                exec("topBack", () -> System.out.println("topBack: " + lista.topBack()), csvWriter, n);
                exec("popBack", () -> lista.popBack(), csvWriter, n);
                exec("find", () -> System.out.println("find: " + lista.find(n-16)), csvWriter, n);
                exec("addBefore", () -> lista.addBefore(n/4, 123), csvWriter, n);
                lista.popBack();
                exec("addAfter", () -> lista.addAfter(n/6, 111), csvWriter, n);
                exec("erase", () -> lista.erase(n-2), csvWriter, n);
                exec("isEmpty", () -> System.out.println("isEmpty: " + lista.isEmpty()), csvWriter, n);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}