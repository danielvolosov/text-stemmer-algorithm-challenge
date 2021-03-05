package solution_tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import solution.TextStemmer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@DisplayName("Tests the TextStemmer class")
public class TextStemmerTest {

    private TextStemmer textStemmer;

    @BeforeEach
    public void setUp() throws Exception {
        textStemmer = new TextStemmer();
    }

    @DisplayName("Test for stemming a word")
    @Test
    void testStemWord() {

        String fishes = "Fishes";
        String fishesResult = textStemmer.stemWord(fishes);

        String hopping = "Hopping";
        String hoppingResult = textStemmer.stemWord(hopping);

        String skydiving = "skydiving";
        String skydivingResult = textStemmer.stemWord(skydiving);

        String obfuscated = "obfuscated";
        String obfuscatedResult = textStemmer.stemWord(obfuscated);

        Assertions.assertEquals("Fish", fishesResult);
        Assertions.assertEquals("Hop", hoppingResult);
        Assertions.assertEquals("skydiv", skydivingResult);
        Assertions.assertEquals("obfusc", obfuscatedResult);
    }

    @DisplayName("Test for stemming several words")
    @Test
    void testStemWords() {

        Set<String> wordSet = new HashSet<>();
        wordSet.add("Hopping");
        wordSet.add("skydiving");
        wordSet.add("obfuscated");

        List<String> stemmedList = new ArrayList<>();
        stemmedList.add("Hop");
        stemmedList.add("skydiv");
        stemmedList.add("obfusc");

        List<String> result = textStemmer.stemWords(wordSet);

        Assertions.assertEquals(stemmedList, result);
    }
}