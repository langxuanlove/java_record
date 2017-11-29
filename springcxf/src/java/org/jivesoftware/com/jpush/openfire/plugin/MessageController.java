package org.jivesoftware.com.jpush.openfire.plugin;
/*   
 * Copyright (c) 2014-2020 Founder Ltd. All Rights Reserved.   
 *   
 * This software is the confidential and proprietary information of   
 * Founder. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with Founder.   
 *   
 */
/**
 * 
 */

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Windows
 * 
 * 
 * @version v1.0
 * 
 *          Created on 2014年11月5日 下午5:26:07
 * 
 *          Revision History: Date Reviser Description
 * 
 *          ---------------------------------------------------- Description:
 */
@RestController(value = "msgController")
@RequestMapping("springcxf/msgController")
public class MessageController {
	MessageController(){
		System.out.println("大家好，我是spring框架");
	}
	@RequestMapping(value = "/demo", method = RequestMethod.GET)
	@ResponseBody//此注解证明返回的是字符串，没有此注解返回的是页面success.jsp
	public String demo(HttpServletRequest  httpRequest,HttpServletResponse response) {
		System.out.println("name:"+httpRequest.getParameter("name"));
		System.out.println("this is ...");
		return "success";
	}

}