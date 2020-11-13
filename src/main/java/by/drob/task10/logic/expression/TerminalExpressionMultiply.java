package by.drob.task10.logic.expression;

public class TerminalExpressionMultiply implements MathExpression {

    @Override
    public void interpret(Context context) {
        int firstNumber = context.popValue();
        int secondNumber = context.popValue();
        context.pushValue(firstNumber * secondNumber);
    }
}
