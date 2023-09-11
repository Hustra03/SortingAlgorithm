public class App {
    public static void main(String[] args) throws Exception {

        int arrayToBeSorted[] = { 2, 1, 3, 2, 1 };

        benchmarkSort(arrayToBeSorted);

    }

    static public void benchmarkSort(int[] arrayToBeSorted) {
        System.out.print("Original array: ");
        printIntArray(arrayToBeSorted);

        System.out.print("Selection Sort: ");
        printIntArray(selectionSort(arrayToBeSorted));

        System.out.print("Insertion Sort: ");
        printIntArray(insertionSort(arrayToBeSorted));

        int copyArray[]=arrayToBeSorted;
        mergeSort(copyArray);
        System.out.print("Merge Sort: ");
        printIntArray(copyArray);

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

//Läs på mer om merge sort, är förvirrande hur den ska fungera
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

            sort(org, aux, mid+1, hi);
            
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
            if (i>mid) {
                org[k]=aux[j];
                j++;
            }
            // if i is greater than mid then
            // move the j'th item to the org array, update j

            else if(j>hi)
            {
                org[k]=aux[i];
                i++;
            }
            // else if j is greater than hi then
            // move the i'th item to the org array, update i

            else if(org[i]<aux[j])
            {
                org[k]=aux[i];
                i++;
            }
            // else if the i'th item is smaller than the j¨ath item,
            // move the i'th item to the org array, update i

            else
            {
                org[k]=aux[j];
                j++;
            }
            // else
            // move the j'th item to the org array, update j
        }
    }
}
