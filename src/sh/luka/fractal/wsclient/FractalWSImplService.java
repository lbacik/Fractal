
package sh.luka.fractal.wsclient;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "FractalWSImplService", targetNamespace = "http://ws.fractal.luka.sh/", wsdlLocation = "http://localhost:9898/fractal?wsdl")
public class FractalWSImplService
    extends Service
{

    private final static URL FRACTALWSIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException FRACTALWSIMPLSERVICE_EXCEPTION;
    private final static QName FRACTALWSIMPLSERVICE_QNAME = new QName("http://ws.fractal.luka.sh/", "FractalWSImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:9898/fractal?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        FRACTALWSIMPLSERVICE_WSDL_LOCATION = url;
        FRACTALWSIMPLSERVICE_EXCEPTION = e;
    }

    public FractalWSImplService() {
        super(__getWsdlLocation(), FRACTALWSIMPLSERVICE_QNAME);
    }

    public FractalWSImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), FRACTALWSIMPLSERVICE_QNAME, features);
    }

    public FractalWSImplService(URL wsdlLocation) {
        super(wsdlLocation, FRACTALWSIMPLSERVICE_QNAME);
    }

    public FractalWSImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, FRACTALWSIMPLSERVICE_QNAME, features);
    }

    public FractalWSImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public FractalWSImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns FractalWSImpl
     */
    @WebEndpoint(name = "FractalWSImplPort")
    public FractalWSImpl getFractalWSImplPort() {
        return super.getPort(new QName("http://ws.fractal.luka.sh/", "FractalWSImplPort"), FractalWSImpl.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns FractalWSImpl
     */
    @WebEndpoint(name = "FractalWSImplPort")
    public FractalWSImpl getFractalWSImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws.fractal.luka.sh/", "FractalWSImplPort"), FractalWSImpl.class, features);
    }

    private static URL __getWsdlLocation() {
        if (FRACTALWSIMPLSERVICE_EXCEPTION!= null) {
            throw FRACTALWSIMPLSERVICE_EXCEPTION;
        }
        return FRACTALWSIMPLSERVICE_WSDL_LOCATION;
    }

}