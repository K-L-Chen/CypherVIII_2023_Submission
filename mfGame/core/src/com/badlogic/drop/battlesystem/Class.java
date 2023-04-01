package com.badlogic.drop.battlesystem;

public class Class {
	public int hp;
	public int maxhp;
	public int mp;
	public int maxmp;
	public final int attack = 100; 
	public final int defense = 100; 
	public double defmult;
	public double attmult;
	public boolean isDefeated;
	
	public Class(int hp, int mp) {
		this.hp = hp;
		this.maxhp = hp;
		this.mp = mp;
		this.maxmp = mp;
		this.defmult = 1;
		this.attmult = 1;
		this.isDefeated = false;
	}
	
	public void attack(Class Other)
	{
		
	}
	
	public void skill1(Class Other) {
		
	}
	
	public void skill2(Class Other) {
		
	}
	
	public boolean isDefeated()
	{
		return this.isDefeated;
	}
	
	public void resetAttackMult()
	{
		this.attmult = 1;
	}

	public void resetDefMult()
	{
		this.defmult = 1;
	}
}
