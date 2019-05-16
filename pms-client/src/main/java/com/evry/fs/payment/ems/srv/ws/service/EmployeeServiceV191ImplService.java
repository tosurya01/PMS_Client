
package com.evry.fs.payment.ems.srv.ws.service;

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
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "EmployeeServiceV191ImplService", targetNamespace = "http://service.ws.srv.ems.payment.fs.evry.com/", wsdlLocation = "http://localhost:3456/pms-srv-ws/services/emsservice/employeeServiceV191?wsdl")
public class EmployeeServiceV191ImplService
    extends Service
{

    private final static URL EMPLOYEESERVICEV191IMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException EMPLOYEESERVICEV191IMPLSERVICE_EXCEPTION;
    private final static QName EMPLOYEESERVICEV191IMPLSERVICE_QNAME = new QName("http://service.ws.srv.ems.payment.fs.evry.com/", "EmployeeServiceV191ImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:3456/pms-srv-ws/services/emsservice/employeeServiceV191?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        EMPLOYEESERVICEV191IMPLSERVICE_WSDL_LOCATION = url;
        EMPLOYEESERVICEV191IMPLSERVICE_EXCEPTION = e;
    }

    public EmployeeServiceV191ImplService() {
        super(__getWsdlLocation(), EMPLOYEESERVICEV191IMPLSERVICE_QNAME);
    }

    public EmployeeServiceV191ImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), EMPLOYEESERVICEV191IMPLSERVICE_QNAME, features);
    }

    public EmployeeServiceV191ImplService(URL wsdlLocation) {
        super(wsdlLocation, EMPLOYEESERVICEV191IMPLSERVICE_QNAME);
    }

    public EmployeeServiceV191ImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, EMPLOYEESERVICEV191IMPLSERVICE_QNAME, features);
    }

    public EmployeeServiceV191ImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public EmployeeServiceV191ImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns EmployeeServiceV191
     */
    @WebEndpoint(name = "EmployeeServiceV191ImplPort")
    public EmployeeServiceV191 getEmployeeServiceV191ImplPort() {
        return super.getPort(new QName("http://service.ws.srv.ems.payment.fs.evry.com/", "EmployeeServiceV191ImplPort"), EmployeeServiceV191.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns EmployeeServiceV191
     */
    @WebEndpoint(name = "EmployeeServiceV191ImplPort")
    public EmployeeServiceV191 getEmployeeServiceV191ImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://service.ws.srv.ems.payment.fs.evry.com/", "EmployeeServiceV191ImplPort"), EmployeeServiceV191.class, features);
    }

    private static URL __getWsdlLocation() {
        if (EMPLOYEESERVICEV191IMPLSERVICE_EXCEPTION!= null) {
            throw EMPLOYEESERVICEV191IMPLSERVICE_EXCEPTION;
        }
        return EMPLOYEESERVICEV191IMPLSERVICE_WSDL_LOCATION;
    }

}
