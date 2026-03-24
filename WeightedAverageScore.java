package com.test;
import java.util.Scanner;


class WACalculator
{
	private double[] scores=new double[100];
	private double[] credits=new double[100];
	private int count;
	public WACalculator(double[] arrScores,double[] arrCredits,int count)
	{
		for(int i=0;i<count;i++)
		{
			this.scores[i]=arrScores[i];
			this.credits[i]=arrCredits[i];
		}
		this.count=count;
	}

	public double WAScoreCalculator()
	{
		double totalScores=0;
		double totalCredits=0;
		for(int i=0;i<count;i++)
		{
			
			totalCredits+=credits[i];
			totalScores+=scores[i]*credits[i];
			
		}
		if(totalCredits==0.0)
		{
			return 0.0;
		}
		return totalScores/totalCredits;
	}
}



public class WeightedAverageScore 
{
	public static int Userinput(Scanner sc,double[] arrScores,double[] arrCredits)
	{
		int count=0;
		Calculator:
		for(int i=0;i<100;i++)
    	{
    		System.out.println("请输入你的分数");
    		double scores=sc.nextDouble();
    		arrScores[i]=scores;
    		System.out.println("请输入你的学分");
    		double credits=sc.nextDouble();
    		arrCredits[i]=credits;
    		count++;	
    		
			while(true)
			{
				System.out.println("输入1：继续输入另一个学科的数据；输入0：开始计算加权平均分");
				String xuanZe=sc.next();
				if(xuanZe.equals("1"))
				{
					break;
				}
				else if(xuanZe.equals("0"))
    			{
    				break Calculator;
    			}
				else
    			{
    				System.out.println("输入错误，请重新输入!");
    			}
			}
    	}
		return count;
	}
    public static void main(String[] args)
    {
    	double[] arrScores=new double[100];
    	double[] arrCredits=new double[100];
    	Scanner sc=new Scanner(System.in);
    	int count=Userinput(sc,arrScores,arrCredits);
    	WACalculator calculator=new WACalculator(arrScores,arrCredits,count);
    	System.out.printf("你的加权平均分是%.2f%n",calculator.WAScoreCalculator());
    }
}
