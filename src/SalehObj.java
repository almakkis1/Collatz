import java.util.*;

public class SalehObj implements java.util.Iterator<Integer>{
	
	private int longestChain;
	private int threshold;
	private int itr=-1;
	private ArrayList<Integer> list = new ArrayList<Integer>();
	//private HashMap<Integer, Integer> list = new HashMap<Integer, Integer>();
	
	SalehObj(int threshold){
		this.threshold = 0;
		this.longestChain = 0;
		generate(threshold);
	}
	
	private void generate(int threshold){
		for (int num=threshold; num >1 ; num--){
			ArrayList<Integer> currentList = new ArrayList<Integer>();

			double result=num;
			while(result > 1){
				
				if (list.indexOf(result) != -1){
					if (result == list.get(0))
						currentList.addAll(list);
					
					result = 0;
				}
				else
					currentList.add((int)result);
				
				
				if (result%2==0.0)
					result = result/2;
				else
					result = 3 * result + 1;
				
				
			}
	
			list = currentList;
		}
		
	}
	
	private void generate2(int threshold){
		for(int i=2; i<threshold; i++){
			LinkedList<Integer> currentList = new LinkedList<Integer>();
			currentList.add(i);
			double result=i;
			while(result > 1){
				if (result%2==0.0)
					result = result/2;
				else
					result = 3 * result + 1;
				
				currentList.add((int)result);
			}
			if (currentList.size() > longestChain){
				this.longestChain = currentList.size();
				this.threshold = i;
			}
		}
		
	}
	
	public int getThreshold(){
		return list.get(0);
	}
	public int getLength(){
		return list.size();
	}

	@Override
	public boolean hasNext() {
		return itr <= longestChain;
	}

	@Override
	public Integer next() {
		if (itr >= longestChain)
			throw new ArrayIndexOutOfBoundsException(itr);
		else
			return 3;
		
	}
	
}
