public class ListAPI {
    int[] lista;
    int contadorElementos = 0;

    public ListAPI(int tamanho) {
        lista = new int[tamanho];
    }

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

    public int topFront() {
        if (contadorElementos == 0) {
            System.out.println("Error: Lista vacia. No se puede obtener el elemento.");
            return -1;
        }
        return lista[0];
    }

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

    public void pushBack(int key) {
        if (contadorElementos >= lista.length) {
            System.out.println("Error: Lista llena. No se puede agregar el elemento.");
            return;
        }
        lista[contadorElementos] = key;
        contadorElementos++;
    }

    public int topBack() {
        if (contadorElementos == 0) {
            System.out.println("Error: Lista vacia. No se puede obtener el elemento.");
            return -1;
        }
        return lista[contadorElementos - 1];
    }

    public void popBack() {
        if (contadorElementos == 0) {
            System.out.println("Error: Lista vacia. No se puede eliminar el elemento.");
            return;
        }
        contadorElementos--;
    }

    public boolean find(int key) {
        for (int i = 0; i < contadorElementos; i++) {
            if (lista[i] == key) {
                return true;
            }
        }
        return false;
    }

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

    public boolean isEmpty() {
        return contadorElementos == 0;
    }

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
}