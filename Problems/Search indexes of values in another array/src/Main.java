import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int[] searchIndexes(int[] first, int[] second) {
        // write your code here
        int[] index = new int[first.length];
        for (int i = 0; i < first.length; i++) {
            index[i] = -1;
            for (int j = 0; j < second.length; j++) {
                if (second[j] == first[i]) {
                    index[i] = j;
                    break;
                }
            }
        }
        return index;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int[] first = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        final int[] second = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        final String result = Arrays.toString(searchIndexes(first, second))
                .replace(", ", " ")
                .replace("[", "")
                .replace("]", "");
        System.out.println(result);
    }
}