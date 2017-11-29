package org.jivesoftware.com.jpush.openfire.plugin;


import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigActionServlet extends HttpServlet {
	
	private static final long serialVersionUID = -827073617548281023L;
	private Logger logger=LoggerFactory.getLogger(getClass());
	public ConfigActionServlet(){
		logger.info("ConfigActionServlet 初始化.");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
        super.init(config);
	
	}
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String config = req.getParameter("config");
		resp.setContentType("application/json;charset=UTF-8");
		if(config!=null){
			logger.info("jpush url: {}",config);
			PropertyUtil.setProperty("url", config);
			resp.getWriter().write("jpush设置的url地址是:"+PropertyUtil.getProperty("url"));
		}else{
			resp.getWriter().write("jpush设置的url地址是:"+PropertyUtil.getProperty("url"));
		}
	}
}