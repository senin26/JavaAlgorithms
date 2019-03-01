package sortingTest;

public final class SortUtility {

    private SortUtility() {
    }

    public static int[] bubbleSort(int[] array) {
        for (int i = (array.length-1); i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[i]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    public static void selectSort(int[] array){
        int out, in, mark;
        for(out = 0; out < array.length; out++){
            mark = out;
            for(in = out+1; in < array.length; in++){
                if (array[in] < array[mark]){
                    mark = in;
                }
            }
            int temp = array[out];
            array[out] = array[mark];
            array[mark] = temp;
        }
    }

    public static int[] insertSort(int[] array) {
        int i, j, temp;
        for (i = 1; i < array.length; i++) {
            temp = array[i];
            j = i;
            while(j > 0 && array[j-1] >= temp) {
                array[j] = array[j-1];
                --j;
            }
            array[j] = temp;
        }
        return array;
    }
}
