package parser.xml.application.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.*;

public class ParserService {
//    private final Logger logger = LoggerFactory.getLogger(ParserService.class);

    public String deparseXML() throws IOException, XMLStreamException {
        File file = new File("E:\\FACULTATE\\SBC\\baza_cunostinte_xml.xml");
        XMLInputFactory f = XMLInputFactory.newFactory();
        XMLStreamReader sr = f.createXMLStreamReader(new FileInputStream(file));
        ObjectMapper mapper = new XmlMapper();
        try {
            return inputStreamToString(new FileInputStream(file));
        } catch (FileNotFoundException e) {
//            logger.error("Error: {} ", e.getMessage());
        }

        return "";

    }

    public String inputStreamToString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }
}


