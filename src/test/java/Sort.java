import java.util.Collections;


public class Sort {
	
	public int[] array = {4,5,8,9,1,3,2,7,6,10};
	
	public void quickSort(int[] array, int head, int tail){
		if(head > tail) return;
		int h = head,t = tail;
		while(head < tail){
			while(head < tail && array[head] < array[tail]){
				tail--;
			}
			if(head < tail)
				exchange(array, head, tail);
			
			while(head < tail && array[head] < array[tail]){
				head++;
			}
			if(head < tail)
				exchange(array, head, tail);
		}

		quickSort(array, h, head-1);
		quickSort(array, tail+1, t);
	}
	
	public void exchange(int[] arr, int i1, int i2){
		int temp = arr[i1];
		arr[i1] = arr[i2];
		arr[i2] = temp;
	}

	public static void main(String[] args) {
		Sort s = new Sort();
		s.quickSort(s.array, 0, s.array.length-1);
	}

}
