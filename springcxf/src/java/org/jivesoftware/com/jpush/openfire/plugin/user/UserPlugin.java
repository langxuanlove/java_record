package org.jivesoftware.com.jpush.openfire.plugin.user;


import java.io.File;

import org.jivesoftware.openfire.container.Plugin;
import org.jivesoftware.openfire.container.PluginManager;
import org.jivesoftware.openfire.event.UserEventDispatcher;

public class UserPlugin implements Plugin {

	public UserPlugin(){
		System.out.println("UserPlugin");
	}
	private UserEventImpl userevent=null;
	@Override
	public void initializePlugin(PluginManager manager, File pluginDirectory) {
			userevent=new UserEventImpl();
			UserEventDispatcher.addListener(userevent);
	}

	@Override
	public void destroyPlugin() {

	}

}
