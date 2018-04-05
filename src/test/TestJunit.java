package test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dao.MemberDao;
import dto.SearchDto;
import service.MemberService;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:/*.xml"})
public class TestJunit {
//	@Autowired
	private MemberService memberService;
	private ApplicationContext applicationContext;
	
	@Before
	public void setUp(){
//		System.out.println("11111111");
		applicationContext = new ClassPathXmlApplicationContext("classpath:/spring-*.xml");
		System.out.println(applicationContext.getId());
	}
	@Test
	public void test0(){
//		try {
//			memberService.page(new SearchDto());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		System.out.println("test");
	}
}
