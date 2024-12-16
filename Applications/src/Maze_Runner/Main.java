package Maze_Runner;
import java.util.*;
public class Main 
{
	public static void main(String[] args)
	{
	 Maze m=new Maze();
	 Scanner sc=new Scanner(System.in);
	 m.board(5, 5); 
	 System.out.println("Enter Treasures Row and Column: ");
	 int rt=sc.nextInt(),ct=sc.nextInt();
	 m.put_Treasure(--rt,--ct);
	 System.out.println("Enter Adventurer's Row and Column: ");
	 int ra=sc.nextInt(),ca=sc.nextInt();
     m.put_Adventurer(--ra,--ca);
	}
}
