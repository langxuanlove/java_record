package model.builder;
/**
 * ���԰ٶȰٿ�:
 * ������ģʽ�����ģʽ��һ�֣���һ�����Ӷ���Ĺ��������ı�ʾ���룬ʹ��ͬ���Ĺ������̿��Դ�����ͬ�ı�ʾ��
 * ʵ�÷�Χ
 * 1 ���������Ӷ�����㷨Ӧ�ö����ڸö������ɲ����Լ����ǵ�װ�䷽ʽʱ��
 * 2 ��������̱�����������Ķ����в�ͬ��ʾʱ��
 * ��ɫ
 * �����������ģʽ�У������¼�����ɫ��
 * 1 builder��Ϊ����һ����Ʒ����ĸ�������ָ������ӿڡ�
 * 2 ConcreteBuilder��ʵ��Builder�Ľӿ��Թ����װ��ò�Ʒ�ĸ������������岢��ȷ���������ı�ʾ��
 *   �� �ṩһ��������Ʒ�Ľӿڡ�
 * 3 Director������һ��ʹ��Builder�ӿڵĶ���
 * 4 Product����ʾ������ĸ��Ӷ���ConcreteBuilder�����ò�Ʒ���ڲ���ʾ����������װ����̣�����������ɲ������࣬
 *   ��������Щ����װ������ղ�Ʒ�Ľӿڡ�
 * @author kui
 *
 */
public class MainTest {
	public static void main(String[] args) {
		Director director=new Director();
		
		Builder builder1=new ConcreteBuilder1();
		director.construct(builder1);
		Product product1= builder1.getResult();
		product1.show();

		
		Builder builder2=new ConcreteBuilder2();
		director.construct(builder2);
		Product product2= builder2.getResult();
		product2.show();
		
	}
}
