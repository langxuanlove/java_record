package org.jivesoftware.com.jpush.openfire.plugin;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


/**
 * 作者 sam
 * 
 * @version v1.0
 * 
 *          Created on 2014-09-04
 * 
 *          Revision History: Date Reviser Description
 * 
 *          ----------------------------------------------------
 *          Description:应用中心服务接口
 */
@Service(value = "messageService")
public class MessageServiceImpl {

	MessageServiceImpl() {
		System.out.println("我是服务....");
	}

	public void demo() {
		System.out.println("service demo;");
	}
}
