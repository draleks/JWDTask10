package by.drob.task10.data.parser;

import by.drob.task10.entity.Component;
import by.drob.task10.entity.Leaf;

import java.util.List;

public class SentenceParser extends AbstractParser {
    private static final String WORD_PATTERN = "\\S+";
    private static final String EXPRESSION_PATTERN = "[\\d_+*]+";

    public SentenceParser(Parser successor) {
        super(successor);
    }

    @Override
    protected void process(List<Component> children, String value) {
        if (EXPRESSION_PATTERN.matches(value)) {
            Leaf expression = Leaf.expression(value);
            children.add(expression);
        } else {
            Leaf word = Leaf.word(value);
            children.add(word);
        }
    }

    @Override
    protected String getPattern() {
        return WORD_PATTERN;
    }
}
