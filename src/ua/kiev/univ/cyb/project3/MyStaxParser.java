package ua.kiev.univ.cyb.project3;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;

/**
 * Class implements StAX parser for xml file
 */
public class MyStaxParser {
    /**
     * Tourist vouchers.
     */
    Vouchers vouchers = new Vouchers();
    public MyStaxParser(){}
    /**
     * One voucher from vouchers.
     */
    Vouchers.Voucher voucher;

    public Vouchers parsing(String filename) throws FileNotFoundException, XMLStreamException {
        boolean bType = false;
        boolean bCountry = false;
        boolean bDays = false;
        boolean bNights = false;
        boolean bTransport = false;
        boolean bStars = false;
        boolean bFood = false;
        boolean bFoodType = false;
        boolean bRoom = false;
        boolean bTV = false;
        boolean bConditioner = false;
        boolean bCost = false;
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLEventReader eventReader =
                factory.createXMLEventReader(
                        new FileReader(filename));
        while (eventReader.hasNext()) {
            XMLEvent event = eventReader.nextEvent();
            switch (event.getEventType()) {
                case XMLStreamConstants.START_ELEMENT: {
                    StartElement startElement = event.asStartElement();
                    String qName = startElement.getName().getLocalPart();
                    if (qName.equalsIgnoreCase("voucher")) {
                        Iterator<Attribute> attributes = startElement.getAttributes();
                        voucher = new Vouchers.Voucher();
                        voucher.id = attributes.next().getValue();
                    } else if (qName.equalsIgnoreCase("type")) {
                        bType = true;
                    } else if (qName.equalsIgnoreCase("country")) {
                        bCountry = true;
                    } else if (qName.equalsIgnoreCase("duration")) {
                        voucher.duration = new DurationType();
                    } else if (qName.equalsIgnoreCase("days")) {
                        bDays = true;
                    } else if (qName.equalsIgnoreCase("nights")) {
                        bNights = true;
                    } else if (qName.equalsIgnoreCase("transport")) {
                        bTransport = true;
                    } else if (qName.equalsIgnoreCase("hotel")) {
                        voucher.hotel = new TypeHotels();
                    } else if (qName.equalsIgnoreCase("stars")) {
                        bStars = true;
                    } else if (qName.equalsIgnoreCase("food")) {
                        bFood = true;
                    } else if (qName.equalsIgnoreCase("foodType")) {
                        bFoodType = true;
                    } else if (qName.equalsIgnoreCase("room")) {
                        bRoom = true;
                    } else if (qName.equalsIgnoreCase("tv")) {
                        bTV = true;
                    } else if (qName.equalsIgnoreCase("conditioner")) {
                        bConditioner = true;
                    } else if (qName.equalsIgnoreCase("cost")) {
                        bCost = true;
                    }
                    break;
                }
                case XMLStreamConstants.CHARACTERS: {
                    Characters characters = event.asCharacters();
                    if (bType) {
                        voucher.type = characters.getData();
                        bType = false;
                    }
                    if (bCountry) {
                        voucher.country = characters.getData();
                        bCountry = false;
                    }
                    if (bDays) {
                        voucher.duration.days = Integer.valueOf(characters.getData());
                        bDays = false;
                    }
                    if (bNights) {
                        voucher.duration.nights = Integer.valueOf(characters.getData());
                        bNights = false;
                    }
                    if (bTransport) {
                        voucher.transport = characters.getData();
                        bTransport = false;
                    }
                    if (bStars) {
                        voucher.hotel.stars = Integer.valueOf(characters.getData());
                        bStars = false;
                    }
                    if (bFood) {
                        voucher.hotel.food = TypeYesNo.fromValue(characters.getData());
                        bFood = false;
                    }
                    if (bFoodType) {
                        voucher.hotel.foodType = characters.getData();
                        bFoodType = false;
                    }
                    if (bRoom) {
                        voucher.hotel.room = Integer.valueOf(characters.getData());
                        bRoom = false;
                    }
                    if (bTV) {
                        voucher.hotel.tv = TypeYesNo.fromValue(characters.getData());
                        bTV = false;
                    }
                    if (bConditioner) {
                        voucher.hotel.conditioner = TypeYesNo.fromValue(characters.getData());
                        bConditioner = false;
                    }
                    if (bCost) {
                        voucher.cost = Integer.valueOf(characters.getData());
                        bCost = false;
                    }
                    break;
                }
                case XMLStreamConstants.END_ELEMENT: {
                    EndElement endElement = event.asEndElement();
                    if (endElement.getName().getLocalPart().equalsIgnoreCase("voucher")) {
                        vouchers.voucher.add(voucher);
                    }
                    break;
                }
            }
        }
        return vouchers;
    }

    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
        MyStaxParser parser = new MyStaxParser();
        Vouchers listVouchers = parser.parsing("vouchers.xml");
        for(Vouchers.Voucher voucher: listVouchers.getVoucher()){
            System.out.println(voucher.transport);
        }
    }
}
