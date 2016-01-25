package ua.kiev.univ.cyb.project2.text;

import java.util.HashSet;
import java.util.Set;

/**
 * Word is part of sentence.
 * Class extends class <code>PartOfSentence</code>.
 * @author Anton Babak
 * @since 26.11.2015
 */
public class Word extends PartOfSentence {
    /**
     * Create word with string.
     * @param word String presentation.
     */
    public Word(String word) {
        this.partOfSentence = word;
    }

    /**
     * Set of vowels letters.
     */
    public static final Set<Character> vowels = new HashSet<>();

    /**
     * Initialization for vowels set.
     */
    static
    {
        vowels.add('a');
        vowels.add('o');
        vowels.add('y');
        vowels.add('u');
        vowels.add('i');
        vowels.add('e');
    }

}
