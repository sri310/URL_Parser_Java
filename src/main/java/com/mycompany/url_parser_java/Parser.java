/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.url_parser_java;

import org.apache.http.client.utils.URLEncodedUtils;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.List;
import org.apache.http.NameValuePair;
import java.util.ArrayList;

/**
 *
 * @author srividhya
 */
public class Parser {
    public static List<NameValuePair> parse_string_url(String url){
        List<NameValuePair> parameters = new ArrayList<NameValuePair>();
        try{
            URI uri = URI.create(url);
            parameters = URLEncodedUtils.parse(uri,Charset.forName("UTF-8"));  
            if(parameters.size()<1){
                 throw new URISyntaxException(url,"malformed url"); 
            }
        }
        catch(URISyntaxException e){           
            System.out.println(e);
        }
        return parameters;       
    }
    
    public static void main(String[] args){
        String url = "https://www.something.com/parameters?arg1=1";
        String url2 = "?arg1=1&arg2=2";
        List<NameValuePair> parameters = parse_string_url(url2);
        for(NameValuePair param : parameters){
            System.out.println(param.getName() + " " + param.getValue());
        }
    }
    
}
