
package proxy;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import jakarta.xml.ws.Service;
import jakarta.xml.ws.WebEndpoint;
import jakarta.xml.ws.WebServiceClient;
import jakarta.xml.ws.WebServiceException;
import jakarta.xml.ws.WebServiceFeature;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.3
 * Generated source version: 3.0
 * 
 */
@WebServiceClient(name = "BanqueWS ", targetNamespace = "http://ws/", wsdlLocation = "http://localhost:9191/?wsdl")
public class BanqueWS_0020
    extends Service
{

    private static final URL BANQUEWS_0020_WSDL_LOCATION;
    private static final WebServiceException BANQUEWS_0020_EXCEPTION;
    private static final QName BANQUEWS_0020_QNAME = new QName("http://ws/", "BanqueWS ");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:9191/?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        BANQUEWS_0020_WSDL_LOCATION = url;
        BANQUEWS_0020_EXCEPTION = e;
    }

    public BanqueWS_0020() {
        super(__getWsdlLocation(), BANQUEWS_0020_QNAME);
    }

    public BanqueWS_0020(WebServiceFeature... features) {
        super(__getWsdlLocation(), BANQUEWS_0020_QNAME, features);
    }

    public BanqueWS_0020(URL wsdlLocation) {
        super(wsdlLocation, BANQUEWS_0020_QNAME);
    }

    public BanqueWS_0020(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, BANQUEWS_0020_QNAME, features);
    }

    public BanqueWS_0020(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public BanqueWS_0020(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns BanqueService
     */
    @WebEndpoint(name = "BanqueServicePort")
    public BanqueService getBanqueServicePort() {
        return super.getPort(new QName("http://ws/", "BanqueServicePort"), BanqueService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns BanqueService
     */
    @WebEndpoint(name = "BanqueServicePort")
    public BanqueService getBanqueServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws/", "BanqueServicePort"), BanqueService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (BANQUEWS_0020_EXCEPTION!= null) {
            throw BANQUEWS_0020_EXCEPTION;
        }
        return BANQUEWS_0020_WSDL_LOCATION;
    }

}
