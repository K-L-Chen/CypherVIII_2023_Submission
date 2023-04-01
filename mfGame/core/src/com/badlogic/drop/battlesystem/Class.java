package com.badlogic.drop.battlesystem;

public class Class {
	private int hp;
	private int mp;
	private final int attack = 100; 
	private final int defense = 100; 
	private float defmult;
	private float attmult;
	
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
	
}
