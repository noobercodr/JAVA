import java.util.*;
class recursion
{
    public static void main(String args[])
    {
        Scanner ob=new Scanner(System.in);
        System.out.println("enter the size of array");
        int n=ob.nextInt();
        int a[]=new int[n];
        System.out.println("enter the elements of the array");
        for(int i=0;i<n;i++)
        a[i]=ob.nextInt();
        System.out.println("reverse array is");
        rev(a,n,0);
    }
    static int rev(int b[],int n,int i)
    {
       if(i>=n)
       return 0;
       else
       {
           rev(b,n,i+1);
           System.out.print(b[i]);
           return 0;
       }
    }
}
