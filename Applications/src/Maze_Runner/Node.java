package Maze_Runner;

public class Node {
int r;
int c;
int steps;
Node previous;
Node(int r,int c,int steps, Node previous)
{
	this.c=c;
	this.r=r;
	this.steps=steps;
	this.previous=previous;
}
}
