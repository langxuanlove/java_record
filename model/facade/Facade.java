package facade;
/**
 * 
 * 外观模式：为子系统中的一组接口提供一个一致的界面，此模式定义了一个高层的接口，
 * 这个接口使得这一子系统更加容易使用。
 * 
 * 优点：
 * （1）实现了子系统与客户端之间的松耦合关系。
 * （2）客户端屏蔽了子系统组件，减少了客户端所需处理的对象数目，并使得子系统使用起来更加容易。
 * 
 * 在以下情况下可以考虑使用外观模式：
 *  (1)设计初期阶段，应该有意识的将不同层分离，层与层之间建立外观模式。
 *  (2) 开发阶段，子系统越来越复杂，增加外观模式提供一个简单的调用接口。
 *  (3) 维护一个大型遗留系统的时候，可能这个系统已经非常难以维护和扩展，但又包含非常重要的功能，为其开发一个外观类，以便新系统与其交互。
 * 
 * 平时写的service层和dao层，service类似就是facade类，
 * 其中很多依赖了dao层。dao层的类就是如下面的one,two,three,four等。
 * 
 * @author Jikey
 * @version 
 * @className: Facade <br/>
 * @date: 2017-12-22 下午5:10:37 <br/>
 * @since JDK 1.7
 *
 */
public class Facade {
	SubSystemOne one;
	SubSystemTwo two;
	SubSystemThree three;
	SubSystemFour four;

	
	public Facade() {
		one=new SubSystemOne();
		two=new SubSystemTwo();
		three=new SubSystemThree();
		four=new SubSystemFour();
	}

	public void methodA() {
		System.out.println("-----方法组A------");
		one.methodOne();
		two.methodTwo();
		four.methodFour();
	}

	public void methodB() {
		System.out.println("------方法组B------");
		two.methodTwo();
		three.methodThree();
	}
}
