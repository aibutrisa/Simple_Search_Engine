import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String s : strings) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }
        strings = scanner.nextLine().split(" ");
        for (String s : strings) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) - 1);
            } else {
                map.put(s, -1);
            }
        }
        boolean haveWords = true;
        for (int i : map.values()) {
            haveWords = i >= 0;
        }
        System.out.println(haveWords ? "You get money" : "You are busted");
    }
}
