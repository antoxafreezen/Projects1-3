package ua.kiev.univ.cyb.project2.text;

import java.util.List;
import java.util.ListIterator;

/**
 * Sentence consists of parts - words or punctuation marks.
 * @author Anton Babak
 * @since 26.11.2015
 */
public class Sentence {
    /**
     * List of sentence.
     */
    private List<PartOfSentence> parts;

    /**
     * Create sentence with parts.
     * @param parts List of sentence parts.
     */
    public Sentence(List<PartOfSentence> parts) {
        this.parts = parts;
    }

    @Override
    public String toString() {
        String sentence = "";
        for (PartOfSentence part: parts){
            sentence += part.getPartOfSentence() + " ";
        }
        return sentence;
    }

    /**
     * Add word or punctuation mark to list of sentence parts.
     * @param part Word or punctuation mark.
     */
    public void addPartOfSentence(PartOfSentence part){
        parts.add(part);
    }

    /**
     * Delete words in sentence which have preset length and begin with consonant letter.
     * @param length Length of words.
     */
    public void deleteWordsWithFirstConsonant(int length){
        ListIterator<PartOfSentence> iterator = parts.listIterator();
        while (iterator.hasNext()){
            PartOfSentence part = iterator.next();
            if (!part.isMark()){
                String word = part.getPartOfSentence();
                char firstLetter = word.charAt(0);
                if (word.length() == length && !Symbol.isVowelLetter(firstLetter)){
                    iterator.remove();
                }
            }
        }
    }

}
