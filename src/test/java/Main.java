

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public Scanner console = new Scanner(System.in);
	public List<MoonCake> list = new ArrayList<MoonCake>();
	public int N;
	public int requirement;
	public double maxProfit;
	
	public Main(){
		this.N = console.nextInt();
		this.requirement = console.nextInt();
		for(int i=0;i < this.N;i++){
			MoonCake m = new MoonCake();
			m.stock = console.nextInt();
			this.list.add(m);
		}
		for(int i=0;i < this.N;i++){
			this.list.get(i).sellPrice = console.nextInt();
		}
	}
	
	public void getMaxProfit(){
		for(int i=0;i < this.N;i++){
			MoonCake m = this.list.get(i);
			m.price = 1.0*m.sellPrice/m.stock;
		}
		Collections.sort(list);
		for(int i=0;this.requirement != 0;i++){
			MoonCake m = this.list.get(i);
			if(this.requirement > m.stock){
				this.maxProfit += m.sellPrice;
				this.requirement -= m.stock;
			}else{
				this.maxProfit += m.price*this.requirement;
				this.requirement = 0;
			}
		}
		System.out.printf("%.2f",this.maxProfit);
	}

	public static void main(String[] args) {
		Main m = new Main();
		m.getMaxProfit();
	}
}

class MoonCake implements Comparable<MoonCake>{
	public int stock;
	public int sellPrice;
	public double price;
	@Override
	public int compareTo(MoonCake o) {
		if(this.price > o.price){
			return -1;
		}
		return 1;
	}
}