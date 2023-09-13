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
        long minimum1 = Long.MAX_VALUE;
        long minimum2 = Long.MAX_VALUE;
        long minimum3 = Long.MAX_VALUE;

        int[] temp;
        for (int i = 0; i < numberOfAttempts; i++) {
            arrayToBeSorted = createUnsortedArray(arraySize);

            temp=arrayToBeSorted.clone();
            t0 = System.nanoTime();
            selectionSort(temp);
            t1 = System.nanoTime();
            if (minimum1 > (t1 - t0)) {
                minimum1 = (t1 - t0);
            }


            temp=arrayToBeSorted.clone();
            t0 = System.nanoTime();
            insertionSort(temp);
            t1 = System.nanoTime();
            if (minimum2 > (t1 - t0)) {
                minimum2 = (t1 - t0);
            }            


            temp=arrayToBeSorted.clone();
            t0 = System.nanoTime();
            mergeSort(temp);
            t1 = System.nanoTime();
            if (minimum3 > (t1 - t0)) {
                minimum3 = (t1 - t0);
            }
        }

        System.out.println("Selection Sort Size " + arraySize + " : " + (minimum1) + " ns");

        System.out.println("Insertion Sort Size " + arraySize + " Minimum: " + (minimum2) + " ns");

        System.out.println("Merge Sort Size " + arraySize + " : " + (minimum3) + " ns");
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

        for (int i = 1; i < array.length; i++) {
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
    static public int[] mergeSort(int[] array) {
        if (array.length == 1)
            {return array;}
        int[] aux = new int[array.length];
        sort(array, aux, 0, array.length - 1);
        return array;
    }

    private static void sort(int[] org, int[] aux, int lo, int hi) {
        int length=hi-lo-1;
        if (length < 0)
            {return;}
            
        int mid = (lo + hi) / 2;
        sort(org, aux, lo, mid);// sort the items from lo to mid
        sort(org, aux, mid + 1, hi);// sort the items from mid+1 to hi
        merge(org, aux, lo, mid, hi);// merge the two sections using the additional array
        
    }

    private static void merge(int[] org, int[] aux, int lo, int mid, int hi) {
        // copy all items from lo to hi from org to aux
        for (int i = lo; i <= hi; i++) {
            aux[i] = org[i];
        }

        // let's do the merging
        int firstArray = lo; // the index in the first part
        int secondArray = mid+1; // the index in the second part
        // for all indices from lo to hi

        int k = lo;

        while (firstArray <= mid && secondArray <= hi) {
            
            if(aux[firstArray] < aux[secondArray]) {
                org[k] = aux[firstArray];
                firstArray++;
                k++;} 
            else {
                org[k] = aux[secondArray];
                secondArray++;
                k++;
            }

        }
        while (firstArray <= mid) {
            org[k] = aux[firstArray];
            firstArray++;
            k++;
        }
        
        while (secondArray <= hi) {
            org[k] = aux[secondArray];
            secondArray++;
            k++;
        }
        
    }
}
