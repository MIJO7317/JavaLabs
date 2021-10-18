package JavaLabs;

public class StringParser {
    public static String wordCount(String string) {
        Map<String, Integer> wordCountMap = new Map<>();
        for (String word :
                string.trim().split(" ")) {
            wordCountMap.put(word, wordCountMap.get(word) == null ? 1 : wordCountMap.get(word) + 1);
        }
        StringBuilder returnString = new StringBuilder();
        List<Map.Entry<String, Integer>> entriesList = wordCountMap.getEntries();
        for (int i = 0; i < entriesList.size(); i++) {
            returnString.append(entriesList.get(i).key).append(" : ").append(entriesList.get(i).value).append('\n');
        }
        return returnString.toString();
    }
    public static String trimRepeat(String string) {
        Map<String, Object> wordMap = new Map<>();
        for (String word :
                string.trim().split(" ")) {
            wordMap.put(word, null);
        }
        StringBuilder returnString = new StringBuilder();
        List<String> wordList = wordMap.getKeys();
        for (int i = 0; i < wordList.size(); i++) {
            returnString.append(wordList.get(i)).append(" ");
        }
        return returnString.toString();
    }
}
