package model.proxy;
/**
 * 代理类
 * 实际就是把真实的类抽象出来,然后用代理去继承抽象类，
 * 达到方法名都是一致的,然后代理类私有实际类的属性对象.
 * 然后调用.
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
