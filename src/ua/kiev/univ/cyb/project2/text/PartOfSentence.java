package ua.kiev.univ.cyb.project2.text;
/**
 * Part of sentence is word or punctuation mark.
 * @author Anton Babak
 * @since 26.11.2015
 */
public abstract class PartOfSentence {
    /**
     * String presentation of word or punctuation mark.
     */
    protected String partOfSentence;

    /**
     * Check if part of sentence is punctuation mark.
     * @return true - part is mark, false - is not mark.
     */
    public boolean isMark(){
        for (Character mark: PunctuationMark.marks){
            if (this.partOfSentence.contains(mark.toString())){
                return true;
            }
        }
        return false;
    }

    public String getPartOfSentence() {
        return partOfSentence;
    }

    public void setPartOfSentence(String partOfSentence) {
        this.partOfSentence = partOfSentence;
    }
}
