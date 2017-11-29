package org.jivesoftware.com.jpush.openfire.plugin.session;


import java.io.File;

import org.jivesoftware.openfire.container.Plugin;
import org.jivesoftware.openfire.container.PluginManager;
import org.jivesoftware.openfire.event.SessionEventDispatcher;

public class SessionPlugin implements Plugin {

	private SessionEventListenerImpl sessionimpl=null;
	public SessionPlugin(){
		System.out.println("SessionPlugin 。。。");
	}
	@Override
	public void initializePlugin(PluginManager manager, File pluginDirectory) {
		// TODO Auto-generated method stub
		sessionimpl=new SessionEventListenerImpl();
		SessionEventDispatcher.addListener(sessionimpl);
	}

	@Override
	public void destroyPlugin() {

	}

}
