import java.util.*;

class Thenga {
    int Partition(String a[], int lb, int ub) {
        int start = lb;
        int end = ub;
        String pivot = a[lb];
        while (start < end) {
            while (start <= ub && a[start].compareTo(pivot) <= 0)
                start++;
            while (end >= lb && a[end].compareTo(pivot) > 0)
                end--;
            
            if (start < end) {
                String temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }
        }
        String temp1 = a[lb];
        a[lb] = a[end];
        a[end] = temp1;
        return end;
    }

    void QuickSort(String a[], int lb, int ub) {
        Thenga ob = new Thenga();
        if (lb < ub) {
            int loc = ob.Partition(a, lb, ub);
            QuickSort(a, lb, loc - 1);
            QuickSort(a, loc + 1, ub);
        }
    }
}

public class dob {
    public static void main(String args[]) {
        Scanner ob = new Scanner(System.in);
        System.out.println("Enter the length of the array:");
        int n = ob.nextInt();
        ob.nextLine();
        String s[] = new String[n];
        System.out.println("Enter the words:");
        for (int i = 0; i < n; i++) {
            s[i] = ob.nextLine();
        }
        int lb = 0;
        int ub = n - 1;
        Thenga ob1 = new Thenga();
        ob1.QuickSort(s, lb, ub);
        System.out.println("Sorted array is:");
        for (String w : s) {
            System.out.print(w + " ");
        }
    }
}
