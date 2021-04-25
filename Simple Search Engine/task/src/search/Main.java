package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello World!");
        ArrayList<String> strings = new ArrayList<String>();
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
                    System.out.println("Enter a name or email to search all suitable people.");
                    String find = scanner1.nextLine();
                    findString(strings, find);
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

    public static void findString(ArrayList<String> strings, String find) {
        boolean isFound = false;
        for (String s : strings) {
            if (s.toLowerCase(Locale.ROOT).contains(find.toLowerCase(Locale.ROOT))) {
                if (!isFound) {
                    System.out.println("Found people:");
                }
                System.out.println(s);
                isFound = true;
            }
        }
        if (!isFound) {
            System.out.println("No matching people found.");
        }
    }

    public static void printAll(ArrayList<String> strings) {
        System.out.println("=== List of people ===");
        for (String s : strings) {
            System.out.println(s);
        }
    }
}
