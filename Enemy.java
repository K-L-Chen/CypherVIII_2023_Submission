public class Enemy {

    protected double health_stat;
    protected double attack_stat;
    protected double defense_stat; 
    protected double mp_stat; 
    protected double special_stat;

    protected String name;
    protected boolean is_defeated;


    public Enemy(){
        this.health_stat = 75;
        this.mp_stat = 50;
        this.attack_stat = 30;
        this.defense_stat = 75;
        this.special_stat = 100;
        this.is_defeated = false;
    }

    public Enemy(int difficulty, int enemy_count){
        this();
        this.health_stat *= difficulty;
        this.mp_stat *= difficulty;
        this.attack_stat *= difficulty;
        this.defense_stat *= difficulty;
        this.special_stat *= difficulty;
        this.name = "Waitlisted_" + enemy_count;

        
    }
    
}
