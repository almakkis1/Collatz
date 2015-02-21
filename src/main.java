import java.util.*;

public class main {

	public static void main(String[] args) {
		int num = 9;
		
		double start = System.currentTimeMillis();
		
		/***** you only need to change this line to your class name to test your code.. my class name is SalehObj**/
		SalehObj A = new SalehObj (num);
		
		double end = System.currentTimeMillis();
		double time = (end-start)/1000;
		
		
		System.out.println("The starting number, under " + num + ", of longest chain produced is: " + A.getLength());
		System.out.println("Chain length of this number is: " + A.getThreshold());
		System.out.println("Running time: " + time);
	}
	

}
