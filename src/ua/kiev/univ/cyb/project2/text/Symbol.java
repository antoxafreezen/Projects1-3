package ua.kiev.univ.cyb.project2.text;

/**
 * Utility class.
 * Class has different symbols checkers.
 * @author Anton Babak
 * @since 26.11.2015
 */
public class Symbol {
    /**
     * Check if symbol is punctuation mark.
     * @return true - part is mark, false - is not mark.
     */
    public static boolean isMark(char mark){
        return PunctuationMark.marks.contains(mark);
    }
    /**
     * Check if symbol is vowel letter.
     * @return true - part is mark, false - is not mark.
     */
    public static boolean isVowelLetter(char letter){
        return Word.vowels.contains(letter);
    }
}
