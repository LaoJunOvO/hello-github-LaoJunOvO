package com.test;
import java.util.Scanner;
import java.lang.Math;

class DecimalToOthers
{
	protected StringBuilder decimal;
	protected int remainder;
	protected String result;
	
	protected DecimalToOthers(StringBuilder decimal)
	{
		this.decimal=decimal;
	}
	
	protected String Calculator()
	{
		result="";
		return "";
	}
}

class DecimalToBinary extends DecimalToOthers
{
	
	
	public DecimalToBinary(StringBuilder decimal)
	{
		super(decimal);
	}
	
	@Override
	public String Calculator()
	{
		super.Calculator();
		StringBuilder two=new StringBuilder();
		int num=Integer.parseInt(decimal.toString());
		if(num==0)
		{
			return "0";
		}
		boolean judgement=true;
		while(judgement)
		{
			remainder=num%2;
			num=num/2;
			two.append(remainder);
			if(num==0)
			{
				two.reverse();
				judgement=false;
			}
		}
		result=two.toString();
		return result;
	}
}

class DecimalToOctal extends DecimalToOthers
{
	public DecimalToOctal(StringBuilder decimal)
	{
		super(decimal);
	}
	
	@Override
	public String Calculator()
	{
		super.Calculator();
		StringBuilder eight=new StringBuilder();
		int num=Integer.parseInt(decimal.toString());
		if(num==0)
		{
			return "0";
		}
		boolean judgement=true;
		while(judgement)
		{
			remainder=num%8;
			num=num/8;
			eight.append(remainder);
			if(num==0)
			{
				eight.reverse();
				judgement=false;
			}
		}
		result=eight.toString();
		return result;
	}
}

class DecimalToHex extends DecimalToOthers
{
	public DecimalToHex(StringBuilder decimal)
	{
		super(decimal);
	} 
	
	@Override
	public String Calculator()
	{
		super.Calculator();
		StringBuilder sixteen=new StringBuilder();
		int num=Integer.parseInt(decimal.toString());
		if(num==0)
		{
			return "0";
		}
		boolean judgement=true;
		while(judgement)
		{
			remainder=num%16;
			num=num/16;
			switch(remainder)
			{
			   case 10:
				   char number1='A';
				   sixteen.append(number1);
				   break;
			   
			   case 11:
				   char number2='B';
				   sixteen.append(number2);
				   break;
				   
			   case 12:
				   char number3='C';
				   sixteen.append(number3);
				   break;
				   
			   case 13:
				   char number4='D';
				   sixteen.append(number4);
				   break;
				   
			   case 14:
				   char number5='E';
				   sixteen.append(number5);
				   break;
				   
			   case 15:
				   char number6='F';
				   sixteen.append(number6);
				   break;
				   
			   default:
				   sixteen.append(remainder);
			   break;
			   
			}
			if(num==0)
			{
				sixteen.reverse();
				judgement=false;
			}
		}
		result=sixteen.toString();
		return result;
	}
}

class BinaryToOthers
{
	protected StringBuilder binary;
	protected int remainder;
	protected String result;
	
	protected BinaryToOthers(StringBuilder binary)
	{
		this.binary=binary;
	}
	
	protected String Calculator()
	{
		result="";
		return "";
	}
}

class BinaryToDecimal extends BinaryToOthers
{
	
	public BinaryToDecimal(StringBuilder binary)
	{
		super(binary);
	}
	
	@Override
	public String Calculator()
	{
		super.Calculator();
		binary.reverse();
		int num1=0;
		int totalNum=0;
		for(int i=0;i<binary.length();i++)
		{
			num1=binary.charAt(i)-'0';
			totalNum += num1*Math.pow(2, i);
		}
		result=Integer.toString(totalNum);
		return result;
	}
}

class BinaryToOctal extends BinaryToOthers
{
	
	public BinaryToOctal(StringBuilder binary)
	{
		super(binary);
	}
	
	@Override
	public String Calculator()
	{
		super.Calculator();
		BinaryToOthers decimal=new BinaryToDecimal(binary);
		String num1=decimal.Calculator();
		StringBuilder num2=new StringBuilder(num1);
		DecimalToOthers octal=new DecimalToOctal(num2);
		result=octal.Calculator();
		return result;
	}
}

class BinaryToHex extends BinaryToOthers
{
	
	public BinaryToHex(StringBuilder binary)
	{
		super(binary);
	}
	
	public String Calculator()
	{
		super.Calculator();
		BinaryToOthers decimal=new BinaryToDecimal(binary);
		String num1=decimal.Calculator();
		StringBuilder num2=new StringBuilder(num1);
		DecimalToOthers hex=new DecimalToHex(num2);
		result = hex.Calculator();
		return result;
	}
}

class OthersToBinary
{
	protected StringBuilder inPut;
	protected String result;
	
	protected OthersToBinary(StringBuilder inPut)
	{
		this.inPut=inPut;
	}
	
	protected String Calculator()
	{
		result="";
		return "";
	}
}

interface ChangeToDecimal
{
	String Change(StringBuilder Octal);
}

