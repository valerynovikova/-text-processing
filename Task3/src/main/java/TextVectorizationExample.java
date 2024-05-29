import org.apache.commons.text.similarity.CosineSimilarity;

import java.util.HashMap;
import java.util.Map;
/* Новикова Валерия 11-108
Пример простой векторизации текста на Java
 */
public class TextVectorizationExample {

    public static void main(String[] args) {
        String text1 = "Это первый текст для векторизации";
        String text2 = "Это второй текст для векторизации";

        // Преобразование текстов в числовые векторы с использованием Apache Commons Text
        CosineSimilarity cosineSimilarity = new CosineSimilarity();
        Map<CharSequence, Integer> vector1 = toCharSequenceIntegerMap(text1);
        Map<CharSequence, Integer> vector2 = toCharSequenceIntegerMap(text2);

        double similarityScore = cosineSimilarity.cosineSimilarity(vector1, vector2);

        System.out.println("Косинусное сходство текстов: " + similarityScore);
    }

    private static Map<CharSequence, Integer> toCharSequenceIntegerMap(String text) {
        Map<CharSequence, Integer> map = new HashMap<>();
        String[] words = text.split("\\s+");

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        return map;
    }
}
