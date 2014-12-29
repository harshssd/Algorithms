package data_structures;

import java.util.ArrayList;

public class Heap<T> {

	private ArrayList<Comparable<T>> elements;
	
	public Heap() {
		elements = new ArrayList<Comparable<T>>();
		elements.add(null);
	}

	@SuppressWarnings("unchecked")
	public void insert(Comparable<T> value){
		
//		add the element at the last position
		elements.add(value);
		
//		percolate to the top
		int k = elements.size()-1;
		while(k>1){
			if(elements.get(k).compareTo((T) elements.get(k/2))>0){
				swap(elements, k, k/2);
				k/=2;
			}else{
				break;
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public Comparable<T> removeMax(){
		
		if(elements.size()==2) return elements.remove(1);
		else if(this.isEmpty()) return null;
		
//		return the top of the heap and swap it with the last element
		Comparable<T> max = elements.get(1);
		elements.set(1, elements.remove(elements.size()-1));
		
//		percolate to the bottom
		int k = 1;
		while(k*2+1<=elements.size()){
//			compare left child and right child, compare the parent with largest child if there's no
//			right child just compare with the left one
			int maxChild = (elements.size()==k*2+1)? k*2 :(elements.get(k*2).compareTo((T) elements.get(k*2+1))>0? k*2: k*2+1);
			swap(elements, k, maxChild);
			k = maxChild;
		}
		
		return max;
	}
	
	public boolean isEmpty(){
		return elements.size()<=1;
	}
	
	private void swap(ArrayList<Comparable<T>> array, int i, int j) {
		Comparable<T> temp = array.get(i);
		array.set(i, array.get(j));
		array.set(j, temp);
	}
	
}

