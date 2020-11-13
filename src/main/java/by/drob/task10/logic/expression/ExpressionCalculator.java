package by.drob.task10.logic.expression;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExpressionCalculator {
    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char MULTIPLY = '*';
    private static final char DIVIDE = '/';
    private static final int FIRST_CHAR = 0;
    private static final String SPLITTER = "_";

    public int interpretExpression(String expression) {
        List<MathExpression> mathExpressionList = parse(expression);
        Context context = new Context();
        for (MathExpression terminal : mathExpressionList) {
            terminal.interpret(context);
        }
        return context.popValue();
    }

    private List<MathExpression> parse(String expression) {
        List<MathExpression> mathExpressions = new ArrayList<>();
        String[] expressions = expression.split(SPLITTER);
        for (String lexeme : expressions) {
            if (lexeme.isEmpty()) {
                continue;
            }
            char temp = lexeme.charAt(FIRST_CHAR);
            switch (temp) {
                case PLUS:
                    mathExpressions.add(new TerminalExpressionPlus());
                    break;
                case MINUS:
                    mathExpressions.add(new TerminalExpressionMinus());
                    break;
                case MULTIPLY:
                    mathExpressions.add(new TerminalExpressionMultiply());
                    break;
                case DIVIDE:
                    mathExpressions.add(new TerminalExpressionDivide());
                    break;
                default:
                    Scanner scanner = new Scanner(lexeme);
                    if (scanner.hasNextInt()) {
                        int number = scanner.nextInt();
                        mathExpressions.add(new NonTerminalExpressionNumber(number));
                    }
            }
        }
        return mathExpressions;
    }
}
