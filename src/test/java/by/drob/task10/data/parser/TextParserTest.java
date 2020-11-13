package by.drob.task10.data.parser;

import by.drob.task10.data.parser.ParagraphParser;
import by.drob.task10.data.parser.Parser;
import by.drob.task10.data.parser.TextParser;
import by.drob.task10.entity.Component;
import by.drob.task10.entity.Composite;
import by.drob.task10.entity.Leaf;
import by.drob.task10.logic.TextProcessor;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.mockito.Mockito.when;

public class TextParserTest {
    private static final Component PARAGRAPH = Leaf.word("Test string.");
    private static final Component EXPECTED_COMPONENT = new Composite(Arrays.asList(PARAGRAPH, PARAGRAPH));
    private static final String TEXT = "Test string.\n" +"Test string.";

    @Test
    public void testParseShouldReturnCorrectComponentWhenTextValid() {
        Parser paragraph = Mockito.mock(ParagraphParser.class);
        TextParser textParser = new TextParser(paragraph);
        when(textParser.parse(TEXT)).thenAnswer(invocation -> Leaf.word(((String) invocation.getArguments()[0])));
        Component actualComponent = textParser.parse(TEXT);
        Assert.assertEquals(EXPECTED_COMPONENT, actualComponent);
    }
}
