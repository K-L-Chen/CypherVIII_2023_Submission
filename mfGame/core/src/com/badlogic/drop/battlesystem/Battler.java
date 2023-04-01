package com.badlogic.drop.battlesystem;

public class Battler {
	public float curHp;
	public float maxHp;
	public float curMp;
	public float maxMp; 
	public float  defenceMult;
	public float attackMult;
	public boolean isDefeated;
	
	public Battler(float hp, float mp) {
		maxHp = curHp = hp;
		maxMp = curMp = mp;
		defenceMult = 0;
		attackMult = 1;
		isDefeated = false;
	}
	
	public void debug() {
		System.out.println("maxHp: " + maxHp);
		System.out.println("maxMp: " + maxMp);
		System.out.println("curHp: " + curHp);
		System.out.println("curMp: " + curMp);
		System.out.println("defenceMult: " + defenceMult);
		System.out.println("attackMult: " + attackMult);
		System.out.println("isDefeated: " + isDefeated);
	}
	
	public void damageOpponent(Battler opponent, float attackValue) {
		System.out.println("OPPONENT HP BEFORE: " + opponent.curHp);
		float attackDamage = (attackMult - defenceMult) * attackValue;
		opponent.curHp = opponent.curHp -  attackDamage;
		System.out.println("OPPONENT HP AFTER: " + opponent.curHp);
	}
	
	public void attack(Battler opponent)
	{
		damageOpponent(opponent, 50);
		
	}
	
	public void skill1(Battler opponent) {
		
	}
	
	public void skill2(Battler opponent) {
		
	}
	
	public boolean isDefeated()
	{
		return this.isDefeated;
	}
	
	public void resetAttackMult()
	{
		attackMult = 1;
	}

	public void resetDefMult()
	{
		defenceMult = 1;
	}
}
