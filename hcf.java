import java.util.*;
class gcd
{
     public static void main(String args[])
    {
        Scanner ob=new Scanner(System.in);
        System.out.println("enter your numbers");
        int a=ob.nextInt();
        int b=ob.nextInt();
        System.out.println("gcd is "+hcf(a,b));
    }
    static int hcf(int a,int b)
        {
                while(a>0&&b>0)
                {
                    if(a>b)
                    a=a%b;
                    else
                    b=b%a;
                }
                return a+b;
                
        }
    
}
