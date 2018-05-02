
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
		
	}

	public static void main(String[] args) {
		Test t = new Test();
		t.test0();
	}

}

class localObject{
	public int value;
}
