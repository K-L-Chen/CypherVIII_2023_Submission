public class Enemy extends Character {

    public Enemy(){
        this.hp = getRandomInt();
        this.mp = getRandomInt();
        this.attack = getRandomInt();
        this.defense = getRandomInt();
        this.special = getRandomInt();
    }

    public Enemy(int difficulty, int enemy_number){
        this();
        this.hp <<= difficulty;
        this.mp <<= difficulty;
        this.attack <<= difficulty;
        this.defense <<= difficulty;
        this.special <<= difficulty;
        this.name = "WaitListed_" + enemy_number;
    }
    
    public int getRandomInt(){
        int rand = (int)(Math.random() * 100) + 1;
        return rand;
    }

    public int damageRange(int atk, int enemyDef){
        return (int)((atk/ (1000.0 /(1000 + enemyDef))) - (Math.random() * (difficulty+1)));
   }
}
