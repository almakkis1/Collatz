import java.util.*;

public class main {

	public static void main(String[] args) {

		int num = 1000;
		
		double start = System.currentTimeMillis();
		SalehObj A = new SalehObj (num);
		
		double end = System.currentTimeMillis();
		double time = (end-start)/1000;
		
		System.out.println("Starting number, under " + num + ", that produces the longest chain is: " + A.getThreshold());
		System.out.println("The chain length of this threshold: " + A.getLength());
		System.out.println("Running time: " + time);
	}
	

}
