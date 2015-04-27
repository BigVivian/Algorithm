package spring.proxy.jdkProxy;

public class HelloWorld implements IHelloWorld {

	public void print(String str) {
		System.out.println("HelloWorld " + str);
	}

	public void write(String str) {
		System.out.println("write " + str);
	}

}
