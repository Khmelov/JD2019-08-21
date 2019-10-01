package by.it.shamuradova.jd01_12;


import java.util.*;

public class TaskC3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String primer = sc.nextLine();

        System.out.println(pravilnieSkobki(primer));
    }

    private static boolean pravilnieSkobki(String primer) {
       // Map<Character, Character> opposites = new HashMap<>();
       // opposites.put('}', '{');
        //opposites.put(')', '(');
        //opposites.put(']', '[');

        primer=primer.replaceAll("-?[0-9]+\\.?[0-9]*", "");
        primer=primer.replaceAll("[-+*=/]", "");

        char[] skobki = primer.toCharArray();
        Stack<Character> stackSkobok=new Stack<>();
        for (int i = 0; i < skobki.length; i++) {
            if(skobki[i]=='(' || skobki[i]=='{' || skobki[i]=='['){
                stackSkobok.push(skobki[i]);
            }
            else{
                if (stackSkobok.isEmpty()) {
                    return false;
                }

                switch (skobki[i]) {
                    case '}':
                        if (stackSkobok.pop() != '{') {
                            return false;
                        }
                        break;
                    case ')':
                        if (stackSkobok.pop() != '(') {
                            return false;
                        }
                        break;
                    case ']':
                        if (stackSkobok.pop() != '[') {
                            return false;
                        }
                        break;
                }

                /*Character character = stackSkobok.pop();
                char opposite = opposites.get(skobki[i]);
                if (opposite != character) {
                    return false;
                }*/
            }
        }
        if (!stackSkobok.isEmpty()) {
            return false;
        }
        return true;
    }
}
