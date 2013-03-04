package lists;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LList1p1l implements IList
{
    private Node root;
    private int count=0;
    private int index=0;
    
    public LList1p1l()
    {
        root=null;
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
        Node temp=new Node(value);
        if(root==null)
        	{
        		root=temp;
        		++index;
        	}
        else
    	{
        	addPos(0, value);
    	}
    }

    @Override
    public void addEnd(int value)
    {
    	if(root==null)
    		{
    			root=new Node(value);
    			++index;
    		}
    	else
    	{
	        addPos(index, value);
    	}
    }

    @Override
    public void addPos(int position, int value)
    {        
        if(position<0||position>index)throw new IndexOutOfBoundsException();
        Node temp=new Node(value);
        if(root==null)root=temp;
        else if (position==0)
        {
        	temp.setNext(root);
        	root=temp;
        }
        else if(position==index)
        {
        	Node current=root;
	        while(current.getNext()!=null)
	        {
	        	current=current.getNext();
	        }
	        current.setNext(new Node(value));
        }
        else
        {
	        Node current=root;
	        int counter=0;
	        while(counter<position-1)
	        {
	        	current=current.getNext();
	            ++counter;
	        }
	        temp.setNext(current.getNext());
	        current.setNext(temp);
        }
        ++index;
    }

    @Override
    public void delStart()
    {
        if(index==0)throw new IndexOutOfBoundsException();
        if(index==1)
        	{
        		root=null;
        		--index;
        	}
        else delPos(0);
    }

    @Override
    public void delEnd()
    {
        if(index==0)throw new IndexOutOfBoundsException();
        if(index==1)
        	{
        		root=null;
        		--index;
        	}
        else delPos(index-1);
    }

    @Override
    public void delPos(int position)
    {       
        if(index==0 || position<0 || position>=index)throw new IndexOutOfBoundsException();
        if(index==1)root=null;
        else if(position==0)root=root.getNext();
        else if(position==index-1)
        {
        	Node current=root;
	        while(current.getNext().getNext()!=null)
	        {
	            current=current.getNext();
	        }
	        current.setNext(null);
        }
        else
        {
	        Node current=root;
	        int counter=0;
	        while(counter<position-1)
	        {
	        	current=current.getNext();
	            ++counter;
	        }
	        current.setNext(current.getNext().getNext());
        }
        --index;
    }

    @Override
    public void set(int position, int value)
    {       
        if(position<0 || position>=index)throw new IndexOutOfBoundsException();      
        Node current=root;
        int counter=0;
        while(current.getNext()!=null & counter<=position)
        {
        	current=current.getNext();
            ++counter;
        }
        current.setData(value);
    }

    @Override
    public int get(int position)
    {
        if(position<0 || position >= index)throw new IndexOutOfBoundsException();
        Node current=root;
        int counter=0;
        while(current != null & counter<position)
        {
        	current=current.getNext();
            ++counter;
        }
        return current.getData();
    }

    @Override
    public void clear()
    {
        root=null;
        index=0;
    }

    @Override
    public int size()
    {
        Node current=root;
        int counter=0;
        while(current!=null)
        {
        	current=current.getNext();
            ++counter;
        }
        return counter;
    }

    @Override
    public void sort()
    {  
        if(index<2) return;
        Node lastSorted=null;
        while(root!=lastSorted)
        {
            Node tmp=root;
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
        LList1p1l temp=new LList1p1l();
        if(this.root==null) return temp;
             
        Node current=root;
        
        while(current!=null)
        {
        	temp.addEnd(current.getData());
        	current=current.getNext();
        }        
        return temp;
    }
  
    @Override
    public String toString()
    {
        String result="";
        Node current=root;
        
        while(current!=null)
        {
            boolean b=(current==root)?true:false;
            
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
        int i=0;
        Node current=root;
        
        while(current!=null)
        {
            arr[i++]=current.getData();
        	current=current.getNext();
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
    protected class Node
    {
        private int data;
        private Node next;

        public Node()
        {
            data=0;
            next=null;
        }
        public Node(int data)
        {
            this.data=data;
            next=null;
        }
        public Node(int data, Node next)
        {
            this.data=data;
            this.next=next;
        }
        public int getData()
        {
            return this.data;
        }
        public void setData(int data)
        {
            this.data=data;
        }
        public Node getNext()
        {
            return this.next;
        }
        public void setNext(Node next)
        {
            this.next=next;
        }
    }
}