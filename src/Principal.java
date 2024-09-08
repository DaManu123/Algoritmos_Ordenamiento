import java.util.Scanner;

public class Principal {

    static int[] lista = new int[100];

    public static void generarLista() {
        for (int i = 0; i < lista.length; i++) {
            lista[i] = (int) (Math.random() * 100) + 1;
        }
    }

    public static void mostrarLista(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        generarLista();

        OrdenamientoDirecto od = new OrdenamientoDirecto();
        OrdenamientoIndirecto oi = new OrdenamientoIndirecto();

        System.out.println("Seleccione el algoritmo: ");
        System.out.println("1. Selección");
        System.out.println("2. Inserción");
        System.out.println("3. Shell");
        System.out.println("4. QuickSort");

        int choice = scanner.nextInt();

        System.out.println("Seleccione el tipo de ordenamiento: ");
        System.out.println("1. Ascendente");
        System.out.println("2. Descendente");

        int orden = scanner.nextInt();

        long tinicio = System.nanoTime();

        switch (choice) {
            case 1: // Selección
                if (orden == 1) od.seleccionAscendente(lista);
                else od.seleccionDescendente(lista);
                break;
            case 2: // Inserción
                if (orden == 1) od.insercionAscendente(lista);
                else od.insercionDescendente(lista);
                break;
            case 3: // Shell
                if (orden == 1) oi.shellAscendente(lista);
                else oi.shellDescendente(lista);
                break;
            case 4: // QuickSort
                if (orden == 1) oi.quickSortAscendente(lista, 0, lista.length - 1);
                else oi.quickSortDescendente(lista, 0, lista.length - 1);
                break;
        }

        long tfinal = System.nanoTime();
        long tiempoEjecutado = tfinal - tinicio;

        mostrarLista(lista);
        System.out.println("Tiempo de ejecución: " + tiempoEjecutado + " nanosegundos");
    }
}
