//Implementing a Queue Class Using array as Underlying Structure.
public class BasicQueue<X> {

	private X[] data;
	private int front;
	private int end;
	
	public BasicQueue() {
		this(1000);
	}
	public BasicQueue(int size) {
		this.front = -1;
		this.end = -1;
		data = (X[]) new Object[size];
	}
	
	public int size() {
		if(front == -1 && end == -1) {
			return 0;
		}else {
			return end - front + 1;
		}
	}
	
	public void enQue(X newItem) {
		if((end+1) % data.length == front) {
			throw new IllegalStateException("Queue is full");
		}
		else if(size() == 0) {
			front++;
			end++;
			data[end] = newItem;
			
		}else {
			end++;
			data[end] = newItem;
		}
	}
	
	public X deQue() {
		X item = null;
		
		if(size() == 0) {
			throw new IllegalStateException("Queue is Empty!");
		}else if(front == end) {
			item = data[front];
			front = -1;
			end = -1;
		}else {
			item = data[front];
			front++;
		}
		
		return item;
	}
	
	public boolean contains(X item) {
		boolean found = false;

		if(size() == 0) {
			throw new IllegalStateException("Queue is Empty!");
		}
		
		for(int i = front; i < end; i++) {
			if(data[i].equals(item)) {
				found = true; 
				break;
			}
		}
		
		return found;
		
	}
	
	public X access(int position) {

		if(size() == 0 || position > size()) {
			throw new IllegalStateException("Queue is Empty!");
		}
		
		int truIndex = 0;
		for(int i = front; i < end; i++) {
			if(truIndex == position) {
				return data[i];
			}
			truIndex++;
		}
		
		throw new IllegalArgumentException("Could not get item at position: " + position);
	}
	
}
