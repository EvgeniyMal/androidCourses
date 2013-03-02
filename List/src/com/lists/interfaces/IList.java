package com.lists.interfaces;


public interface IList {
    
    public int size();
    
    public void addEnd(int el);
    public void addStart(int el);
    public void add(int position, int el);
    
    public void delEnd();
    public void delStart();
    public void del(int position);
    
    public void sort();
    
    public void set(int position, int el);
    public int get(int position);
    
    public void clear();
    public IList copy();
    
    public void init(int[] data);
    public String toString();
    public int[] toArray();
}
