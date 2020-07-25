
import java.util.*;
public class Moderator implements Runnable
{
	public static Moderator instance;
	private static SharedData obj;
	private int numberGenerated=0;
	
	/*public Moderator(SharedData obj)
	{
		this.obj=obj;
	}*/
	
	private Moderator(SharedData obj)
	{
		Moderator.obj=obj;
	}
	
	public static Moderator getInstance(SharedData obj)
	{
		if(instance==null)
		{
			instance=new Moderator(obj);
		}
		return instance;
	}
	
	public void run()
	{
System.out.println("MODERATOR STARTED");
		 	while(!obj.gameCompleteFlag && obj.al.size()<10)
		  {
			  	Random num=new Random();
				this.numberGenerated=num.nextInt(50)+1;
			    obj.put(this.numberGenerated);
			    //System.out.println();
			    System.out.println("Moderator has generated " + this.numberGenerated);
			    
			    try {
		            Thread.sleep(1000);
//					System.out.println("wait");
		         } catch (InterruptedException e) {

//			    	System.out.println("we have error");
				}
		  }
			
		  if(obj.gameCompleteFlag==false)
		  {
			  System.out.println();
			  System.out.println("Unfortunately,no one has won :(");
		  }
	}
}
