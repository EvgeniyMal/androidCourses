package com.lists;

import com.lists.interfaces.IList;

public class LinkedList implements IList {

    private class Element {

	private int value;
	private Element next;

	public Element(int value) {
	    this.value = value;
	    next = null;
	}
    }

    private Element start;

    public LinkedList() {
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
    public void add(int pos, int el) {
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
    public void del(int pos) {
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
    
    private class Stack {
	int level;
	Element item;
    }

    @Override
    public void sort() {
	int stackPos = 0;
	Element p = start;
	Stack[] stack = new Stack[32];
	while (p != null) {
	    Stack stackItem = new Stack();
	    stackItem.level = 1;
	    stackItem.item = p;
	    stack[stackPos] = stackItem;
	    p = p.next;
	    stack[stackPos].item.next = null;
	    stackPos++;
	    while (stackPos > 1 && stack[stackPos - 1].level == stack[stackPos - 2].level) { 
		stack[stackPos - 2].item = intersectSorted(stack[stackPos - 2].item, stack[stackPos - 1].item);
		stack[stackPos - 2].level++;
		stackPos--;
	    }
	}
	while (stackPos > 1) {
	    stack[stackPos - 2].item = intersectSorted(stack[stackPos - 2].item, stack[stackPos - 1].item);
	    stack[stackPos - 2].level++;
	    stackPos--;
	}
	if (stackPos > 0) {
	    start = stack[0].item;
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
	    return new LinkedList();
	}
	LinkedList res = new LinkedList();
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
	int [] res = new int[size()];
	Element el = start;
	int count = 0;
	while (el != null) {
	    res[count++] = el.value;
	    el = el.next;
	}
	return res;
    }
    
    private Element intersectSorted(Element el1, Element el2) {
	Element pCurItem;
	if (el1.value <= el2.value) { 
	    pCurItem = el1;
	    el1 = el1.next;
	} else {
	    pCurItem = el2;
	    el2 = el2.next;
	}
        Element result = pCurItem;
        while (el1 != null && el2 != null) {
            if (el1.value <= el2.value) {
        	pCurItem.next = el1;
        	pCurItem = el1;
        	el1 = el1.next;
            } else {
        	pCurItem.next = el2;
        	pCurItem = el2;
        	el2 = el2.next;
            }
            if (el1 != null) {
        	pCurItem.next = el1;
            } else {
        	pCurItem.next = el2;
            }
        }
        return result;
    }

}
