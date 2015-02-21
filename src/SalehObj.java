import java.util.LinkedList;

public class SalehObj implements java.util.Iterator<Integer>{
	
	private int length=0;
	private int threshold=0;
	private int itr=-1;
	private LinkedList<Integer> list = new LinkedList<Integer>();
	
	SalehObj(int num){
		threshold = num;
		generate(num);
	}
	
	private void generate(int num){
		double result=num;
		
		while(result > 1){
			if (result%2==0)
				result = result/2;
			else
				result = 3 * result + 1;
			list.add((int)result);
			length++;
		}
		
	}
	
	public int getThreshold(){
		return length;
	}
	public int getLength(){
		return length;
	}

	@Override
	public boolean hasNext() {
		return itr <= length;
	}

	@Override
	public Integer next() {
		if (itr >= length)
			throw new ArrayIndexOutOfBoundsException(itr);
		else
			return list.get(++itr);
		
	}
	
}
