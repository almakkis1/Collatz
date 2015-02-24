import java.util.ArrayList;
import java.util.Iterator;

public class TianObj implements Iterator<Integer>{
	private int startNum;
	private int chainLength;
	private int itr;
	private ArrayList<Integer> list = new ArrayList<Integer>();
	
	public TianObj(int threshold){
		this.startNum = 0;
		this.chainLength = 0;
		itr = 0;
		findLongest(threshold);
		chainGenerator(this.startNum);
	}
	
	private void findLongest(int threshold){
		
		ArrayList<Integer> temp = new ArrayList<Integer>();
		int longestLength = 1;
		int value = 1;
		int searchStartNum = 1;
		if( threshold % 2 == 0){
		  searchStartNum = searchStartNum / 2 + 1;
		}
		else{
		  searchStartNum = (searchStartNum - 1) / 2;
		}
		for (int num = 1; num < threshold + 1; num++){
		  if( (num - 1) % 3 != 0){
			  temp = chainGenerator(num);
			  if(temp.size() > longestLength){
			    longestLength = temp.size();
			    value = num;
			  }
		  }
		}
		this.chainLength = longestLength;
		this.startNum = value;
	}
	
	private ArrayList<Integer> chainGenerator(int num){
		double tempNum = num;
		ArrayList<Integer> tempList = new ArrayList<Integer>();
		tempList.add(num);
		while(tempNum > 1){
			if (tempNum% 2 == 0.0){
				tempNum = tempNum / 2;
			}
			else{
				tempNum = 3 * tempNum + 1;
			}
			tempList.add((int) tempNum);
		}
		return tempList;
	}
	
	public int getThreshold(){
		return this.startNum;
	}
	public int getLength(){
		return this.chainLength;
	}
	
	public boolean hasNext() {
		return itr < chainLength - 1;
	}

	public Integer next() {
		if (hasNext())
			return list.get(itr++);
		else
			throw new ArrayIndexOutOfBoundsException(itr);
	}
	
}
