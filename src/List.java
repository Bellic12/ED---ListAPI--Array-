public class List {
    int[] lista;
    int contadorElementos = 0;

    public List(int tamanho) {
        lista = new int[tamanho];
    }

    // Inserción de un elemento al inicio de la lista.
    public void pushFront(int key) {
        if (contadorElementos >= lista.length) {
            System.out.println("Error: Lista llena. No se puede agregar el elemento.");
            return;
        }
        for (int i = contadorElementos; i > 0; i--) {
            lista[i] = lista[i - 1];
        }

        lista[0] = key;
        contadorElementos++;
    }

    // Eliminación del primer elemento de la lista.
    public void popFront() {
        if (contadorElementos == 0) {
            System.out.println("Error: Lista vacia. No se puede eliminar el elemento.");
            return;
        }
        for (int i = 0; i < contadorElementos - 1; i++) {
            lista[i] = lista[i + 1];
        }
        contadorElementos--;
    }

    // Inserción de un elemento al final de la lista.
    public void pushBack(int key) {
        if (contadorElementos >= lista.length) {
            System.out.println("Error: Lista llena. No se puede agregar el elemento.");
            return;
        }
        lista[contadorElementos] = key;
        contadorElementos++;
    }

    // Eliminación del último elemento de la lista.
    public void popBack() {
        if (contadorElementos == 0) {
            System.out.println("Error: Lista vacia. No se puede eliminar el elemento.");
            return;
        }
        contadorElementos--;
    }

    // Indicación de la existencia del elemento en la lista.
    public boolean find(int key) {
        for (int i = 0; i < contadorElementos; i++) {
            if (lista[i] == key) {
                return true;
            }
        }
        return false;
    }

    // Eliminación del elemento indicado de la lista.
    public void erase(int key) {
        int i = 0;
        for (i = 0; i < contadorElementos; i++) {
            if (lista[i] == key) {
                break;
            }
        }
        if (i == contadorElementos) {
            System.out.println("Error: Elemento no encontrado. No se puede eliminar el elemento.");
            return;
        }
        for (int j = i; j < contadorElementos - 1; j++) {
            lista[j] = lista[j + 1];
        }
        contadorElementos--;
    }

    // Inserción de un elemento antes del elemento indicado en la lista.
    public void addBefore(int index, int key) {
        if (contadorElementos >= lista.length) {
            System.out.println("Error: Lista llena. No se puede agregar el elemento.");
            return;
        }
        for (int i = contadorElementos; i > index; i--) {
            lista[i] = lista[i - 1];
        }
        lista[index] = key;
        contadorElementos++;
    }

    // Inserción de un elemento después del elemento indicado en la lista.
    public void addAfter(int index, int key) {
        if (contadorElementos >= lista.length) {
            System.out.println("Error: Lista llena. No se puede agregar el elemento.");
            return;
        }
        for (int i = contadorElementos; i > index + 1; i--) {
            lista[i] = lista[i - 1];
        }
        lista[index + 1] = key;
        contadorElementos++;
    }

    // Indicación de la existencia de elementos en la lista.
    public boolean isEmpty() {
        return contadorElementos == 0;
    }

    // Obtención del primer elemento de la lista.
    public int topFront() {
        if (contadorElementos == 0) {
            System.out.println("Error: Lista vacia. No se puede obtener el elemento.");
            return -1;
        }
        return lista[0];
    }

    // Obtención del último elemento de la lista.
    public int topBack() {
        if (contadorElementos == 0) {
            System.out.println("Error: Lista vacia. No se puede obtener el elemento.");
            return -1;
        }
        return lista[contadorElementos - 1];
    }

}