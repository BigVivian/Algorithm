package spring.proxy.cglibProxy;

import net.sf.cglib.proxy.Enhancer;

public class Test {
	public static void main(String[] args) {
		Enhancer enhancer = new Enhancer();

		enhancer.setSuperclass(HelloWorld.class);

		// 设置回调方法实现类
		enhancer.setCallback(new MethodInterceptorImpl());

		// 实例化已经添加回调实现的HelloWorld实例
		HelloWorld my = (HelloWorld) enhancer.create();

		my.print();

	}

}
