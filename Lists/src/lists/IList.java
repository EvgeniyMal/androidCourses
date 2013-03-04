package lists;

import java.util.Iterator;

public interface IList extends Iterable<Integer>, Iterator
{
    public void init(int[]initArray);
    public void addStart(int value);
    public void addEnd(int value);
    public void addPos(int position, int value) throws IndexOutOfBoundsException;
    public void delStart() throws IndexOutOfBoundsException;
    public void delEnd() throws IndexOutOfBoundsException;
    public void delPos(int position) throws IndexOutOfBoundsException;
    public void set(int position, int value) throws IndexOutOfBoundsException;
    public int get(int position) throws IndexOutOfBoundsException;
    public void clear();
    public int size();
    public void sort();
    public IList copy();
    public int[]toArray();
}
