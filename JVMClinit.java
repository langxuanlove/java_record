package snsoft.cargo.ui;

public class JVMClinit
{
	//虚拟机加载类的过程： 加载 验证 准备 解析 初始化 使用 卸载 ;准备阶段已经给变量赋初始值，
	//根据关键字final决定是赋初值0还是实际值2.(参考来源于jvm原理，7.3.4准备和7.3.5初始化)
	//实际初始化过程就是执行clinit()方法的过程.
	//clinit()方法是由编译器自动收集类中的所有变量的赋值动作和静态语句块(static{})中的语句产生的,
	//编译收集器的顺序是由语句在原文件中出现的顺序决定的，静态语句块只能访问到定义静态语句块之前的变量，定义
	//在它之后的变量，在前面的静态语句块可以赋值，但是不能访问。
	//clinit()方法与类的构造函数（或者说实例构造器init()方法）不同,他不需要显示地调用父类构造器，
	//虚拟机会保证在子类的clinit（）方法执行之前,父类的clinit（）已经执行完毕.因此虚拟机中第一个被执行的
	//对象一定是java.lang.Object。
	//由于父类的clinit()方法先执行,也就意味着父类中定义的静态语句块要优先于子类的变量赋值操作.
	//接口中不能使用静态语句块，但仍然有变量的初始化赋值，因此接口与类都一样
	//都会生成clinit（）方法,但接口与类不同的是，执行接口的clinit()方法不需要先执行父接口的clinit(）
	//方法.只有当父接口中定义的变量使用时，父接口才会初始化.另外接口的实现类在初始化时也一样不会执行接口的clinit()方法
	//虚拟机会保证一个类的clinit（）方法在多线程下被正确的加锁，同步,如果多个线程同时去初始化一个类,那么只会有
	//一个线程去执行这个类的clinit()方法,其他线程都需要阻塞等待,直到活动线程执行clinit（）方法完毕为止.
	
	static   int a=2;// 此情况发生在准备阶段并且赋值初值是0，
					 // 执行完clinit()中的putstatic的指令方法后再赋值a=2.
//	static final  int a=2;// 此情况发生在准备阶段并且直接赋值初值是2.
	
	static{
		a=1;
		System.out.println("一.this is static method !");
	}
//	static{
//		if(true){
//			System.out.println("this is if .");
//			while(true){
//				
//			}
//		}
//	}
	public TestPay(){
		System.out.println("二.this is TestPay .");
		System.out.println(a);
		System.out.println("三.this is TestPay .");
	}
	public static void main(String[] args)
	{
		TestPay pay=new TestPay();
		System.out.println(TestPay.a);
//		Runnable runnable=new Runnable()
//		{
//			@Override
//			public void run()
//			{
//				System.out.println("start ..");
//				TestPay pay=new TestPay();
//				System.out.println("end ...");
//			}
//		};
//		Thread thread=new Thread(runnable);
//		Thread thread1=new Thread(runnable);
//		thread.start();
//		thread1.start();
		
	}
}
