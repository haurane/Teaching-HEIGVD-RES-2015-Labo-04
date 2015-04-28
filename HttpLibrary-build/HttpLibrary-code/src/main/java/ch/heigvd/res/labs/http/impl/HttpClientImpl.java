/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.res.labs.http.impl;

import ch.heigvd.res.labs.http.interfaces.IHttpClient;
import ch.heigvd.res.labs.http.interfaces.IHttpRequest;
import ch.heigvd.res.labs.http.interfaces.IHttpResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author haurane
 */


public class HttpClientImpl implements IHttpClient{
    
    private PrintWriter writer;
    private BufferedReader reader;
    
    

    @Override
    public IHttpResponse sendRequest(IHttpRequest request) {
        try {
            Socket sock = new Socket(request.getURI(), request.getPort());
            writer = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));
            reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            
            writer.print(request.makeMessage());
            
        } catch (IOException ex) {
            Logger.getLogger(HttpClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
