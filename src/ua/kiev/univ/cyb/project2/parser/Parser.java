package ua.kiev.univ.cyb.project2.parser;

import ua.kiev.univ.cyb.project2.text.PunctuationMark;
import ua.kiev.univ.cyb.project2.text.Sentence;
import ua.kiev.univ.cyb.project2.text.Symbol;
import ua.kiev.univ.cyb.project2.text.Word;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Parser can parse text and create list of sentences.
 * @author Anton Babak
 * @since 26.11.2015
 */
public class Parser {
    /**
     * Buffered reader for symbol-by-symbol reading.
     */
    private BufferedReader reader;

    /**
     * Create parser with file name and initialize input stream from this file.
     * @param fileName
     */
    public Parser (String fileName){
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(fileName)),
                                                              Charset.forName("Unicode")));
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    /**
     * Read and parse text for sentences with words and punctuation marks.
     * @return List of sentences in text.
     * @throws IOException
     */
    public List<Sentence> readAndParseText() throws IOException {
        List<Sentence> sentences = new ArrayList<>();
        StringBuilder futureWord = new StringBuilder();
        Sentence sentence = new Sentence(new ArrayList<>());
        int symbol = reader.read();
        while (symbol != -1){
            StringBuilder sb = new StringBuilder(new String(String.valueOf((char) symbol)));
            if (sb.toString().matches("\\s")){
                if (!futureWord.toString().isEmpty()) {
                    sentence.addPartOfSentence(new Word(futureWord.toString()));
                    futureWord = new StringBuilder();
                }
            }else if (Symbol.isMark((char) symbol)) {
                    if (!futureWord.toString().isEmpty()) {
                        sentence.addPartOfSentence(new Word(futureWord.toString()));
                    futureWord = new StringBuilder();
                    }
                    sentence.addPartOfSentence(new PunctuationMark(sb.toString()));
                    if (symbol == '.' || symbol == '!' || symbol == '?') {
                        sentences.add(sentence);
                        sentence = new Sentence(new ArrayList<>());
                    }
                }
            else{
                futureWord.append((char)symbol);
            }
            symbol = reader.read();
        }
        reader.close();
        return sentences;
    }

}
