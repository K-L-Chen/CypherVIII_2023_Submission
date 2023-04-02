package com.badlogic.drop.battlesystem;

public class KeyboardWarrior extends Battler{
	
	public KeyboardWarrior(int hp, int mp) {
		super(hp, mp);
	}
	
	@Override
	public void attack(Battler Other)
	{
		double totalmult = (this.attackMult - Other.defenceMult)+1;
		Other.curHp = (int) (Other.curHp - (100*totalmult));
		if(Other.curHp < 0)
		{
			Other.isDefeated = true;
		}
	}
	
	@Override 
	public void skill1(Battler Other) {
		if(this.curMp < 20)
		{
			//Not enough MP
		}
		else
		{
			this.curMp = this.curMp-20;
			double totalmult = (this.attackMult - Other.defenceMult)+1;
			Other.curHp = (int) (Other.curHp - (100*totalmult));
			if(Other.curHp < 0)
			{
				Other.isDefeated = true;
			}
		}
	}
	
	@Override
	public void skill2(Battler Other) {
		if(this.curMp < 10)
		{
			//Not Enough mp
		}
		else
		{
			this.curMp = this.curMp-20;
			this.attackMult = this.attackMult+0.5;
			this.defenceMult = this.defenceMult-0.5;
		}
	}

}
