package org.jivesoftware.com.jpush.openfire.plugin.group;


import java.io.File;

import org.jivesoftware.openfire.container.Plugin;
import org.jivesoftware.openfire.container.PluginManager;
import org.jivesoftware.openfire.event.GroupEventDispatcher;

public class GroupPlugin implements Plugin {
	private GroupEventImpl groupImpl = null;

	public GroupPlugin() {
		System.out.println("GroupPlugin");
	}

	@Override
	public void initializePlugin(PluginManager manager, File pluginDirectory) {
		// TODO Auto-generated method stub
		groupImpl = new GroupEventImpl();
		GroupEventDispatcher.addListener(groupImpl);
	}

	@Override
	public void destroyPlugin() {

	}

}
