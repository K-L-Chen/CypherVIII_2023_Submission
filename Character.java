public class Character {
   protected int hp;                        //Character stats
   protected int mp;
   protected int attack;
   protected int defense;
   protected int special;
   protected boolean defeated = false;
   protected int difficulty = 0;

   private int base_hp;
   private int base_mp;
   private int base_attack;
   private int base_defense;
   private int base_special;

   //name of character
   protected String name = "name";

   public Character()
   {
      this.hp = 75;
      this.mp = 50;
      this.attack = 30;
      this.defense = 75;
      this.special = 100;

      //save base values
      base_hp = hp;
      base_mp = mp;
      base_attack = attack;
      base_defense = defense;
      base_special = special;
   }

   //default character archetype stats
   public Character(String name)
   {
      this();
      this.name = name;
   }

   //set difficulty value for damage range
   public Character(int difficulty, String name){
       this(name);
       this.difficulty = difficulty;
   }

   //specific character stats
   public Character(int hp, int mp, int atk, int def, int special, String name)
   {
      this.hp = hp;
      this.mp = mp;
      this.attack = atk;
      this.defense = def;
      this.special = special;
      this.name = name;

      //save base values
      base_hp = hp;
      base_mp = mp;
      base_attack = attack;
      base_defense = defense;
      base_special = special;
   }

   public void floorRampUp(int floorNum){
       this.hp = this.base_hp + 10 * floorNum;
       this.mp = this.base_mp + 10 * floorNum;
       this.attack = this.base_attack + 10 * floorNum;
       this.defense = this.base_defense + 10 * floorNum;
       this.special = this.base_special + 10 * floorNum;
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

   public int getMP(){
      return mp;
   }

   public int getHP(){
      return hp;
   }

   public int getAttack(){
      return attack;
   }
   
   public int getDefense(){
      return defense;
   }

   //altering values in character
   public void changeToHP(int n){
       hp = hp+n;
   }

   public void changeToMP(int change){
       mp = mp+change;
   }

   public void changeToAttack(int n){
      attack = attack+n;
   }

   public void changeToDefense(int n){
      defense = defense+n;
   }

   public int damageRange(int atk, int enemyDef){
        return (int)((atk/ (1000.0 /(1000 + enemyDef))) + (Math.random() * (difficulty+1)));
   }

   /**
    * This attacks other using a damage formula based on this attack and defense power.
    * If the attack causes other's HP to drop to 0 or below, other is defeated.
    */
   public void attack(Character other)
   {
      int damage = damageRange(this.attack, other.getDefense());  //Formula sourced from: http://rpg.wikia.com/wiki/Damage_Formula
      
      System.out.print(damage);
      other.changeToHP((-1)*damage);
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
         int healPoints;
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