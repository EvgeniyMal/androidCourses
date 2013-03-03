package lists;

import java.util.Iterator;

public class LList2p2l implements IList
{
    DNode front;
    DNode rear;
    
    public LList2p2l()    
    {
        front=new DNode();
        rear=new DNode();
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
        DNode temp=new DNode(value);
        if(front.getNext()==null)
        {
            front.setNext(temp);
            temp.setPrev(front);
            rear.setPrev(temp);
            temp.setNext(rear);
        }
        else
        {
            temp.setNext(front.getNext());
            front.getNext().setPrev(temp);
            temp.setPrev(front);
            front.setNext(temp);
            
        }
    }

    @Override
    public void addEnd(int value)
    {        
        DNode temp=new DNode(value);
        if(rear.getPrev()==null)
        {
            front.setNext(temp);
            temp.setPrev(front);
            rear.setPrev(temp);
            temp.setNext(rear);
        }
        else
        {
            temp.setPrev(rear.getPrev());
            rear.getPrev().setNext(temp);
            temp.setNext(rear);
            rear.setPrev(temp);            
        }
    }

    @Override
    public void addPos(int position, int value)
    {
        if(position<0||position>size())throw new ArrayIndexOutOfBoundsException();
        
        DNode temp=new DNode(value);
        
        if(front.getNext()==null)
        {
            front.setNext(temp);
            temp.setPrev(front);
            rear.setPrev(temp);
            temp.setNext(rear);
        }
        else
        {
            DNode pluck=front.getNext();
            int counter=0;
            while(pluck!=rear&&counter++<position)
            {
                pluck=pluck.getNext();
            }
            temp.setPrev(pluck.getPrev());
            pluck.setPrev(temp);
            temp.getPrev().setNext(temp);
            temp.setNext(pluck);
        }
    }

    @Override
    public void delStart()
    {
        if(size()==0)throw new ArrayIndexOutOfBoundsException();
        front.setNext(front.getNext().getNext());
        front.getNext().setPrev(front);
        if(front.getNext()==rear)
        {
            front=new DNode();
            rear=new DNode();
        }
    }

    @Override
    public void delEnd()
    {
        if(size()==0)throw new ArrayIndexOutOfBoundsException();
        rear.setPrev(rear.getPrev().getPrev());
        rear.getPrev().setNext(rear);
        if(front.getNext()==rear)
        {
            front=new DNode();
            rear=new DNode();
        }
    }

    @Override
    public void delPos(int position)
    {
        if(position<0||position>=size())throw new ArrayIndexOutOfBoundsException();
            
        if(front.getNext()==rear)
        {
            front=new DNode();
            rear=new DNode();
        }  
        else
        {
            DNode pluck=front.getNext();
            int counter=0;
            while(pluck!=rear&&counter++<position)
            {
                pluck=pluck.getNext();
            }
            pluck.getPrev().setNext(pluck.getNext());
            pluck.getNext().setPrev(pluck.getPrev());
        }
    }

    @Override
    public void set(int position, int value)
    {
        if(position<0||position>=size())throw new ArrayIndexOutOfBoundsException();
        DNode pluck=front;
        int counter=0;
        while(pluck.getNext()!=null&&counter++<=position)
        {
            pluck=pluck.getNext();
        }
        pluck.setData(value);
    }

    @Override
    public int get(int position)
    { 
        if(position<0||position>=size())throw new ArrayIndexOutOfBoundsException();       
        DNode pluck=front.getNext();
        int counter=0;
        while(pluck.getNext()!=rear&&counter++<position)
        {
            pluck=pluck.getNext();
        }
        return pluck.getData();
    }

    @Override
    public void clear()
    {        
        front=new DNode();
        rear=new DNode();
    }

    @Override
    public int size()
    {             
        DNode pluck=front;
        int counter=0;
        while(pluck.getNext()!=rear&&pluck.getNext()!=null)
        {
            pluck=pluck.getNext();
            ++counter;
        }
        return counter;
    }

    @Override
    public void sort()
    {
        if(size()<2) return;
        DNode lastSorted=rear;
        while(front.getNext().getNext()!=lastSorted)
        {
            DNode tmp=front.getNext();
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
    public void revers()
    {
        if(size()<2) return;
        DNode first=front.getNext();
        while(first.getNext()!=rear)
        {
            DNode tmp=first.getNext();
            first.setNext(tmp.getNext());
            tmp.getNext().setPrev(first);
            tmp.setNext(front.getNext());
            front.getNext().setPrev(tmp);
            front.setNext(tmp);
            tmp.setPrev(front);
            
        }
    }

    @Override
    public IList copy()
    {
        LList2p2l temp=new LList2p2l();
        DNode tempParent=temp.front;
        DNode pluck=front;
        
        while(pluck.getNext()!=rear)
        {
            pluck=pluck.getNext();
            DNode n=new DNode(pluck.getData());
            tempParent.setNext(n);
            tempParent.getNext().setPrev(tempParent);
            tempParent=tempParent.getNext();
        }        
        temp.rear.setPrev(tempParent);
        tempParent.setNext(temp.rear);
        return temp;
    }

    @Override
    public String toString()
    {
        String result="";
        if(size()>0)
        {
            DNode pluck=front.getNext();

            while(pluck!=rear)
            {
                boolean b=(front.getNext()==pluck)?true:false;

                if(b) result=""+pluck.getData();
                else result=result + " "+pluck.getData();
                pluck=pluck.getNext();
            }      
        }
        return result;
    }
    @Override
    public int[] toArray()
    {
        int[]arr=new int[size()];
        if(size()>0)
        {
            int i=0;
            DNode pluck=front.getNext();

            while(pluck!=rear)
            {
                arr[i++]=pluck.getData();
                pluck=pluck.getNext();
            }      
        }
        return arr;
    }

    @Override
    public Iterator<Integer> iterator()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean hasNext()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object next()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
