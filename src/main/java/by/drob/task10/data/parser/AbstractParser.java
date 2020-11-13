package by.drob.task10.data.parser;

import by.drob.task10.entity.Component;
import by.drob.task10.entity.Composite;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractParser implements Parser {
    private final Parser successor;

    public AbstractParser(Parser successor) {
        this.successor = successor;
    }

    public Component parse(String text) {
        Pattern pattern = Pattern.compile(getPattern());
        Matcher matcher = pattern.matcher(text);
        List<Component> childrenList = new ArrayList<>();
        while (matcher.find()) {
            String value = matcher.group();
            process(childrenList, value);
        }
        return new Composite(childrenList);
    }

    protected void process(List<Component> children, String value) {
        Component child = successor.parse(value);
        children.add(child);
    }

    protected abstract String getPattern();
}
