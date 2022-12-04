package com.techorzo.kwality.kitchen.misc;


import org.springframework.util.ResourceUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.Objects;

/*
Note: Valid only for this project, do not import it to other projects without making significant changes
 */
public class XmlParser {
    public String getStringByID(String id) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();


        try {
            File file = ResourceUtils.getFile("classpath:strings.xml");
            System.out.println("Resource Path :: " + file.getPath());

            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc = db.parse(file);

            doc.getDocumentElement().normalize();

            NodeList list = doc.getElementsByTagName("string");

            for(int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);

                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    NodeList name_list = element.getElementsByTagName("name");

                    for(int j = 0; j < name_list.getLength(); j++) {
                        Node node1 = name_list.item(j);
                        if(Objects.equals(id, ((Element) node1).getAttribute("id"))) {
                            return node1.getTextContent();
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "<N/A>";
    }

}
