package ua.kiev.univ.cyb.project2;

import ua.kiev.univ.cyb.project2.parser.Parser;
import ua.kiev.univ.cyb.project2.text.Text;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Parser parser = new Parser("d:\\Downloads\\text.txt");
        Text text = new Text(parser.readAndParseText());
        text.deleteWordsWithFirstConsonantLetterByLength(4);
        System.out.println(text);
    }

}
