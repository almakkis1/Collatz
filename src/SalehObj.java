import java.util.*;

public class SalehObj implements java.util.Iterator<Integer>{
	private int startingNum; //starting number of the longest chain
	private int chainLength; //length of the longest chain
	private int itr;         //iterator for hasNext() and next() methods
	private ArrayList<Integer> list = new ArrayList<Integer>(); //list to hold longest chain elements
	
	
	SalehObj(int threshold){
	  //set up the values with 0
		this.startingNum = 0;
		this.chainLength = 0;
		this.itr=0;
		//find longest chain and generate its elements
		findLongest(threshold);
		generateChainElements();
	}
	
	//this method is to search for the starting number that can generate the longest chain
	private void findLongest(int threshold){
	  
		this.list.add(0);
		
		for (int num=1; num <threshold ; num++){
			int length=1;
			double result=num;
			
			while(result > 1){
			  //find the next element
				if (result%2==0.0)
					result = result/2;
				else
					result = 3 * result + 1;

				//check if this result already computed
				if (result < num){
					length = length + this.list.get((int)result);
					result=0;//add the length and stop here, result=0 means break
				}
				else
					length++;
			}
			
			this.list.add(length);
			
		}	
		
	}
	
	//this is the generator of the elements. longest chain is known
	private void generateChainElements(){
	  //search for the longest chain
	  //   - indexes represent the starting numbers. 
    //   - elements represent the length value (NOT THE CHAIN, JUST LENGTH VALUE)
	  while (hasNext())
	  {
	    int length = next();
      //if this is the longest, update data
      if( length> this.chainLength){
        this.chainLength = length;
        this.startingNum = list.indexOf(length);
      }
	  }
    
	  //add the starting number first
	  this.list.clear();
		this.list.add(this.startingNum); 
		
		//calculate the other elements and add them to the list
		double result= (int)this.startingNum;
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
		return itr < list.size()-1;
	}

	@Override
	public Integer next() {
		if (hasNext())
			return list.get(itr++);
		else
			throw new ArrayIndexOutOfBoundsException(itr);
	}
	
}
