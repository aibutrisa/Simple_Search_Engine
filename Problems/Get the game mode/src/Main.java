import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Problem {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\aibut\\Downloads\\dataset_91065.txt");
        ArrayList<Integer> ints = new ArrayList<Integer>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                int n = scanner.nextInt();
                if (n == 0) {
                    break;
                }
                if (n % 2 == 0) {
                    ints.add(n);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found: ");
        }
        System.out.println(ints.size());
    }
}