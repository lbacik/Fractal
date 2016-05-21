
package sh.luka.fractal.wsclient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the sh.luka.fractal.wsclient package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetCurrentIteration_QNAME = new QName("http://ws.fractal.luka.sh/", "getCurrentIteration");
    private final static QName _UploadImage_QNAME = new QName("http://ws.fractal.luka.sh/", "uploadImage");
    private final static QName _GetFractalResponse_QNAME = new QName("http://ws.fractal.luka.sh/", "getFractalResponse");
    private final static QName _UploadImageResponse_QNAME = new QName("http://ws.fractal.luka.sh/", "uploadImageResponse");
    private final static QName _GetIterationNumbersResponse_QNAME = new QName("http://ws.fractal.luka.sh/", "getIterationNumbersResponse");
    private final static QName _GetScaleResponse_QNAME = new QName("http://ws.fractal.luka.sh/", "getScaleResponse");
    private final static QName _GetSessionID_QNAME = new QName("http://ws.fractal.luka.sh/", "getSessionID");
    private final static QName _GetSessionIDResponse_QNAME = new QName("http://ws.fractal.luka.sh/", "getSessionIDResponse");
    private final static QName _FinishSuccessIteration_QNAME = new QName("http://ws.fractal.luka.sh/", "finishSuccessIteration");
    private final static QName _GetFractalFileNameResponse_QNAME = new QName("http://ws.fractal.luka.sh/", "getFractalFileNameResponse");
    private final static QName _FinishSuccessIterationResponse_QNAME = new QName("http://ws.fractal.luka.sh/", "finishSuccessIterationResponse");
    private final static QName _GetIterationNumbers_QNAME = new QName("http://ws.fractal.luka.sh/", "getIterationNumbers");
    private final static QName _GetScale_QNAME = new QName("http://ws.fractal.luka.sh/", "getScale");
    private final static QName _GetFractal_QNAME = new QName("http://ws.fractal.luka.sh/", "getFractal");
    private final static QName _GetFractalFileName_QNAME = new QName("http://ws.fractal.luka.sh/", "getFractalFileName");
    private final static QName _GetCurrentIterationResponse_QNAME = new QName("http://ws.fractal.luka.sh/", "getCurrentIterationResponse");
    private final static QName _UploadImageArg1_QNAME = new QName("", "arg1");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: sh.luka.fractal.wsclient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UploadImage }
     * 
     */
    public UploadImage createUploadImage() {
        return new UploadImage();
    }

    /**
     * Create an instance of {@link GetFractalResponse }
     * 
     */
    public GetFractalResponse createGetFractalResponse() {
        return new GetFractalResponse();
    }

    /**
     * Create an instance of {@link UploadImageResponse }
     * 
     */
    public UploadImageResponse createUploadImageResponse() {
        return new UploadImageResponse();
    }

    /**
     * Create an instance of {@link GetIterationNumbersResponse }
     * 
     */
    public GetIterationNumbersResponse createGetIterationNumbersResponse() {
        return new GetIterationNumbersResponse();
    }

    /**
     * Create an instance of {@link GetScaleResponse }
     * 
     */
    public GetScaleResponse createGetScaleResponse() {
        return new GetScaleResponse();
    }

    /**
     * Create an instance of {@link GetCurrentIteration }
     * 
     */
    public GetCurrentIteration createGetCurrentIteration() {
        return new GetCurrentIteration();
    }

    /**
     * Create an instance of {@link GetSessionIDResponse }
     * 
     */
    public GetSessionIDResponse createGetSessionIDResponse() {
        return new GetSessionIDResponse();
    }

    /**
     * Create an instance of {@link GetSessionID }
     * 
     */
    public GetSessionID createGetSessionID() {
        return new GetSessionID();
    }

    /**
     * Create an instance of {@link GetFractalFileNameResponse }
     * 
     */
    public GetFractalFileNameResponse createGetFractalFileNameResponse() {
        return new GetFractalFileNameResponse();
    }

    /**
     * Create an instance of {@link FinishSuccessIteration }
     * 
     */
    public FinishSuccessIteration createFinishSuccessIteration() {
        return new FinishSuccessIteration();
    }

    /**
     * Create an instance of {@link FinishSuccessIterationResponse }
     * 
     */
    public FinishSuccessIterationResponse createFinishSuccessIterationResponse() {
        return new FinishSuccessIterationResponse();
    }

    /**
     * Create an instance of {@link GetFractal }
     * 
     */
    public GetFractal createGetFractal() {
        return new GetFractal();
    }

    /**
     * Create an instance of {@link GetScale }
     * 
     */
    public GetScale createGetScale() {
        return new GetScale();
    }

    /**
     * Create an instance of {@link GetIterationNumbers }
     * 
     */
    public GetIterationNumbers createGetIterationNumbers() {
        return new GetIterationNumbers();
    }

    /**
     * Create an instance of {@link GetFractalFileName }
     * 
     */
    public GetFractalFileName createGetFractalFileName() {
        return new GetFractalFileName();
    }

    /**
     * Create an instance of {@link GetCurrentIterationResponse }
     * 
     */
    public GetCurrentIterationResponse createGetCurrentIterationResponse() {
        return new GetCurrentIterationResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCurrentIteration }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.fractal.luka.sh/", name = "getCurrentIteration")
    public JAXBElement<GetCurrentIteration> createGetCurrentIteration(GetCurrentIteration value) {
        return new JAXBElement<GetCurrentIteration>(_GetCurrentIteration_QNAME, GetCurrentIteration.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadImage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.fractal.luka.sh/", name = "uploadImage")
    public JAXBElement<UploadImage> createUploadImage(UploadImage value) {
        return new JAXBElement<UploadImage>(_UploadImage_QNAME, UploadImage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFractalResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.fractal.luka.sh/", name = "getFractalResponse")
    public JAXBElement<GetFractalResponse> createGetFractalResponse(GetFractalResponse value) {
        return new JAXBElement<GetFractalResponse>(_GetFractalResponse_QNAME, GetFractalResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadImageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.fractal.luka.sh/", name = "uploadImageResponse")
    public JAXBElement<UploadImageResponse> createUploadImageResponse(UploadImageResponse value) {
        return new JAXBElement<UploadImageResponse>(_UploadImageResponse_QNAME, UploadImageResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetIterationNumbersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.fractal.luka.sh/", name = "getIterationNumbersResponse")
    public JAXBElement<GetIterationNumbersResponse> createGetIterationNumbersResponse(GetIterationNumbersResponse value) {
        return new JAXBElement<GetIterationNumbersResponse>(_GetIterationNumbersResponse_QNAME, GetIterationNumbersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetScaleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.fractal.luka.sh/", name = "getScaleResponse")
    public JAXBElement<GetScaleResponse> createGetScaleResponse(GetScaleResponse value) {
        return new JAXBElement<GetScaleResponse>(_GetScaleResponse_QNAME, GetScaleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSessionID }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.fractal.luka.sh/", name = "getSessionID")
    public JAXBElement<GetSessionID> createGetSessionID(GetSessionID value) {
        return new JAXBElement<GetSessionID>(_GetSessionID_QNAME, GetSessionID.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSessionIDResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.fractal.luka.sh/", name = "getSessionIDResponse")
    public JAXBElement<GetSessionIDResponse> createGetSessionIDResponse(GetSessionIDResponse value) {
        return new JAXBElement<GetSessionIDResponse>(_GetSessionIDResponse_QNAME, GetSessionIDResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FinishSuccessIteration }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.fractal.luka.sh/", name = "finishSuccessIteration")
    public JAXBElement<FinishSuccessIteration> createFinishSuccessIteration(FinishSuccessIteration value) {
        return new JAXBElement<FinishSuccessIteration>(_FinishSuccessIteration_QNAME, FinishSuccessIteration.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFractalFileNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.fractal.luka.sh/", name = "getFractalFileNameResponse")
    public JAXBElement<GetFractalFileNameResponse> createGetFractalFileNameResponse(GetFractalFileNameResponse value) {
        return new JAXBElement<GetFractalFileNameResponse>(_GetFractalFileNameResponse_QNAME, GetFractalFileNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FinishSuccessIterationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.fractal.luka.sh/", name = "finishSuccessIterationResponse")
    public JAXBElement<FinishSuccessIterationResponse> createFinishSuccessIterationResponse(FinishSuccessIterationResponse value) {
        return new JAXBElement<FinishSuccessIterationResponse>(_FinishSuccessIterationResponse_QNAME, FinishSuccessIterationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetIterationNumbers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.fractal.luka.sh/", name = "getIterationNumbers")
    public JAXBElement<GetIterationNumbers> createGetIterationNumbers(GetIterationNumbers value) {
        return new JAXBElement<GetIterationNumbers>(_GetIterationNumbers_QNAME, GetIterationNumbers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetScale }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.fractal.luka.sh/", name = "getScale")
    public JAXBElement<GetScale> createGetScale(GetScale value) {
        return new JAXBElement<GetScale>(_GetScale_QNAME, GetScale.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFractal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.fractal.luka.sh/", name = "getFractal")
    public JAXBElement<GetFractal> createGetFractal(GetFractal value) {
        return new JAXBElement<GetFractal>(_GetFractal_QNAME, GetFractal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFractalFileName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.fractal.luka.sh/", name = "getFractalFileName")
    public JAXBElement<GetFractalFileName> createGetFractalFileName(GetFractalFileName value) {
        return new JAXBElement<GetFractalFileName>(_GetFractalFileName_QNAME, GetFractalFileName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCurrentIterationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.fractal.luka.sh/", name = "getCurrentIterationResponse")
    public JAXBElement<GetCurrentIterationResponse> createGetCurrentIterationResponse(GetCurrentIterationResponse value) {
        return new JAXBElement<GetCurrentIterationResponse>(_GetCurrentIterationResponse_QNAME, GetCurrentIterationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "arg1", scope = UploadImage.class)
    public JAXBElement<byte[]> createUploadImageArg1(byte[] value) {
        return new JAXBElement<byte[]>(_UploadImageArg1_QNAME, byte[].class, UploadImage.class, ((byte[]) value));
    }

}
