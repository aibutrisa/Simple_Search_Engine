import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> ints = new ArrayList<>();
        String[] strings = scanner.nextLine().split(" ");
        for (String s : strings) {
            ints.add(Integer.parseInt(s));
        }
        ints.removeIf(i -> ints.indexOf(i) % 2 == 0);
        for (int i = ints.size() - 1; i >= 0; i--) {
            System.out.print(ints.get(i) + " ");
        }
    }
}
