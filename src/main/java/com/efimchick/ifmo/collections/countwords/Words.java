package com.efimchick.ifmo.collections.countwords;


import java.util.*;

public class Words {

    public String countWords(List<String> lines) {
        Map<String, Integer> map = new TreeMap<>();


        for (String line : lines) {

            String[] arr = line.toLowerCase().replaceAll("[^А-Яа-яA-Za-z]", " ").trim().split("\\s");


            for (String word : arr) {
                if (!map.containsKey(word) && word.length() >= 4) {
                    map.put(word, 0);
                }
                if (word.length() >= 4) {
                    map.put(word, map.get(word) + 1);
                }
            }
        }

        StringBuilder result = new StringBuilder();



        List<Map.Entry<String, Integer>> list = new LinkedList(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return -o1.getValue().compareTo(o2.getValue());
            }
        });

        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }


        for (String s : sortedMap.keySet()) {
            if (map.get(s) >= 10) {
                result.append(s).append(" - ").append(sortedMap.get(s)).append("\n");
            }
        }

        return result.toString().trim();
    }
}
