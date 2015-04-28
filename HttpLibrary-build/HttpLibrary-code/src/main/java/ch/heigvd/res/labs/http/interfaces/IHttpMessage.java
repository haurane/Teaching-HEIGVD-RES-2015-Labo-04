/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.res.labs.http.interfaces;

import java.util.Map;

/**
 *
 * @author haurane
 */
public interface IHttpMessage {
    public Map<String, IHttpHeader> getHeaders();
    public IHttpHeader getHeader(String name);
    public byte[] getBody();
    public int getContentLength();
    public String getProtocolVersion();
    public int getPort();
    public String makeMessage();
    
}
