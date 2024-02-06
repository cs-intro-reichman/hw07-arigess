
public class SpellChecker {


    public static void main(String[] args) {
        //String word = args[0];
        String word = "concensus";
        //int threshold = Integer.parseInt(args[1]);
        int threshold = 1;
        String[] dictionary = readDictionary("dictionary.txt");
        String correction = spellChecker(word, threshold, dictionary);
        System.out.println(correction);
        //String word1 = "bla";
        //String word2 = "brra";
        //int result = levenshtein(word1, word2);
        //System.out.println(result);

    }

    public static String tail(String str) {
        // Your code goes here
        return "";
    }

    public static int levenshtein(String word1, String word2) {
        word1 = word1.toLowerCase();
        word2 = word2.toLowerCase();
        if (word1 == "") {
            return word2.length();
        } else if (word2 == "") {
            return word1.length();
        } else if (word1.charAt(0) == word2.charAt(0)) {
            return levenshtein(word1.substring(1), word2.substring(1));
        }

        return 1 + Math.min(Math.min(levenshtein(word1.substring(1), word2.substring(1)),
                        levenshtein(word1.substring(1), word2)),
                levenshtein(word1, word2.substring(1)));
    }

    public static String[] readDictionary(String fileName)
	{
        String[] dictionary = new String[3000];

        In in = new In(fileName);
        for(int i=0;i<dictionary.length; i++){
            dictionary[i] = in.readLine();
        }

        return dictionary;
    }

    public static String spellChecker(String word, int threshold, String[] dictionary) {
        int smallestDistance = Integer.MAX_VALUE;
        String closestWord = "";
        for (int i=0; i< dictionary.length; i++){
            int result = levenshtein(word, dictionary[i]);
            if (result <= threshold && result < smallestDistance){
                smallestDistance = result;
                closestWord = dictionary[i];
            }
        }
        if (closestWord == ""){
            return word;
        }

        return closestWord;
    }

}
