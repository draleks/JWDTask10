package by.drob.task10.data;

import by.drob.task10.data.DataReader;
import by.drob.task10.exception.DataException;
import org.junit.Assert;
import org.junit.Test;

public class DataReaderTest {
    private static final String VALID_FILE_PATH = "src/test/resources/testFile.txt";
    private static final String INVALID_FILE_PATH = "src/test/resources/invalidFile.txt";
    private static final String EXPECTED_TEXT = "Test file. first string.\n" + "Second string.\n";
   private static final DataReader dataReader = new DataReader();
    @Test
    public void testReadShouldCorrectReadTextFromFileWhenFileExists() throws DataException {

        String actualText = dataReader.read(VALID_FILE_PATH);
        Assert.assertEquals(EXPECTED_TEXT, actualText);
    }

    @Test(expected = DataException.class)
    public void testReadShouldThrowDataExceptionWhenFileNotExists() throws DataException {
        dataReader.read(INVALID_FILE_PATH);
    }
}
