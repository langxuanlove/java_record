package org.jivesoftware.com.jpush.openfire.plugin;

import java.io.File;

import org.springframework.web.servlet.DispatcherServlet;

public class CustomDispatcherServlet extends DispatcherServlet {
	private static final long serialVersionUID = 5713165491251313468L;  
	  
    public CustomDispatcherServlet() {  
        super();  
        // openfireHome的目录  参考：XMPPServer的locateOpenfire()方法,可能不完善需要多加些判断条件.
        String homeProperty = System.getProperty("openfireHome");
        System.out.println("homeProperty:"+homeProperty);
        String pluginDir = "/plugins/springcxf/web";  
        String contextConfigLocation =homeProperty+pluginDir + File.separatorChar+ "PluginServlet-servlet.xml";  
        // 更改模板目录  
//      XMLEditor.alterXML(pluginDir, contextConfigLocation);  
        contextConfigLocation = "file:" +contextConfigLocation;
        System.out.println("contextConfigLocation:"+contextConfigLocation);
        super.setContextConfigLocation(contextConfigLocation);  
    }  
}
