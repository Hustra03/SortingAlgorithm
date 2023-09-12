import java.util.Random;

public class App {

    public static void main(String[] args) throws Exception {

        int numberOfAttempts = 1000;
        int arraySizes[] = { 100, 200, 500, 1000, 2500, 5000 };

        for (int i : arraySizes) {

            benchmarkSort(i, numberOfAttempts);
            System.out.println(" ");
        }

    }

    static public void benchmarkSort(int arraySize, int numberOfAttempts) {

        int arrayToBeSorted[] = createUnsortedArray(arraySize);
        long t0;
        long t1;
        long minimum = Long.MAX_VALUE;

        for (int i = 0; i < numberOfAttempts; i++) {

            t0 = System.nanoTime();
            // printIntArray(selectionSort(arrayToBeSorted));
            selectionSort(arrayToBeSorted);
            t1 = System.nanoTime();
            if (minimum > (t1 - t0)) {
                minimum = (t1 - t0);
            }
        }

        System.out.println("Selection Sort Size " + arraySize + " : " + (minimum) + " ns");

        minimum = Long.MAX_VALUE;

        for (int i = 0; i < numberOfAttempts; i++) {

            arrayToBeSorted = createUnsortedArray(arraySize);
            t0 = System.nanoTime();
            insertionSort(arrayToBeSorted);
            t1 = System.nanoTime();
            if (minimum > (t1 - t0)) {
                minimum = (t1 - t0);
            }
        }
        System.out.println("Insertion Sort Size " + arraySize + " Minimum: " + (minimum) + " ns");

        minimum = Long.MAX_VALUE;

        for (int i = 0; i < numberOfAttempts; i++) {

            arrayToBeSorted = createUnsortedArray(arraySize);
            t0 = System.nanoTime();
            mergeSort(arrayToBeSorted);
            t1 = System.nanoTime();
            if (minimum > (t1 - t0)) {
                minimum = (t1 - t0);
            }
        }

        System.out.println("Merge Sort Size " + arraySize + " : " + (minimum) + " ns");
    }

    static public int[] createUnsortedArray(int arraySize) {
        int array[] = new int[arraySize];

        Random rnd = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(10 * arraySize) + 1;
        }

        return array;
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
                array = swap(array, i, candidate);
            }
        }
        return array;
    }

    static public int[] insertionSort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            for (int j = i; j > 0 && array[j] < array[j - 1]; j--) {
                array = swap(array, j, j - 1);
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

    // Läs på mer om merge sort, är förvirrande hur den ska fungera
    static public void mergeSort(int[] array) {
        if (array.length == 0)
            return;
        int[] aux = new int[array.length];
        sort(array, aux, 0, array.length - 1);
    }

    private static void sort(int[] org, int[] aux, int lo, int hi) {
        if (lo != hi) {
            int mid = (lo + hi) / 2;
            // sort the items from lo to mid

            sort(org, aux, lo, mid);

            // sort the items from mid+1 to hi

            sort(org, aux, mid + 1, hi);

            // merge the two sections using the additional array
            merge(org, aux, lo, mid, hi);
        }
    }

    private static void merge(int[] org, int[] aux, int lo, int mid, int hi) {
        // copy all items from lo to hi from org to aux
        for (int i = lo; i <= hi; i++) {
            aux[i] = org[i];
        }
        // let's do the merging
        int i = lo; // the index in the first part
        int j = mid + 1; // the index in the second part
        // for all indices from lo to hi
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                org[k] = aux[j];
                j++;
            }
            // if i is greater than mid then
            // move the j'th item to the org array, update j

            else if (j > hi) {
                org[k] = aux[i];
                i++;
            }
            // else if j is greater than hi then
            // move the i'th item to the org array, update i

            else if (org[i] < aux[j]) {
                org[k] = aux[i];
                i++;
            }
            // else if the i'th item is smaller than the j¨ath item,
            // move the i'th item to the org array, update i

            else {
                org[k] = aux[j];
                j++;
            }
            // else
            // move the j'th item to the org array, update j
        }
    }
}
