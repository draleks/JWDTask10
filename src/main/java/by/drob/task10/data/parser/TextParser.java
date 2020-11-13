package by.drob.task10.data.parser;

public class TextParser extends AbstractParser {
    private static final String PARAGRAPH_PATTERN_REGEX = ".+";

    public TextParser(Parser successor) {
        super(successor);
    }

    @Override
    protected String getPattern() {
        return PARAGRAPH_PATTERN_REGEX;
    }
}
