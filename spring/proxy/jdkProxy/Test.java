package spring.proxy.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Test {

	public static void main(String args[]) {
		Class clazz = new HelloWorld().getClass();
		ClassLoader classLoader = clazz.getClassLoader();

		// interfaces
		Class[] interfaces = clazz.getInterfaces();

		InvocationHandler handler = new DefaultInvocationHandler();

		// 用InvocationHandler给HelloWorld进行AOP包装

		IHelloWorld ihw = (IHelloWorld) Proxy.newProxyInstance(classLoader,
				interfaces, handler);
		ihw.print("test");

		System.out.println("**********");

		ihw.write("test");
	}
}
