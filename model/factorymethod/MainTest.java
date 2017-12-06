package model.factorymethod;
/**
 * ��������ģʽ�ǶԼ򵥹����Ľ�һ������
 * 
 * GoodPerson������+IFactory���󹤳�
 * ÿ��StudentFacotry��VolunteerFacotry��ʵ��IFactory
 * Student��Volunteer�̳�GoodPerson������
 * student��Volunteer�Ķ��󴴽����ڸ��ԵĹ�����������ʵ��.
 * �����˿�-��ԭ�򣨶��޸Ĺرն���չ���ţ�.
 * 
 * @author kui
 *
 */
public class MainTest {
	public static void main(String[] args) {
		//ѧ�������µĻ�
		IFactory factory =new StudentFactory();
		GoodPerson student=factory.createGoodPerson();
		student.dasao();
		//־Ը�������µĻ�
		GoodPerson voPerson=new VolubteerFactory().createGoodPerson();
		voPerson.dasao();
	}
}
