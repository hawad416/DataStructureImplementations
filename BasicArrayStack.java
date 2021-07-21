// IMPLEMENTING A STACK DATA STRUCTURE FROM SCRATCH USING AN ARRAY AS THE UNDERLYING STRUCTURE
import java.util.*;

public class BasicArrayStack<X> {

	private X [] data;
	private int stackPointer;
	
	public BasicStack() {
		ArrayList<X> data = new ArrayList<X>();
		stackPointer = 0;
		
	}
	
	public void push(X newItem) {
		data[stackPointer++] = newItem;
	
	}
	
	public X pop() {
		
		if(stackPointer == 0){
			throw new IllegalStateException("No more items on the stack");
		}
		return data[--stackPointer];
	}
	
	
	public boolean contains(X item) {
		
		boolean found = false;
		for(int i = 0; i < stackPointer; i++) {
			if(data[i] == item) {
				found = true;
				break;
			}
		}
		return found;
	}
	
	public X access(X item) {
		
		while(stackPointer > 0) {
			X tmpItem = pop();
			if(item.equals(tmpItem)) {
				return tmpItem;
			}
		}
		throw new IllegalArgumentException("Could not find item on stack");
	}
	
	public int size() {
		return stackPointer;
	}
	
	public String toString() {
		
		String sentence = "[" + data[0];
		
		for(int i = 1; i < stackPointer; i++) {
			sentence+= ", " + data[i];
		}
		
		sentence+="]";
		return sentence;
	}
}
