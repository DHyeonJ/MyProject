package com.sist.controller;
import java.util.*;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import java.io.*;
// C/S
// Ŭ����(��Ŭ����)
public class WebApplicationContext {
    private Map map=new HashMap();
    public WebApplicationContext(String path)
    {
    	try{
    		SAXParserFactory spf=SAXParserFactory.newInstance();
    		// ML => HTML , XML , WML(*****) , HDML
    		SAXParser sp=spf.newSAXParser();
    		HandlerMapping hm=new HandlerMapping();
    		sp.parse(new File(path), hm);
    		map=hm.map;
    	}catch(Exception ex){}
    }
    public Object getBean(String id) // Modelã�� 
    {
    	return map.get(id);
    }
}









