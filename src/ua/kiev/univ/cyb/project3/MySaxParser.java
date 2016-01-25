package ua.kiev.univ.cyb.project3;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Class implements SAX parser for xml file
 */
public class MySaxParser extends DefaultHandler {
    /**
     * Tourist vouchers.
     */
    Vouchers vouchers = new Vouchers();
    /**
     * One voucher from vouchers.
     */
    Vouchers.Voucher voucher;
    /**
     * Tag's number in xml file
     */
    int current = 0;
    public MySaxParser(){

    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start parsing...");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End parsing.");
    }

    @Override
    public void endElement(String s, String s1, String s2) throws SAXException {
        switch(s2){
            case "v:voucher":{
                vouchers.voucher.add(this.voucher);
            }
        }
        current = 0;
    }

    @Override
    public void startElement(String s, String s1, String s2, Attributes attributes) throws SAXException {
        switch(s2){
            case "v:vouchers": current = 1; break;
            case "v:voucher": {
                current = 2;
                voucher = new Vouchers.Voucher();
                voucher.id = attributes.getValue(0);
                break;
            }
            case "v:type":{
                current = 3;
                break;
            }
            case "v:country": current = 4; break;
            case "v:duration": {
                current = 5;
                voucher.duration = new DurationType();
                break;
            }
            case "v:days": current = 6; break;
            case "v:nights": current = 7; break;
            case "v:transport": current = 8; break;
            case "v:hotel":{
                current = 9;
                voucher.hotel = new TypeHotels();
                break;
            }
            case "hotels:stars": current = 10; break;
            case "hotels:food": current = 11; break;
            case "hotels:foodType": current = 12; break;
            case "hotels:room": current = 13; break;
            case "hotels:tv": current = 14; break;
            case "hotels:conditioner": current = 15; break;
            case "v:cost": current = 16; break;
        }
    }

    @Override
    public void characters(char[] chars, int i, int i1) throws SAXException {
        String text = new String(chars, i, i1);
        switch (current) {
            case 3:{
                voucher.type = text;
                current = 0;
                break;
            }
            case 4:{
                voucher.country = text;
                current = 0;
                break;
            }
            case 6: {
                voucher.duration.days = Integer.valueOf(text);
                current = 0;
                break;
            }
            case 7: {
                voucher.duration.nights = Integer.valueOf(text);
                current = 0;
                break;
            }
            case 8: {
                voucher.transport = text;
                current = 0;
                break;
            }
            case 10: {
                voucher.hotel.stars = Integer.valueOf(text);
                current = 0;
                break;
            }
            case 11: {
                voucher.hotel.food = TypeYesNo.fromValue(text);
                current = 0;
                break;
            }
            case 12: {
                voucher.hotel.foodType = text;
                current = 0;
                break;
            }
            case 13: {
                voucher.hotel.room = Integer.valueOf(text);
                current = 0;
                break;
            }
            case 14: {
                voucher.hotel.tv = TypeYesNo.fromValue(text);
                current = 0;
                break;
            }
            case 15: {
                voucher.hotel.conditioner = TypeYesNo.fromValue(text);
                current = 0;
                break;
            }
            case 16: {
                voucher.cost = Integer.valueOf(text);
                break;
            }
        }
    }

    /**
     * @return list of vouchers
     */
    public Vouchers getList(){
        return vouchers;
    }

    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException{
        SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
        MySaxParser par = new MySaxParser();
        parser.parse("vouchers.xml", par);
        Vouchers list = par.getList();

        for(Vouchers.Voucher temp: list.getVoucher()){
            System.out.println(temp.transport);
        }
    }
}
