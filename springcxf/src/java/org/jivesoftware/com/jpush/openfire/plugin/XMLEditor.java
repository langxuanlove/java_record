package org.jivesoftware.com.jpush.openfire.plugin;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class XMLEditor {
	public static Document read(String fileName) {
		SAXReader reader = new SAXReader();
		Map<String, String> nsMap = new HashMap<String, String>();
		nsMap.put("beans", "http://www.springframework.org/schema/beans");
		reader.getDocumentFactory().setXPathNamespaceURIs(nsMap);
		reader.setEncoding("UTF-8");
		Document document = null;
		try {
			document = reader.read(new File(fileName));
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return document;
	}

	public static void alterXML(String newValue, String url) {
		OutputFormat format = new OutputFormat("\t", true);
		format.setEncoding("UTF-8");
		Document document = read(url);
		Element node = ((Element) document.selectSingleNode("//beans:property[@name='resourceLoaderPath']"))
				.element("value");
		 String string = "file:/%s\\web\\WEB-INF\\template";  
	        string = String.format(string, newValue);  
	        node.setText(string);  
	        try {  
	            // 重新写入到XML文档  
	            XMLWriter writer = new XMLWriter(new FileOutputStream(url), format);  
	            writer.write(document);  
	            writer.close();  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
	}
}
