import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;


public class Test {
	
	public void test0(){
		LocalObject l = new LocalObject();
		l.value = 1;
		test1(l);
		System.out.println(l.value);
	}
	
	public void test1(LocalObject l){
		l.value = 2;
	}
	
	public void test2(){
//		List<Integer> in = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
		List<String> in = new ArrayList<String>(Arrays.asList("ss","tt","sss","aaa"));
		Iterator<String>ite = in.iterator();
		while(ite.hasNext()) {
			if(ite.next().contains("ss")){
				ite.remove();
			}
		}
//		for (Integer integer : in) {
//			System.out.println(integer);
//		}
		for (String integer : in) {
			System.out.println(integer);
		}
	}
	
	public void test3(){
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "1");
		map.put(2, "2");
		map.put(3, "3");
		map.put(4, "4");
		Iterator<?> ite = map.entrySet().iterator();
		while (ite.hasNext()) {
			System.out.println(ite.next());
		}
	}

	public void testShiro(){
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		
		Subject subject = SecurityUtils.getSubject();
		
		UsernamePasswordToken token = new UsernamePasswordToken("shiro", "201314");
		
		try {
			subject.login(token);
		} catch (AuthenticationException e) {
			System.out.println("µÇÂ¼Ê§°Ü");
			e.printStackTrace();
		}
		System.out.println("µÇÂ¼³É¹¦");
	}
	
	
	public static void main(String[] args) {
		Test t = new Test();
		t.test3();
	}

}

class LocalObject{
	public int value;
}

abstract class TestMethod<E> implements List<E>{
	
}
