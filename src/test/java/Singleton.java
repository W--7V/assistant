
public class Singleton {
	
	private static Singleton singleInstance;
	
	private Singleton(){
	}
	
	private static Singleton getInstance(){
		if(singleInstance == null){
			singleInstance = new Singleton();
		}
		return singleInstance;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
