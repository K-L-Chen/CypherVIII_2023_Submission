package com.badlogic.drop.battlesystem;

public class CompSciMageor extends Battler {
	
	public CompSciMageor(int hp, int mp) {
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
		if(this.curMp < 10)
		{
			//Not enough MP
		}
		else
		{
			this.curMp = this.curMp-10;
			this.curHp = this.curHp+10;
			if(this.curHp > this.maxHp)
			{
				this.curHp = this.maxHp;
			}
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
			Other.attackMult = Other.attackMult/1.5;
			Other.defenceMult = Other.defenceMult/1.5;
		}
	}
	
	@Override
	public String getSkill1Name()
	{
		return "Healing Potion (Raw caffeine) 10MP";
		
	}
	
	@Override
	public String getSkill2Name()
	{
		return "Hack'em 20MP";
		
	}
}
