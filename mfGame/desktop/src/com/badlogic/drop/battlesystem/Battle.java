package com.badlogic.drop.battlesystem;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;



public class Battle {
	
	Battler player;
	Random rand = new Random();
	int battlenum = 0;
	Battler enemy = null;
	Battler enemy2 = null;
	public Battle(Battler player, int battlenumber, Battler Enemy) {
		this.player = player;
		this.battlenum = battlenumber;
		this.enemy = Enemy;
	}
	public Battle(Battler player, int battlenumber, Battler Enemy, Battler Enemy2) {
		this.player = player;
		this.battlenum = battlenumber;
		this.enemy = Enemy;
		this.enemy = Enemy2;
	}
	public void getPlayerAction() {
		
		Scanner scanner = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Enter action of 1 through 3");
	    int action = Integer.valueOf(scanner.nextLine());  // Read user input
	    //System.out.println("Action was: " + action);  // Output user input
	    if(battlenum == 2)
	    {
	    	System.out.println("Pick target 1 or 2");
	    	int target = Integer.valueOf(scanner.nextLine());
	    	if(target == 1)
	    	{
	    		if(action == 1)
	    		{
	    			player.attack(enemy);
	    		}
	    		else if(action == 2)
	    		{
	    			player.skill1(enemy);
	    		}
	    		else
	    		{
	    			player.skill2(enemy);
	    		}
	    			
	    	}
	    	else
	    	{
	    		if(action == 1)
	    		{
	    			player.attack(enemy2);
	    		}
	    		else if(action == 2)
	    		{
	    			player.skill1(enemy2);
	    		}
	    		else
	    		{
	    			player.skill2(enemy2);
	    		}
	    			
	    	}
	    }
	    else 
	    {
    		if(action == 1)
    		{
    			player.attack(enemy);
    		}
    		else if(action == 2)
    		{
    			player.skill1(enemy);
    		}
    		else
    		{
    			player.skill2(enemy);
    		}
	    }
	    scanner.close();
	}
	public void EnemyAction(Battler curBattler) {
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
	
	// Main method for testing purposes
	public static void main(String[] args) {

	}
}