class OctalToBinary extends OthersToBinary implements ChangeToDecimal
{
	
	public OctalToBinary(StringBuilder inPut)
	{
		super(inPut);
	}
	
	@Override
	public String Change(StringBuilder Octal)
	{
		char digit;
		StringBuilder binary=new StringBuilder();
		for(int i=0;i<Octal.length();i++)
		{
			digit=Octal.charAt(i);
			switch(digit)
			{
			case '1':
				binary.append("001");
				break;
				
			case '2':
				binary.append("010");
				break;
				
			case '3':
				binary.append("011");
				break;
				
			case '4':
				binary.append("100");
				break;
				
			case '5':
				binary.append("101");
				break;
				
			case '6':
				binary.append("110");
				break;
				
			case '7':
				binary.append("111");
				break;
				
			default:
				break;
			}	
		}
		String number=binary.toString();
		return number;
	}
	
	public String Calculator()
	{
		super.Calculator();
		result=Change(inPut);
		return result;
	}
}

class HexToBinary extends OthersToBinary implements ChangeToDecimal
{
	public HexToBinary(StringBuilder inPut)
	{
		super(inPut);
	}
	
	@Override
	public String Change(StringBuilder Octal)
	{
		char digit;
		StringBuilder binary=new StringBuilder();
		for(int i=0;i<Octal.length();i++)
		{
			digit=Octal.charAt(i);
			switch(digit)
			{
			case '1':
				binary.append("0001");
				break;
				
			case '2':
				binary.append("0010");
				break;
				
			case '3':
				binary.append("0011");
				break;
				
			case '4':
				binary.append("0100");
				break;
				
			case '5':
				binary.append("0101");
				break;
				
			case '6':
				binary.append("0110");
				break;
				
			case '7':
				binary.append("0111");
				break;
				
			case '8':
				binary.append("1000");
				break;
				
			case '9':
				binary.append("1001");
				break;
				
			case 'A':
				binary.append("1010");
				break;
				
			case 'B':
				binary.append("1011");
				break;
				
			case 'C':
				binary.append("1100");
				break;
				
			case 'D':
				binary.append("1101");
				break;
				
			case 'E':
				binary.append("1110");
				break;
				
			case 'F':
				binary.append("1111");
				break;
				
			default:
				break;
			}	
		}
		String number=binary.toString();
		return number;
	}
	public String Calculator()
	{
		super.Calculator();
		result=Change(inPut);
		return result;
	}
}

public class BaseConversion
{
	
	public static String TenToTwo(Scanner sc)
	{
		
		System.out.println("请输入十进制数字");
		String ten=sc.next();
		sc.nextLine();
		StringBuilder decimal=new StringBuilder(ten);
		DecimalToOthers decimalToBinary=new DecimalToBinary(decimal);
		return decimalToBinary.Calculator();
	}
	
	public static String TenToEight(Scanner sc)
	{
		
		System.out.println("请输入十进制数字");
		String ten=sc.next();
		sc.nextLine();
		StringBuilder octal=new StringBuilder(ten);
		DecimalToOthers decimalToOctal=new DecimalToOctal(octal);
		return decimalToOctal.Calculator();
	}
	
	public static String TenToSixteen(Scanner sc)
	{
		System.out.println("请输入十进制数字");
		String sixteen=sc.next();
		sc.nextLine();
		StringBuilder tex=new StringBuilder(sixteen);
		DecimalToOthers decimalToOctal=new DecimalToHex(tex);
		return decimalToOctal.Calculator();
	}
	
	public static String InputBinary(Scanner sc)
	{
		String number2=sc.next();
		sc.nextLine();
		for(int i=0;i<number2.length();i++)
		{
			if(number2.charAt(i)!='1'&&number2.charAt(i)!='0')
			{
				System.out.println("你输入的不是二进制数字，请重新输入");
				return "error";
			}
		}
		return number2;
	}
	
	public static String TwoToTen(Scanner sc)
	{
		String number=null;
		boolean weiShuJudgement=true;
		while(weiShuJudgement)
		{
			System.out.println("请输入二进制数字");
			String judgement=InputBinary(sc);
			if(!judgement.equals("error"))
			{
				number=judgement;
				weiShuJudgement=false;
			}			
		}
		StringBuilder binary=new StringBuilder(number);
		BinaryToOthers binaryToDecimal=new BinaryToDecimal(binary);
		return binaryToDecimal.Calculator();
	}
	
	public static String TwoToEight(Scanner sc)
	{
		String number=null;
		boolean weiShuJudgement=true;
		while(weiShuJudgement)
		{
			System.out.println("请输入二进制数字");
			String judgement=InputBinary(sc);
			if(!judgement.equals("error"))
			{
				number=judgement;
				break;
			}			
		}
		StringBuilder binary=new StringBuilder(number);
		BinaryToOthers binaryToOctal=new BinaryToOctal(binary);
		
		return binaryToOctal.Calculator();
	}
	
