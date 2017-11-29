package model.decorator;

/**
 * 装饰者模式：
 * 
 * 实际就是在改造旧的项目的时候，不更改原来的类，而新增加一个类并且继承原类，再把原类作为私有变量，
 * 在执行前方法调用时逻辑判断使用哪个新的类的方法还是老的方法。符合开闭原则--不动旧类，同时扩展了旧类。
 * 
 * @author kui
 *
 */
public class Person {
	private String name;
	/**
	 * 参考：http://blog.csdn.net/qq_35257397/article/details/52013299
	 * 必须有个无参构造方法，不然子类必须继承父类的有参构造方法
	 * 
	 */
	public Person(){
		
	}
	public Person(String name) {
		this.name=name;
	}

	public void show() {
		System.out.println("Person 的show方法:" + name);
	}
}
