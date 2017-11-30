1、eclipse中如何连接github的方法.
http://blog.csdn.net/qiyeliuli/article/details/51798725
2、github插件
http://blog.csdn.net/poem_of_sunshine/article/details/77894438


1.离线消息监听
2.用户事件监听
3.群组事件监听 
4.session事件监听
5.http请求给指定用户发送消息
待开发
1.在线用户监听：onlineusers
参考：https://github.com/candy-chat/onlineUsersPlugin
2.apns插件开发
3.注册用户插件
参考：
https://github.com/pnspinelli/registerUser
https://github.com/wangzognwen/openfire_plugin_wechat
https://github.com/sunshinefather/openfire-plugin-radar
4.判断用户是否在线
http://blog.csdn.net/newjueqi/article/details/8613125


5.更改了JiveClassLoader主类初始化加载lib的同时加载了springcxf中的lib。
融合成功了，（但是不标准，还是有些问题.都是正确的执行方式加载的openfire的lib>插件lib>web-custom.xml。但是spring就是不解析spring.xml文件,所以只能进行更改加载lib的方式
PluginClassLoader是加载插件的lib的，增加了测试代码.
插件管理参考：
http://blog.csdn.net/huwenfeng_2011/article/details/43418433
6.参考资料：
https://www.cnblogs.com/xiepeixing/p/4243801.html
spring的返回类型。
http://eggtk.iteye.com/blog/2213143
http://eggtk.iteye.com/blog/2213142
https://www.hz7788.com/news/aF9iNjA5MWY2MWYxMTFmMTg1ODJkMDVhMDM_2/
openfire的融合springmvc例子


JiveClassLoader也有具体的注释说明
