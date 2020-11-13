package by.drob.task10.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Leaf implements Component {
    private String value;
    private LeafType leafType;

    private Leaf(String value, LeafType leafType) {
        this.value = value;
        this.leafType = leafType;
    }

    public static Leaf word(String value) {
        return new Leaf(value, LeafType.WORD);
    }

    public static Leaf expression(String value) {
        return new Leaf(value, LeafType.EXPRESSION);
    }

    @Override
    public List<Component> getChildren() {
        return new ArrayList<>();
    }

    public String getValue() {
        return value;
    }

    public LeafType getLeafType() {
        return leafType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Leaf leaf = (Leaf) o;
        return Objects.equals(value, leaf.value) &&
                leafType == leaf.leafType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, leafType);
    }
}
