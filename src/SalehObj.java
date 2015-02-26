import java.util.*;

public class SalehObj implements java.util.Iterator<Integer>{

	private int itr;         //iterator for hasNext() and next() methods
	private ArrayList<Integer> list = new ArrayList<Integer>(); //list to hold longest chain elements
	
	
	SalehObj(int threshold){
	  //set up the values with 0
		this.itr=0;
		
		findLengths(threshold); //find length of all number chains under that threshold
		findLongest();  //find Longest chain
	}
	
	//this method is to find the length of each starting's number chain
	private void findLengths(int threshold){
	  
		this.list.add(0);//index 0 has length 0
		
		for (int num=1; num <threshold ; num++){
			int length=1;
			double nextElement=num;
			
			while(nextElement > 1){
			  //find the next element
				if (nextElement%2==0.0)
				  nextElement = nextElement/2;
				else
				  nextElement = 3 * nextElement + 1;

				//check if this result already computed
				if (nextElement < num){
					length = length + this.list.get((int)nextElement);
					break;//add the length and stop here, result=0 means break
				}
				else
					length++;
			}
			
			this.list.add(length);
			
		}	
		
	}
	
	//this method is to find the index that has the longest chain
	private void findLongest(){

	  int longest=0;
	  int startingNum=0;
    //   - indexes represent the starting numbers. 
    //   - elements represent the length value (NOT THE CHAIN, JUST LENGTH VALUE)
    while (hasNext())
    {
      int length = next();
      //if this is the longest, update data
      if( length> longest){
        startingNum = list.indexOf(length);
        longest = length;
      }
    }
    itr=0; //reset iterator for the new chain
    generateChainElements(startingNum); //generate elements for the longest chain
	}
	
	//this is the generator of the elements. longest chain is known
	private void generateChainElements(int startingNum){

	  //add the starting number first
	  this.list.clear();
		this.list.add(startingNum); 
		
		//calculate the other elements and add them to the list
		double nextElement= (int)startingNum;
		while(nextElement > 1){
			if (nextElement%2==0.0)
			  nextElement = nextElement/2;
			else
			  nextElement = 3 * nextElement + 1;
			
			this.list.add((int)nextElement);
		}
		
	}
	
	public Integer getStartingNumber(){
		return this.list.get(0);
	}
	public int getLength(){
		return this.list.size();
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
