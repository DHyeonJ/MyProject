package com.sist.controller;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.*;
/*
 *    dom :
 *           단점 : 속도가 느리다 
 *                ========== XML을 읽어서 메모리 트리형태로 저장한 후에 처리 
 *                           ==================== 
 *           장점 : 수정 , 삭제, 추가가 가능 
 *    sax : framework (sax) => Spring, Mybatis 
 *          한줄씩 읽어서 데이터만 추출 
 *          
 *          <?xml version="1.0" encoding="UTF-8"?> => startDocument()
 *          <book>   => startElement()
 *            <list> => startElement()
 *              <title> => startElement()
 *                aaa   => characters()
 *              </title> => endElement()
 *              
 *              <price> startElement()
 *               1000  characters()
 *               </price> endElement()
 *            </list>  endElement()
 *          </book> endElement()
 *          endDocument()
 *          
 *          <beans>
			   <bean id="list.do" class="com.sist.model.ListModel"/>
			   <bean id="detail.do" class="com.sist.model.DetailModel"/>
			   <bean id="insert.do" class="com.sist.model.InsertModel"/>
			   <bean id="insert_ok.do" class="com.sist.model.InsertOkModel"/>
			</beans>
			
			JAXP = DOM/SAX
			JAXB = 대용량 (빅데이터)
 */
public class HandlerMapping extends DefaultHandler{
    Map map=new HashMap();

	/*@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		super.startElement(uri, localName, qName, attributes);
	}*/
    
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// qName(태그명) , attributes(속성)
		try
		{
			if(qName.equals("bean"))
			{
				String id=attributes.getValue("id");
				String cls=attributes.getValue("class");
				
				Class clsName=Class.forName(cls);
				Object obj=clsName.newInstance();
				
				map.put(id,obj);
			}
		}catch(Exception ex){}
	}
    
}













