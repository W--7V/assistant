

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import service.MemberService;
import dao.MemberDao;
import dao.TaskDao;
import entity.MemberInfo;
import entity.Task;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-context.xml"})

public class TestJunit {
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	TaskDao taskDao;
	
	@Autowired
	private MemberService memberService;
	
	private ClassPathXmlApplicationContext applicationContext;
	
	@Before
	public void setUp(){
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		System.out.println(loader.getResource("").getPath());
//		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/spring-context.xml");
//		System.out.println(applicationContext.getId());
//		memberDao = (MemberDao) applicationContext.getBean("memberDao");
		XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("application.xml"));
		System.out.println(xmlBeanFactory);
		Object o = xmlBeanFactory.getBean("customeBean");
		System.out.println(memberDao);
	}
	@Test
	public void test0(){
//		MemberInfo m = memberDao.getEntity("4028808b61dcb05d0161dcb211490000");
//		System.out.println(m.getName());
		try {
//			memberService.testDelete();
//			taskDao.saveEntity(new Task());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
