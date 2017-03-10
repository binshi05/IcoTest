package test;

import wsdl.DataUploadWebService;
import wsdl.DataUploadWebServiceSoap;

/**
 * Created by shibin on 2017/1/12.
 */
public class WsdlTest {
    public static void main(String[] args) {
        DataUploadWebService dataUploadWebService = new DataUploadWebService();
        DataUploadWebServiceSoap dataUploadWebServiceSoap = dataUploadWebService.getDataUploadWebServiceSoap();
        dataUploadWebServiceSoap.saleAdd("", "");
    }
}