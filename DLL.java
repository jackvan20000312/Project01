package edu.mtc.egr283.dll;

public class DLL<E> {

	private DLLNode<E> head;
	private DLLNode<E> tail;
	private int length;

	public DLL() {
		this.length = 0;
		this.head = new DLLNode<E>();
		this.tail = new DLLNode<E>();
		this.head.setNext(tail);
		this.tail.setPrevious(head);
	}// Ending bracket of constructor

	public int size() {
		return this.length;
	}// Ending bracket of constructor

	public E getDataAtPosition(int position) {
		return (this.find(position)).getNodeData();
	}// Ending bracket of method getNodeDataAt

	public void addAtHead(E newNodeData) {
		this.addAfter(this.head, new DLLNode<E>(null, newNodeData, null));
	}// Ending bracket of method addAtHead

	public void addAtTail(E newNodeData) {
		this.addAfter(this.tail.getPrevious(), new DLLNode<E>(null, newNodeData, null));
	}// Ending bracket of method addAtTail

	public void add(E newNodeData, int position) {
		DLLNode<E> cursor = this.head;
		DLLNode<E> newNode = new DLLNode<E>(null, newNodeData, null);

		if(position > 0) {
			cursor = this.find(position - 1);
		}// Ending bracket of if

		this.addAfter(cursor, newNode);
	}// Ending bracket of method add

	public E remove(int position) {
		DLLNode<E> cursor = this.head;
		if(position > 0) {
			cursor = this.find(position - 1);
		}// Ending bracket of if

		DLLNode<E> target = cursor.getNext();
		(target.getPrevious()).setNext(target.getNext());
		(target.getNext()).setPrevious(target.getPrevious());
		--this.length;

		E rv = target.getNodeData();

		target.setNext(null);
		target.setNodeData(null);
		target.setPrevious(null);
		return rv;

	}// Ending bracket of method remove

	public E removeData(E target) {
		return this.remove(this.findIndex(target));
	}// Ending bracket of method removeData

	public void setData(E newNodeData, int position) {
		(this.find(position)).setNodeData(newNodeData);
	}// Ending bracket of method setData

	private void addAfter(DLLNode<E> cursor, DLLNode<E> newNode) {
		newNode.setNext(cursor.getNext());
		cursor.setNext(newNode);
		newNode.setPrevious(cursor);
		(newNode.getNext()).setPrevious(newNode);
		++this.length;
	}// Ending bracket of method addAfter

	private DLLNode<E> findData(E target) {
		DLLNode<E> cursor = this.head.getNext();

		while((cursor != tail) && (!(cursor.getNodeData().equals(target)))) {
			cursor = cursor.getNext();
		}// Ending bracket of while loop

		return cursor;
	}// Ending bracket of method findData

	private int findIndex(E target) {
		int index = 0;

		DLLNode<E> cursor = this.head.getNext();

		while((cursor != tail) && (!(cursor.getNodeData().equals(target)))) {
			cursor = cursor.getNext();
			++index;
		}// Ending bracket of while loop

		if(!(cursor.getNodeData().equals(target))) {
			index = -1;
		}// Ending bracket of if

		return index;
	}// Ending bracket of method findIndex

	private DLLNode<E> find(int position) {
		DLLNode<E> cursor = null;
		if(position < (this.size()/2)) {
			cursor = this.head.getNext();
			for(int i = 0; i != position; ++i) {
				cursor = cursor.getNext();
			}// Ending bracket of for loop
		} else {
			cursor = this.tail.getPrevious();
			for(int i = this.size() - 1; i != position; --i) {
				cursor = cursor.getPrevious();
			}// Ending bracket of for loop
		}// Ending bracket of if

		return cursor;
	}// Ending bracket of method find

}// Ending bracket of class DLL


