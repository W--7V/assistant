
import util.MyClassLoader;

public class TestClassLoader {

	public static void main(String[] args) {
//		SecureClassLoader s = SecureClassLoader()
		MyClassLoader myClassLoader = new MyClassLoader();
		System.out.println(myClassLoader.getClass().getClassLoader());
	}

}
