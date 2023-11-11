import java.util.*;
class recursion
{
   static int print(int i,int a)
    {
        if(i>a)
        return 0;
        else
        print(i+1,a);
        System.out.println(i);
        return 0;
    }
    public static void main(String args[])
    {
        Scanner ob=new Scanner(System.in);
        System.out.println("enter your number");
        int a=ob.nextInt();
        print(1,a);
    }
}
