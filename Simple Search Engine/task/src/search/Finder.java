package search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

public class Finder {
    private FindingStrategy strategy;

    public Finder(FindingStrategy strategy) {
        this.strategy = strategy;
    }
    public ArrayList<Integer> find(Map<String, ArrayList<Integer>> strings, String[] findingStrings) {
        // write your code here
        return this.strategy.getResult(strings, findingStrings);
    }
}

interface FindingStrategy {
    ArrayList<Integer> getResult(Map<String, ArrayList<Integer>> strings, String[] findingStrings);
}

class AllFindingStrategy implements FindingStrategy {
    public ArrayList<Integer> getResult(Map<String, ArrayList<Integer>> strings, String[] findingStrings) {
        ArrayList<Integer> result = new ArrayList<>();
        HashSet<Integer> hashSet = new HashSet<>();
        if (strings.containsKey(findingStrings[0])) {
            hashSet.addAll(strings.get(findingStrings[0]));
            for (int i = 1; i < findingStrings.length; i++) {
                if (strings.containsKey(findingStrings[i])) {
                    hashSet.retainAll(strings.get(findingStrings[i]));
                }
                else break;
            }
        }
        result.addAll(hashSet);
        return result;
    }
}

class AnyFindingStrategy implements FindingStrategy {
    public ArrayList<Integer> getResult(Map<String, ArrayList<Integer>> strings, String[] findingStrings) {
        ArrayList<Integer> result = new ArrayList<>();
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < findingStrings.length; i++) {
            hashSet.addAll(strings.get(findingStrings[i]));
        }
        result.addAll(hashSet);
        return result;
    }
}

class NoneFindingStrategy implements FindingStrategy {
    public ArrayList<Integer> getResult(Map<String, ArrayList<Integer>> strings, String[] findingStrings) {
        ArrayList<Integer> result = new ArrayList<>();
        HashSet<Integer> hashSet = new HashSet<>();
        for (Map.Entry<String, ArrayList<Integer>> entry : strings.entrySet()) {
            hashSet.addAll(entry.getValue());
        }
        for (int i = 0; i < findingStrings.length; i++) {
            hashSet.removeAll(strings.get(findingStrings[i]));
        }
        result.addAll(hashSet);
        return result;
    }
}