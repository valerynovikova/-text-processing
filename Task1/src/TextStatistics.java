import java.util.HashMap;
import java.util.Map;
/*Новикова Валерия Дмитриевна 11-108
* Пример статистического анализа:подсчет частоты слов в тексте  */
public class TextStatistics {

    public static void main(String[] args) {
        String text = "Это пример текста для статистического анализа. Пример кода на Java.";

        // Удаляем знаки препинания и приводим текст к нижнему регистру
        text = text.replaceAll("[^a-zA-Zа-яА-Я ]", "").toLowerCase();

        // Разбиваем текст на слова
        String[] words = text.split("\\s+");

        // Создаем Map для хранения частоты слов
        Map<String, Integer> wordFrequency = new HashMap<>();

        // Подсчитываем частоту каждого слова
        for (String word : words) {
            if (!word.isEmpty()) {
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }
        }

        // Выводим результаты
        System.out.println("Частота слов в тексте:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

