package by.drob.task10.logic;

import by.drob.task10.entity.Component;
import org.junit.Assert;
import org.junit.Test;

public class TextProcessorTest {
    private static final TextProcessor processor = new TextProcessor();

    @Test
    public void testRestoreTextShouldRestoreText() {
        final String expectedText = "String test. Test! \nLong sentence.";
        Component actualComponent = DataProvider.getUnsortedText();
        String actualText = processor.restoreText(actualComponent);
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void testSortParagraphsShouldReturnSortedText() {
        Component actualComponent = DataProvider.getUnsortedText();
        Component actualSortedComponent =
                processor.sortParagraphsBySentenceLength(actualComponent);
        Component expectedSortedText = DataProvider.getSortedTextByParagraphs();
        Assert.assertEquals(expectedSortedText, actualSortedComponent);
    }

    @Test
    public void testSortWordsShouldReturnSortedText() {
        Component actualComponent = DataProvider.getUnsortedText();
        Component actualSortedComponent =
                processor.sortWordsByLength(actualComponent);
        Component expectedSortedText = DataProvider.getSortedTextByWords();
        Assert.assertEquals(expectedSortedText, actualSortedComponent);
    }
}



