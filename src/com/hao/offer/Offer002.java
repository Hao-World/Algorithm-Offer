package com.hao.offer;

/**
 * 实现单例模式
 * 
 * @author hao
 *
 */
public class Offer002 {
	public static void main(String[] args) {

	}
}




/**
 * 利用枚举实现单例模式
 * 
 * @author hao
 *
 */
class Singleton1 {
	// 私有化构造方法
	private Singleton1() {
		System.out.println("调用了构造方法");
	}

	public static Singleton1 getInstance() {
		return SingleEnum.INSTANCE.getInstance();
	}

	// 创建枚举
	private static enum SingleEnum {
		INSTANCE;
		private Singleton1 instance;

		private SingleEnum() {
			instance = new Singleton1();
		}

		private Singleton1 getInstance() {
			return instance;
		}
	}
}


/**
 * 利用双重检测锁机制
 * @author hao
 *
 */
class Singleton2{
	//私有化构造方法
	private Singleton2() {System.out.println("调用了构造方法");}
	private volatile static Singleton2 instance;
	public static Singleton2 getInstance() {
		
		if(instance!=null) {
			synchronized(Singleton2.class){
				if(instance!=null) {
					instance = new Singleton2();
				}
			}
		}
		return instance;
	}
}

/**
 * 利用成员内部类的方式
 * @author hao
 *
 */
class Singleton3{
	//私有化构造方法
	private Singleton3(){System.out.println("调用构造方法");}
	private static Singleton3 getInstance() {
		return SingleHandler.INSTANCE;
	}
	private static class SingleHandler{
		private static Singleton3 INSTANCE = new Singleton3();
	}
	
}

/**
 * 这里是测试接口中的修饰符
 * 
 * @author hao
 *
 */
interface USB {
	int a = 0;
	String str = "fsda";
	static double c = 2;
	public static final float i = 2.3f;

	// Illegal modifier for the interface method add; only public, abstract,
	// default, static and strictfp are permitted
	public abstract void add();

	static strictfp void run() {
	};

}
