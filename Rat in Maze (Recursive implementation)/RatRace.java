import java.util.Scanner;

public class RatRace {
	
	public static boolean done = false;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
	
		int rows = in.nextInt();
		int columns = in.nextInt();
		char[][] maze = new char[rows][columns];
		
		for(int i = 0; i < rows; i++) {
			String curr = in.next();
			for(int j = 0; j < columns; j++) {
				maze[i][j] = curr.charAt(j);
			}
		}
		System.out.println();
		
		solve(maze, 0, 0);
		if(maze[maze.length-1][maze[0].length-1] == 'R') 
			System.out.println("Solved!");
		else
			System.out.println("No solution :(");
	}
	
	//Recursive method that moves the rat (represented by R) through the maze
	public static void solve (char[][] maze, int x, int y) {
		try {
			maze[x][y] = 'R';
			printArr(maze);
			
			if((x == (maze.length-1)) && (y == (maze[0].length-1))) {
				done = true;
				return;
			}
			
			else {
				if((y+1) < maze.length && maze[x][y+1] != '*' && maze[x][y+1] != 'X' && !done) {
					maze[x][y] = '*';
					Thread.sleep(100);
					solve(maze, x, (y+1));
					maze[x][y] = '-';
				}
				if((x+1) < maze[0].length && maze[x+1][y] != '*' && maze[x+1][y] != 'X' && !done) {
					maze[x][y] = '*';
					Thread.sleep(100);
					solve(maze, (x+1), y);
					maze[x][y] = '-';
				}
				if((y-1) >= 0 && maze[x][y-1] != '*' && maze[x][y-1] != 'X' && !done) {
					maze[x][y] = '*';
					Thread.sleep(100);
					solve(maze, x, (y-1));
					maze[x][y] = '-';
				}
				//System.out.println(maze[x-1][y]);
				if((x-1) >= 0 && maze[x-1][y] != '*' && maze[x-1][y] != 'X' && !done) {
					maze[x][y] = '*';
					Thread.sleep(100);
					solve(maze, (x-1), y);
					maze[x][y] = '-';
				}
				maze[x][y] = '-';
				Thread.sleep(10);
			}
		} catch (Exception e) {}
	}
	
	public static void printArr(char[][] maze) {
		for(int r = 0; r < maze.length; r++) {
			for(int c = 0; c < maze[r].length; c++) {
				System.out.print(maze[r][c]);
			}
			System.out.println();
		}
		System.out.println();
	}
}