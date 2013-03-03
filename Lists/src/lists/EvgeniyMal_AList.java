package com.lists;

import java.util.Iterator;

import com.lists.interfaces.IList;

public class AList implements IList, Iterable<Integer>, Iterator<Integer> {
    
    private int[] data;
    private int INIT_SIZE = 10; 
    private int position;
    private int pos = 0;
    
    public AList() {
	data = new int[INIT_SIZE];
	position = 0;
    }

    @Override
    public int size() {
	return position;
    }

    @Override
    public void addEnd(int el) {
	this.add(position, el);	
    }

    @Override
    public void addStart(int el) {
	this.add(0, el);
    }

    @Override
    public void add(int pos, int el) {
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
	this.del(position);	
    }

    @Override
    public void delStart() {
	this.del(0);
    }

    @Override
    public void del(int pos) {
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
	AList res = new AList();
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
