package com.example.demo;

import java.io.*;
import java.util.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.*;

public class CsvToXmlConverter {
    public static void main(String[] args) {
        String csvFilePath = "input.csv";
        String xmlFilePath = "output.xml";

        try {
            List<String[]> csvData = readCsvFile(csvFilePath);
            Document xmlDocument = convertCsvToXml(csvData);
            writeXmlFile(xmlDocument, xmlFilePath);
            System.out.println("Conversion successful!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<String[]> readCsvFile(String csvFilePath) throws Exception {
        List<String[]> csvData = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                csvData.add(row);
            }
        }

        return csvData;
    }

    private static Document convertCsvToXml(List<String[]> csvData) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document xmlDocument = builder.newDocument();

        Element rootElement = xmlDocument.createElement("Books");
        xmlDocument.appendChild(rootElement);

        for (String[] row : csvData) {
            Element recordElement = xmlDocument.createElement("Book");
            rootElement.appendChild(recordElement);

            String[] column = new String[]{"Title", "Author", "ISBN13", "Pages"};
            for (int i = 0; i < column.length; i++) {
                String columnName = column[i];
                Element columnElement = xmlDocument.createElement(columnName);
                columnElement.appendChild(xmlDocument.createTextNode(row[i]));
                recordElement.appendChild(columnElement);
            }
        }

        return xmlDocument;
    }

    private static void writeXmlFile(Document xmlDocument, String xmlFilePath) throws Exception {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

        DOMSource source = new DOMSource(xmlDocument);
        StreamResult result = new StreamResult(new File(xmlFilePath));
        transformer.transform(source, result);
    }
}