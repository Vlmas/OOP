package lab3.sorting;

public class Sort {
    public static <E extends Comparable<E>> void quickSort(E[] array, int low, int high) {
        if(low < high) {
            int part = partition(array, low, high);
            quickSort(array, low, part - 1);
            quickSort(array, part + 1, high);
        }
    }

    public static <E extends Comparable<E>> void insertionSort(E[] array) {
        E key;
        int j;

        for(int i = 1; i < array.length; i++) {
            key = array[i];
            j = i - 1;

            while(j >= 0 && array[j].compareTo(key) == 1) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    public static <E extends Comparable<E>> int partition(E[] array, int low, int high) {
        E pivot = array[high];
        int i = low - 1;

        for(int j = low; j <= high - 1; j++) {
            if(array[j].compareTo(pivot) == -1) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }

    public static<E> void swap(E[] array, int i, int j) {
        E temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
