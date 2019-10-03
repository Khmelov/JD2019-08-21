package by.it.zlotnikova.jd01_12;

import java.util.*;

public class TaskC1 {
    public static void main(String[] args) {
        String text = getText();  //gets text from console
        Map<Long, String> map = getTreeMap(text);
        System.out.println("Map с дубликатами значений: " + map.toString());
        Map<Long, String> newMap = removeDuplicates(map);
        System.out.println("Map без дубликатов: " + newMap.toString());
    }

    private static Map<Long, String> removeDuplicates(Map<Long, String> map) {
        HashSet<String> valueSet = new HashSet<>();
        Iterator<Map.Entry<Long, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Long, String> next = it.next();
            if (!valueSet.add(next.getValue())) {
                it.remove();
            }
        }
    return map;
    }

    private static Map<Long, String> getTreeMap(String text) {
        String[] values = text.split("\n");
        Map<Long, String> map = new TreeMap<>();
        for (String value : values) {
            map.put(System.nanoTime(), value);
        }
        return map;
    }

    private static String getText() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String newLine;
        while (!(newLine = scanner.nextLine()).equals("end")) {
            sb.append(newLine.trim()).append('\n');
        }
        return sb.toString();
    }
}

