package lists;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class AListDouble implements IList
{
    private int[]arr=new int[10];
    private int front=arr.length/2-1;
    private int rear=front+1;
    private int count=0;
    
    @Override
    public void init(int[] initArray)
    {
        for(int i=0;i<initArray.length;++i)
        {
            addEnd(initArray[i]);
        }
    }

    private void increaseArray()
    {
        if(size()==arr.length-2)
        {
            int[]tempArr=new int[(int)(arr.length+(arr.length*0.3))];
            for(int i=front+1;i<rear;++i)
            {
                tempArr[i]=arr[i];
            }
            arr=tempArr;
        }
    }
    private void balanceArray()
    {
        increaseArray();
        int newFront=arr.length/2-size()/2-1;
        if(front<newFront)
        {
            int step=newFront-front;
            for(int i=rear-1;i>front;--i)
            {
                arr[i+step]=arr[i];
            }
            int size=size();
            front=newFront;
            rear=front+1+size;
        }
        else if(front>newFront)
        {
            int step=front-newFront;
            for(int i=front+1;i<rear;++i)
            {
                arr[i-step]=arr[i];
            }
            int size=size();
            front=newFront;
            rear=front+1+size;
        }
    }
    @Override
    public void addStart(int value)
    {
        balanceArray();
        arr[front--]=value;
    }

    @Override
    public void addEnd(int value)
    {
        balanceArray();
        arr[rear++]=value;
    }

    @Override
    public void addPos(int position, int value)
    {
        if(front+1+position<=front||front+1+position>rear)throw new ArrayIndexOutOfBoundsException();
        balanceArray();
        if(position<size()/2)
        {
            for(int i=front;i<front+1+position;++i)
            {
                arr[i]=arr[i+1];
            }
            arr[front+1+position]=value;
            --front;
        }
        else
        {
            for(int i=rear;i>front+position;--i)
            {
                arr[i]=arr[i-1];
            }
            arr[front+1+position]=value;
            ++rear;
        }
    }

    @Override
    public void delStart()
    {
        if(size()==0)throw new ArrayIndexOutOfBoundsException();
        ++front;
    }

    @Override
    public void delEnd()
    {
        if(size()==0)throw new ArrayIndexOutOfBoundsException();
        --rear;
    }

    @Override
    public void delPos(int position)
    {
        if(size()==0||front+1+position<=front||front+1+position>=rear)throw new ArrayIndexOutOfBoundsException(); 
        if(position<size()/2)
        {
            for(int i=front+1+position;i>front+1;--i)
            {
                arr[i]=arr[i-1];
            }
            ++front;
        }
        else
        {
            for(int i=position;i<rear-1;++i)
            {
                arr[i]=arr[i+1];
            }
            --rear;
        }
    }

    @Override
    public void set(int position, int value)
    {
        if(front+1+position<=front||front+1+position>=rear)throw new ArrayIndexOutOfBoundsException();
        arr[front+1+position]=value;
    }

    @Override
    public int get(int position)
    {
        if(front+1+position<=front||front+1+position>=rear)throw new ArrayIndexOutOfBoundsException();
        return arr[front+1+position];
    }

    @Override
    public void clear()
    {
        front=arr.length/2-1;
        rear=front+1;
    }

    @Override
    public int size()
    {
        return rear-front-1;
    }

    @Override
    public void sort()
    {
        if(size()<2) return;
        if(rear-front==2) return;
        for(int i=front+1;i<rear-1;++i)
        {
            for(int j=i;j>=front+1;--j)
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
    public void revers()
    {
        if(size()<2) return;
        int backCounter=1;
        for(int i=front+1;i<front+1+size()/2;++i)
        {
            int temp=arr[rear-backCounter];
            arr[rear-backCounter]=arr[i];
            arr[i]=temp;
            ++backCounter;
        }
    }

    @Override
    public IList copy()
    {
        IList result=new AListDouble();
        for(int i=front+1;i<rear;++i)
        {
            result.addEnd(arr[i]);
        }
        return result;
    }    
    @Override
    public String toString()
    {
        String result="";
        for(int i=front+1; i<rear;++i)
        {
            if(i==front+1)
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
        int resCounter=0;
        int[]resultArray=new int[size()];
        for(int i=front+1;i<rear;++i)
        {
            resultArray[resCounter++]=arr[i];
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
        if(count<this.size())return true;
        return false;
    }

    @Override
    public Object next()
    {
        if(count == this.size())
        throw new NoSuchElementException();

        count++;
        return arr[front+count];
    }

    @Override
    public void remove()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
