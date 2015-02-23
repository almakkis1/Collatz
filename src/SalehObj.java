import java.util.*;

public class SalehObj implements java.util.Iterator<Integer>{
	private int startingNum;
	private int chainLength;
	private int itr;
	private ArrayList<Integer> list = new ArrayList<Integer>();
	
	SalehObj(int threshold){
		this.startingNum = 0;
		this.chainLength = 0;
		this.itr=0;
		findLongest(threshold);
		generateChainElements();
	}
	
	private void findLongest(int threshold){
		
		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp.add(0);
		for (int num=1; num <threshold ; num++){
			
			int length=1;
			double result=num;
			
			while(result > 1){

				if (result%2==0.0)
					result = result/2;
				else
					result = 3 * result + 1;

				if (result < num){
					length = length + temp.get((int)result);
				}
				else
					length++;
			}
			
			temp.add(length);
			if(length > this.chainLength){
				this.chainLength = length;
				this.startingNum = num;
			}
		}	
	}
	
	private void generateChainElements(){
		double result= (int)this.startingNum;
		this.list.add((int)result);
		while(result > 1){
			if (result%2==0.0)
				result = result/2;
			else
				result = 3 * result + 1;
			
			this.list.add((int)result);
		}
	}
	
	public int getThreshold(){
		return this.startingNum;
	}
	public int getLength(){
		return this.chainLength;
	}

	@Override
	public boolean hasNext() {
		return itr < chainLength;
	}

	@Override
	public Integer next() {
		if (hasNext())
			return list.get(itr++);
		else
			throw new ArrayIndexOutOfBoundsException(itr);
	}
	
}
