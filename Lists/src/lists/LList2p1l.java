package lists;

public class LList2p1l extends LList1p1l
{
    private Node tail;
    
    public LList2p1l()
    {
        super();
        tail=new Node();
    }
    
    @Override
    public void init(int[] initArray)
    {
        Node parent=root;
        for(int i=0;i<initArray.length;++i)
        {
            Node temp=new Node(initArray[i]);
            parent.setNext(temp);
            parent=temp;
        }
        tail.setNext(parent);
    }
    
    @Override
    public void addEnd(int value)
    {   
        Node temp=new Node(value);     
        if(root.getNext()==null)
        {
            root.setNext(temp);
            tail.setNext(temp);
        }
        else
        {
            tail.getNext().setNext(temp);
            tail.setNext(temp);
        }
    }
    
    @Override
    public void delEnd()
    {
        if(size()==0)throw new ArrayIndexOutOfBoundsException();
        Node pluck=root;
        Node prePluck=null;
        while(pluck.getNext()!=null)
        {
            prePluck=pluck;
            pluck=pluck.getNext();
        }
        prePluck.setNext(null);
        tail.setNext(prePluck);
    }    
    
    @Override
    public void clear()
    {
        super.clear();
        tail=new Node();
    }
}
