package HashMapConcept;

import java.util.HashMap;
import java.util.Map;

public class HighestMarkFinders {

	public static void main(String[] args) {

		// Create a HashMap to store subjects and their corresponding marks
        HashMap<String, Integer> subjects = new HashMap<>();
        subjects.put("English", 30);
        subjects.put("Math", 25);
        subjects.put("Science", 40);

        // Variables to track the subject with the highest mark
        String highestMarkSubject = "";
        int highestMark = 0;
        
        // Print the marks in a tabular format
        System.out.println("Subject\t\tMark");
        System.out.println("----------------------");
        for (Map.Entry<String, Integer> entry : subjects.entrySet()) {
            System.out.println(entry.getKey() + "\t\t" + entry.getValue());
        }

        // Find the subject with the highest mark
        for (Map.Entry<String, Integer> entry : subjects.entrySet()) {
           if (entry.getValue() > highestMark) {
                highestMark = entry.getValue();
                highestMarkSubject = entry.getKey();
            }
        }


        // Display the subject with the highest mark
        System.out.println("\nThe highest mark is in: " + highestMarkSubject + " with " + highestMark + " marks.");
    }

}
