import java.io.FileReader;
import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        Map<String, Integer> wordFrequencies = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader("11.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\W+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        word = word.replaceAll("[^a-zA-Z0-9]", ""); // убираем знаки препинания
                        Integer count = wordFrequencies.get(word);
                        if (count == null) {
                            count = 1;
                        } else {
                            count++;
                        }
                        wordFrequencies.put(word, count);
                    }
                }
            }
        }

        // Выводим результаты
        System.out.println("Слова и их частота встречаемости:");
        for (Map.Entry<String, Integer> entry : wordFrequencies.entrySet()) {
            System.out.format("%-20s: %d\n", entry.getKey(), entry.getValue());
        }
    }
}