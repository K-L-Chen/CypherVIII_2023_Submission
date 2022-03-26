import java.util.ArrayList;
import java.util.Scanner;

public class TutorialBattle extends Battler{
    Character player; 
    ArrayList<Enemy> enemy_list = new ArrayList<Enemy>();
    Scanner in;

    public TutorialBattle(Character player_to_set, ArrayList<Enemy> enemy_to_set, Scanner in){
        super(player_to_set, enemy_to_set, in);
        this.player = player_to_set;
        this.enemy_list = enemy_to_set; 
        this.start_battle(in);
    }
}