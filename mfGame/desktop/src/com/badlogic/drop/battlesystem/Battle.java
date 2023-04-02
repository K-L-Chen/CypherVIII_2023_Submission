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
	public Battler getPlayerAction(int action, int target) 
	{
	    if(battlenum == 2)
	    {
	    	if(target == 1)
	    	{
	    		if(action == 1)
	    		{
	    			player.attack(enemy);
	    			return enemy;
	    		}
	    		else if(action == 2)
	    		{
	    			player.skill1(enemy);
	    			return enemy;
	    		}
	    		else
	    		{
	    			player.skill2(enemy);
	    			return enemy;
	    		}
	    			
	    	}
	    	else
	    	{
	    		if(action == 1)
	    		{
	    			player.attack(enemy2);
	    			return enemy;
	    		}
	    		else if(action == 2)
	    		{
	    			player.skill1(enemy2);
	    			return enemy;
	    		}
	    		else
	    		{
	    			player.skill2(enemy2);
	    			return enemy;
	    		}
	    			
	    	}
	    }
	    else 
	    {
    		if(action == 1)
    		{
    			player.attack(enemy);
    			return enemy;
    		}
    		else if(action == 2)
    		{
    			player.skill1(enemy);
    			return enemy;
    		}
    		else
    		{
    			player.skill2(enemy);
    			return enemy;
    		}
	    }
	}
	public Battler EnemyAction(Battler curEnemy) {
		int randomAction = rand.nextInt(3);
		switch(randomAction) 
		{
			
		case 0:
			curEnemy.attack(player);
			return player;
		case 1:
			curEnemy.skill1(player);
			return player;
		case 2:
			curEnemy.skill2(player);
			return player;
		}
		return player;
	}
	
	// Main method for testing purposes
	public static void main(String[] args) {

	}
}
