package test;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by shibin on 2017/1/12.
 */
public class CommonWsdl {
    public static void main(String[] args) throws Exception {
        String soapRequestData = ""
                + "<?xml version=\"1.0\" encoding=\"utf-8\"?>"
                + "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\">"
                + "  <soap:Body>"
                + "   <qqCheckOnline xmlns=\"http://WebXml.com.cn/\">"
                + "    <qqCode>396738007</qqCode>"
                + "   </qqCheckOnline>"
                + "  </soap:Body>"
                + "</soap:Envelope>";

        URL u = new URL("http://webservice.webxml.com.cn/webservices/qqOnlineWebService.asmx?wsdl");
        URLConnection uc = u.openConnection();
        uc.setDoOutput(true);
        uc.setRequestProperty("Content-Type","application/soap+xml; charset=utf-8");
        PrintWriter pw = new PrintWriter(uc.getOutputStream());
        pw.println(soapRequestData);
        pw.close();

        DocumentBuilderFactory bf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = bf.newDocumentBuilder();
        Document document = db.parse(uc.getInputStream());

        String res = document.getElementsByTagName("qqCheckOnlineResponse").item(0).getTextContent();

        System.out.println(res);
    }
}
