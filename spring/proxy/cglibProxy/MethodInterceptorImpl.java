package spring.proxy.cglibProxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class MethodInterceptorImpl implements MethodInterceptor {

	@Override
	public Object intercept(Object obj, Method method, Object[] args,

	MethodProxy proxy) throws Throwable {

		System.out.println("******" + method);

		proxy.invokeSuper(obj, args);

		return null;

	}

}
