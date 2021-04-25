package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello World!");
        ArrayList<String> strings = new ArrayList<>();
        try {
            if (args[0].equals("--data")) {
                File file = new File(args[1]);
                Scanner scanner = new Scanner(file);
                while (scanner.hasNext()) {
                    strings.add(scanner.nextLine());
                }
                scanner.close();
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File is not found");
        }
        /*Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        while (!s.equals("stop")) {
            strings.add(s);
            s = scanner.nextLine();
        }*/
        Map<String, ArrayList<Integer>> index = createMap(strings);
        Scanner scanner1 = new Scanner(System.in);
        int choose = -1;
        while (choose != 0) {
            System.out.println("=== Menu ===");
            System.out.println("1. Find a person");
            System.out.println("2. Print all people");
            System.out.println("0. Exit");
            choose = Integer.parseInt(scanner1.nextLine());
            switch (choose) {
                case 1: {
                    System.out.println("Select a matching strategy: ALL, ANY, NONE");
                    String strategy = scanner1.nextLine();
                    FindingStrategy searchstrat = create(strategy);
                    Finder finder = new Finder(searchstrat);
                    System.out.println("Enter a name or email to search all suitable people.");
                    String[] findingStrings = scanner1.nextLine().toLowerCase(Locale.ROOT).split(" ");
                    ArrayList<Integer> find = finder.find(index, findingStrings);
                    for (int i : find) {
                        System.out.println(strings.get(i));
                    }
                    break;
                }
                case 2: {
                    printAll(strings);
                    break;
                }
                case 0: {
                    System.out.println("Bye!");
                    break;
                }
                default: System.out.println("Incorrect option! Try again.");
            }
        }
    }

    public static void findString(Map<String, ArrayList<Integer>> strings, ArrayList<String> list,  String find) {
        boolean isFound = false;
        if (strings.containsKey(find.toLowerCase(Locale.ROOT))) {
            ArrayList<Integer> ints = strings.get(find.toLowerCase(Locale.ROOT));
            System.out.println("Found people:");
            for (int i : ints) {
                System.out.println(list.get(i));
            }
        } else {
            System.out.println("No matching people found.");
        }
    }

    public static void printAll(ArrayList<String> strings) {
        System.out.println("=== List of people ===");
        for (String s : strings) {
            System.out.println(s);
        }
    }

    public static Map<String, ArrayList<Integer>> createMap(ArrayList<String> strings) {
        Map<String, ArrayList<Integer>> map = new HashMap<>();
        for (String s: strings) {
            String[] strings1 = s.toLowerCase(Locale.ROOT).split(" ");
            for (String s1: strings1) {
                if (map.containsKey(s1)) {
                    ArrayList<Integer> ints = map.get(s1);
                    ints.add(strings.indexOf(s));
                    map.put(s1, ints);
                } else {
                    ArrayList<Integer> integers = new ArrayList<>();
                    integers.add(strings.indexOf(s));
                    map.put(s1, integers);
                }
            }

        }
        return map;
    }

    public static FindingStrategy create(String algType) {
        switch (algType) {
            case "ALL": {
                return new AllFindingStrategy();
            }
            case "ANY": {
                return new AnyFindingStrategy();
            }
            case "NONE": {
                return new NoneFindingStrategy();
            }
            default: {
                throw new IllegalArgumentException("Unknown algorithm type " + algType);
            }
        }
    }
}
