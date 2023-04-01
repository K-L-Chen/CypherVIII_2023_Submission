//package com.badlogic.drop.battlesystem;
//
//public class KeyboardWarrior extends Battler{
//	
//	public KeyboardWarrior(int hp, int mp) {
//		super(hp, mp);
//	}
//	
//	@Override
//	public void attack(Battler Other)
//	{
//		double totalmult = (this.attmult - Other.defmult)+1;
//		Other.hp = (int) (Other.hp - (100*totalmult));
//		if(Other.hp < 0)
//		{
//			Other.isDefeated = true;
//		}
//	}
//	
//	@Override 
//	public void skill1(Battler Other) {
//		if(this.mp < 20)
//		{
//			//Not enough MP
//		}
//		else
//		{
//			this.mp = this.mp-20;
//			double totalmult = (this.attmult - Other.defmult)+1;
//			Other.hp = (int) (Other.hp - (100*totalmult));
//			if(Other.hp < 0)
//			{
//				Other.isDefeated = true;
//			}
//		}
//	}
//	
//	@Override
//	public void skill2(Battler Other) {
//		if(this.mp < 10)
//		{
//			//Not Enough mp
//		}
//		else
//		{
//			this.attmult = this.attmult+0.5;
//			this.defmult = this.defmult-0.5;
//		}
//	}
//
//}
