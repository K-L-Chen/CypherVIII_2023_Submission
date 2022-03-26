public class BossEnemy extends Enemy{
    public int getRandomInt(){
        int rand = (int)(Math.random() * 500) + 1;
        return rand;
    }
}
