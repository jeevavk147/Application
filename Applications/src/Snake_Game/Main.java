package Snake_Game;
import java.util.*;
public class Main 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		Snake s=new Snake();
		s.snakeboard(5,5);
		int r=sc.nextInt();
		int c=sc.nextInt();
		s.putSnake(--r,--c);
		char move;
		boolean loop=true;
		while(!(s.q.isEmpty())) {
		move=sc.next().charAt(0);
		move=Character.toUpperCase(move);
		switch(move)
		{
		case 'R':
			if(r>=0&&r<s.board.length && c+1>=0&&c+1<s.board[0].length)
			  s.move(r,++c);
			break;
		case 'L':
			if(r>=0&&r<s.board.length && c-1>=0&&c-1<s.board[0].length)
			  s.move(r,--c);
			break;
		case 'U':
			if(r-1>=0&&r-1<s.board.length && c>=0&&c<s.board[0].length)
			  s.move(--r,c);
			break;
		case 'D':
			if(r+1>=0&&r+1<s.board.length && c>=0&&c<s.board[0].length)
			  s.move(++r, c);
			break;
		default:
			System.out.println("Invalid Move");
		}	
			
		}
	}
}
