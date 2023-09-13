public class MergeTest {
    
    public static void main(String[] args) throws Exception {

        int array1[]={1,2,3,4,5,6};
        int array2[]={10,11,12,7,8,9};

        merge(array1, array2);
        printIntArray(array1);
    }

    static public void printIntArray(int[] arrayToBePrinted) {
        for (int i = 0; i < arrayToBePrinted.length; i++) {
            System.out.print(arrayToBePrinted[i] + ",");
        }
        System.out.println("");
    }

    private static void merge(int[] org, int[] aux) {


        int firstArray = 0; // the index in the first part
        int secondArray = aux.length/2; // the index in the second part
        // for all indices from lo to hi

        int mid =org.length/2;
        int hi=org.length;
        int k = 0;

        while (firstArray < mid && secondArray < hi) {
            
            if(aux[firstArray] < aux[secondArray]) {
                org[k] = aux[firstArray];
                firstArray++;
                k++;
            } else {
                org[k] = aux[secondArray];
                secondArray++;
                k++;
            }

        }
        while (firstArray < mid) {
            org[k] = aux[firstArray];
            firstArray++;
            k++;
        }
        while (secondArray < hi) {
            org[k] = aux[secondArray];
            secondArray++;
            k++;
        }

    }
}
