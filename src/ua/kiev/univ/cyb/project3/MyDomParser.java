package ua.kiev.univ.cyb.project3;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import java.io.IOException;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.Namespace;
import org.jdom2.input.DOMBuilder;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXParseException;

/**
 * Catch warning and error in xml file.
 */
class MyErrorHandler implements ErrorHandler {
    boolean flag=true;

    /**
     * Catch warnings.
     * @param e exception
     */
    public void warning(SAXParseException e) {
        System.err.println("warning: " + getLineAddress(e) +
                " - " + e.getMessage());
    }
    /**
     * Catch errors.
     * @param e exception
     */
    public void error(SAXParseException e) {
        flag=false;
        System.err.println((getLineAddress(e) +
                " - " + e.getMessage()));
    }
    /**
     * Catch fatal errors.
     * @param e exception
     */
    public void fatalError(SAXParseException e) {
        flag=false;
        System.err.println(getLineAddress(e) +
                " - " + e.getMessage());
    }

    /**
     * Show error's place.
     * @param e cought exception
     * @return error's place in xml file
     */
    private String getLineAddress(SAXParseException e) {
        return e.getLineNumber() + " : " + e.getColumnNumber();
    }
}

/**
 * Class implements DOM parser for xml file
 */
public class MyDomParser {
    /**
     * Tourist vouchers.
     */
    Vouchers vouchers = new Vouchers();

    public MyDomParser(){

    }

    /**
     * Main parsing method.
     * @param fileName path to xml file
     * @return list of vouchers
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     */
    public Vouchers parsing(String fileName) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        factory.setNamespaceAware(true);

        DocumentBuilder dombuilder = factory.newDocumentBuilder();

        org.w3c.dom.Document w3cDocument = dombuilder.parse(fileName);

        DOMBuilder jdomBuilder = new DOMBuilder();

        Document jdomDocument = jdomBuilder.build(w3cDocument);

        Element root = jdomDocument.getRootElement();


        List<Element> listVouchers = root.getChildren("voucher", Namespace.getNamespace("http://ccc.com/Purchase"));
        System.out.println(listVouchers.size());
        for (Element temp : listVouchers) {
            Vouchers.Voucher voucher = new Vouchers.Voucher();
            voucher.id = temp.getAttributeValue("id");
            voucher.type = temp.getChildText("type", Namespace.getNamespace("http://ccc.com/Purchase"));
            voucher.country = temp.getChildText("country", Namespace.getNamespace("http://ccc.com/Purchase"));
            Element duration = temp.getChild("duration", Namespace.getNamespace("http://ccc.com/Purchase"));
            int days = Integer.valueOf(duration.getChildText("days", Namespace.getNamespace("http://ccc.com/Purchase")));
            int nights = Integer.valueOf(duration.getChildText("nights", Namespace.getNamespace("http://ccc.com/Purchase")));
            voucher.duration = new DurationType();
            voucher.duration.days = days;
            voucher.duration.nights = nights;
            voucher.transport = temp.getChildText("transport", Namespace.getNamespace("http://ccc.com/Purchase"));
            Element hotel = temp.getChild("hotel", Namespace.getNamespace("http://ccc.com/Purchase"));
            voucher.hotel = new TypeHotels();
            String stars = hotel.getChildText("stars", Namespace.getNamespace("http://aaa.com/Purchase"));
            String food = hotel.getChildText("food", Namespace.getNamespace("http://aaa.com/Purchase"));
            String foodType = hotel.getChildText("foodType", Namespace.getNamespace("http://aaa.com/Purchase"));
            String room = hotel.getChildText("room", Namespace.getNamespace("http://aaa.com/Purchase"));
            String tv = hotel.getChildText("tv", Namespace.getNamespace("http://aaa.com/Purchase"));
            String conditioner = hotel.getChildText("conditioner", Namespace.getNamespace("http://aaa.com/Purchase"));
            voucher.hotel.stars = Integer.valueOf(stars);
            voucher.hotel.food = TypeYesNo.fromValue(food);
            voucher.hotel.foodType = foodType;
            voucher.hotel.room = Integer.valueOf(room);
            voucher.hotel.tv = TypeYesNo.fromValue(tv);
            voucher.hotel.conditioner = TypeYesNo.fromValue(conditioner);
            voucher.cost = Integer.valueOf(temp.getChildText("cost", Namespace.getNamespace("http://ccc.com/Purchase")));
            vouchers.voucher.add(voucher);
        }
        return vouchers;
    }

    /**
     * Check validation of xml file by corresponding xsd file
     * @param xmlFile
     * @param xsdFile
     * @return <code>false</code> if xml file is invalid
     * @throws SAXException
     * @throws IOException
     */
    public boolean validation(String xmlFile,String xsdFile) throws SAXException, IOException{
        DOMParser parser = new DOMParser();
        MyErrorHandler handler=new MyErrorHandler();
        try {

            parser.setErrorHandler(handler);
            parser.setFeature(
                    "http://xml.org/sax/features/validation", true);
            parser.setFeature(
                    "http://apache.org/xml/features/validation/schema",true);
            parser.setFeature(
                    "http://apache.org/xml/features/validation/schema-full-checking",
                    true);
            parser.setProperty(
                    "http://apache.org/xml/properties/schema/external-schemaLocation", xsdFile);

            parser.parse(xmlFile);

        } catch (SAXNotRecognizedException e) {
            e.printStackTrace();

        }
        return handler.flag;
    }
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        MyDomParser par = new MyDomParser();
        Vouchers listVouchers = par.parsing("vouchers.xml");

        for(Vouchers.Voucher voucher: listVouchers.getVoucher()) {
            System.out.println(voucher.hotel.tv);
        }
        System.out.println(par.validation("vouchers.xml", "vouchers.xsd"));

    }
}
