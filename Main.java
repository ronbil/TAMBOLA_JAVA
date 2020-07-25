import java.io.*;
public class Main
{
	public static void main(String args[])
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s1=null;
		String s2=null;
		System.out.println("ENTER THE NAME OF PLAYER 1");
		try {
			s1=br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("ENTER THE NAME OF PLAYER 2");
		try {
			s2=br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		SharedData obj=new SharedData();
		//Moderator mod=new Moderator(obj);
		Moderator mod=Moderator.getInstance(obj);
		Player p1=new Player(obj,0,s1);
		Player p2=new Player(obj,1,s2);
		
		System.out.println("THE PLAYERS HAVE THE FOLLOWING CARDS INITIALLY");
		p1.display();
		p2.display();
	
		Thread t1=new Thread(mod);
		Thread t2=new Thread(p1);
		Thread t3=new Thread(p2);
		t1.start();
		t2.start();
		t3.start();	
	}
}
