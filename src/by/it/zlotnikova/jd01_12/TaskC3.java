package by.it.zlotnikova.jd01_12;

import java.util.*;

public class TaskC3 {

    // not finished
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        List<Character> chars = new ArrayList<>();
        for (char ch : string.toCharArray()) {
            chars.add(ch);
        }
        Iterator<Character> it = chars.iterator();
        System.out.println(checkLeftBracket(it));
    }

    private static boolean checkLeftBracket(Iterator<Character> it) {
        while (it.hasNext()) {
            Character ch = it.next();
            switch (ch) {
                case '}':
                case ')':
                case ']':
                    return false;
                case '{':
                case '(':
                case '[':
                    return (checkRightBracket(it));
                default:
                    continue;
            }
        }
        return true;
    }

    private static boolean checkRightBracket(Iterator<Character> it) {
        while (it.hasNext()) {
            Character ch = it.next();
            switch (ch) {
                case '}':
                case ')':
                case ']':
                    return true;
                case '{':
                case '(':
                case '[':
                    return (checkRightBracket(it));
                default:
                    continue;
            }
        }
        return false;
    }

}
