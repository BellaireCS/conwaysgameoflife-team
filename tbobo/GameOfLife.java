package tbobo;

import java.util.Random;

public class GameOfLife {
	
	private boolean[][] gameGrid;
	private int time;
	private int population;
	private static final int size;
	
	static {
		size = 10;
	}
	
	{
		gameGrid = new boolean[size][size];
		time = 0;
		population = 0;
	}
	
	// If no parameters, generate random game
	public GameOfLife() {

		Random randomBool = new Random();
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < gameGrid[i].length; j++) {
				if(gameGrid[i][j] = randomBool.nextBoolean())
					population++;
			}
		}
	}
	
	// Accepts coordinates for desired alive cells in row x col format
	public GameOfLife(int[][] coordinates) {
		for (int i = 0; i < coordinates.length; i++) {
			gameGrid[coordinates[i][0]][coordinates[i][1]] = true;
			population++;
		}
	}
	
	public void setCell(int row, int col, boolean alive) {
		gameGrid[row][col] = alive;
	}
	
	
	public boolean isAlive(int row, int col) {
		return gameGrid[row][col];
	}
	public int getNeighborCount(int row, int col) {
		int count = 0;
		int west = col - 1 >= 0 ? col - 1 : size - 1;
		int north = row - 1 >= 0 ? row - 1 : size - 1;
		int south = (row + 1) % size;
		int east = (col + 1) % size;
		
		final int[][] neighbors = {{north, west}, {north, col}, {north, east},
								   {row, west},					{row, east},
								   {south, west}, {south, col},	{south, east}};
		
		for (int i = 0; i < neighbors.length; i++) {
			if (gameGrid[neighbors[i][0]][neighbors[i][1]]) {
				count++;
			}
		}
		
		return count;
	}
	
	public void display() {	
		
		for (int i = 0; i < gameGrid.length; i++) {
			for (int j = 0; j < gameGrid[i].length; j++) {
				char cell = (gameGrid[i][j]) ? 'X' : '-';
				
				System.out.print(cell + " ");
			}
			
			System.out.println();
		}
		
		System.out.println("time: " + time);
		System.out.println("population: " + population);
	}
	
	public static void main(String[] args) {
		GameOfLife test = new GameOfLife(new int[][]{{0,0}, {1,2}, {9, 0}});
		test.display();
		System.out.println(test.getNeighborCount(9, 9));
	}
}
