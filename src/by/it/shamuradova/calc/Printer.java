package by.it.shamuradova.calc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Printer {
    void print(Var var){
        System.out.println(var);
    }
    void printMap(Map<String, Var> varMap) {
        if (varMap.isEmpty()) {
            System.out.println("[]");
        }
        for (Map.Entry<String, Var> entry : varMap.entrySet()) {
            System.out.println(entry);
        }
    }

    void printSorted(Map<String, Var> varMap) {
        if (varMap.isEmpty()) {
            System.out.println("[]");
        }
        List<String> keys = new ArrayList<>(varMap.keySet());
        keys.sort(null);
        for (String key : keys) {
            System.out.println(key + "=" + varMap.get(key));
        }
    }
}
