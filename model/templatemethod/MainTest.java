package model.prototype;
/**
 * 基于继承的代码复用技术.
 * 
 * @author kui
 *
 */
public class MainTest {
	public static void main(String[] args) {
		AbstractClass abstractClass;
		abstractClass = new ConCreteClassA();
		abstractClass.templatedMethod();
		abstractClass = new ConCreteClassB();
		abstractClass.templatedMethod();
	}
}
