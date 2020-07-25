import java.util.*;
public class SharedData 
{
	ArrayList<Integer>al=new ArrayList<Integer>();
	public boolean gameCompleteFlag ;
	private int contents;
	private int available;


	public SharedData()
	   {
	   	gameCompleteFlag=false;
	   	available=0;
	   	contents=0;
	   }

	  /* public int avl()
	   {
	   	return available;
	   }*/

	   public synchronized int get() 
	   {
	      while (available == 0) 
	      {
	         try
	         {
	            wait();
	         }

	         catch (InterruptedException e) {
	        	 System.out.println("COULDN'T WAIT");
	         }
	      }
		  //System.out.println("available to be updated   " +available );
	      available-- ;
	      notifyAll();
	      return contents;
	   }
	   
	   public synchronized void put(int value) 
	   {
	      while (available != 0)
	      {
	         try {
				 wait();
	         }
	         catch (InterruptedException e) { }
//			  continue;
	      }
	      try {

	          Thread.sleep(1000);

	       } catch (InterruptedException e) { }
//		   System.out.println("WAIT");
	      contents=value;
	      available = 2;
	      al.add(value);
	      notifyAll();
	   }
}
