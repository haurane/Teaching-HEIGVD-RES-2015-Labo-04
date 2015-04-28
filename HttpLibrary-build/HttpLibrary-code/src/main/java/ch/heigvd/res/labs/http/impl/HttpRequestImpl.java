/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.res.labs.http.impl;

import ch.heigvd.res.labs.http.interfaces.IHttpHeader;
import ch.heigvd.res.labs.http.interfaces.IHttpRequest;
import java.io.IOException;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haurane
 */
public class HttpRequestImpl implements IHttpRequest {

    private String message;
    private Socket connectionSocket;
    private URI uri;
    private String host;
    private int port;
    private String target;
    private Map<String, IHttpHeader> headers;
    private String method;
    private String ProtocolVersion;
    
    public HttpRequestImpl(){
        
    }
    
    public HttpRequestImpl(String url){
        try {
            uri = new URI(url);
            host = uri.getHost();
            port = uri.getPort();
            target = uri.getPath();
            HttpHeaderImpl hostHeader = new HttpHeaderImpl();
            hostHeader.setName("host");
            String[] hostHeaderVal = {host};
            hostHeader.setValues(hostHeaderVal);
            addHeader(hostHeader);
        } catch (URISyntaxException ex) {
            Logger.getLogger(HttpRequestImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public String getMethod() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void setMethod(String method){
        this.method = method;
    }

    @Override
    public String getURI() {
        return host;
    }
    
    public int getPort(){
        return port;
    }
    
    public void setURI(String url){
        try {
            uri = new URI(url);
            host = uri.getHost();
            port = uri.getPort();
            target = uri.getPath();
            HttpHeaderImpl hostHeader = new HttpHeaderImpl();
            hostHeader.setName("host");
            String[] hostHeaderVal = {host};
            hostHeader.setValues(hostHeaderVal);
            addHeader(hostHeader);
        } catch (URISyntaxException ex) {
            Logger.getLogger(HttpRequestImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public Map<String, IHttpHeader> getHeaders() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IHttpHeader getHeader(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void addHeader(IHttpHeader header){
        headers.put(header.getName(), header);
    }

    @Override
    public byte[] getBody() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getContentLength() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getProtocolVersion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void setProtocolVersion(String version){
        ProtocolVersion = version;
    }
    
    public String makeMessage(){
        String request = method + " " + target + " " + ProtocolVersion + "\r\n";
        for(Entry<String, IHttpHeader> header : headers.entrySet()){
            request += header.getKey() + " : ";
            for(String value : header.getValue().getValues()){
                request += value + " ";
            }
            request += "\r\n";
        }
        request += "\r\n";
        return request;
    }
    
}
