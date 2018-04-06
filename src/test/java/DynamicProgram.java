

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DynamicProgram {
	public Integer f = new Integer(0);
	public Map<Integer, Integer>map = new HashMap<Integer, Integer>();
	public Scanner console = new Scanner(System.in); 
	public DynamicProgram(){
		
	}
	
	public Integer Dynamic(Integer in){
		int value;
		if(in == 1){
			return 1;
		}else if(in == 2){
			return 2;
		}
		
		if(map.containsKey(in)){
			return map.get(in);
		}else {
			value = Dynamic(in-1)+Dynamic(in-2);
			return value;
		}
	}
	
	public static void main(String[] args){
		DynamicProgram d = new DynamicProgram();
		d.f = d.Dynamic(d.console.nextInt());
		System.out.println(d.f);
	}
}
