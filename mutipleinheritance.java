import java.util.Scanner;

interface Sports{
	float sportwt = 6.0F;
	abstract void putwt(); 
}

class Student{
	int rollnumber;
	public void getNumber(){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter roll number: ");
		this.rollnumber = sc.nextInt();
	}
	public void putNumber(){
		System.out.println("Roll number: "+this.rollnumber);
	}
}

class Test extends Student{
	double term1, term2;
	public void getMarks(){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter term 1 mark: ");
		this.term1 = sc.nextDouble();
		System.out.print("Enter term 2 mark: ");
		this.term2 = sc.nextDouble();
	}
	public void putMarks(){
		System.out.println("term 1 mark: "+ this.term1 +"\nterm 2 mark: "+ this.term2);
	}
}

class Results extends Test implements Sports{
	public void putwt(){
		System.out.println("Sports weight: "+sportwt);
	}
	public void display(){
		super.getNumber();
		super.getMarks();
		super.putNumber();
		putMarks();
		putwt();
		System.out.println("Total score: "+(super.term1+super.term2+sportwt));
	}
}

public class Mulit{
	public static void main(String args[]){
		Results re = new Results();
		re.display();
	}
}
