package src;

import java.util.Random;

public class ThreeDoors {
	//Private Data Members
	private int[] door = new int[3];
	private static Random random = new Random();
	
	//Empty Constructor
	ThreeDoors() {}
	
	//Private Methods
	//Given a value a, pick a random value for b where a =/ b and within bounds
	private int chooseTwo(int a) {
		int b = random.nextInt(3);
		while (b == a) b = random.nextInt(3);
		return b;
	}
	
	//Given values a and b, pick the remaining value for c using the logic that
	//a + b =  1 -> c = 2 || a + b = 2 -> c = 1 || a + b = 3 -> c = 0
	private int chooseThree(int a, int b) {
		if (a + b == 1) return 2;
		else if (a + b == 2) return 1;
		else return 0;
	}
	
	private void displayMessage(int n, int w) {
		System.out.println("After " + n + " trials, the probability of winning a car if you"
				+ " switch doors is " + (double) w / n + ".");
	}
	
	//Given d[3], return a randomly shuffled array where each value is distinct
	public int[] shuffleArray(int[] d) {
		d[0] = random.nextInt(3);
		d[1] = chooseTwo(d[0]);
		d[2] = chooseThree(d[0], d[1]);
		return d;
	}
	
	//Given a shuffled array, randomly pick one door
	//Assume 0 represents a car and 1 and 2 represent goats
	public boolean winner(int[] d) {
		int choice = random.nextInt(3);
		if(d[choice] == 0) return false;
		else return true;
	}
	
	//This method will run n number of simulations and return wins / n
	//which is the probability of switching and winning
	public void runSimulations(int n) {
		int wins = 0;
		for (int i = 0; i < n; i++) {
			shuffleArray(door);
			if(winner(door)) wins++;
		}
		displayMessage(n, wins);
	}
	
	//Main Method
	public static void main(String[] arg) {
		ThreeDoors ex = new ThreeDoors();
		ex.runSimulations(100000000);
	}
}
