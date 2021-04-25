import java.util.*;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        Set<String> dict = new HashSet<>();
        for (int i = 0; i < num; i++) {
            dict.add(scanner.nextLine().toLowerCase(Locale.ROOT));
        }
        Set<String> words = new HashSet<>();
        int lines = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < lines; i++) {
            words.addAll(Arrays.asList(scanner.nextLine().toLowerCase(Locale.ROOT).split(" ")));
        }
        words.removeAll(dict);
        for (String s : words) {
            System.out.println(s);
        }

    }
}
