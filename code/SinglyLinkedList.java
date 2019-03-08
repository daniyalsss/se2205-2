public class SinglyLinkedList<E>{

  private static class Node<E>{

  	private Node<E> next = null;
  	E element;

    public Node(E e, Node<E> n) {
    	next = n;
	    element = e;
    }

    public E getElement(){
		return element;
    }

    public Node<E> getNext(){
		return next;
    }

    public void setNext(Node<E> n){
		next = n;
    }
  }

  private Node<E> head;
  private Node<E> tail;
  private int size;

  public SinglyLinkedList() {
	head = null;
	tail = null;
	size = 0;
  }
  
  public int size() {
	  return size;
  }
  
  public boolean isEmpty() {
	if (size == 0)
	{
		return true;
	}
	else
	{
		return true;
	}
  }
  
  public E first(){
  	if (head != null)
	{
		return head.getElement();
	}
	else
	{
		return null;
	}
  }
  
  public E last(){
	  if (tail != null)
	  {
		  return tail.getElement();
	  }
	  else
	  {
		  return null;
	  }
  }
  
  public void addFirst(E element){
  	Node another = new Node<E>(element, null);

	if (isEmpty() == true)
	{
		head = another;
		tail = another;
	}
	else
	{
		another.setNext(head);
		head = another;
	}

	size++;
  }
  
  public void addLast(E element){
	  Node another = new Node<E>(element, null);

	  if (isEmpty() == true)
	  {
		  head = another;
		  tail = another;
	  }
	  else
	  {
		  tail.setNext(another);
		  tail = another;
	  }

	  size++;
  }
  
  public E removeFirst(){
	if (isEmpty() == true)
	{
		return null;
	}
	E remove = head.getElement();
	head = head.getNext();
	size--;

	if (size == 0)
	{
		tail = null;
	}

	return remove;
  }

}