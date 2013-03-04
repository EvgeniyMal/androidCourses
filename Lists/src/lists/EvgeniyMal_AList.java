package lists;

import java.util.Iterator;

public class EvgeniyMal_AList implements IList {
    
    private int[] data;
    private int INIT_SIZE = 10; 
    private int position;
    private int pos = 0;
    
    public EvgeniyMal_AList() {
	data = new int[INIT_SIZE];
	position = 0;
    }

    @Override
    public int size() {
	return position;
    }

    @Override
    public void addEnd(int el) {
	this.addPos(position, el);	
    }

    @Override
    public void addStart(int el) {
	this.addPos(0, el);
    }

    @Override
    public void addPos(int pos, int el) {
	if (pos < 0 || pos > position) {
	    throw new IndexOutOfBoundsException();
	}
	if (position == INIT_SIZE) {
	    int[] temp = new int[INIT_SIZE];
	    System.arraycopy(data, 0, temp, 0, position);
	    INIT_SIZE *=2;
	    data = new int[INIT_SIZE];
	    System.arraycopy(temp, 0, data, 0, position);
	}
	for (int i = position; i>pos; i--) {
	    data[i] = data[i-1];
	}
	data[pos] = el;
	position++;	
    }

    @Override
    public void delEnd() {
	this.delPos(position);	
    }

    @Override
    public void delStart() {
	this.delPos(0);
    }

    @Override
    public void delPos(int pos) {
	if (position == 0) {
	    throw new IndexOutOfBoundsException();
	}
	position--;
	for (int i=pos; i<position; i++) {
	    data[i] = data[i+1];
	}
    }

    @Override
    public void sort() {
	for (int i=0; i<position-1; i++) {
	    for (int j=i+1; j<position; j++) {
		if (data[i] > data[j]) {
		    int a = data[j];
		    data[j] = data[i];
		    data[i] = a;
		}
	    }
	}
    }

    @Override
    public void set(int pos, int el) {
	if (pos < 0 || pos >= position) {
	    throw new IndexOutOfBoundsException();
	}
	data[pos] = el;	
    }

    @Override
    public int get(int pos) {
	if (pos < 0 || pos >= position) {
	    throw new IndexOutOfBoundsException();
	}
	return data[pos];
    }

    @Override
    public void clear() {
	position = 0;
    }

    @Override
    public IList copy() {
    	EvgeniyMal_AList res = new EvgeniyMal_AList();
    	for (int i=0; i<position; i++) {
    		res.addEnd(data[i]);
    	}
    	return res;
    }
    
    public void init(int[] m) {
	data = new int[INIT_SIZE];
	System.arraycopy(m, 0, data, 0, m.length);
	position = m.length;
    }
    
    @Override
    public Iterator<Integer> iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public Integer next() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void remove() {
	// TODO Auto-generated method stub
	
    }

    @Override
    public int[] toArray() {
	return data;
    }
}