	public static String TwoToSixteen(Scanner sc)
	{
		String number=null;
		boolean weiShuJudgement=true;
		while(weiShuJudgement)
		{
			System.out.println("请输入二进制数字");
			String judgement=InputBinary(sc);
			if(!judgement.equals("error"))
			{
				number=judgement;
				break;
			}			
		}
		StringBuilder binary=new StringBuilder(number);
		BinaryToOthers binaryToHex=new BinaryToHex(binary);
		return binaryToHex.Calculator();
	}
	
	public static String InputOctal(Scanner sc)
	{
		String number2=sc.next();
		sc.nextLine();
		for(int i=0;i<number2.length();i++)
		{
			if(number2.charAt(i)!='0'&&number2.charAt(i)!='1'&&number2.charAt(i)!='2'&&number2.charAt(i)!='3'&&number2.charAt(i)!='4'&&number2.charAt(i)!='5'&&number2.charAt(i)!='6'&&number2.charAt(i)!='7')
			{
				System.out.println("你输入的不是八进制数字，请重新输入");
				return "error";
			}
		}
		return number2;
	}
	
	public static String EightToTwo(Scanner sc)
	{
		String number="";
		boolean weiShuJudgement=true;
		while(weiShuJudgement)
		{
			System.out.println("请输入八进制数字");
			String judgement=InputOctal(sc);
			if(!judgement.equals("error"))
			{
				number=judgement;
				break;
			}			
		}
		StringBuilder octal=new StringBuilder(number);
		OthersToBinary octalToTwo=new OctalToBinary(octal);
		return octalToTwo.Calculator();
	}
	
	public static String InputHex(Scanner sc)
	{
		String number2=sc.next();
		sc.nextLine();
		for(int i=0;i<number2.length();i++)
		{
			if(number2.charAt(i)!='0'
			   	&&number2.charAt(i)!='1'
		        &&number2.charAt(i)!='2'
				&&number2.charAt(i)!='3'
				&&number2.charAt(i)!='4'
				&&number2.charAt(i)!='5'
				&&number2.charAt(i)!='6'
				&&number2.charAt(i)!='7'
				&&number2.charAt(i)!='8'
				&&number2.charAt(i)!='9'
				&&number2.charAt(i)!='A'
				&&number2.charAt(i)!='B'
				&&number2.charAt(i)!='C'
				&&number2.charAt(i)!='D'
				&&number2.charAt(i)!='E'
				&&number2.charAt(i)!='F')
			{
				System.out.println("你输入的不是十六进制数字，请重新输入");
				return "error";
			}
		}
		return number2;
	}
	
	public static String SixteenToTwo(Scanner sc)
	{
		String number="";
		boolean weiShuJudgement=true;
		while(weiShuJudgement)
		{
			System.out.println("请输入十六进制数字");
			String judgement=InputHex(sc);
			if(!judgement.equals("error"))
			{
				number=judgement;
				break;
			}			
		}
		StringBuilder hex=new StringBuilder(number);
		OthersToBinary hexToBinary=new HexToBinary(hex);
		return hexToBinary.Calculator();
	}
	
	public static boolean SecondChoice(Scanner sc)
	{
		while(true)
		{
			System.out.println("您是否还要继续进行计算？1.是\t2.否");
			String secondChoice=sc.next();
			sc.nextLine();
			if(secondChoice.equals("1"))
			{
				return true;
				
			}
			else if(secondChoice.equals("2"))
			{
				System.out.println("感谢您的再次使用");
				return false;
			}
			else
			{
				System.out.println("输入错误，请重新输入");
				return true;
			}
		}
	}
	
	
	public static void UserChoice(Scanner sc)
	{
		boolean judgement=true;
		while(judgement)
		{
			System.out.println("请输入你想进行的进制计算:\n1.十转二   2.十转八\n3.十转十六 4.二转十\n5.二转八   6.二转十六\n7.八转二   8.十六转二");
			String firstChoice=sc.next();
			sc.nextLine();
			switch(firstChoice)
			{
			case "1":
				System.out.printf("转化为二进制的计算结果为:%s\n",TenToTwo(sc));
				break;
			case "2":
				System.out.printf("转化为八进制的计算结果为:%s\n",TenToEight(sc));
				break;
			case "3":
				System.out.printf("转化为十六进制的计算结果为:%s\n",TenToSixteen(sc));
				break;
			case "4":
				System.out.printf("转化为十进制的计算结果为:%s\n",TwoToTen(sc));
				break;
			case "5":
				System.out.printf("转化为八进制的结果为:%s\n", TwoToEight(sc));
				break;
			case "6":
				System.out.printf("转化为十六进制的结果为:%s\n", TwoToSixteen(sc));
				break;
			case "7":
				System.out.printf("转化为二进制的结果为:%s\n", EightToTwo(sc));
				break;
			case "8":
				System.out.printf("转化为二进制的结果为:%s\n", SixteenToTwo(sc));
				break;
			default:
				System.out.println("输入错误，请重新输入");	
				break;
			}
			if(!SecondChoice(sc))
			{
				break;
			}
		}
	}
	
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		UserChoice(sc);
	}
}