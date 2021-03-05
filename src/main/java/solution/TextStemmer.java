package solution;

import stemmers.PorterStemmer;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TextStemmer {

    /**
     * Accepts set of words without stopwords, iterates through words and applies Porter Stemmer stem algorithm to each word.
     *
     * @return stemmedWords
     */
    public List<String> stemWords(Set<String> wordsWithoutStopwords) {

        List<String> stemmedWords = new ArrayList<>();

        for (String word : wordsWithoutStopwords) {
            word = stemWord(word);
            stemmedWords.add(word);
        }

        return stemmedWords;
    }

    /**
     * Implements Porter Stemmer algorithm to reduce each word into its root.
     *
     * @param word
     * @return
     */
    public static String stemWord(String word) {

        PorterStemmer stemmer = new PorterStemmer();

        char[] charsOfStem = word.toCharArray();

        for (Character letter : charsOfStem) {
            stemmer.add(letter);
        }
        stemmer.stem();

        return stemmer.toString();
    }
}