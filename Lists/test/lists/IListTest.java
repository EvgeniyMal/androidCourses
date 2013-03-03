package lists;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IListTest
{    
    static IList arr;
    
    @Parameterized.Parameters
    public static Collection data()
    {
       return Arrays.asList
               (new Object[][]
                    {
                        {new AListSingle()},
                        {new AListDouble()},
                        {new LList1p1l()},
                        {new LList2p1l()},
                        {new LList2p2l()}
                    }
                );
    }
    
    
    public IListTest(IList arr)
    {
        this.arr=arr;
    }
     
    
//    @BeforeClass
//    public static void SetUp()
//    {
//        //arr=new MyArrayList();
//        //arr=new MyDList();
//        //arr=new MyLList();
//        arr=new MyLEList();
//    }
    //--------------------------------------------------------------------------
    @Before
    public void clearArr()
    {
        arr.clear();
    }
  @Test
  public void testAddStart_0()
  {
    arr.addStart(2);
    assertEquals(2, arr.get(0));
    assertEquals(1, arr.size());    
    assertEquals("2",arr.toString());
    int[]tmp={2};
    assertArrayEquals(tmp, arr.toArray());
  }
  @Test
  public void testAddStart_1()
  {
    int[]tmp={13};
    arr.init(tmp);
    arr.addStart(2);
    assertEquals(2, arr.get(0));
    assertEquals(2, arr.size());
    assertEquals("2 13", arr.toString());
    int[]res={2,13};
    assertArrayEquals(res, arr.toArray());
  }
  @Test
  public void testAddStart_2()
  {
    int[]tmp={13,14};
    arr.init(tmp);
    arr.addStart(2);
    assertEquals(2, arr.get(0));
    assertEquals(3, arr.size());
    assertEquals("2 13 14", arr.toString());
    int[]res={2,13,14};
    assertArrayEquals(res, arr.toArray());
  }
  @Test
  public void testAddStart_MANY()
  {
    int[]tmp={13,14,56,44,78,79};
    arr.init(tmp);
    arr.addStart(2);
    assertEquals(2, arr.get(0));
    assertEquals(7, arr.size());
    assertEquals("2 13 14 56 44 78 79", arr.toString());
    int[]res={2,13,14,56,44,78,79};
    assertArrayEquals(res, arr.toArray());
  }
    //--------------------------------------------------------------------------
  @Test
  public void testAddEnd_0()
  {
    arr.addEnd(2);
    assertEquals(2, arr.get(0));
    assertEquals(1, arr.size());
    assertEquals("2",arr.toString());
    int[]tmp={2};
    assertArrayEquals(tmp, arr.toArray());
  }
  @Test
  public void testAddEnd_1()
  {
    int[]tmp={13};
    arr.init(tmp);
    arr.addEnd(2);
    assertEquals(2, arr.get(1));
    assertEquals(2, arr.size());
    assertEquals("13 2", arr.toString());
    int[]res={13,2};
    assertArrayEquals(res, arr.toArray());
  }
  @Test
  public void testAddEnd_2()
  {
    int[]tmp={13,14};
    arr.init(tmp);
    arr.addEnd(2);
    assertEquals(2, arr.get(2));
    assertEquals(3, arr.size());
    assertEquals("13 14 2", arr.toString());
    int[]res={13,14,2};
    assertArrayEquals(res, arr.toArray());
  }
  @Test
  public void testAddEnd_MANY()
  {
    int[]tmp={13,14,56,44,78,79};
    arr.init(tmp);
    arr.addEnd(2);
    assertEquals(2, arr.get(6));
    assertEquals(7, arr.size());
    assertEquals("13 14 56 44 78 79 2", arr.toString());
    int[]res={13,14,56,44,78,79,2};
    assertArrayEquals(res, arr.toArray());
  }
    //--------------------------------------------------------------------------
  @Test
  public void testAddPosition_0()
  {
    arr.addPos(0,2);
    assertEquals(2, arr.get(0));
    assertEquals(1, arr.size());
    assertEquals("2",arr.toString());
    int[]tmp={2};
    assertArrayEquals(tmp, arr.toArray());
  }
  @Test
  public void testAddPosition_1()
  {    
    int[]tmp={13};
    arr.init(tmp);
    arr.addPos(0,2);
    assertEquals(2, arr.get(0));
    assertEquals(2, arr.size());
    assertEquals("2 13", arr.toString());
    int[]res={2,13};
    assertArrayEquals(res, arr.toArray());
  }
  @Test
  public void testAddPosition_2()
  {    
    int[]tmp={13,14};
    arr.init(tmp);
    arr.addPos(1,2);
    assertEquals(2, arr.get(1));
    assertEquals(3, arr.size());
    assertEquals("13 2 14", arr.toString());
    int[]res={13,2,14};
    assertArrayEquals(res, arr.toArray());
  }
  @Test
  public void testAddPosition_MANY()
  {    
    int[]tmp={13,14,56,44,78,79};
    arr.init(tmp);
    arr.addPos(3,2);
    assertEquals(2, arr.get(3));
    assertEquals(7, arr.size());
    assertEquals("13 14 56 2 44 78 79", arr.toString());
    int[]res={13,14,56,2,44,78,79};
    assertArrayEquals(res, arr.toArray());
  }
  @Test(expected=ArrayIndexOutOfBoundsException.class)
  public void testAddPosition_ArrayIndexOutOfBoundsException_NEGATIVE()
  {
    arr.addPos(-1,12);
  }
  @Test(expected=ArrayIndexOutOfBoundsException.class)
  public void testAddPosition_ArrayIndexOutOfBoundsException_TOOMUCH()
  {
    int[]tmp={13,14,56,44,78,79};
    arr.init(tmp);
    arr.addPos(7,12);
  }
    //--------------------------------------------------------------------------  
  @Test(expected=ArrayIndexOutOfBoundsException.class)
  public void testDelStart_ArrayIndexOutOfBoundsException()
  {
    arr.delStart();
  }
  @Test
  public void testDelStart_1()
  {
    int[]tmp={2};
    arr.init(tmp);
    arr.delStart();
    assertEquals(0, arr.size());
    assertEquals("", arr.toString());
    int[]res={};
    assertArrayEquals(res, arr.toArray());
  }
  @Test
  public void testDelStart_2()
  {       
    int[]tmp={13,14};
    arr.init(tmp);
    arr.delStart();
    assertEquals(14, arr.get(0));
    assertEquals(1, arr.size());
    assertEquals("14", arr.toString());
    int[]res={14};
    assertArrayEquals(res, arr.toArray());
  }
  @Test
  public void testDelStart_MANY()
  {       
    int[]tmp={13,14,56,44,78,79};
    arr.init(tmp);
    arr.delStart();
    assertEquals(14, arr.get(0));
    assertEquals(5, arr.size());
    assertEquals("14 56 44 78 79", arr.toString());
    int[]res={14,56,44,78,79};
    assertArrayEquals(res, arr.toArray());
  }
    //--------------------------------------------------------------------------
  @Test(expected=ArrayIndexOutOfBoundsException.class)
  public void testDelEnd_ArrayIndexOutOfBoundsException()
  {
    arr.delEnd();
  }
  @Test
  public void testDelEnd_1()
  {
    int[]tmp={2};
    arr.init(tmp);
    arr.delEnd();
    assertEquals(0, arr.size());
    assertEquals("", arr.toString());
    int[]res={};
    assertArrayEquals(res, arr.toArray());
  }
  @Test
  public void testDelEnd_2()
  {
    int[]tmp={13,14};
    arr.init(tmp);
    arr.delEnd();
    assertEquals(13, arr.get(0));
    assertEquals(1, arr.size());
    assertEquals("13", arr.toString());
    int[]res={13};
    assertArrayEquals(res, arr.toArray());
  }
  @Test
  public void testDelEnd_MANY()
  {
    int[]tmp={13,14,56,44,78,79};
    arr.init(tmp);
    arr.delEnd();
    assertEquals(78, arr.get(4));
    assertEquals(5, arr.size());
    assertEquals("13 14 56 44 78", arr.toString());
    int[]res={13,14,56,44,78};
    assertArrayEquals(res, arr.toArray());
  }
    //--------------------------------------------------------------------------
  @Test(expected=ArrayIndexOutOfBoundsException.class)
  public void testDelPosition_ArrayIndexOutOfBoundsException_EMPTY()
  {
    arr.delPos(0);
  }
  @Test(expected=ArrayIndexOutOfBoundsException.class)
  public void testDelPosition_ArrayIndexOutOfBoundsException_NEGATIVE()
  {
    arr.delPos(-1);
  }
  @Test(expected=ArrayIndexOutOfBoundsException.class)
  public void testDelPosition_ArrayIndexOutOfBoundsException_TOOMUCH()
  {
    int[]tmp={13,14,56,44,78,79};
    arr.init(tmp);
    arr.delPos(7);
  }
  @Test
  public void testDelPosition_1()
  {    
    int[]tmp={2};
    arr.init(tmp);
    arr.delPos(0);
    assertEquals(0, arr.size());
    assertEquals("", arr.toString());
    int[]res={};
    assertArrayEquals(res, arr.toArray());
  }
  @Test
  public void testDelPosition_2()
  {
    int[]tmp={13,14};
    arr.init(tmp);
    arr.delPos(0);
    assertEquals(14, arr.get(0));
    assertEquals(1, arr.size());
    assertEquals("14", arr.toString());
    int[]res={14};
    assertArrayEquals(res, arr.toArray());
  }
  @Test
  public void testDelPosition_MANY()
  {
    int[]tmp={13,14,56,44,78,79};
    arr.init(tmp);
    arr.delPos(2);
    assertEquals(14, arr.get(1));
    assertEquals(44, arr.get(2));
    assertEquals(5, arr.size());
    assertEquals("13 14 44 78 79", arr.toString());
    int[]res={13,14,44,78,79};
    assertArrayEquals(res, arr.toArray());
  }
    //--------------------------------------------------------------------------
  @Test
  public void testSet()
  {
    int[]tmp={2};
    arr.init(tmp);
    arr.set(0,3);
    assertEquals(3, arr.get(0));
    assertEquals(1, arr.size());
    assertEquals("3",arr.toString());
    int[]tmpArr={3};
    assertArrayEquals(tmpArr, arr.toArray());
  }
  @Test(expected=ArrayIndexOutOfBoundsException.class)
  public void testSet_ArrayIndexOutOfBoundsException_NEGATIVE()
  {
    arr.set(-1,12);
  }
  @Test(expected=ArrayIndexOutOfBoundsException.class)
  public void testSet_ArrayIndexOutOfBoundsException_TOOMUCH()
  {
    int[]tmp={13,14,56,44,78,79};
    arr.init(tmp);
    arr.set(7,17);
  }
    //--------------------------------------------------------------------------
  @Test
  public void testGet()
  {
    int[]tmp={2};
    arr.init(tmp);
    assertEquals(2, arr.get(0));
    assertEquals(1, arr.size());
    assertEquals("2",arr.toString());
    int[]tmpArr={2};
    assertArrayEquals(tmpArr, arr.toArray());
  }
  @Test(expected=ArrayIndexOutOfBoundsException.class)
  public void testGet_ArrayIndexOutOfBoundsException_NEGATIVE()
  {
    arr.get(-1);
  }
  @Test(expected=ArrayIndexOutOfBoundsException.class)
  public void testGet_ArrayIndexOutOfBoundsException_TOOMUCH()
  {
    int[]tmp={13,14,56,44,78,79};
    arr.init(tmp);
    arr.get(7);
  }
    //--------------------------------------------------------------------------
  @Test
  public void testClear()
  {  
    int[]tmp={13,14,56,44,78,79};
    arr.init(tmp);
    arr.clear();
    assertEquals(0, arr.size());
    assertEquals("", arr.toString());
    int[]res={};
    assertArrayEquals(res, arr.toArray());
  }
    //--------------------------------------------------------------------------
  @Test
  public void testSize_MANY()
  {  
    int[]tmp={13,14,56,44,78,79};
    arr.init(tmp);
    assertEquals(6, arr.size());
    assertEquals("13 14 56 44 78 79", arr.toString());
  }
  @Test
  public void testSize_2()
  {  
    int[]tmp={13,14};
    arr.init(tmp);
    assertEquals(2, arr.size());
    assertEquals("13 14", arr.toString());
  }
  @Test
  public void testSize_1()
  {  
    int[]tmp={13};
    arr.init(tmp);
    assertEquals(1, arr.size());
    assertEquals("13", arr.toString());
  }
  @Test
  public void testSize_0()
  {  
    int[]tmp={};
    arr.init(tmp);
    assertEquals(0, arr.size());
    assertEquals("", arr.toString());
  }
    //--------------------------------------------------------------------------
  @Test
  public void testSort_MANY()
  {
    int[]tmp={13,14,2,44,79,17};
    arr.init(tmp);
    arr.sort();
    assertEquals("2 13 14 17 44 79", arr.toString());
    int[]res={2,13,14,17,44,79};
    assertArrayEquals(res, arr.toArray());
  }
  @Test
  public void testSort_2()
  {
    int[]tmp={13,14};
    arr.init(tmp);
    arr.sort();
    assertEquals("13 14", arr.toString());
    int[]res={13,14};
    assertArrayEquals(res, arr.toArray());
  }
  @Test
  public void testSort_1()
  {
    int[]tmp={13};
    arr.init(tmp);
    arr.sort();
    assertEquals("13", arr.toString());
    int[]res={13};
    assertArrayEquals(res, arr.toArray());
  }
  @Test
  public void testSort_0()
  {
    int[]tmp={};
    arr.init(tmp);
    arr.sort();
    assertEquals("", arr.toString());
    int[]res={};
    assertArrayEquals(res, arr.toArray());
  }
    //--------------------------------------------------------------------------
  @Test
  public void testRevers_MANY()
  {
    int[]tmp={13,14,2,44,79,17};
    arr.init(tmp);
    arr.revers();
    assertEquals("17 79 44 2 14 13", arr.toString());
    int[]res={17,79,44,2,14,13};
    assertArrayEquals(res, arr.toArray());
  }
  @Test
  public void testRevers_2()
  {
    int[]tmp={13,14};
    arr.init(tmp);
    arr.revers();
    assertEquals("14 13", arr.toString());
    int[]res={14,13};
    assertArrayEquals(res, arr.toArray());
  }
  @Test
  public void testRevers_1()
  {
    int[]tmp={13};
    arr.init(tmp);
    arr.revers();
    assertEquals("13", arr.toString());
    int[]res={13};
    assertArrayEquals(res, arr.toArray());
  }
  @Test
  public void testRevers_0()
  {
    int[]tmp={};
    arr.init(tmp);
    arr.revers();
    assertEquals("", arr.toString());
    int[]res={};
    assertArrayEquals(res, arr.toArray());
  }
    //--------------------------------------------------------------------------
  @Test
  public void testCopy_MANY()
  {
    int[]tmp={13,14,2,44,79,17};
    arr.init(tmp);
    IList res=arr.copy();
    assertEquals(res.size(), arr.size());
    assertEquals(res.toString(), arr.toString());
    assertArrayEquals(res.toArray(), arr.toArray());
  }
  @Test
  public void testCopy_2()
  {
    int[]tmp={13,14};
    arr.init(tmp);
    IList res=arr.copy();
    assertEquals(res.size(), arr.size());
    assertEquals(res.toString(), arr.toString());
    assertArrayEquals(res.toArray(), arr.toArray());
  }
  @Test
  public void testCopy_1()
  {
    int[]tmp={13};
    arr.init(tmp);
    IList res=arr.copy();
    assertEquals(res.size(), arr.size());
    assertEquals(res.toString(), arr.toString());
    assertArrayEquals(res.toArray(), arr.toArray());
  }
    //--------------------------------------------------------------------------
  @Test
  public void testToString()
  {
    int[]tmp={13,14,2,44,79,17};
    arr.init(tmp);
    assertEquals("13 14 2 44 79 17", arr.toString());
  }
}