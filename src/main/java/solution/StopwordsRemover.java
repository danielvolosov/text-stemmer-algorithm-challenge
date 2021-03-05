package solution;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class StopwordsRemover {

    /**
     * Accepts paths for stopwords and text file, checks for stopwords in text file, removes them and returns
     * a collection of words that do not include stopwords.
     *
     * @param stopwordsPath
     * @param textFilePath
     * @return textFileSet
     */
    public static Set<String> removeStopwordsFromTextFile(Path stopwordsPath, Path textFilePath) {

        Set<String> stopwordsSet = new HashSet<>();
        Set<String> textFileSet = new HashSet<>();

        try (Stream<String> linesInStopwords = Files.lines(stopwordsPath)) {
            linesInStopwords.forEach(stopwordsLine -> {
                String[] stopwords = stopwordsLine.split(" ");

                for (String stopword : stopwords) {
                    stopwordsSet.add(stopword);
                }
            });
        } catch (IOException e) {
            System.out.println("Error: Cannot stream lines from stopwords file.");
        }

        try (Stream<String> linesInTextFile = Files.lines(textFilePath)) {
            linesInTextFile.forEach((textFileLine -> {

                String[] words = textFileLine.split(" ");

                for (String word : words) {
                    word = word.toLowerCase().replaceAll("[-+.^:;,?&\\s+]", "");

                    if (textFileSet.contains(word) == stopwordsSet.contains(word)) {
                        textFileSet.remove(word);
                    }

                    textFileSet.add(word);
                }
            }));
        } catch (IOException e) {
            System.out.println("Error: Unable to remove stopword(s).");
        }

        return textFileSet;
    }
}
