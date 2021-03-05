package solution_tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import solution.StopwordsRemover;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class StopwordsRemoverTest {

    @Mock
    private StopwordsRemover stopwordsRemover;

    final Path testTextFile = Paths.get("/Users/danielvolosov/Developer/text-stemmer-algorithm-challenge/src/test/java/provided_test_files/Text1Test.txt");
    final Path testStopwordsFile = Paths.get("/Users/danielvolosov/Developer/text-stemmer-algorithm-challenge/src/test/java/provided_test_files/StopwordsTest.txt");


    @BeforeEach
    public void setUp() throws Exception {
        stopwordsRemover = new StopwordsRemover();
    }

    @Test
    @DisplayName("Stopwords are successfully removed")
    void testRemoveStopwordsFromTextFile() {
        Set<String> resultSet = new HashSet<>();
        resultSet.add("story");
        Mockito.when(stopwordsRemover.removeStopwordsFromTextFile(testStopwordsFile, testTextFile)).thenReturn(resultSet);
    }


}
