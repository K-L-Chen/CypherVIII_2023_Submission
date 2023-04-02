package com.badlogic.drop.battlesystem;

public class OpenSourceBanbit extends Battler {
	
	public OpenSourceBanbit(int hp, int mp) {
		super(hp, mp);
	}
	
	@Override
	public void attack(Battler Other)
	{
		double totalmult = (this.attackMult - Other.defenceMult);
		if(totalmult == 0)
		{
			totalmult = 0.1;
		}
		Other.curHp = (int) (Other.curHp - (10*totalmult));
		if(Other.curHp < 0)
		{
			Other.isDefeated = true;
		}
	}
	
	@Override 
	public void skill1(Battler Other) {
		double totalmult = (this.attackMult - Other.defenceMult);
		if(totalmult == 0)
		{
			totalmult = 0.1;
		}
		Other.curHp = (int) (Other.curHp - (10*totalmult));
		Other.defenceMult = Other.defenceMult/1.5;
		if(Other.curHp < 0)
		{
			Other.isDefeated = true;
		}
	}
	
	@Override
	public void skill2(Battler Other) {
		double totalmult = (this.attackMult - Other.defenceMult);
		if(totalmult == 0)
		{
			totalmult = 0.1;
		}
		Other.curHp = (int) (Other.curHp - 3*(10*totalmult));
		Other.defenceMult = Other.defenceMult/1.5;
		if(Other.curHp < 0)
		{
			Other.isDefeated = true;
		}
	}
	
	@Override
	public String getSkill1Name()
	{
		return "Go-N-Back";
		
	}
	
	@Override
	public String getSkill2Name()
	{
		return "Multi-Threaded Strike";
		
	}
}