package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * �۲���ģʽ��������һ��һ�Զ��������ϵ���ö���۲��߶���ͬʱ����ĳһ���������
 * ������������״̬�����仯ʱ����֪ͨ���еĹ۲��߶���ʹ�������Զ��ĸ����Լ���
 * 
 * @author Jikey
 * @version
 * @className: Subject <br/>
 * @date: 2017-12-22 ����5:32:13 <br/>
 * @since JDK 1.7
 * 
 */
public abstract class Subject {
	
	private List<Observer> observers = new ArrayList<Observer>();
	
	/**
	 * 
	 * attach:(���ӹ۲���). <br/>
	 *
	 * @author Jikey
	 * @param observer
	 */
	public void attach(Observer observer){
		observers.add(observer);
	}
	/**
	 * 
	 * detach:(ɾ���۲���). <br/>
	 *
	 * @author Jikey
	 * @param observer
	 */
	public void detach(Observer observer){
		observers.remove(observer);
	}
	/**
	 * 
	 * notice:(֪ͨ). <br/>
	 *
	 * @author Jikey
	 */
	public void notice(){
		for (Observer o :observers) {
			o.update();
		}
	}
	
}
