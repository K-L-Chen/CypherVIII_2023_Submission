package com.badlogic.drop.battlesystem;

public class Class {
	protected int hp;
	protected int mp;
	protected final int attack = 100; 
	protected final int defense = 100; 
	protected float defmult;
	protected float attmult;
	protected String skill1;
	protected String skill2;
	
	public Class(int hp, int mp, float defmult, float attmult) {
		this.hp = hp;
		this.mp = mp;
		this.defmult = defmult;
		this.attmult = attmult;
	}
	
	public int skill1() {
		
		return 0;
	}
	
	public int skill2() {
		
		return 0;
	}
	
	public String getSkill1Name() {
		return skill1;
	}
	
	public String getSkill2Name() {
		return skill2;
	}
}
