package org.jivesoftware.com.jpush.openfire.plugin;


import java.io.File;
import org.jivesoftware.admin.AuthCheckFilter;
import org.jivesoftware.openfire.container.Plugin;
import org.jivesoftware.openfire.container.PluginManager;
import org.jivesoftware.openfire.container.PluginServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * 1.spring在打包后相关jar包要拷贝到openfire的lib目录才有效果
 * 2.
 * 
 * @author kui
 *
 */
public class SpringCxfPlugin implements Plugin {
	private static Logger logger = LoggerFactory.getLogger(SpringCxfPlugin.class);

	@Override
	public void destroyPlugin() {
		logger.info("销毁Jpush插件.");
		//绕过登录验证过程.
	    AuthCheckFilter.addExclude("springcxf/*");
	}
/**
 * 参考博客
 * http://eggtk.iteye.com/blog/2213142
 */
	@Override
	public void initializePlugin(PluginManager arg0, File arg1) {
	    String libDirString = System.getProperty("openfire.lib.dir");  
	    System.out.println("libDirString:"+libDirString);
		System.out.println("加载spring。。。。。");
		 // 得到spring mvc配置文件路径,修改成你相应的路径,我是放在web-inf下的  
	    File webXML = new File(arg1.toString() + File.separatorChar  
	    + "web" +  File.separatorChar  
	    + "spring-context.xml");  
	    	    // 注册servlet  
//	    System.out.println("sprng-context配置文件路径:"+String.valueOf(webXML));
	    // 注册servlet  
//	    PluginServlet.registerServlets(arg0, this, webXML);
//	    PluginServlet.registerServlets(arg0, this, webXML1);  
	    //绕过登录验证过程.
	    AuthCheckFilter.addExclude("springcxf/*");
	    System.out.println("444444444444444444444444SpringCxfPlugin");
	    System.out.println("========================");
	}
}