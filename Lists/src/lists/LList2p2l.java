package lists;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LList2p2l implements IList
{
	private DNode front;
	private DNode rear;
    private int count=0;
    private int index=0;
    
    public LList2p2l()    
    {
        front=null;
        rear=null;
    }
    @Override
    public void init(int[] initArray)
    {
        for(int i=0;i<initArray.length;++i)
        {
            addEnd(initArray[i]);
        }
    }

    @Override
    public void addStart(int value)
    {
        addPos(0,value);
    }

    @Override
    public void addEnd(int value)
    {     
        addPos(index,value);
    }

    @Override
    public void addPos(int position, int value)
    {
        if(position<0||position>index)throw new IndexOutOfBoundsException();
        
        DNode temp=new DNode(value);
        
        if(front==null)
        {
            front=temp;
            rear=temp;
        }
        else if(position==0)
        {
        	temp.setNext(front);
            front.setPrev(temp);
            front=temp;  
        }
        else if(position==index)
        {
        	temp.setPrev(rear);
        	rear.setNext(temp);
        	rear=temp;
        }
        else
        {
            DNode current=front;
            int counter=0;
            while(counter++<position)
            {
            	current=current.getNext();
            }
            temp.setPrev(current.getPrev());
            current.setPrev(temp);
            temp.getPrev().setNext(temp);
            temp.setNext(current);
        }
        ++index;
    }

    @Override
    public void delStart()
    {
    	delPos(0);
    }

    @Override
    public void delEnd()
    {
    	delPos(index-1);
    }

    @Override
    public void delPos(int position)
    {
        if(position<0||position>=index)throw new IndexOutOfBoundsException();
        if(index==1)
        {
        	front=null;
        	rear=null;
        }
        else if(position==0)
        {
        	front=front.getNext();
	        front.setPrev(null);
        }
        else if(position==index-1)
        {
        	rear=rear.getPrev();
	        rear.setNext(null);
        }
        else
        { 
            DNode current=front.getNext();
            int counter=0;
            while(counter++<position-1)
            {
            	current=current.getNext();
            }
            current.getPrev().setNext(current.getNext());
            current.getNext().setPrev(current.getPrev());
        }
        --index;
    }

    @Override
    public void set(int position, int value)
    {
        if(position<0||position>=index)throw new IndexOutOfBoundsException();
        DNode current=front;
        int counter=0;
        while(counter++<=position-1)
        {
        	current=current.getNext();
        }
        current.setData(value);
    }

    @Override
    public int get(int position)
    { 
        if(position<0||position>=index)throw new IndexOutOfBoundsException();       
        DNode current=front;
        int counter=0;
        while(counter++<position)
        {
        	current=current.getNext();
        }
        return current.getData();
    }

    @Override
    public void clear()
    {        
        front=null;
        rear=null;
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
        DNode lastSorted=null;
        while(front.getNext()!=lastSorted)
        {
            DNode tmp=front;
            while(tmp.getNext()!=lastSorted)
            {
                if(tmp.getData()>tmp.getNext().getData())
                {
                    int temp=tmp.getData();
                    tmp.setData(tmp.getNext().getData());
                    tmp.getNext().setData(temp);
                }
                tmp=tmp.getNext();
            }
            lastSorted=tmp;
        }        
    }

    @Override
    public IList copy()
    {
    	LList2p2l temp=new LList2p2l();
        if(this.front==null) return temp;
        
        temp.front=new DNode(front.getData());
        
        DNode tempCurrent=temp.front;        
        DNode current=front;
        
        while(current!=rear)
        {
        	current=current.getNext();
            DNode n=new DNode(current.getData());
            tempCurrent.setNext(n);
            tempCurrent=tempCurrent.getNext();
        }   
        rear=tempCurrent;
        temp.index=this.index;
        return temp;
    }

    @Override
    public String toString()
    {
    	String result="";
        DNode current=front;
        
        while(current!=null)
        {
            boolean b=(current==front)?true:false;
            
            if(b) result=""+current.getData();
            else result=result + " "+current.getData();
            
            current=current.getNext();
        }      
        
        return result;
    }
    @Override
    public int[] toArray()
    {
        int[]arr=new int[index];
        if(index>0)
        {
            int i=0;
            DNode current=front;

            while(current!=null)
            {
                arr[i++]=current.getData();
                current=current.getNext();
            }      
        }
        return arr;
    }

    @Override
    public Iterator<Integer> iterator()
    {
        return this;
    }

    @Override
    public boolean hasNext()
    {
    	if(count<this.index)return true;
        return false;
    }

    @Override
    public Object next()
    {
        if(count == this.index)
        throw new NoSuchElementException();

        count++;
        return this.get(count-1);
    }

    @Override
    public void remove()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    protected class DNode
    {
        private int data;
        private DNode next;
        private DNode prev;

        public DNode()
        {
            this.data=0;
            this.next=null;
            this.prev=null;
        }
        public DNode(int value)
        {
            this.data=value;
            this.next=null;
            this.prev=null;
        }
        public void setData(int value)
        {
            this.data=value;
        }
        public int getData()
        {
            return this.data;
        }
        public void setNext(DNode next)
        {
            this.next=next;
        }
        public DNode getNext()
        {
            return this.next;
        }
        public void setPrev(DNode prev)
        {
            this.prev=prev;
        }
        public DNode getPrev()
        {
            return this.prev;
        }

    }
}
