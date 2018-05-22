import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


public class Test {
	
	public void test0(){
		localObject l = new localObject();
		l.value = 1;
		test1(l);
		System.out.println(l.value);
	}
	
	public void test1(localObject l){
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

	public static void main(String[] args) {
		Test t = new Test();
		t.test2();
	}

}

class localObject{
	public int value;
}
