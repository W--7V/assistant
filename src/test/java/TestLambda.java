

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.Predicate;

public class TestLambda {
	public static int sumAll(List<Integer> numbers, Predicate<Integer> p){
		int total = 0;
		for(int number : numbers){
			if(p.test(number)){
				total += number;
			}
		}
		System.out.println(total);
		return total;
	}
	
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
		
		TestLambda.sumAll(numbers, n -> true);
		TestLambda.sumAll(numbers, n -> n % 2 ==0);
		TestLambda.sumAll(numbers, n -> n > 3);
		
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
	}

}
