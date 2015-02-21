import java.util.*;

public class main {

	public static void main(String[] args) {
		HashMap<Integer, Iterator<Integer>> hash = new HashMap<Integer, Iterator<Integer>>();
		
		int threshold=0;
		int longestChain=0;
		int range = 1000000;
		
		double start = System.currentTimeMillis();
		for (int i=2; i<= range; i++){
			Collatz A = new Collatz(i);
			
			if (A.getLength() > longestChain){
				longestChain = A.getLength();
				threshold = i;
			}
		}	
		double end = System.currentTimeMillis();
		double time = (end-start)/1000;
		
		System.out.println("Starting number, under " + range/1000000 + " million, that produces the longest chain: " + threshold);
		System.out.println("The chain length of this threshold: " + longestChain);
		System.out.println("Running time: " + time);
	}
	

}
