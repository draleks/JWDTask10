package by.drob.task10.data.parser;

import by.drob.task10.data.parser.SentenceParser;
import by.drob.task10.entity.Component;
import by.drob.task10.entity.Leaf;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SentenceParserTest {
    private static final String TEXT = "Simple string!";
    private static final Component EXPECTED_LEAF = Leaf.word("Simple");

    @Test
    public void testParseShouldParseWhenDataValid() {
        SentenceParser parser = new SentenceParser(null);
        Component actualComponent = parser.parse(TEXT);
        List<Component> componentList = actualComponent.getChildren();
        Component actualLeaf = componentList.get(0);
        Assert.assertEquals(EXPECTED_LEAF, actualLeaf);
    }
}
