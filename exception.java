import java.util.*;
import java.io.*;
public class feq
{
    public static void main(String args[]) throws ArrayIndexOutOfBoundsException
    {
        try
        {
            int a=args.length;
            int d=5;
            int e=d/a;
            int c[]={1};
            c[42]=42;
        }
        catch(ArithmeticException e)
        {
            System.out.println(e);
        }
        finally
        {
            System.out.println("exception blocks exceuted");
        }
    }
}
