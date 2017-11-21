package com.jpush.openfire.plugin;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.MessageFormat;
import java.util.Iterator;
import org.dom4j.Element;
import org.dom4j.Namespace;
import org.dom4j.QName;
import org.jdom.Document;
import org.jdom.input.SAXBuilder;
import org.jivesoftware.openfire.OfflineMessageListener;
import org.jivesoftware.openfire.XMPPServer;
import org.jivesoftware.openfire.user.UserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.InputSource;
import org.xmpp.packet.JID;
import org.xmpp.packet.Message;

public class OfflineMessageListenerImpl implements OfflineMessageListener{
	private static String JPUSH_URL=PropertyUtil.getProperty("url");
	  private static final String JPUSH_PARAMS =
		    	"\"USERIDINFO\":{0},\"CONTENT\":\"{1}\",\"PACKAGENAME\":\"{2}\","
		    	+ "\"GOTYPE\":\"{3}\"";
	private Logger logger=LoggerFactory.getLogger(getClass());
	@Override
	public void messageBounced(Message message) {
		
	}
 public OfflineMessageListenerImpl(){
	 logger.info("OfflineMessageListenerImpl初始化..");
 }
	@Override
	public void messageStored(Message message) {
		System.out.println("OfflineMessageListenerImpl.........."+message);
        if (message == null) {
            return;
        }
        if(!shouldStoreMessage(message)) {
            return;
        }
        JID recipient = message.getTo();
        String username = recipient.getNode();
        // If the username is null (such as when an anonymous user), don't store.
        if (username == null || !UserManager.getInstance().isRegisteredUser(recipient)) {
            return;
        }
        else
        if (!XMPPServer.getInstance().getServerInfo().getXMPPDomain().equals(recipient.getDomain())) {
            // Do not store messages sent to users of remote servers
            return;
        }
        try { 
        	// Get the message in XML format.
        	String msgXML = message.getElement().asXML();
          //解析离校消息字段，获取推送唯一标识及内容
            StringReader read = new StringReader(msgXML);
            InputSource source = new InputSource(read);
            SAXBuilder sb = new SAXBuilder();
            //通过输入源构造一个Document
            Document doc;
				doc = sb.build(source);
            //取的根元素
            org.jdom.Element root = doc.getRootElement();
            System.out.println(root.getName());//输出根元素的名称（测试）
            System.out.println(root.getAttributeValue("to"));//获取根节点属性值
            System.out.println(root.getAttributeValue("type"));//获取根节点属性值
            org.jdom.Element et = root.getChild("body");//获取body子节点
            if(et!=null){
            	System.out.println(et.getText());//获取子节点内容
	            String userId = root.getAttributeValue("to");
	            String content = et.getText();
	            String goType = root.getAttributeValue("type");
	            System.out.println(PropertyUtil.getProperty("url")+"this is OfflineMessageStore class ...");
          
	            //推送处理
	            String pushParam = "JSON_PARAM={\"HEAD\":{\"VERSION\":\"\",\"DEVICETYPE\":\"\",\"USERID\":\"\","
	            		+ "\"DRIVERID\":\"\",\"CLOUDID\":\"\",\"SIGN\":\"\",\"ZIP\":\"\"},"
	            		+ "\"INFO\":{"+MessageFormat.format(JPUSH_PARAMS,"[\""+userId+"\"]",content,"com.gnet.enp.ibd",goType)+"}}";
	            BufferedReader reader = null;
	    	    String result = null;
	    	    StringBuffer sbf = new StringBuffer();
	            URL url = new URL(JPUSH_URL);
		        HttpURLConnection connection = (HttpURLConnection) url
		                .openConnection();
		        connection.setRequestMethod("POST");
		        connection.setDoOutput(true);  
		        connection.setRequestProperty("User-Agent", "directclient");
		        connection.connect();
		        PrintWriter out = new PrintWriter(new OutputStreamWriter(connection.getOutputStream(),"utf-8"));  
		        out.println(pushParam);  
		        out.close();
		        InputStream is = connection.getInputStream();
		        reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		        String strRead = null;
		        while ((strRead = reader.readLine()) != null) {
		            sbf.append(strRead);
		            sbf.append("\r\n");
		        }
		        reader.close();
		        result = sbf.toString();
		        System.out.println(result);
	           }
			} catch (Exception e) {
				e.printStackTrace();
			}
    		
	}
	
	  static boolean shouldStoreMessage(final Message message) {
	        // XEP-0334: Implement the <no-store/> hint to override offline storage
	        if (message.getChildElement("no-store", "urn:xmpp:hints") != null) {
	            return false;
	        }

	        switch (message.getType()) {
	            case chat:
	                // XEP-0160: Messages with a 'type' attribute whose value is "chat" SHOULD be stored offline, with the exception of messages that contain only Chat State Notifications (XEP-0085) [7] content
	                // Iterate through the child elements to see if we can find anything that's not a chat state notification or
	                // real time text notification
	                Iterator<?> it = message.getElement().elementIterator();

	                while (it.hasNext()) {
	                    Object item = it.next();

	                    if (item instanceof Element) {
	                        Element el = (Element) item;
	                        if (Namespace.NO_NAMESPACE.equals(el.getNamespace())) {
	                            continue;
	                        }
	                        if (!el.getNamespaceURI().equals("http://jabber.org/protocol/chatstates")
	                                && !(el.getQName().equals(QName.get("rtt", "urn:xmpp:rtt:0")))
	                                ) {
	                            return true;
	                        }
	                    }
	                }

	                return message.getBody() != null && !message.getBody().isEmpty();

	            case groupchat:
	            case headline:
	                // XEP-0160: "groupchat" message types SHOULD NOT be stored offline
	                // XEP-0160: "headline" message types SHOULD NOT be stored offline
	                return false;

	            case error:
	                // XEP-0160: "error" message types SHOULD NOT be stored offline,
	                // although a server MAY store advanced message processing errors offline
	                if (message.getChildElement("amp", "http://jabber.org/protocol/amp") == null) {
	                    return false;
	                }
	                break;

	            default:
	                // XEP-0160: Messages with a 'type' attribute whose value is "normal" (or messages with no 'type' attribute) SHOULD be stored offline.
	                break;
	        }
	        return true;
	    }

}
