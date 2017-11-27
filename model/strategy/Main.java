package model.strategy;

/**
 * 策略模式：
 * 
 * 以上代码是基于策略模式和简单的工厂模式进行开发计算的，
 * 针对不同的算法进行了封装,这样不必每次添加新算法而导致更改原来
 * 的类.
 * 
 * @author kui
 *
 */
public class Main {
	public static void main(String[] args) {
		//默认价格
		Context context0=new Context("0");
		System.out.println(context0.price(100));
		//价格打八折
		Context context1=new Context("1");
		System.out.println(context1.price(100));
		//价格涨价一倍
		Context context2=new Context("2");
		System.out.println(context2.price(100));
	}
}
