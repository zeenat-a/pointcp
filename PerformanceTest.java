import java.util.*;

public class PerformanceTest {

    private static final int COLLECTION_SIZE = 10000000; 

    public static void main(String[] args) {
        testCollectionConstruction();

        testIterationTime();
    }

    public static void testCollectionConstruction() {
        // ArrayList Test
        long start = System.currentTimeMillis();
        ArrayList<Integer> arrayList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < COLLECTION_SIZE; i++) {
            arrayList.add(random.nextInt(10));
        }
        long end = System.currentTimeMillis();
        System.out.println("ArrayList Time: " + (end - start) + " milliseconds");

        // Vector Test
        start = System.currentTimeMillis();
        Vector<Integer> vector = new Vector<>();
        for (int i = 0; i < COLLECTION_SIZE; i++) {
            vector.add(random.nextInt(10));
        }
        end = System.currentTimeMillis();
        System.out.println("Vector Time: " + (end - start) + " milliseconds");

        // Array Test
        start = System.currentTimeMillis();
        int[] array = new int[COLLECTION_SIZE];
        for (int i = 0; i < COLLECTION_SIZE; i++) {
            array[i] = random.nextInt(10);
        }
        end = System.currentTimeMillis();
        System.out.println("Array Time: " + (end - start) + " milliseconds");
    }

    public static void testIterationTime() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Vector<Integer> vector = new Vector<>();
        int[] array = new int[COLLECTION_SIZE];
        Random random = new Random();
        for (int i = 0; i < COLLECTION_SIZE; i++) {
            int value = random.nextInt(10);
            arrayList.add(value);
            vector.add(value);
            array[i] = value;
        }

        // ArrayList Test
        long start = System.currentTimeMillis();
        int sum = 0;
        for (int value : arrayList) {
            sum += value;
        }
        long end = System.currentTimeMillis();
        System.out.println("ArrayList Time: " + (end - start) + " milliseconds");

        // Vector Test
        start = System.currentTimeMillis();
        sum = 0;
        for (int value : vector) {
            sum += value;
        }
        end = System.currentTimeMillis();
        System.out.println("Vector Time: " + (end - start) + " milliseconds");

        // Array Test
        start = System.currentTimeMillis();
        sum = 0;
        for (int value : array) {
            sum += value;
        }
        end = System.currentTimeMillis();
        System.out.println("Array Time: " + (end - start) + " milliseconds");
    }
}
