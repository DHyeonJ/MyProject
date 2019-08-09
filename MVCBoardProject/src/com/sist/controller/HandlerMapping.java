package com.sist.controller;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.*;
/*
 *    dom :
 *           ���� : �ӵ��� ������ 
 *                ========== XML�� �о �޸� Ʈ�����·� ������ �Ŀ� ó�� 
 *                           ==================== 
 *           ���� : ���� , ����, �߰��� ���� 
 *    sax : framework (sax) => Spring, Mybatis 
 *          ���پ� �о �����͸� ���� 
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
			JAXB = ��뷮 (������)
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
		// qName(�±׸�) , attributes(�Ӽ�)
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













