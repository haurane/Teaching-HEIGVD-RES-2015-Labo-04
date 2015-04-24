/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.res.labs.http.interfaces;

/**
 *
 * @author haurane
 */
public interface IHttpClient {
    public IHttpResponse sendRequest(IHttpRequest request);
}
