package model.proxy;
/**
 * ������
 * ʵ�ʾ��ǰ���ʵ����������,Ȼ���ô���ȥ�̳г����࣬
 * �ﵽ����������һ�µ�,Ȼ�������˽��ʵ��������Զ���.
 * Ȼ�����.
 * 
 * @author kui
 *
 */
public class Proxy extends Subject{
	private  RealSubject real;
	@Override
	public void request() {
		// TODO Auto-generated method stub
		if(real==null){
			real=new RealSubject();
		}
		real.request();
	}

}
