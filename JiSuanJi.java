package com.test;
import java.util.Scanner;

class ShiShuCalculator
{
	private double a;
	private double b;
	public ShiShuCalculator()
	{
		
	}
	public ShiShuCalculator(double a,double b)
	{
		this.a=a;
		this.b=b;
	}
	public double Minus()
	{
		return a-b;
	}
	public double Add()
	{
		return a+b;
	}
	public double Multiple()
	{
		return a*b;
	}
	public double Divide()
	{
		if(b==0)
		{
			System.out.println("输入错误，请重新输入");
			return 0.0;
		}
		else
		{
			return a/b;
		}
		
	}
}

class FuShuCalculator
{
	private double a;
	private double b;
	private double c;
	private double d;
	public FuShuCalculator()
	{
		
	}
	public FuShuCalculator(double a,double b,double c,double d)
	{
		this.a=a;
		this.b=b;
		this.c=c;
		this.d=d;
	}
	public double[] plus()
	{
		double shiBu=a+c;
		double xuBu=b+d;
		double[] plusArr=new double[] {shiBu,xuBu};
		return plusArr;
	}
	public double[] minus()
	{
		double shiBu=a-c;
		double xuBu=b-d;
		double[] plusArr=new double[] {shiBu,xuBu};
		return plusArr;
	}
	//(a+bi)*(c+di)=ac-bd+(ad+bc)i
	public double[] multiply()
	{
		double shiBu=a*c-b*d;
		double xuBu=a*d+b*c;
		double[] plusArr=new double[] {shiBu,xuBu};
		return plusArr;
	}
	//(a+bi)/(c+di)=((ac+bd)+(bc-ad)i)/(c^2+d^2)
	public double[] divide()
	{
		
		
		if(c==0&&d==0)
		{
			System.out.println("输入错误，请重新输入");
			
			return null;
		}
		else
		{
			double fenMu=c*c+d*d;
			double shiBu=(a*c+b*d)/fenMu;
			double xuBu=(b*c-a*d)/fenMu;
			double[] plusArr=new double[] {shiBu,xuBu};
			return plusArr;
		}
	}
}




