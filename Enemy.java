public class Enemy extends Character {

    public Enemy(){
        this.hp = getRandomInt();
        this.mp = getRandomInt();
        this.attack = getRandomInt();
        this.defense = getRandomInt();
        this.special = getRandomInt();
    }

    public Enemy(int difficulty, int enemy_count){
        this();
        this.hp *= difficulty;
        this.mp *= difficulty;
        this.attack *= difficulty;
        this.defense *= difficulty;
        this.special *= difficulty;
        this.name = "WaitListed_" + enemy_count;
    }
    
    public int getRandomInt(){
        int rand = (int)(Math.random() * 100) + 1;
        return rand;
    }
}
