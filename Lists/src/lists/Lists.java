package lists;
public class Lists
{
    public static void main(String[] args)
    {
        IList arr=new LList2p2l();
        int[]tempArray={4,56,66};
        arr.init(tempArray);
        
        for(int element:arr)
        {
            System.out.println(element);
        }
    }
}
