package eArrays;

public class Buffer {

	String[] buffer;
	int capacity;
	int size = 0;
	int front;
	int rear;
	
	public Buffer(int max_size){
		this.capacity = max_size;
		front = -1;
		rear = -1;
		buffer = new String[max_size];
	}
	
	
	public boolean isEmpty(){
		return (front == -1);
	}
	
	public boolean isFull(){
		return (rear + 1) % capacity == front;
	}
	
	
	public void append(String data){
	
		if(isFull()){
			
		}else{
			rear = (rear+1)% capacity;
			buffer[rear] = data;
			if(front == -1)
				front = rear;
		}
	}
	
	public void remove(){
		assert(!isEmpty());
		if(front == rear)
			front = rear -1;
		else
			front = (front +1 )%capacity;
		
	}
	
	public void print(int n){
		int begin = front;
		int pos = begin;
		int i =0;
		while(i< size){
			System.out.println(buffer[pos]);
			i++;
			begin++;
			pos = begin % capacity;
		}
	}
}
