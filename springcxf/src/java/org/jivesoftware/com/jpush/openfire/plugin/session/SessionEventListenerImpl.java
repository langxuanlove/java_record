package org.jivesoftware.com.jpush.openfire.plugin.session;


import java.net.UnknownHostException;

import org.jivesoftware.openfire.event.SessionEventListener;
import org.jivesoftware.openfire.session.Session;

public class SessionEventListenerImpl implements SessionEventListener {

	public SessionEventListenerImpl() {
		System.out.println("SessionEventListenerImpl变化......."); 
	}
	@Override
	public void sessionCreated(Session session) {
		try {
			System.out.println("SessionEventListenerImpl的sessionCreated:"+session.getAddress()+";"+session.getHostName());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void sessionDestroyed(Session session) {
		try {
			System.out.println("SessionEventListenerImpl的sessionDestroyed:"+session.getAddress()+";"+session.getHostName());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void anonymousSessionCreated(Session session) {
		
	}

	@Override
	public void anonymousSessionDestroyed(Session session) {
		
	}

	@Override
	public void resourceBound(Session session) {
		
	}

}
