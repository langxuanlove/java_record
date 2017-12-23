package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 观察者模式：定义了一种一对多的依赖关系，让多个观察者对象同时监听某一个主题对象，
 * 这个主题对象在状态发生变化时，会通知所有的观察者对象，使他们能自动的更新自己。
 * 
 * @author Jikey
 * @version
 * @className: Subject <br/>
 * @date: 2017-12-22 下午5:32:13 <br/>
 * @since JDK 1.7
 * 
 */
public abstract class Subject {
	
	private List<Observer> observers = new ArrayList<Observer>();
	
	/**
	 * 
	 * attach:(增加观察者). <br/>
	 *
	 * @author Jikey
	 * @param observer
	 */
	public void attach(Observer observer){
		observers.add(observer);
	}
	/**
	 * 
	 * detach:(删除观察者). <br/>
	 *
	 * @author Jikey
	 * @param observer
	 */
	public void detach(Observer observer){
		observers.remove(observer);
	}
	/**
	 * 
	 * notice:(通知). <br/>
	 *
	 * @author Jikey
	 */
	public void notice(){
		for (Observer o :observers) {
			o.update();
		}
	}
	
}
