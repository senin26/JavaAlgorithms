package sortingTest;

public class SortingTest {

    private int arrayRandomSize = 10_000;
    private int numberCalc = 100;
    private RandomArrayGenerator randomArrayGenerator = new RandomArrayGenerator(arrayRandomSize);

    public int getNumberCalc() {
        return numberCalc;
    }

    public RandomArrayGenerator getRandomArrayGenerator() {
        return randomArrayGenerator;
    }

    public static void main(String[] args) {

        SortingTest sortingTest = new SortingTest();
        int N = sortingTest.getNumberCalc();
        int[] arrayRandom;

        ///////////////////////////////

        System.out.println("Get results for Bubble sorting");
        long start = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            arrayRandom = sortingTest.getRandomArrayGenerator().getRandomArray();
            SortUtility.bubbleSort(arrayRandom);
        }
        long t = System.currentTimeMillis() - start;
        System.out.println("Time of Bubble sorting " + t);
        System.out.println("Average time of Bubble sorting " + (float) t/N + "\n");

        ///////////////////////////////

        System.out.println("Get results for Select sorting");
        start = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            arrayRandom = sortingTest.getRandomArrayGenerator().getRandomArray();
            SortUtility.selectSort(arrayRandom);
        }
        t = System.currentTimeMillis() - start;
        System.out.println("Time of Select sorting " + t);
        System.out.println("Average time of Select sorting " + (float) t/N + "\n");

        ///////////////////////////////

        System.out.println("Get results for Insert sorting");
        start = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            arrayRandom = sortingTest.getRandomArrayGenerator().getRandomArray();
            SortUtility.insertSort(arrayRandom);
        }
        t = System.currentTimeMillis() - start;
        System.out.println("Time of Insert sorting " + t);
        System.out.println("Average time of Insert sorting " + (float) t/N);

    }

}
