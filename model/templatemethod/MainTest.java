package model.prototype;
/**
 * ���ڼ̳еĴ��븴�ü���.
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
