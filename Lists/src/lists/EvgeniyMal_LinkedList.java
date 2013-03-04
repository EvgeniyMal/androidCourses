package lists;

import java.util.Iterator;

public class EvgeniyMal_LinkedList implements IList {

    private class Element {

	private int value;
	private Element next;

	public Element(int value) {
	    this.value = value;
	    next = null;
	}
    }

    private Element start;

    public EvgeniyMal_LinkedList() {
	this.start = null;
    }

    @Override
    public int size() {
	int size = 0;
	Element el = start;
	while (el != null) {
	    size++;
	    el = el.next;
	}
	return size;
    }

    @Override
    public void addEnd(int el) {
	Element newEl = new Element(el);
	if (start == null) {
	    start = newEl;
	} else {
	    Element elem = start;
	    while (elem.next != null) {
		elem = elem.next;
	    }
	    elem.next = newEl;
	}

    }

    @Override
    public void addStart(int el) {
	Element newEl = new Element(el);
	newEl.next = start;
	start = newEl;
    }

    @Override
    public void addPos(int pos, int el) {
	if (pos < 0 || pos > size()) {
	    throw new IndexOutOfBoundsException();
	}
	Element newEl = new Element(el);
	if (pos == 0) {
	    newEl.next = start;
	    start = newEl;
	} else {
	    Element elem = start;

	    for (int i = 0; i < pos - 1; i++) {
		elem = elem.next;
	    }
	    newEl.next = elem.next;
	    elem.next = newEl;
	}
    }

    @Override
    public void delEnd() {
	if (start == null) {
	    throw new IndexOutOfBoundsException();
	}
	if (start.next == null) {
	    start = null;
	} else {
	    Element el = start;
	    while (el.next.next != null) {
		el = el.next;
	    }
	    el.next = null;
	}
    }

    @Override
    public void delStart() {
	if (start == null) {
	    throw new IndexOutOfBoundsException();
	}
	start = start.next;
    }

    @Override
    public void delPos(int pos) {
	if (pos < 0 || pos >= size()) {
	    throw new IndexOutOfBoundsException();
	}
	if (pos == 0) {
	    start = start.next;
	} else {
	    Element el = start;
	    for (int i = 0; i < pos - 1; i++) {
		el = el.next;
	    }
	    el.next = el.next.next;
	}
    }

    @Override
    public void sort() {
	int size = size();
	for (int i = 0; i < size - 1; i++) {
	    for (int j = i + 1; j < size; j++) {
		if (get(i) > get(j)) {
		    int a = get(i);
		    set(i, get(j));
		    set(j, a);
		}
	    }
	}
    }

    @Override
    public void set(int pos, int el) {
	if (pos < 0 || pos >= size()) {
	    throw new IndexOutOfBoundsException();
	}
	Element elem = start;
	for (int i = 0; i < pos; i++) {
	    elem = elem.next;
	}
	elem.value = el;
    }

    @Override
    public int get(int pos) {
	if (pos < 0 || pos >= size()) {
	    throw new IndexOutOfBoundsException();
	}
	Element elem = start;
	for (int i = 0; i < pos; i++) {
	    elem = elem.next;
	}
	return elem.value;
    }

    @Override
    public void clear() {
	start = null;
    }

    @Override
    public IList copy() {
	if (start == null) {
	    return new EvgeniyMal_LinkedList();
	}
	EvgeniyMal_LinkedList res = new EvgeniyMal_LinkedList();
	res.start = new Element(start.value);
	Element el = start;
	Element resEl = res.start;
	while (el.next != null) {
	    Element newEl = new Element(el.next.value);
	    resEl.next = newEl;
	    resEl = resEl.next;
	    el = el.next;
	}
	return res;
    }
    
    public void init(int[] m) {
	for (int i=0; i<m.length; i++) {
	    this.addEnd(m[i]);
	}
    }

    @Override
    public int[] toArray() {
	// TODO Auto-generated method stub
	return null;
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
