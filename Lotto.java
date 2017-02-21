
package exercise2;


import java.security.SecureRandom;

import javax.swing.JOptionPane;

public class Lotto {  // Lotto class for game

	int sum;     // instance variable 
	int arr[]=new int[3];    
	
	public Lotto(int arr[],int s) //constructor randomly populates lotto numbers 
	{
		for(int i=0;i<3;i++)
		{
			this.arr[i]=arr[i];
			System.out.printf("%nValues showing from Constructor:%n %d random value: %d",i+1,this.arr[i]);	 // populates array from constructor
	        
		}
		System.out.printf("%nSum of random values: %d", s);
		
		set_sum(s);
	}
	
	public void lottogame()// method for selecting random values
	{
		int sum=0;
		
		SecureRandom randomN = new SecureRandom();
	 	
		 for(int j=0;j<3;j++)
		  {
			int value=1+randomN.nextInt(9);                   // storing random value from 1-9
			arr[j]=value;
		    sum=sum+arr[j];
		  }
		 Lotto ob=new Lotto(arr,sum);     // calling constructor from inside method
	
		set_sum(sum);
		 
	}
	
	public void set_sum(int sum)//  method to set value of sum
	{
		this.sum=sum;
	}
	public int get_sum() // method to get sum value
	{
		return this.sum;
		
	}
	public int[] returnArray()     // method to return an array
	{
		
		return this.arr;    // returning an array
	}
	
	public static void main(String[] args) // main method
	{
		
		// TODO Auto-generated method stub
		SecureRandom randomN = new SecureRandom();
		
		int ar1[]=new int[3];
		int sum=0;
		int s=0;
		
		 for(int j=0;j<3;j++)
		  {
			int value=1+randomN.nextInt(9);                   // storing random value from 1-9
			ar1[j]=value;
		    sum=sum+ar1[j];
		  }
	
		Lotto obj=new Lotto(ar1,sum); // creating object inside main function
		
		String op=JOptionPane.showInputDialog("Choose no. between 3-27: ");
		
		int ch=Integer.parseInt(op);
		
		if(ch>=3 && ch<=27)
		{
		
			for(int i=0;i<5;i++) // loop for user to run lotto upto 5 times
			{
				s=obj.get_sum();
			
				if(ch==s)  // comparing sum and choice that user enter
			
				{
					JOptionPane.showMessageDialog(null, "YOU WIN");  
			
					System.exit(0);  //if user wins program exit
				}
			
				else
				{
				
					JOptionPane.showMessageDialog(null, "YOU LOOSE!!!!");
			
				}
		
				obj.lottogame();// calling method to get random values 
				
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Please Try again......\n\n\n\n(Choose between 3 to 27)");// message when user choose wrong integer 
		}
	}

}
