package by.drob.task10.data.parser;

import by.drob.task10.data.parser.ParagraphParser;
import by.drob.task10.data.parser.Parser;
import by.drob.task10.data.parser.SentenceParser;
import by.drob.task10.entity.Component;
import by.drob.task10.entity.Composite;
import by.drob.task10.entity.Leaf;
import by.drob.task10.logic.TextProcessor;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

public class ParagraphParserTest {
   private static final String TEXT = "Simple string! Simple string!";
    private static final Component EXAMPLE_SENTENCE = Leaf.word("Simple string!");
    private static final Component EXPECTED_COMPONENT = new Composite(Arrays.asList(EXAMPLE_SENTENCE, EXAMPLE_SENTENCE));

    @Test
    public void testParseShouldReturnCorrectComponentList() {
        Parser sentence = Mockito.mock(SentenceParser.class);
        ParagraphParser parser = new ParagraphParser(sentence);
        when(parser.parse(TEXT)).thenAnswer(invocation -> Leaf.word(((String) invocation.getArguments()[0])));
        Component actualComponent = parser.parse(TEXT);
      Assert.assertEquals(EXPECTED_COMPONENT, actualComponent);
    }
}
