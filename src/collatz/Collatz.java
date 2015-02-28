package collatz;
import java.util.ArrayList;

public class Collatz implements java.util.Iterator<Integer>{
  private int threshold;
  private int startingNum;
  private int itr;         //iterator for hasNext() and next() methods
  private ArrayList<Integer> list; //list to hold longest chain elements
  
  
  public Collatz(int threshold){
    //set up the values
    this.startingNum = 0;
    this.itr=0;
    this.list = new ArrayList<Integer>();
    this.threshold = threshold;
  }
  
  public void run(){
      findLengths();    //find length of all number chains under that threshold
      findStartingNum();    //find starting number that can generate Longest chain
      generateChainElements(); //generate elements for the longest chain
  }
  
  //this method is to find the chain length of each starting number
  //   - indexes represent the starting numbers. 
  //   - elements represent the length value (NOT THE CHAIN, JUST LENGTH VALUE)
  private void findLengths(){
    list.add(0);//index 0 has length 0
    
    for (int num=1; num <threshold ; num++){
      int length=1;
      
      long nextElement=num;
      while(nextElement > 1){
        //find the next element
        if (nextElement%2==0)
          nextElement = nextElement/2;
        else
          nextElement = 3 * nextElement + 1;

        //check if this result already computed
        if (nextElement < num){
          length = length + list.get((int)nextElement);
          break;//add the length and stop here
        }
        else
          length++;
      }
      
      list.add(length);
      
    } 
    
  }
   
  //this method is to find the index (index=starting number) that has the longest chain
  private void findStartingNum(){

    int longest=0;
    //   - indexes represent the starting numbers. 
    //   - elements represent the length value (NOT THE CHAIN, JUST LENGTH VALUE)
    while (hasNext()){
      int length = next();
      //if this is the longest, update data
      if( length> longest){
        startingNum = list.indexOf(length);
        longest = length;
      }
    }
    itr=0; //reset iterator for the new chain
    
  }
  
  //this is the generator of the elements. longest chain is known
  private void generateChainElements(){

    //add the starting number first
    list.clear();
    list.add(startingNum); 
    
    //calculate the other elements and add them to the list
    long nextElement= startingNum;
    while(nextElement > 1){
      if (nextElement%2==0)
        nextElement = nextElement/2;
      else
        nextElement = 3 * nextElement + 1;
      
      list.add((int)nextElement);
    }
    
  }
  
  public int getThreshold(){
    return this.threshold;
  }
  
  public int getStartingNumber(){
    return this.startingNum;
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
