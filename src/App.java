public class App {
    public static void main(String[] args) throws Exception {

        int arrayToBeSorted[] = { 2, 1 ,3,2,1};

        benchmarkSort(arrayToBeSorted);

        //printIntArray(swap(arrayToBeSorted, 0, 1));

    }

    static public void benchmarkSort(int[] arrayToBeSorted) {
        System.out.print("Original array: ");
        printIntArray(arrayToBeSorted);

        System.out.print("Selection Sort: ");
        printIntArray(selectionSort(arrayToBeSorted));

        System.out.print("Insertion Sort: ");
        printIntArray(insertionSort(arrayToBeSorted));

    }

    static public void printIntArray(int[] arrayToBePrinted) {
        for (int i = 0; i < arrayToBePrinted.length; i++) {
            System.out.print(arrayToBePrinted[i] + ",");
        }
        System.out.println("");
    }

    static public int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int candidate = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[candidate]) {
                    candidate = j;
                }

            }
            if (candidate != i) {
                array =swap(array, i, candidate);
            }
        }
        return array;
    }

    static public int[] insertionSort(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i; j > 0 && array[j] < array[j - 1]; j--) {
                array = swap(array, j - 1, j);
            }
        }
        return array;
    }

    static public int[] swap(int[] array, int firstIndex, int secondIndex) {
        int candidate = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = candidate;
        return array;
    }

}
