package ua.kiev.univ.cyb.project2.text;

import java.util.HashSet;
import java.util.Set;

/**
 * Punctuation mark is part of sentence.
 * Class extends class <code>PartOfSentence</code>.
 * @author Anton Babak
 * @since 26.11.2015
 */
public class PunctuationMark extends PartOfSentence {
    /**
     * Set of punctuation marks.
     */
    public static final Set<Character> marks = new HashSet<>();
    /**
     * Initialization for marks set.
     */
    static
    {
        marks.add('.');
        marks.add(',');
        marks.add('!');
        marks.add('?');
        marks.add(':');
    }
    /**
     * Create mark with string.
     * @param mark String presentation.
     */
    public PunctuationMark(String mark) {
        this.partOfSentence = mark;
    }


}
