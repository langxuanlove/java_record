package com.jpush.openfire.plugin;

import java.io.File;

import org.jivesoftware.openfire.OfflineMessageStrategy;
import org.jivesoftware.openfire.container.Plugin;
import org.jivesoftware.openfire.container.PluginManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JpushPlugin implements Plugin {
	private OfflineMessageListenerImpl offlineMessageListener=null;
	private static Logger logger = LoggerFactory.getLogger(JpushPlugin.class);
	@Override
	public void destroyPlugin() {
		logger.info("销毁Jpush插件.");
	}

	@Override
	public void initializePlugin(PluginManager arg0, File arg1) {
		logger.info("初始化jpush插件.");
		offlineMessageListener = new OfflineMessageListenerImpl();
		OfflineMessageStrategy.addListener(offlineMessageListener);
	}

}