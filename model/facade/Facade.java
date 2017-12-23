package facade;
/**
 * 
 * ���ģʽ��Ϊ��ϵͳ�е�һ��ӿ��ṩһ��һ�µĽ��棬��ģʽ������һ���߲�Ľӿڣ�
 * ����ӿ�ʹ����һ��ϵͳ��������ʹ�á�
 * 
 * �ŵ㣺
 * ��1��ʵ������ϵͳ��ͻ���֮�������Ϲ�ϵ��
 * ��2���ͻ�����������ϵͳ����������˿ͻ������账��Ķ�����Ŀ����ʹ����ϵͳʹ�������������ס�
 * 
 * ����������¿��Կ���ʹ�����ģʽ��
 *  (1)��Ƴ��ڽ׶Σ�Ӧ������ʶ�Ľ���ͬ����룬�����֮�佨�����ģʽ��
 *  (2) �����׶Σ���ϵͳԽ��Խ���ӣ��������ģʽ�ṩһ���򵥵ĵ��ýӿڡ�
 *  (3) ά��һ����������ϵͳ��ʱ�򣬿������ϵͳ�Ѿ��ǳ�����ά������չ�����ְ����ǳ���Ҫ�Ĺ��ܣ�Ϊ�俪��һ������࣬�Ա���ϵͳ���佻����
 * 
 * ƽʱд��service���dao�㣬service���ƾ���facade�࣬
 * ���кܶ�������dao�㡣dao���������������one,two,three,four�ȡ�
 * 
 * @author Jikey
 * @version 
 * @className: Facade <br/>
 * @date: 2017-12-22 ����5:10:37 <br/>
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
		System.out.println("-----������A------");
		one.methodOne();
		two.methodTwo();
		four.methodFour();
	}

	public void methodB() {
		System.out.println("------������B------");
		two.methodTwo();
		three.methodThree();
	}
}
