package model.factorymethod;
/**
 * 工厂方法模式是对简单工厂的进一步抽象
 * 
 * GoodPerson抽象类+IFactory抽象工厂
 * 每个StudentFacotry和VolunteerFacotry都实现IFactory
 * Student和Volunteer继承GoodPerson抽象类
 * student和Volunteer的对象创建都在各自的工厂方法里面实现.
 * 符合了开-闭原则（对修改关闭对扩展开放）.
 * 
 * @author kui
 *
 */
public class MainTest {
	public static void main(String[] args) {
		//学生做好事的话
		IFactory factory =new StudentFactory();
		GoodPerson student=factory.createGoodPerson();
		student.dasao();
		//志愿者做好事的话
		GoodPerson voPerson=new VolubteerFactory().createGoodPerson();
		voPerson.dasao();
	}
}
