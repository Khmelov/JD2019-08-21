package by.it.kiturka.jd01_06;

public class TaskB1 {
    public static void main(String[] args) {
        String s = Poem.text;
        String[] splitResult = s.split(" ?(?<!\\G)((?<=[^\\p{Punct}])(?=\\p{Punct})|\\b) ?");

        soglasGlas(splitResult);


    }

    private static void soglasGlas(String[] words) {
        String glasnie = "аАеЕёЁиИоОуУыЫэЭюЮяЯ";
        String soglasnie = "бБвВгГдДжЖзЗкКлЛмМнНпПрРсСтТфФхХцЦчЧшШщЩьЬъЪ"; // к

        for (int i = 0; i < words.length; i++) {
            String word = words[i]; // кот
            if (word.length() >= 2) {
                char firstChar = word.charAt(0); // к
                char lastChar = word.charAt(word.length() - 1);
                if (soglasnie.indexOf(firstChar) != -1 && glasnie.indexOf(lastChar) != -1) {
                    System.out.println(word);
                }
            }
        }
    }
}
