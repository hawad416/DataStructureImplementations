// IMPLEMENTING A STACK DATA STRUCTURE FROM SCRATCH USING A LIST AS THE UNDERLYING STRUCTURE
import java.util.*;

public class BasicStack<X> {

	List<X> data;
	private int stackPointer;
	
	public BasicStack() {
		data = new ArrayList<X>();
		stackPointer = 0;
		
	}
	
	public void push(X newItem) {
		data.add(newItem);

	
	}
	
	public X pop() {
		
		if(data == null || data.size() == 0){
			throw new IllegalStateException("No more items on the stack");
		}
		return data.remove(data.size()-1);
	
	}
	
	
	public boolean contains(X item) {
		
		if(data == null || data.size()==0) {
			throw new IllegalStateException("Stack is empty!");
		}
		
		for(int i = data.size() -1; i >=0; i--) {
			if(data.get(i) == item) {
				return true;
			}
		}
		throw new IllegalArgumentException("Item not found on stack");
	}
	
	public X access(X item) {
		
		if(data == null || data.size()==0) {
			throw new IllegalStateException("Stack is empty!");
		}else {
			for(int i = data.size()-1; i >=0; i--) {
				if(data.get(i) == item) {
					return item;
				}
			}
			throw new IllegalArgumentException("Could not find item on stack");
		}
	}
	
	public int size() {
		return data.size();
	}
	
	public String toString() {
		
		String sentence = "[" + data.get(0);
		
		for(int i = 1; i < data.size(); i++) {
			sentence+= ", " + data.get(i);
		}
		
		sentence+="]";
		return sentence;
	}
}
