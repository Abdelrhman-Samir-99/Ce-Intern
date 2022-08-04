import java.util.Hashtable;
import java.util.Scanner;

/*
    Time Complexity: O(max(N, M)) Where N is the size of wordsInLecture and M is the size of the dictionary
    Space Complexity: O(max(N, M))
    Description: we will just store a bidirectional way for each word. (so I know what does this word mean in the
    other dictionary), that's all what I need.
    It would be a good problem if we can extend it so a word can have multiple meanings in the other dictionary. (DSU and connected components)
*/
public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int numberOfWordsInLecture = reader.nextInt();
        int numberOfWordsInLanguage = reader.nextInt();

        Hashtable <String, String> first_to_second = new Hashtable<>();
        Hashtable <String, String> second_to_first = new Hashtable<>();

        for(int i = 0; i < numberOfWordsInLanguage; ++i) {
            String firstLanguage = reader.next();
            String secondLanguage = reader.next();
            first_to_second.put(firstLanguage, secondLanguage);
            second_to_first.put(secondLanguage, firstLanguage);
        }

        for(int i = 0; i < numberOfWordsInLecture; ++i) {
            String word = reader.next();

            String firstLanguage = null;
            String secondLanguage = null;

            if(first_to_second.containsKey(word)) {
                firstLanguage = word;
            } else {
                secondLanguage = word;
            }

            if(firstLanguage == null) {
                firstLanguage = second_to_first.get(word);
            } else {
                secondLanguage = first_to_second.get(word);
            }

            if(firstLanguage.length() <= secondLanguage.length()) {
                System.out.print(firstLanguage + " ");
            } else {
                System.out.print(secondLanguage + " ");
            }
        }
    }
}