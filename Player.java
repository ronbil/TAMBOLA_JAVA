import java.util.*;
public class Player implements Runnable
{
	private SharedData obj;
	private int id;
	private int[] arr=new int[10];
	private int count=0;
	private String name;
	//private HashSet<Integer> st=new HashSet<Integer>();
	
	public Player(SharedData obj,int id,String name)
	{
		this.obj=obj;
		this.id=id;
		this.name=name;
		Random num=new Random();
		int i=0;
		for(i=0;i<10;i++)
		{
			arr[i]=num.nextInt(50)+1;
		}
	}
	public void display()
	{
		System.out.println("The PLAYER "+this.name+" WITH ID "+ this.id+" HAS THE FOLLOWING CARDS:");

		for(int i=0;i<10;i++)
			System.out.print(arr[i]+"  ");
		
		System.out.println();
	}
	public void run()
	{
		while(!obj.gameCompleteFlag)
		{
		int value=obj.get();
		int flag=0;
			for(int i=0;i<10;i++)
			{
				if(arr[i]==value)
				{
//					System.out.println(obj.avl());
					System.out.println("THE PLAYER " +this.name+" WITH ID "+this.id+" HAS GOT THIS CARD");

					flag=1;
					this.count++;
					arr[i]=51;//jisse ye firse strikeout na ho kyuki range 1-50 ki h
					break;//to prevent striking all the redundant occurrences of a number
				}
			}
			
			if(flag==0)
			{
//				System.out.println(obj.avl());
				System.out.println("THE PLAYER "+this.name+" WITH ID "+this.id+" DON'T HAS GOT THIS CARD");
			}
			
			if(count==3)
			{
				System.out.println("Congratulations! The PLAYER "+this.name+" WITH ID "+this.id+" has won !!");
				obj.gameCompleteFlag=true;
				System.exit(0);
			}
	}}

}
