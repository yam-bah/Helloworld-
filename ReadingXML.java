
import javax.xml.parsers.DocumentBuilderFactory;
        import javax.xml.parsers.DocumentBuilder;
        import org.w3c.dom.Document;
        import org.w3c.dom.NodeList;
        import org.w3c.dom.Node;
        import org.w3c.dom.Element;
        import java.io.File;
        import java.io.*;
        import java.util.Base64;



public class ReadingXML {


    public static void main(String argv[]) {

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("what should  search for: ");

            String Search = reader.readLine();
            System.out.println("I will search for: " + Search);

            File fXmlFile = new File("C:\\Users\\pc\\Desktop\\ELGA-043-Laborbefund_EIS-FullSupport.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            //optional, but recommended
            //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();
            // creat a document object. return type is node list https://www.youtube.com/watch?v=HfGWVy-eMRc

            System.out.println("keine Ahnung :" );
           byte[] bytes = ("IMam").getBytes("UTF-8");
            System.out.println("bytes"+bytes);
            String encoded = Base64.getEncoder().encodeToString(bytes);
            System.out.println("encoded"+encoded);
            byte[] decoded = Base64.getDecoder().decode(encoded);
            System.out.println("decoded"+decoded);

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("ClinicalDocument");

            System.out.println("----------------------------");
// it will loop as much as the nodes we have
            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;
                  //  System.out.println("Test0"+eElement.getElementsByTagName(Search).item(0).getNodeName());
                   // System.out.println("Test1"+eElement.getElementsByTagName(Search).item(1).getNodeValue());

                    System.out.println("observationMedia1"+eElement.getElementsByTagName("observationMedia").item(1).getTextContent());
                    System.out.println("observationMedia2"+eElement.getElementsByTagName("observationMedia").item(0).getTextContent());
                    System.out.println("observationMedia3"+eElement.getElementsByTagName("participant").item(3).getTextContent());
                    System.out.println("participant"+eElement.getElementsByTagName("participant").item(0).getTextContent());

                   // System.out.println("Test3"+eElement.getElementsByTagName(Search).item(1).getChildNodes());
                    //System.out.println("Staff id : " + eElement.getAttribute(Search));
                    //System.out.println("First Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
                    //System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
                    //System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
                    //System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}