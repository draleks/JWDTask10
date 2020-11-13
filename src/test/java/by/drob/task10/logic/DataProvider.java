package by.drob.task10.logic;

import by.drob.task10.entity.Component;
import by.drob.task10.entity.Composite;
import by.drob.task10.entity.Leaf;

import java.util.Arrays;
import java.util.Collections;

// package access for provide data only this package
 class DataProvider {
    private static final Leaf FIRST_LEAF = Leaf.word("String ");
    private static final Leaf SECOND_LEAF = Leaf.word("test. ");
    private static final Leaf THIRD_LEAF = Leaf.word("Test! ");
    private static final Leaf FORTH_LEAF = Leaf.word("Long ");
    private static final Leaf FIFTH_LEAF = Leaf.word("sentence.");

    public static Component getUnsortedText() {
        Component firstSentence = new Composite(Arrays.asList(FIRST_LEAF, SECOND_LEAF));
        Component secondSentence = new Composite(Collections.singletonList(THIRD_LEAF));
        Component thirdSentence = new Composite(Arrays.asList(FORTH_LEAF, FIFTH_LEAF));
        Component firstParagraph = new Composite(Arrays.asList(firstSentence,secondSentence));
        Component secondParagraph = new Composite(Collections.singletonList(thirdSentence));
        return new Composite(Arrays.asList(firstParagraph,secondParagraph));
    }

    public static Component getSortedTextByParagraphs() {
        Component firstSentence = new Composite(Arrays.asList(FIRST_LEAF, SECOND_LEAF));
        Component secondSentence = new Composite(Collections.singletonList(THIRD_LEAF));
        Component thirdSentence = new Composite(Arrays.asList(FORTH_LEAF, FIFTH_LEAF));
        Component firstParagraph = new Composite(Arrays.asList(firstSentence,secondSentence));
        Component secondParagraph = new Composite(Collections.singletonList(thirdSentence));
        return new Composite(Arrays.asList(secondParagraph,firstParagraph));
    }

    public static Component getSortedTextByWords() {
        Component firstSentence = new Composite(Arrays.asList( SECOND_LEAF,FIRST_LEAF));
        Component secondSentence = new Composite(Collections.singletonList(THIRD_LEAF));
        Component thirdSentence = new Composite(Arrays.asList(FORTH_LEAF, FIFTH_LEAF));
        Component firstParagraph = new Composite(Arrays.asList(firstSentence,secondSentence));
        Component secondParagraph = new Composite(Collections.singletonList(thirdSentence));
        return new Composite(Arrays.asList(firstParagraph,secondParagraph));
    }

}
