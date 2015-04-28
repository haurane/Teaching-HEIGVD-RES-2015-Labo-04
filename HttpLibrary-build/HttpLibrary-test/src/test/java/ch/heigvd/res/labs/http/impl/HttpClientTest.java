package ch.heigvd.res.labs.http.impl;

import ch.heigvd.res.labs.http.interfaces.IHttpClient;
import ch.heigvd.res.labs.http.interfaces.IHttpRequest;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;


/**
 *
 * @author Olivier Liechti
 */
public class HttpClientTest {
  
    @Test
    public void ARequestShouldHandleA200Status(){
        HttpClientImpl client = new HttpClientImpl();
        HttpRequestImpl valid = new HttpRequestImpl();
        
        valid.setMethod("GET");
        valid.setProtocolVersion("HTTP/1.0");
        valid.setURI("www.heig-vd.ch");
        
        int status = client.sendRequest(valid).getStatus();
        
        assertEquals(200, status);
    }
    
    public void ARequestShouldHandleA302Status(){
        HttpClientImpl client = new HttpClientImpl();
        HttpRequestImpl valid = new HttpRequestImpl();
        
        valid.setMethod("GET");
        valid.setProtocolVersion("HTTP/1.0");
        valid.setURI("www.google.com");
        
        int status = client.sendRequest(valid).getStatus();
        
        assertEquals(302, status);
    }
    
    public void ARequestShouldHandleA404Status(){
        HttpClientImpl client = new HttpClientImpl();
        HttpRequestImpl valid = new HttpRequestImpl();
        
        valid.setMethod("GET");
        valid.setProtocolVersion("HTTP/1.0");
        valid.setURI("www.heig-vd.ch/manamana");
        
        int status = client.sendRequest(valid).getStatus();
        
        assertEquals(404, status);
    }
}
