package sortingTest;

import java.util.Random;

public class RandomArrayGenerator {

    private int arraySize;
    private int[] array;
    private Random random = new Random();

    public RandomArrayGenerator(int arraySize) {
        this.arraySize = arraySize;
        this.array = new int[arraySize];
    }

    public int[] getRandomArray() {
        for (int i = 0; i < arraySize; i++) {
            array[i] = random.nextInt(arraySize);
        }
        return array;
    }

}
