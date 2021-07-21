//Implements linked list from scratch
public class BasicLinkedList<X> {
	private Node first;
	private Node last;
	private int nodeCount;
	
	public BasicLinkedList() {
		
		first = null;
		last = null;
		nodeCount = 0;
	}
	
	public void add(X item) {
		
		if(first==null) {
			first = new Node(item);
			last = first;
		}else {
			Node newLastNode = new Node(item);
			last.setNextNode(newLastNode);
			last = newLastNode;
		}
		nodeCount++;
	}
	
	public void insert(int index, X item) {
		
		if(index > nodeCount) {
			throw new IllegalArgumentException("Index Out of bounds");
		}
		
		Node currentNode = first;
		
		for(int i = 1; i < index && currentNode != null; i++) {
			currentNode = currentNode.getNextNode();
		}
		
		Node newNode = new Node(item);
		Node nextNode = currentNode.getNextNode();
		currentNode.setNextNode(newNode);
		newNode.setNextNode(nextNode);
		nodeCount++;
	}
	

	
	public X remove() {
		if(first==null) {
			throw new IllegalStateException("List Empty");
		}
		
		X nodeItem = first.getNodeItem();
		first = first.getNextNode();
		nodeCount--;
		return nodeItem;
	}
	public int size() {
		return nodeCount;
	}
	
	private class Node{
		private Node nextNode;
		private X nodeItem;
		
		public Node(X item) {
			this.nextNode = null;
			this.nodeItem = item;
		}

		public Node getNextNode() {
			return nextNode;
		}

		public void setNextNode(Node nextNode) {
			this.nextNode = nextNode;
		}

		public X getNodeItem() {
			return nodeItem;
		}

		public void setNodeItem(X nodeItem) {
			this.nodeItem = nodeItem;
		}
		
	}
}
