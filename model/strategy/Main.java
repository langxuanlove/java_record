package model.strategy;

/**
 * ����ģʽ��
 * 
 * ���ϴ����ǻ��ڲ���ģʽ�ͼ򵥵Ĺ���ģʽ���п�������ģ�
 * ��Բ�ͬ���㷨�����˷�װ,��������ÿ��������㷨�����¸���ԭ��
 * ����.
 * 
 * @author kui
 *
 */
public class Main {
	public static void main(String[] args) {
		//Ĭ�ϼ۸�
		Context context0=new Context("0");
		System.out.println(context0.price(100));
		//�۸�����
		Context context1=new Context("1");
		System.out.println(context1.price(100));
		//�۸��Ǽ�һ��
		Context context2=new Context("2");
		System.out.println(context2.price(100));
	}
}
