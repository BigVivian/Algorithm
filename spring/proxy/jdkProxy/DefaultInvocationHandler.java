package spring.proxy.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DefaultInvocationHandler implements InvocationHandler {
	/**
	 * 替换外部class调用的方法 obj 外部已经已经包装好InvocationHandler的实例 method 外部方法 args 方法参数
	 */
	public Object invoke(Object obj, Method method, Object[] args)
			throws Throwable {
		String s1[] = { "kris" };
		String s2[] = { "anyone" };

		IHelloWorld ihw = new HelloWorld();
		System.out.println("start...");

		method.invoke(ihw, args);
		method.invoke(ihw, s1);

		Object o = method.invoke(ihw, s2);
		System.out.println("stop...");
		return o;
	}

}
