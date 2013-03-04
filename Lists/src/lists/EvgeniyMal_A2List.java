package lists;

import java.util.Iterator;

public class EvgeniyMal_A2List implements IList {

    private int[] data;
    private int INIT_SIZE = 10;
    private int startPosition, endPosition;

    public EvgeniyMal_A2List() {
	data = new int[INIT_SIZE];
	endPosition = INIT_SIZE / 2;
	startPosition = endPosition - 1;
    }

    @Override
    public int size() {
	return endPosition - startPosition - 1;
    }

    @Override
    public void addEnd(int el) {
	checkBounds(false);
	data[endPosition++] = el;
    }

    @Override
    public void addStart(int el) {
	checkBounds(true);
	data[startPosition--] = el;
    }

    @Override
    public void addPos(int pos, int el) {
	if (pos < startPosition || pos > endPosition) {
	    throw new IndexOutOfBoundsException();
	}
	if (pos < INIT_SIZE / 2) {
	    checkBounds(true);
	    for (int i = startPosition; i < pos; i++) {
		data[i] = data[i + 1];
	    }
	    startPosition--;
	} else {
	    checkBounds(false);
	    for (int i = endPosition; i > pos; i--) {
		data[i] = data[i - 1];
	    }
	    endPosition++;
	}
	data[pos] = el;
    }

    private void checkBounds(boolean isAddToStart) {
	if ((isAddToStart && startPosition == -1) || (!isAddToStart && endPosition == INIT_SIZE)) {
	    int[] temp = new int[size()];
	    int start = (startPosition == -1) ? 0 : startPosition;
	    int size = size();
	    System.arraycopy(data, start, temp, 0, size);
	    startPosition = INIT_SIZE - size / 2;
	    endPosition = startPosition + size;
	    INIT_SIZE *= 2;
	    data = new int[INIT_SIZE];
	    System.arraycopy(temp, 0, data, startPosition, size);
	    startPosition--;
	}
    }

    @Override
    public void delEnd() {
	if (size() == 0) {
	    throw new IndexOutOfBoundsException();
	}
	endPosition--;
    }

    @Override
    public void delStart() {
	if (size() == 0) {
	    throw new IndexOutOfBoundsException();
	}
	startPosition--;
    }

    @Override
    public void delPos(int pos) {
	if (pos <= startPosition || pos >= endPosition) {
	    throw new IndexOutOfBoundsException();
	}
	if (pos < INIT_SIZE / 2) {
	    for (int i = pos; i > startPosition; i--) {
		data[i] = data[i - 1];
	    }
	    startPosition++;
	} else {
	    for (int i = pos; i < endPosition; i++) {
		data[i] = data[i + 1];
	    }
	    endPosition--;
	}
    }

    @Override
    public void sort() {
	for (int i = startPosition + 1; i < endPosition - 1; i++) {
	    for (int j = i + 1; j < endPosition; j++) {
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
	if (pos <= startPosition || pos >= endPosition) {
	    throw new IndexOutOfBoundsException();
	}
	data[pos] = el;
    }

    @Override
    public int get(int pos) {
	if (pos <= startPosition || pos >= endPosition) {
	    throw new IndexOutOfBoundsException();
	}
	return data[pos];
    }

    @Override
    public void clear() {
	endPosition = INIT_SIZE / 2;
	startPosition = endPosition - 1;
    }

    @Override
    public IList copy() {
	EvgeniyMal_A2List res = new EvgeniyMal_A2List();
	res.INIT_SIZE = INIT_SIZE;
	res.data = new int[INIT_SIZE];
	res.startPosition = startPosition;
	res.endPosition = endPosition;
	for (int i = startPosition+1; i < endPosition; i++) {
	    res.data[i] = data[i];
	}
	return res;
    }
    
    public void init(int[] m) {
	data = new int[INIT_SIZE];
	System.arraycopy(m, 0, data, 0, m.length);
	startPosition = 0;
	endPosition = m.length;
    }

    @Override
    public int[] toArray() {
	int[] temp = new int[size()];
	System.arraycopy(data, startPosition+1, temp, 0, size());
	return temp;
    }

	@Override
	public Iterator<Integer> iterator()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasNext()
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object next()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove()
	{
		// TODO Auto-generated method stub
		
	}

}
