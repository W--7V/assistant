

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dao.MemberDao;
import entity.MemberInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-context.xml"})
public class TestJunit {
	@Autowired
	private MemberDao memberDao;
	
	@Before
	public void setUp(){
//		System.out.println("11111111");
//		applicationContext = new ClassPathXmlApplicationContext("classpath:/spring-*.xml");
//		System.out.println(applicationContext.getId());
	}
	@Test
	public void test0(){
		MemberInfo m = memberDao.getEntity("4028808b61dcb05d0161dcb211490000");
		System.out.println(m.getName());
	}
}
