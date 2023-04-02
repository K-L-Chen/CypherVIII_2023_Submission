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
	public ArrayList<Battler> getPlayerAction(int action, int target) 
	{
		ArrayList<Battler> current = new ArrayList<Battler>();
	    if(battlenum == 2)
	    {
	    	if(target == 1)
	    	{
	    		if(action == 1)
	    		{
	    			player.attack(enemy);
	    			current.add(player);
	    			current.add(enemy);
	    			return current;
	    		}
	    		else if(action == 2)
	    		{
	    			player.skill1(enemy);
	    			current.add(player);
	    			current.add(enemy);
	    			return current;
	    		}
	    		else
	    		{
	    			player.skill2(enemy);
	    			current.add(player);
	    			current.add(enemy);
	    			return current;
	    		}
	    			
	    	}
	    	else
	    	{
	    		if(action == 1)
	    		{
	    			player.attack(enemy2);
	    			current.add(player);
	    			current.add(enemy2);
	    			return current;
	    		}
	    		else if(action == 2)
	    		{
	    			player.skill1(enemy2);
	    			current.add(player);
	    			current.add(enemy2);
	    			return current;
	    		}
	    		else
	    		{
	    			player.skill2(enemy2);
	    			current.add(player);
	    			current.add(enemy2);
	    			return current;
	    		}
	    			
	    	}
	    }
	    else 
	    {
    		if(action == 1)
    		{
    			player.attack(enemy);
    			current.add(player);
    			current.add(enemy);
    			return current;
    		}
    		else if(action == 2)
    		{
    			player.skill1(enemy);
    			current.add(player);
    			current.add(enemy);
    			return current;
    		}
    		else
    		{
    			player.skill2(enemy);
    			current.add(player);
    			current.add(enemy);
    			return current;
    		}
	    }
	}
	public Battler EnemyAction(Battler curEnemy) {
		int randomAction = rand.nextInt(3);
		ArrayList<Battler> current = new ArrayList<Battler>();
		switch(randomAction) 
		{
			
		case 0:
			curEnemy.attack(player);
			current.add(player);
			current.add(curEnemy);
			return player;
		case 1:
			curEnemy.skill1(player);
			current.add(player);
			current.add(curEnemy);
			return player;
		case 2:
			curEnemy.skill2(player);
			current.add(player);
			current.add(curEnemy);
			return player;
		}
		return player;
	}
	
	// Main method for testing purposes
	public static void main(String[] args) {

	}
}
