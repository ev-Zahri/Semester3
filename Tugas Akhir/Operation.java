import java.util.Arrays;
import java.util.Random;

public class Operation {
    protected static int[][] patternCopy = {
        {0,0},{0,1},{0,2},{0,3},{0,4},{0,5},{0,6},
        {1,1},{1,2},{1,3},{1,4},{1,5},{1,6},{2,2},
        {2,3},{2,4},{2,5},{2,6},{3,3},{3,4},{3,5},
        {3,6},{4,4},{4,5},{4,6},{5,5},{5,6},{6,6},
    };
    public static int[][] removeElement(int[][] array, int indexToRemove) {
        int[][] newArray = new int[array.length - 1][2];
        for (int i = 0; i < indexToRemove; i++) {
            newArray[i] = array[i];
        }
        for (int i = indexToRemove+1; i < array.length; i++) {
            newArray[i-1] = array[i];
        }
        return newArray;
    }

    public static int[][] getRandomElements(int count) {
        Random random = new Random();
        int[][] resultArray = new int[count][2];
        for (int i = 0; i < count; i++) {
            int randomIndex = random.nextInt(patternCopy.length);
            resultArray[i] = patternCopy[randomIndex];
            patternCopy = removeElement(patternCopy, randomIndex);
        }
        return resultArray;
    }

    public static void printArray(int[][] array) {
        System.out.print("{ ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(Arrays.toString(array[i]) + " ");
        }
        System.out.println("}");
    }
}