public class JiSuanJi
{
	public static void ShiShuCalculationChoice(Scanner sc)
	{
		boolean judge=true;
		while(judge)
		{
			System.out.printf("请选择你要执行的运算：%n1.加法 %n2.减法 %n3.乘法 %n4.除法");
			String shiShuChoice=sc.next();
			
			switch(shiShuChoice)
			{
			case "1":
				System.out.println("请输入一个加数");
				double a1=sc.nextDouble();
				System.out.println("请输入另一个加数");
				double b1=sc.nextDouble();
				ShiShuCalculator shiShuCalculator1=new ShiShuCalculator(a1,b1);
				System.out.printf("计算结果为：%2f%n", shiShuCalculator1.Add());
				judge=false;
				break;
			case "2":
				System.out.println("请输入被减数");
				double a2=sc.nextDouble();
				System.out.println("请输入减数");
				double b2=sc.nextDouble();
				ShiShuCalculator shiShuCalculator2=new ShiShuCalculator(a2,b2);
				System.out.printf("计算结果为：%2f%n", shiShuCalculator2.Minus());
				judge=false;
				break;
			case "3":
				System.out.println("请输入一个乘数");
				double a3=sc.nextDouble();
				System.out.println("请输入另一个乘数");
				double b3=sc.nextDouble();
				ShiShuCalculator shiShuCalculator3=new ShiShuCalculator(a3,b3);
				System.out.printf("计算结果为：%2f%n", shiShuCalculator3.Multiple());
				judge=false;
				break;
			case "4":
				System.out.println("请输入被除数");
				double a4=sc.nextDouble();
				System.out.println("请输入除数");
				double b4=sc.nextDouble();
				ShiShuCalculator shiShuCalculator4=new ShiShuCalculator(a4,b4);
				System.out.printf("计算结果为：%2f%n", shiShuCalculator4.Divide());
				judge=false;
				break;
			default:
				System.out.println("输入错误，请重新输入");
				break;
			}
		}
		sc.nextLine();
	}
	public static void FuShuDivideCalculator(Scanner sc)
	{
		System.out.println("请输入第一个复数的实部");
		double a4=sc.nextDouble();
		System.out.println("请输入第一个复数的虚部");
		double b4=sc.nextDouble();
		System.out.println("请输入第二个复数的实部");
		double c4=sc.nextDouble();
		System.out.println("请输入第二个复数的虚部");
		double d4=sc.nextDouble();
		if(c4==0&&d4==0)
		{
			System.out.println("输入错误，请重新输入");
		}
		else
		{
			FuShuCalculator fuShuCalculator4=new FuShuCalculator(a4,b4,c4,d4);
			double[] plusArr=fuShuCalculator4.divide();
			System.out.printf("计算结果为:%2f+%2fi%n",plusArr[0],plusArr[1]);	
			
		}
		
	}
	public static void FuShuCalculationChoice(Scanner sc)
	{
		
		boolean judge=true;
		while(judge)
		{
			System.out.printf("请选择你要执行的运算：%n1.加法 %n2.减法 %n3.乘法 %n4.除法");
			String fuShuChoice=sc.next();
			
			switch(fuShuChoice)
			{
				case "1":
					System.out.println("请输入第一个复数的实部");
					double a1=sc.nextDouble();
					System.out.println("请输入第一个复数的虚部");
					double b1=sc.nextDouble();
					System.out.println("请输入第二个复数的实部");
					double c1=sc.nextDouble();
					System.out.println("请输入第二个复数的虚部");
					double d1=sc.nextDouble();
					FuShuCalculator fuShuCalculator1=new FuShuCalculator(a1,b1,c1,d1);
					double[] plusArr1=fuShuCalculator1.plus();
					System.out.printf("计算结果为:%2f+%2fi%n",plusArr1[0],plusArr1[1]);
					judge=false;
					break;
				case "2":
					System.out.println("请输入第一个复数的实部");
					double a2=sc.nextDouble();
					System.out.println("请输入第一个复数的虚部");
					double b2=sc.nextDouble();
					System.out.println("请输入第二个复数的实部");
					double c2=sc.nextDouble();
					System.out.println("请输入第二个复数的虚部");
					double d2=sc.nextDouble();
					FuShuCalculator fuShuCalculator2=new FuShuCalculator(a2,b2,c2,d2);
					double[] plusArr2=fuShuCalculator2.minus();
					System.out.printf("计算结果为:%2f+%2fi%n",plusArr2[0],plusArr2[1]);
					judge=false;
					break;
				case "3":
					System.out.println("请输入第一个复数的实部");
					double a3=sc.nextDouble();
					System.out.println("请输入第一个复数的虚部");
					double b3=sc.nextDouble();
					System.out.println("请输入第二个复数的实部");
					double c3=sc.nextDouble();
					System.out.println("请输入第二个复数的虚部");
					double d3=sc.nextDouble();
					FuShuCalculator fuShuCalculator=new FuShuCalculator(a3,b3,c3,d3);
					double[] plusArr3=fuShuCalculator.multiply();
					System.out.printf("计算结果为:%2f+%2fi%n",plusArr3[0],plusArr3[1]);
					judge=false;
					break;
				case "4":
					FuShuDivideCalculator(sc);
					judge=false;
					break;
			     default:
			    	System.out.println("输入错误，请重新输入");
			    	break;	
			}
		}
		sc.nextLine();
	}
	public static String UserChoice(Scanner sc)
	{
		
		boolean judge=true;
		while(judge)
		{
			System.out.println("请选择你想进行的运算");
			System.out.printf("1.实数运算%n2.复数运算%n");
			String firstChoice=sc.nextLine().trim();
			
			if(firstChoice.equals("1"))
			{
				
				String result="1";
				return result;
				
			}
			else if(firstChoice.equals("2"))
			{
				
				String result="2";
				return result;
			}
			else
			{
				
				System.out.println("输入错误，请重新输入");
			}
		}
		return null;
	}
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			String choice=UserChoice(sc);
			if(choice.equals("1"))
			{
				ShiShuCalculationChoice(sc);
			}
			else if(choice.equals("2"))
			{
				FuShuCalculationChoice(sc);
			}
			else
			{
				System.out.println("输入错误，请重新输入");
			}	
		}
	}
}