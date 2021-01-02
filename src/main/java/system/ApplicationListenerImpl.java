package system;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationListenerImpl implements ApplicationListener<ApplicationEvent>{

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
//		System.out.println("init++++");
		System.out.println("start......");
//		System.out.println(event.getSource());
//		StackTraceElement[] stackElements = new Throwable().getStackTrace();
//		if(stackElements != null)
//		{
//			for(int i = 0; i < stackElements.length; i++)
//			{
//				System.out.println(""+ stackElements[i]);
//			}
//		}
		System.out.println(this.getClass().getResource(""));
	}
}
