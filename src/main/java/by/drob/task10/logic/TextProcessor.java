package by.drob.task10.logic;

import by.drob.task10.entity.Component;
import by.drob.task10.entity.Composite;
import by.drob.task10.entity.Leaf;
import by.drob.task10.entity.LeafType;
import by.drob.task10.logic.expression.ExpressionCalculator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TextProcessor {
    private static final char NEW_LINE = '\n';
    private static final String EXPRESSION_SEPARATOR = " ";
    private static final ExpressionCalculator expressionCalculator = new ExpressionCalculator();

    public Component calculateExpression(Component component) {
        List<Component> childrenList = component.getChildren();
        if (childrenList.isEmpty()) {
            Leaf leaf = (Leaf) component;
            return manipulateLeaf(leaf);
        }

        List<Component> resolvedComponents = new ArrayList<>();
        for (Component child : childrenList) {
            Component childResolved = calculateExpression(child);
            resolvedComponents.add(childResolved);
        }
        return new Composite(resolvedComponents);
    }

    private Leaf manipulateLeaf(Leaf leaf) {
        LeafType leafType = leaf.getLeafType();
        if (leafType != LeafType.EXPRESSION) {
            return leaf;
        }
        String value = leaf.getValue();
        int result = expressionCalculator.interpretExpression(value);
        String stringResult = Integer.toString(result);
        return Leaf.word(stringResult + EXPRESSION_SEPARATOR);
    }

    public String restoreText(Component root) {
        StringBuilder text = new StringBuilder();
        for (Component paragraph : root.getChildren()) {
            for (Component sentence : paragraph.getChildren()) {
                for (Component lexeme : sentence.getChildren()) {
                    String lexemeValue = ((Leaf) lexeme).getValue();
                    text.append(lexemeValue);
                }
            }
            text.append(NEW_LINE);
        }
        return text.toString().trim();
    }

    public Component sortParagraphsBySentenceLength(Component text) {
        List<Component> paragraphsList = new ArrayList<>(text.getChildren());
        Comparator<Component> comparator =
                Comparator.comparingInt(sortedParagraph -> sortedParagraph.getChildren().size());
        paragraphsList.sort(comparator);
        return new Composite(paragraphsList);
    }

    public Component sortWordsByLength(Component text) {
        List<Component> paragraphsList = new ArrayList<>();
        for (Component paragraph : text.getChildren()) {
            List<Component> sentencesList = new ArrayList<>();
            for (Component sentence : paragraph.getChildren()) {
                List<Component> lexemesList = new ArrayList<>(sentence.getChildren());
                sortLexemes(lexemesList);
                sentencesList.add(new Composite(lexemesList));
            }
            paragraphsList.add(new Composite(sentencesList));
        }
        return new Composite(paragraphsList);
    }

    private void sortLexemes(List<Component> lexemesList) {
        lexemesList.sort(Comparator.comparingInt(lexeme -> {
            String lexemeValue = ((Leaf) lexeme).getValue();
            return lexemeValue.length();
        }));
    }
}
