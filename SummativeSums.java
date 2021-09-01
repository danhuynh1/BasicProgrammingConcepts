public class SummativeSums {
    
public static void main(String[] args){
    int[] array1 = { 1, 90, -33, -55, 67, -16, 28, -55, 15 };
    System.out.printf("#1 ArraySum %d\n",sumIntArray(array1));
    int[] array2 = { 999, -60, -77, 14, 160, 301 };
    System.out.printf("#1 ArraySum %d\n",sumIntArray(array2));
    int[] array3 = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200, -99 };
    System.out.printf("#1 ArraySum %d\n",sumIntArray(array3));
}
/**
 * Helper method that sums the contents of an intArray
 * @param intArray
 * @return sum of IntArray
 */
    public static int sumIntArray(int[] intArray){
        int sum = 0;
        for (int i : intArray) sum+=i;
        return sum;
    }
}
