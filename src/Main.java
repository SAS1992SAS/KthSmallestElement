import java.util.Random;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int[] arr = generateRandomArray(55,1,100);
        System.out.println(KthSmallestElement.select2(4, arr));
    }


    public static int[] generateRandomArray(int size, int min, int max) {
        int[] randomArray = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            // Generate a random integer between 'min' (inclusive) and 'max' (exclusive)
            randomArray[i] = random.nextInt(max - min) + min;
        }

        return randomArray;
    }
}