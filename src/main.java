import java.util.*;

public class main {

	public static void main(String[] args) {
		int num = 10;
		
		double start = System.currentTimeMillis();
		
		// you only need to change this line to your class name to test your code.. my class name is SalehObj
		SalehObj A = new SalehObj (num);
		
		double end = System.currentTimeMillis();
		double time = (end-start)/1000;		
		
		System.out.println("The starting number: " + A.getThreshold());
		System.out.println("Chain length: " + A.getLength());
		System.out.println("Running time: " + time);
		
		
	}
	

}
