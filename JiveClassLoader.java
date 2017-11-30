/**
 * $RCSfile$
 * $Revision: 1089 $
 * $Date: 2005-03-07 02:36:27 -0300 (Mon, 07 Mar 2005) $
 *
 * Copyright (C) 2004-2008 Jive Software. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jivesoftware.openfire.starter;

import java.io.File;
import java.io.FilenameFilter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;

/**
 * A simple classloader to extend the classpath to
 * include all jars in a lib directory.<p>
 *
 * The new classpath includes all <tt>*.jar</tt> and <tt>*.zip</tt>
 * archives (zip is commonly used in packaging JDBC drivers). The extended
 * classpath is used for both the initial server startup, as well as loading
 * plug-in support jars.
 *
 * @author Derek DeMoro
 * @author Iain Shigeoka
 */
class JiveClassLoader extends URLClassLoader {

    /**
     * Constructs the classloader.
     *
     * @param parent the parent class loader (or null for none).
     * @param libDir the directory to load jar files from.
     * @throws java.net.MalformedURLException if the libDir path is not valid.
     */
    JiveClassLoader(ClassLoader parent, File libDir) throws MalformedURLException {
        super(new URL[] { libDir.toURI().toURL() }, parent);
        System.out.println("111111111111111111111111111:libDir:"+libDir.toURI().toURL() );
        String pluginsName=System.getProperty("pluginsName");
        if(pluginsName==null||pluginsName.isEmpty()){
        	pluginsName="springcxf";
        }
        // 1.如果报错，可能是log4j的jar冲突了，因为原生的openfire也是使用log4j进行开发的
        // 2.如果不想这么加载，也可以把plugins下的springcxf/lib下的所有的文件都拷贝到openfire/lib/springcxf中去。记住一定要是所有的，并且有更新时候也要重新拷贝，因为插件会自动生成三个新的jar文件。切记
        // 3。目前还是未进行jar包卸载的情况，这样更改源码只是为了添加插件，具体卸载不知道可不可用。
        String springjarpath= System.getProperty("openfireHome")+"/plugins/"+pluginsName+"/lib";
        System.out.println("springjarpath:"+springjarpath);
        File[] springjars=new File(springjarpath).listFiles();
        if(springjars!=null&&springjars.length>0)
        	{Arrays.sort(springjars);
	        System.out.println( "getAbsolutePath;"+libDir.toURI().toURL()+"../plugins/springcxf/lib");
	        for (int i = 0; i < springjars.length; i++) {
	            if (springjars[i].isFile()) {
	                addURL(springjars[i].toURI().toURL());
	                System.out.println("change:"+springjars[i].toURI().toURL());
	            }
	        }
        }
        File[] jars = libDir.listFiles(new FilenameFilter() {
        	@Override
            public boolean accept(File dir, String name) {
                boolean accept = false;
                String smallName = name.toLowerCase();
                if (smallName.endsWith(".jar")) {
                    accept = true;
                }
                else if (smallName.endsWith(".zip")) {
                    accept = true;
                   //过滤掉文件夹.//但是只能是一层.
                }else if (dir!=null&&dir.isDirectory()&&dir.exists()){
                	accept=true;
                }
                return accept;
            }
        });
        // Do nothing if no jar or zip files were found
        if (jars == null) {
            return;
        }
    
        // sort jars otherwise order differs between installations (e.g. it's not alphabetical)
        // order may matter if trying to patch an install by adding patch jar to lib folder
        Arrays.sort(jars);
        for (int i = 0; i < jars.length; i++) {
            if (jars[i].isFile()) {
                addURL(jars[i].toURI().toURL());
                System.out.println("ssssssssssssssssssssssssssss:"+jars[i].toURI().toURL());
                // 此处为修改的地方.
            }else if (jars[i]!=null&&jars[i].isDirectory()){
            	// 添加自定义的lib库
            	File[] list=jars[i].listFiles();
            		for (int j = 0; j < list.length; j++) {
            			 addURL(list[j].toURI().toURL());
            			 System.out.println("mmmmmmmmmmmmmmmmmmmmmmmmmmm:"+(list[j].toURI().toURL()));
				}	
            }
        }
    }
}
