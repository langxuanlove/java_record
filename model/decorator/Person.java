package model.decorator;

/**
 * װ����ģʽ��
 * 
 * ʵ�ʾ����ڸ���ɵ���Ŀ��ʱ�򣬲�����ԭ�����࣬��������һ���ಢ�Ҽ̳�ԭ�࣬�ٰ�ԭ����Ϊ˽�б�����
 * ��ִ��ǰ��������ʱ�߼��ж�ʹ���ĸ��µ���ķ��������ϵķ��������Ͽ���ԭ��--�������࣬ͬʱ��չ�˾��ࡣ
 * 
 * @author kui
 *
 */
public class Person {
	private String name;
	/**
	 * �ο���http://blog.csdn.net/qq_35257397/article/details/52013299
	 * �����и��޲ι��췽������Ȼ�������̳и�����вι��췽��
	 * 
	 */
	public Person(){
		
	}
	public Person(String name) {
		this.name=name;
	}

	public void show() {
		System.out.println("Person ��show����:" + name);
	}
}
