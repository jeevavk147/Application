package Snake_Game;
import java.util.*;
public class Snake 
{
	 char[][] board;
	Queue<Node> q=new LinkedList<>();
	public void snakeboard(int r,int c)
	{
		board =new char[r][c];
		for(int i=0;i<r;i++)
		{
			for(int j=0;j<c;j++)
			{
				board[i][j]='0';
			}
		}
		snakelength();
	}
    public void snakelength()
    {
    	board[0][4]='X';
    	board[1][3]='X';
    	board[2][2]='X';
    	board[3][1]='X';
    	board[4][0]='X';
    	viewboard();
    }
	public void viewboard() 
	{
		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board[0].length;j++)
			{
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	public void putSnake(int r,int c)
	{
		board[r][c]='.';
		q.add(new Node(r,c,board[r][c]));
		viewboard();
	}

	public void move(int r, int c) 
	{
		
		
		if(board[r][c]=='X')
		{
			board[r][c]='.';
			q.add(new Node(r,c,board[r][c]));
			viewboard();
		}
		else if(board[r][c]=='.')
		{
			System.out.println("Game Over!!");		
		}
		else 
		{
		Node n=q.poll();
		board[r][c]=n.val;
		q.add(new Node(r,c,board[r][c]));
		board[n.r][n.c]='0';
		viewboard();
		}
	
	}
	
}

