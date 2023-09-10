public class App {
    public static void main(String[] args) throws Exception {

        int arrayToBeSorted[] ={2,1,3,4,5,6,7,8,9};

        benchmarkSort(arrayToBeSorted);

    }

    static public void benchmarkSort(int[] arrayToBeSorted)
    {
        System.out.print("Original array: ");
        printIntArray(arrayToBeSorted);
        int arrayCopy[]= arrayToBeSorted;

        arrayCopy=selectionSort(arrayCopy);

        arrayToBeSorted=insertionSort(arrayToBeSorted);

        System.out.println("Selection Sort: ");
        printIntArray(arrayCopy);

        System.out.println("Insertion Sort: ");
        printIntArray(arrayToBeSorted);


    }

    static public void printIntArray(int[] arrayToBePrinted)
    {
        for (int i = 0; i < arrayToBePrinted.length; i++) {
            System.out.print(arrayToBePrinted[i]+",");
        }
        System.out.println("");
    }

    static public int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int candidate = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[i]) {
                    candidate = j;
                }
            }
            if (candidate!=i) {
                 array=swap(array,array[i],array[candidate]);
            }
           
            
        }
        return array;
    }

    static public int[] insertionSort(int[] array) {

            for (int i = 0; i < array.length; i++) {
                for (int j = i; j > 0 && array[j]<array[j-1] ; j--) {
                array=swap(array, array[j-1],array[j]);
                }
            }
            return array;
        }

    static public int[] swap(int[] array, int firstIndex, int secondIndex)
    {
            int candidate = array[firstIndex];
            array[firstIndex] = array[secondIndex];
            array[secondIndex] = candidate;
            
        return array;
    }
    
}
