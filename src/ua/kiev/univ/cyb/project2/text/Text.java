package ua.kiev.univ.cyb.project2.text;

import java.util.ArrayList;
import java.util.List;

/**
 * Text consists of sentences.
 * @author Anton Babak
 * @since 26.11.2015
 */
public class Text {
    /**
     * List of sentences in the text.
     */
    List<Sentence> text = new ArrayList<>();

    public List<Sentence> getText() {
        return text;
    }

    public void setText(List<Sentence> text) {
        this.text = text;
    }

    /**
     * Create text with sentences.
     * @param text List of sentences.
     */
    public Text(List<Sentence> text) {
        this.text = text;
    }

    @Override
    public String toString() {
        String out = "";
        for (Sentence sentence: text){
            out += sentence.toString();
        }
        return out;
    }

    /**
     * Delete words in text which have preset length and begin with consonant letter.
     * @param length Length of words.
     */
    public void deleteWordsWithFirstConsonantLetterByLength(int length){
        for (Sentence sentence: text){
            sentence.deleteWordsWithFirstConsonant(length);
        }
    }
}
