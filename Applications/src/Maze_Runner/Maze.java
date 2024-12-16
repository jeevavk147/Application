package Maze_Runner;
import java.util.*;
public class Maze 
{
	Queue<Node> q=new LinkedList<>();
	char[][] board;
	public void board(int r,int c)
	{
		board=new char[r][c];
		for(int i=0;i<r;i++)
		{
			for(int j=0;j<c;j++)
			{
				board[i][j]='0';
			}
		}
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
		System.out.println();
	}
	public void put_Treasure(int r,int c)
	{
		board[r][c]='T';
		viewboard();
	}
	public void put_Adventurer(int r,int c)
	{
		board[r][c]='A';
		viewboard();
		System.out.println(shortest_path(r,c));
	}
	public int shortest_path(int r,int c)
	{
		boolean[][] visited=new boolean[board.length][board[0].length];
		int[][] move= {{0,-1},{0,1},{1,0},{-1,0}};
		visited[r][c]=true;
		q.add(new Node(r,c,0,null));
		while(!q.isEmpty())
		{
			Node currentnode=q.poll();
		for(int[] i:move)
		{
			int next_row=i[0]+currentnode.r;
			int next_col=i[1]+currentnode.c;
			if(next_row>=0&&next_row<board.length&&next_col>=0&&next_col<board[0].length&&!visited[next_row][next_col])
			{
			if(board[next_row][next_col]=='T')
			{
				int steps=currentnode.steps+1;
				board[currentnode.r][currentnode.c]='.';
				while(currentnode.previous!=null)
				{					
					Node nn=currentnode.previous;
					if(board[nn.r][nn.c]!='A')
					board[nn.r][nn.c]='.';
					currentnode=currentnode.previous;
				}
			viewboard();
				return steps;
			}
			visited[next_row][next_col]=true;
			q.add(new Node(next_row,next_col,currentnode.steps+1,currentnode));

			}
		}
		}
		return -1;
	}
}
