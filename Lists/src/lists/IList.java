package lists;

import java.util.Iterator;

public interface IList extends Iterable<Integer>, Iterator
{
    public void init(int[]initArray);
    public void addStart(int value);
    public void addEnd(int value);
    public void addPos(int position, int value);
    public void delStart();
    public void delEnd();
    public void delPos(int position);
    public void set(int position, int value);
    public int get(int position);
    public void clear();
    public int size();
    public void sort();
    public void revers();
    public IList copy();
    public int[]toArray();
}
