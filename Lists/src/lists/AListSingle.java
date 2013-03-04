package lists;

import java.util.*;
public class AListSingle implements IList
{
    private int[]arr=new int[10];
    private int index=0;
    private int count=0;
    
    public void init(int[]initArray)
    {
        for(int i=0;i<initArray.length;++i)
        {
            addEnd(initArray[i]);
        }
    }
    private void increaseArray()
    {
        if(index==arr.length)
        {
            int[]tempArr=new int[(int)(arr.length+(arr.length*0.3))];
            for(int i=0;i<arr.length;++i)
            {
                tempArr[i]=arr[i];
            }
            arr=tempArr;
        }
    }
    @Override
    public void addStart(int value)
    {
        increaseArray();
        for(int i=index;i>=1;--i)
        {
            arr[i]=arr[i-1];
        }
        arr[0]=value;
        ++index;
    }

    @Override
    public void addEnd(int value)
    {
        increaseArray();
        arr[index]=value;
        ++index;
    }

    @Override
    public void addPos(int position, int value)
    {
        if(position<0||position>index)throw new IndexOutOfBoundsException();
        increaseArray();
        if(index==0)
        {
            arr[index++]=value;
            return;
        }
        for(int i=index;i>position;--i)
        {
            arr[i]=arr[i-1];
        }
        arr[position]=value;
        ++index;
    }

    @Override
    public void delStart()
    {
        if(index==0)throw new IndexOutOfBoundsException();
        for(int i=1;i<index;++i)
        {
            arr[i-1]=arr[i];
        }
        --index;
    }

    @Override
    public void delEnd()
    {
        if(index==0)throw new IndexOutOfBoundsException();
        --index;
    }

    @Override
    public void delPos(int position)
    {
        if(index==0||position<0||position>=index)throw new IndexOutOfBoundsException();     
        for(int i=position+1;i<index;++i)
        {
            arr[i-1]=arr[i];
        }
        --index;
    }

    @Override
    public void set(int position, int value)
    {
        if(position<0||position>=index)throw new IndexOutOfBoundsException();
        arr[position]=value;
    }

    @Override
    public int get(int position)
    {        
        if(position<0||position>=index)throw new IndexOutOfBoundsException();
        return arr[position];
    }

    @Override
    public void clear()
    {
        index=0;
    }

    @Override
    public int size()
    {
        return index;
    }

    @Override
    public void sort()
    {
        if(index<2) return;
        for(int i=0;i<index-1;++i)
        {
            for(int j=i;j>=0;--j)
            {
                if(arr[j+1]<arr[j])
                {
                    int temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                }
            }
        }
    }

    @Override
    public IList copy()
    {
        IList result=new AListSingle();
        for(int i=0;i<index;++i)
        {
            result.addEnd(arr[i]);
        }
        return result;
    }    
    @Override
    public String toString()
    {
        String result="";
        for(int i=0; i<index;++i)
        {
            if(i==0)
            {
                result=""+arr[i];
            }
            else
            {
                result=result+" "+arr[i];
            }
        }
        return result;
    }
    @Override
    public int[] toArray()
    {
        int[]resultArray=new int[index];
        for(int i=0;i<index;++i)
        {
            resultArray[i]=arr[i];
        }
        return resultArray;
    }

    @Override
    public Iterator<Integer> iterator()
    {
        return this;
    }

    @Override
    public boolean hasNext()
    {
        if(count < index) return true;
        return false; 
    }

    @Override
    public Object next()
    {
        if(count == index)
        throw new NoSuchElementException();

        count++;
        return arr[count-1];
    }

    @Override
    public void remove()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
