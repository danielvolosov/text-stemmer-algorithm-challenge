package solution;

import java.util.List;
import java.util.Set;

import static constants.Constants.stopwordsFile;
import static constants.Constants.textFile1;

public class Main {

    public static void main(String[] args) {

        StopwordsRemover stopwordsRemover = new StopwordsRemover();
        TextStemmer textStemmer = new TextStemmer();
        CommonTermCounter commonTermCounter = new CommonTermCounter();

        Set<String> fileWithoutStopwords = stopwordsRemover.removeStopwordsFromTextFile(stopwordsFile, textFile1);

        List<String> stemsOfWords = textStemmer.stemWords(fileWithoutStopwords);

        System.out.println("This output represents the words in the input text file without stop words & without non-alphabetical text: " + fileWithoutStopwords);
//
//        System.out.println("This output represents the previous output, but all the words are stemmed into their root form: " + stemsOfWords);

//        System.out.println("This output represents the top-20 most commonly occuring terms, as well as the frequency of each term: " + CommonTermCounter.getCommonWordFrequencyAndCount(stemsOfWords));
    }
}
