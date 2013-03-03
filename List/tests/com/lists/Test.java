package com.lists;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.lists.A2List;
import com.lists.AList;
import com.lists.LinkedList;
import com.lists.interfaces.IList;

@RunWith(Parameterized.class)
public class Test {

    private IList list;
    private int[] one = { 7 };
    private int[] two = { 4, 5 };
    private int[] many = { 5, 4, 3, 2, 1 };

    @Parameters
    public static List<Object[]> isEmptyData() {
	return Arrays.asList(new Object[][] {
		{ new AList() },
		{ new A2List() },
		{ new LinkedList() },
		{ new LinkedList() },
	});
    }

    public Test(IList list) {
	this.list = list;
    }
    
    @Before
    public void init() {
	list.clear();
    }

    @org.junit.Test
    public void testSizeZero() {
	assertEquals(0, list.size());
    }

    @org.junit.Test
    public void testSizeOne() {
	list.init(one);
	assertEquals(1, list.size());
    }

    @org.junit.Test
    public void testSizeTwo() {
	list.init(two);
	assertEquals(2, list.size());
    }

    @org.junit.Test
    public void testSizeMny() {
	list.init(many);
	assertEquals(5, list.size());
    }

    @org.junit.Test
    public void testAddEndZero() {
	list.addEnd(7);
	assertEquals(1, list.size());
	assertEquals(7, list.get(0));
    }

    @org.junit.Test
    public void testAddEndOne() {
	list.init(one);
	list.addEnd(7);
	assertEquals(2, list.size());
	assertEquals(7, list.get(1));
    }

    @org.junit.Test
    public void testAddEndTwo() {
	list.init(two);
	list.addEnd(7);
	assertEquals(3, list.size());
	assertEquals(7, list.get(2));
    }

    @org.junit.Test
    public void testAddEndMany() {
	list.init(many);
	list.addEnd(7);
	assertEquals(6, list.size());
	assertEquals(7, list.get(5));
    }

    @org.junit.Test
    public void testAddStartZero() {
	list.addStart(7);
	assertEquals(7, list.get(0));
    }

    @org.junit.Test
    public void testAddPosZero() {
	list.add(0, 7);
	assertEquals(1, list.size());
	assertEquals(7, list.get(0));
    }

    @org.junit.Test
    public void testAddPosOne() {
	list.init(one);
	list.add(1, 7);
	assertEquals(2, list.size());
	assertEquals(7, list.get(1));
    }

    @org.junit.Test
    public void testAddPosTwo() {
	list.init(two);
	list.add(1, 7);
	assertEquals(3, list.size());
	assertEquals(7, list.get(1));
    }

    @org.junit.Test
    public void testAddPosMany() {
	list.init(many);
	list.add(3, 7);
	assertEquals(6, list.size());
	assertEquals(7, list.get(3));
    }

    @org.junit.Test (expected = IndexOutOfBoundsException.class)
    public void testDelEnd() {
	list.delEnd();
    }

    @org.junit.Test (expected = IndexOutOfBoundsException.class)
    public void testDelStart() {
	list.delStart();
    }

    @org.junit.Test (expected = IndexOutOfBoundsException.class)
    public void testDelPos() {
	list.del(1);
	assertEquals("", 3, list.size());
	assertEquals("", 5, list.get(0));
	assertEquals("", 3, list.get(1));
	assertEquals("", 2, list.get(2));
    }

    @org.junit.Test
    public void testSort() {
	list.init(many);
	list.sort();
	int [] sorted = list.toArray();
	for (int i=0; i<many.length; i++) {
	    assertEquals(many[many.length - i - 1], sorted[i]);
	}
    }

    @org.junit.Test
    public void testSet() {
	list.set(2, 7);
	assertEquals("", 7, list.get(2));
    }

    @org.junit.Test
    public void testGet() {
	assertEquals("", 5, list.get(0));
	assertEquals("", 4, list.get(1));
	assertEquals("", 3, list.get(2));
	assertEquals("", 2, list.get(3));
    }

    @org.junit.Test
    public void testClear() {
	list.clear();
	assertEquals("", 0, list.size());
    }

    @org.junit.Test
    public void testCopy() {
	AList al = new AList();
	al.add(0, 3);
	al.add(1, 1);
	al.add(2, 2);
	AList al2 = (AList) al.copy();
	assertEquals("", al.size(), al2.size());
	for (int i = 0; i < al.size(); i++)
	    assertEquals("", al.get(i), al2.get(i));
    }

}
