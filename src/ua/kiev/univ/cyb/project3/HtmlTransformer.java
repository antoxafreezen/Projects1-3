package ua.kiev.univ.cyb.project3;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * Class that implements xml file to html.
 */
public class HtmlTransformer {
    public static void main(String[] args) {
        try {
            TransformerFactory tFact =
                    TransformerFactory.newInstance();
            Transformer transformer = tFact.newTransformer(
                    new StreamSource("vouchers.xsl"));
            transformer.transform(
                    new StreamSource("vouchers.xml"),
                    new StreamResult("vouchers.html"));
        } catch (TransformerException e){
            e.printStackTrace();
        }
    }
}
