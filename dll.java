import java.util.*;
public class dob
{
    class node
    {
        int data;
        node previous;
        node next;
    
        public node(int data)
        {
            this.data=data;
        }
    }
    node head,tail=null;
    public void addNode(int data)
    {
        node newnode=new node(data);
        if(head==null)
        {
            head=tail=newnode;
            newnode.previous=null;
            newnode.next=null;
        }
        else
        {
            tail.next=newnode;
            newnode.previous=tail;
            tail=newnode;
        }
    }
    public void delete(int data)
    {
        node curr=head;
        if(head==null)
        {
            System.out.println("list is empty");
        }
        else if(curr.data==data)
        {
            head=curr.next;
            curr.next.previous=null;
        }
        else
        {
            while(curr.data!=data)
            {
                curr=curr.next;
            }
            if(curr.next==null)
            {
                tail=tail.previous;
                tail.next=null;
            }
            else
            {
                curr.previous.next=curr.next;
                curr.next.previous=curr.previous;
            }
        }
    }
    public void display()
    {
        node temp=head;
        if(head==null)
        {
            System.out.println("list is empty");
        }
        while(temp!=null)
        {
            System.out.print(temp.data+" -> ");
            temp=temp.next;
        }
        System.out.println();
    }
    public static void main(String args[])
    {
        dob oj=new dob();
        System.out.println(" 1) Add a Node\n 2) Delete a Node 3) Display a Node");
        Scanner ob=new Scanner(System.in);
        while(true)
        {
            System.out.println("enter ur choice");
            int num=ob.nextInt();
            switch(num)
            {
                case 1:System.out.println("enter the data");
                       int data2=ob.nextInt();
                       oj.addNode(data2);
                       break;
                case 2: System.out.println("enter the data to be deleted");
                        int data1=ob.nextInt();
                        oj.delete(data1);
                        break;
                case 3 :oj.display();
                        break;
                case 4 :System.exit(0);
            }
        }
    }
}
