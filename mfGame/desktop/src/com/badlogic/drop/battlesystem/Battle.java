package com.badlogic.drop.battlesystem;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;



public class Battle {
	
	Battler player;
	ArrayList<Battler> opponents;
	Random rand = new Random();
	
	public Battle(Battler player, ArrayList<Battler> opponents) {
		this.player = player;
		this.opponents = opponents;
	}
	
	public void getPlayerAction() {
		
		Scanner scanner = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Enter action of 0 through 3");
	    int action = Integer.valueOf(scanner.nextLine());  // Read user input
	    System.out.println("Action was: " + action);  // Output user input
	    System.out.println("Pick target 0 through 1");
	    int target = Integer.valueOf(scanner.nextLine());
	    player.attack(opponents.get(target));
	    scanner.close();
	}
	public void takeAction(Battler curBattler) {
		if(curBattler.equals(player)) {
			getPlayerAction();
		}
		
		// An additional check will need to be made for every buffing skill:
		else {
			int randomAction = rand.nextInt(3);
			switch(randomAction) {
			
			case 0:
				curBattler.attack(player);
				break;
			case 1:
				curBattler.skill1(player);
				break;
			case 2:
				curBattler.skill2(player);
				break;
			}
		}
	}
	
	// Main method for testing purposes
	public static void main(String[] args) {
		Battler player = new Battler(100, 100);
		Battler opp1 = new Battler(100, 100);
//		Battler opp2 = new Battler(10, 10);
		ArrayList<Battler> opponents = new ArrayList<>();
		opponents.add(opp1);
//		opponents.add(opp2);
		Battle curBattle = new Battle(player,opponents);
	    
		System.out.println("Player debug:");
		player.debug();
		System.out.println("Opponent debug:");
		opp1.debug();
	    curBattle.takeAction(player);
	    opp1.debug();
    	for(Battler opponent : opponents) {
    		System.out.println("Opponent debug:");
    		opponent.debug();
    		curBattle.takeAction(opponent);
    		
    	}
	    
	}
}
