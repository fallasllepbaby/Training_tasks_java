import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        // Strings


        // Task 1
        // Напишите метод для поиска самой длинной строки в массиве.

        String[] array = new String[] {"mama", "papa", "maria", "aba", "conclusion", "good", "better"};
        System.out.print("The longest word in the array is \"" + getTheLongestString(array) + "\"\n");

        // Task 2
        // Напишите метод, который проверяет является ли слово палиндромом.

        System.out.println(isPalindrome("rba"));

        // Task 3
        // Напишите метод, заменяющий в тексте все вхождения слова «бяка» на «[вырезано цензурой]».

        String string = "бяка надоело мне заниматься бяка";
        System.out.println(replaceCensorship(string));

        // Task 4
        // Имеются две строки. Напишите метод, возвращающий количество вхождений одной строки в другую.

        String stringOccurrences = "dad brother ball good bad worst paper book floor table monitor bad good bad water";
        System.out.println("Количество вхождений: " + countOccurrences("bad", stringOccurrences));


        // Task 5
        // Постройте частотный словарь букв русского (или английского) алфавита.
        // Опустим проблему выбора и анализа корпуса языка, достаточно будет взять текст небольшой длины).

        String frequencyString = "The self-study lessons in this section are written and organised by English level based on the Common European Framework of Reference for languages (CEFR). There are different types of texts and interactive exercises that practise the reading skills you need to do well in your studies, to get ahead at work and to communicate in English in your free time.";
        getFrequencyDictionary(frequencyString);

    }

    public static String getTheLongestString(String[] array) {
        String max = array[0];
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i + 1].length() > max.length()) max = array[i + 1];
        }
        return max;
    }

    public static boolean isPalindrome(String string1) {
        StringBuilder string2 = new StringBuilder(string1).reverse();
        return string1.equalsIgnoreCase(String.valueOf(string2));
    }

    public static String replaceCensorship(String string) {
        return string.replaceAll("бяка", "[вырезано цензурой]");
    }

    public static int countOccurrences(String substring, String string) {
        int count = 0;
        for (int i = 0; i < string.length() - substring.length(); i++) {
            if (string.substring(i, i + substring.length()).equals(substring)) {
                count++;
            }
        }
        return count;
    }

    public static void getFrequencyDictionary(String text) {
        text = text.toLowerCase();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
          char ch = text.charAt(i);

          if((ch >= 'a' && ch <= 'z')) {
              map.put(text.charAt(i), 0);
          }
        }

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if((ch >= 'a' && ch <= 'z')) {
                map.put(text.charAt(i), map.get(text.charAt(i)) + 1);
            }
        }

        map.forEach((key, value) -> System.out.println(key + " : " + value));

    }
}
