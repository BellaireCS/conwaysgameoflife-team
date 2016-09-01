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
	
	public GameOfLife() {
		gameGrid = new boolean[size][size];
		time = 0;
		population = 0;
		
		Random randomBool = new Random();
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < gameGrid[i].length; j++) {
				if(gameGrid[i][j] = randomBool.nextBoolean())
					population++;
			}
		}
	}
	
	// Potential console display; swing might be better
	/*
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
	*/
	
	public static void main(String[] args) {
		GameOfLife test = new GameOfLife();
	}
}
