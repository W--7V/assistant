

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dao.MemberDao;
import entity.MemberInfo;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:spring/spring-context.xml"})

public class TestJunit {
//	@Autowired
	private MemberDao memberDao;
	
	private ClassPathXmlApplicationContext applicationContext;
	
	@Before
	public void setUp(){
//		System.out.println("11111111");
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/spring-context.xml");
//		System.out.println(applicationContext.getId());
		memberDao = (MemberDao) applicationContext.getBean("memberDao");
	}
	@Test
	public void test0(){
		MemberInfo m = memberDao.getEntity("4028808b61dcb05d0161dcb211490000");
		System.out.println(m.getName());
	}
}
