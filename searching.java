package hw3;

import java.io.*;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class searching {
	public void sorting(String s[],int length)//method for bubble sort
	{
		int i,j;
		for(i=0;i<length;i++)
		{
			for(j=0;j<length-i-1;j++)
			{
				if(s[j].compareTo(s[j+1])>=1)//swapping of strings
				{
					String ab=s[j];
					s[j]=s[j+1];
					s[j+1]=ab;
					
				}
			}
		}
	}
	public static void main(String[] args)throws Exception
	{
		int count=0,i=0;
		 FileWriter fw=new FileWriter("C:\\Users\\WELCOME\\Desktop\\JAVA LAB\\HW3\\hw3.txt");
		 File ke=new File("C:\\Users\\WELCOME\\Desktop\\JAVA LAB\\HW3\\HW3-unsorted-keywords.txt");
		 File input=new File("C:\\Users\\WELCOME\\Desktop\\JAVA LAB\\HW3\\HW3-input-code.cpp");
		 Scanner key=new Scanner(ke);    //reading unsorted keywords file
		 Scanner inp=new Scanner(input);
		 //reading input code file
		 //Counting no of lines in unsorted keyword file
		 while(key.hasNextLine())
		 {
			 String t=key.nextLine();
			 if(t.length()>0)
			 count++;
		 }
		 //Dynamic allocation of string variable
		 String keyword[]=new String[count];
	     Scanner te=new Scanner(ke);
	     //reading keyword file and storing each line in string array 
		 while(te.hasNextLine())
		 {
			 String t=te.nextLine();
			 if(t.length()>0) {
				 keyword[i]=t;
				 i++;
			 } 
		 }
		 //declaring object of class Searching
		 searching se=new searching();
		 //calling sorting function
		 se.sorting(keyword,count);
		int m=0;int line_number=1,l=0;
		 //reading input code file
		 while(inp.hasNextLine())
		 {
			 String t=inp.nextLine();
			 t=t.replaceAll("(//[^\\n]*)",""); //replaces all comments
			 t=t.replaceAll("[^\\w\\s]+"," "); // replaces all special characters except alphanumeric characters with blankspaces
			 String q[]=t.split(" ");
			 int k=0,pos=0;
			 //searching string element in keyword string
		     for(i=0;i<q.length;i++)
			 {
				if(Arrays.asList(keyword).contains(q[i]))
				{
					pos=t.indexOf(q[i],-1);
					if(k==0){
					System.out.print("Line "+line_number+": "+q[i]+"("+pos+")"+" ");
					fw.write("Line "+line_number+": "+q[i]+"("+pos+")"+" ");
					m++;}
					else {
						System.out.print(q[i]+"("+pos+")"+" ");m++;
						fw.write("Line "+line_number+": "+q[i]+"("+pos+")"+" ");
					}
					k++;
				}	

			 }
			 if(k!=0) {
				 fw.write("\r\n");
				System.out.println();
				l++;}
			 line_number++;
		 }
		 System.out.println("Number of Keywords found="+m);
		 fw.write("Number of Keywords found="+m);
		 key.close();
		 te.close();
		 fw.close();
	 }
}
