public class OrdenamientoIndirecto {

    // Shell Ascendente
    public void shellAscendente(int[] arr) {
        int n = arr.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }

    // Shell Descendente
    public void shellDescendente(int[] arr) {
        int n = arr.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] < temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }

    // QuickSort Ascendente
    public void quickSortAscendente(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partitionAscendente(arr, low, high);
            quickSortAscendente(arr, low, pi - 1);
            quickSortAscendente(arr, pi + 1, high);
        }
    }

    private int partitionAscendente(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // QuickSort Descendente
    public void quickSortDescendente(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partitionDescendente(arr, low, high);
            quickSortDescendente(arr, low, pi - 1);
            quickSortDescendente(arr, pi + 1, high);
        }
    }

    private int partitionDescendente(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] > pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}
