package by.drob.task10.logic.expression;

import java.util.ArrayDeque;
import java.util.Deque;

public class Context {
    private final Deque<Integer> contextValues = new ArrayDeque<>();

    public Integer popValue() {
        return contextValues.pop();
    }

    public void pushValue(Integer value) {
        contextValues.push(value);
    }
}
