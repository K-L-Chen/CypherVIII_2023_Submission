public class Character {
   protected double hp;                        //Character stats
   protected double mp;
   protected double attack;
   protected double defense;
   protected double special;
   protected boolean defeated = false;
   protected double difficulty = 0;

   //name of character
   protected String name;

   //default character archetype stats
   public Character()
   {
      this.hp = 75;
      this.mp = 50;
      this.attack = 30;
      this.defense = 75;
      this.special = 100;
   }

   //set difficulty value for damage range
   public Character(double difficulty){
       this();
       this.difficulty = difficulty;
   }

   //specific character stats
   public Character(double hp, double mp, double atk, double def, double special)
   {
      this.hp = hp;
      this.mp = mp;
      this.attack = atk;
      this.defense = def;
      this.special = special;
   }

   public boolean checkDefeated(){
       return defeated;
   }

   public void isNowDefeated(){
       this.defeated = true;
   }

   public void setName(String name){
        this.name = name;
   }
   
   public String getName(){
       return this.name;
   }

   public double getMP(){
      return mp;
   }

   public double getHP(){
      return hp;
   }

   public double getAttack(){
      return attack;
   }
   
   public double getDefense(){
      return defense;
   }

   //altering values in character
   public void changeToHP(double n){
       hp = hp+n;
   }

   public void changeToMP(double change){
       mp = mp+change;
   }

   public void changeToAttack(int n){
      attack = attack+n;
   }

   public void changeToDefense(int n){
      defense = defense+n;
   }

   public int damageRange(double atk, double enemyDef){
        return (int)((atk/ (1000.0 /(1000 + enemyDef))) + (Math.random() * (difficulty+1)));
   }

   /**
    * This attacks other using a damage formula based on this attack and defense power.
    * If the attack causes other's HP to drop to 0 or below, other is defeated.
    */
   public void attack(Character other)
   {
      int damage = damageRange(this.attack, other.getDefense());  //Formula sourced from: http://rpg.wikia.com/wiki/Damage_Formula
      
      other.changeToHP(damage);
      if(other.getHP() <= 0){
         other.isNowDefeated();
      }
   }
   public void specialAttack(Character other)
   {
      if (this.mp >= 20)
      {
         this.changeToMP(-20);
         int damage = damageRange(this.special, other.defense);
            other.changeToHP((-1) * damage);
            if(other.getHP() <= 0){
               other.isNowDefeated();
            }
      }      
      else{
         System.out.println("Not enough MP!");
      }
   }
   /**
    * This heals other if this RPGCharacter's MP points are high enough.
    * Warriors are healed by 70.
    * Mages are healed by 30.
    */
   public void heal(Character other){
      //Does this have sufficient MP?
      if(this.mp >= 10){
         this.changeToMP(-10);
         double healPoints;
         //What is other's class?
         healPoints = 30;
         hp = hp + healPoints;
      }
      else{
         System.out.println("Not enough MP!");
      }
   }
   public String toString()
   {
      return "Stats:\n HP: "+hp+"    MP: "+mp+"\n Attack:"+attack+"   Special: "+special+"    Defense:"+defense+"";
   }
}