import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import system.CustomizeInterceotor;

public class TestApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"application.xml");
		CustomizeInterceotor customizeInterceotor = (CustomizeInterceotor) applicationContext
				.getBean("customeBean");
		System.out.println("test " + customizeInterceotor);
	}

}
