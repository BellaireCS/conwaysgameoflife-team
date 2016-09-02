package tbobo;

import java.util.Random;

public class GameOfLife {
	
	private boolean[][] gameGrid;
	private int time;
	private int population;
	private static final int size;
	
	static {
		size = 30;
	}
	
	{
		gameGrid = new boolean[size][size];
		time = 0;
		population = 0;
	}
	
	/* 
	 * Generates random game if no constructor params
	 */
	public GameOfLife() {

		Random randomBool = new Random();
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < gameGrid[i].length; j++) {
				if(gameGrid[i][j] = randomBool.nextBoolean())
					population++;
			}
		}
	}
	
	/* 
	 * Coordinates come in row by column in a int matrix of 1x2 matrices 
	 */
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
	
	public void nextTurn() {
		boolean[][] newBoard = new boolean[size][size];
		int newPop = 0;
		
		for (int i = 0; i < gameGrid.length; i++) {
			for (int j = 0; j < gameGrid[i].length; j++) {
				int neighborCount = getNeighborCount(i, j);
				
				if (gameGrid[i][j]) {
					if (neighborCount < 2) {
						newBoard[i][j] = false;
					}
					
					else if (neighborCount > 3) {
						newBoard[i][j] = false;
					}
					
					else {
						newBoard[i][j] = true;
						newPop++;
					}
				}
				
				else {
					if (neighborCount == 3) {
						newBoard[i][j] = true;
						newPop++;
					}
					
					else {
						newBoard[i][j] = false;
					}
				}
			}
		}
		
		gameGrid = newBoard;
		time++;
		population = newPop;
	}
	
	/*
	 * Console "GUI"
	 */
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
	
	/*
	 * Infinite loop to run the game
	 */
	public void go() {
		while (true) {
			display();
			nextTurn();
			
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		
		int[][] coordinates = {{5, 2}, {7, 2}, {4, 3}, {4, 4}, {4,5}, {4,6}, {5,6}
								,{6,6}, {7, 5}
		};
		GameOfLife test = new GameOfLife(coordinates);
		test.go();
	}
}
