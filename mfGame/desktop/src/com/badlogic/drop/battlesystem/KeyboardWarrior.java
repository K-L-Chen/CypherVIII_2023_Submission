package com.badlogic.drop.battlesystem;

public class KeyboardWarrior extends Battler{
	
	public KeyboardWarrior(int hp, int mp) {
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
		if(Other.curHp <= 0)
		{
			Other.isDefeated = true;
		}
	}
	
	@Override
	public void skill1(Battler Other) {
		if(this.curMp < 10)
		{
			//Not Enough mp
		}
		else
		{
			this.curMp = this.curMp-20;
			this.attackMult = this.attackMult*1.2;
			this.defenceMult = this.defenceMult/1.5;
		}
	}
	
	@Override 
	public void skill2(Battler Other) {
		if(this.curMp < 20)
		{
			//Not enough MP
		}
		else
		{
			this.curMp = this.curMp-20;
			double totalmult = (this.attackMult - Other.defenceMult);
			if(totalmult == 0)
			{
				totalmult = 0.1;
			}
			Other.curHp = (int) (Other.curHp - (20*totalmult));
			if(Other.curHp <= 0)
			{
				Other.isDefeated = true;
			}
		}
	}
	
	@Override
	public String getSkill1Name()
	{
		return "Rage";
		
	}
	
	@Override
	public String getSkill2Name()
	{
		return "Keyboard Smash";
		
	}
}
