package com.badlogic.drop.battlesystem;

public class MechaResLife extends Battler{
	private int count;
	
	public MechaResLife(int hp, int mp) {
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
		this.attackMult = 1;
		this.defenceMult = 1;
	}
	
	@Override 
	public void skill2(Battler Other) {
		if(count > 4)
		{
			//Mecha Res life is out of beams
		}
		else
		{
			upCount();
			double totalmult = (this.attackMult - Other.defenceMult);
			if(totalmult == 0)
			{
				totalmult = 0.1;
			}
			Other.curHp = (int) (Other.curHp - (2*totalmult));
			if(Other.curHp < 0)
			{
				Other.isDefeated = true;
			}
		}
	}
	
	@Override
	public String getSkill1Name()
	{
		return "Normalize";
		
	}
	
	@Override
	public String getSkill2Name()
	{
		return "Res-Life Beam";
		
	}
	private void upCount()
	{
		count = count+1;
	}
}
