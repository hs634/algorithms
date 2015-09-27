package cSorting;

public class Heapsort {

	private int[] Heap;
	private int size = 0;
	
	public Heapsort(){
		Heap[0] = Integer.MIN_VALUE;
	}
	
	public int leftChild(int pos){
		return 2*pos;
	}
	
	public int rightChild(int pos){
		return 2*pos+1;
	}
	public int parent(int child){
		return child/2;
	}
	
    private void swap(int fpos, int spos)
    {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }
 
	public void bottomup(){
		
		for(int i=size/2; i >0; i--){
			minHeapify(i);
		}
	}

	private void minHeapify(int pos) {
		
		if(Heap[pos] > Heap[leftChild(pos)] || Heap[pos] > Heap[rightChild(pos)]){
			if(Heap[leftChild(pos)] < Heap[rightChild(pos)]){
				swap(leftChild(pos), pos);
				minHeapify(leftChild(pos));
			}else{
				swap(rightChild(pos), pos);
				minHeapify(rightChild(pos));
			}
		}
	}
	
	//heapify while inserting
	public void topdown(int element){
		Heap[++size] = element;
		int current = size;
		while(Heap[current] < Heap[parent(current)]){
			swap(current, parent(current));
			current = parent(current);
		}
	}
	
	public int sort(){
		swap(1,size);
		int remove = Heap[size--];
		return remove;
	}
	
}
