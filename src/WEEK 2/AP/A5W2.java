import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class A5W2 {

    public static void printFilteredWordFrequency(String feedback) {

        String cleanedText = feedback.toLowerCase();

        cleanedText = cleanedText.replace(".", "");
        cleanedText = cleanedText.replace(",", "");

        String[] words = cleanedText.split("\\s+");

        String[] stopWords = {
                "the", "was", "and", "a", "is", "of", "in"
        };

        HashMap<String, Integer> frequency = new HashMap<>();

        for (int i = 0; i < words.length; i++) {

            boolean isStopWord = false;

            for (int j = 0; j < stopWords.length; j++) {

                if (words[i].equals(stopWords[j])) {
                    isStopWord = true;
                    break;
                }
            }

            if (!isStopWord) {

                if (frequency.containsKey(words[i])) {
                    frequency.put(words[i], frequency.get(words[i]) + 1);
                } else {
                    frequency.put(words[i], 1);
                }
            }
        }

        // Print words sorted by frequency in descending order
        while (!frequency.isEmpty()) {

            String highestWord = "";
            int highestCount = 0;

            for (Map.Entry<String, Integer> entry : frequency.entrySet()) {

                if (entry.getValue() > highestCount) {
                    highestWord = entry.getKey();
                    highestCount = entry.getValue();
                }
            }

            System.out.println(highestWord + ": " + highestCount);

            frequency.remove(highestWord);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter feedback: ");
        String feedback = sc.nextLine();

        printFilteredWordFrequency(feedback);

        sc.close();
    }
}
