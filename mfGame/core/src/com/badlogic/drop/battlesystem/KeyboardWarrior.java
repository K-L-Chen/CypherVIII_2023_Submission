package com.badlogic.drop.battlesystem;

public class KeyboardWarrior extends Class{
	
	public KeyboardWarrior(int hp, int mp, float defmult, float attmult) {
		super(hp, mp, defmult, attmult);
		this.skill1 = "Skill1 Name";
		this.skill2 = "Skill2 Name";
	}
	
	@Override 
	public int skill1() {
		return 0;
	}
	
	@Override
	public int skill2() {
		return 0;
	}

}
