import java.util.Map;
import java.util.TreeMap;

public class Dictionary {
    private TreeMap<String, String> words;

    public Dictionary() {
        words = new TreeMap<>();
    }

    // Adds a word and its definition to the dictionary
    public String addWord(String word, String definition) {
        // Check if the word exists in the dictionary
        if (!words.containsKey(word)) {
            words.put(word, definition);
            return null;
        } else
            // If the word exists, returns an error message
            return ("Word '" + word
                    + "' is already in the dictionary - if you would like to update the value then use the correct way.");
    }

    // Retrieves the definition of a word from the dictionary
    public String getDefinition(String word) {
        return words.get(word);
    }

    // Updates the definition of a word from the dictionary
    public String updateWord(String word, String newDefinition) {
        // Check if the word exists in the dictionary
        if (words.containsKey(word)) {
            // If the word exists, updates its definition
            words.put(word, newDefinition);
            return null;
        } else {
            // If the word doesn't exist, returns an error message
            return ("Word '" + word + "' not found in the dictionary.");
        }
    }

    // Removes a word and its definition from the dictionary
    public String removeWord(String word) {
        if (words.containsKey(word)) {
            // If the word exists, removes from dictionary
            words.remove(word);
            return null;
        } else {
            // If the word doesn't exist, returns an error message
            return ("Word '" + word + "' not found in the dictionary and therefore could not be deleted.");
        }

    }

    // Checks if a word exists in the dictionary
    public String containsWord(String word) {
        if (words.containsKey(word))
            return words.get(word);
        return null;
    }

    // Gets the number of words in the dictionary
    public int size() {
        return words.size();
    }

    // Prints all words and their definitions in the dictionary
    public void printDictionary() {
        for (Map.Entry<String, String> entry : words.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
