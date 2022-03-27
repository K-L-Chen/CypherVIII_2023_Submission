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
        say_lines = new ArrayList<String>();
        say_lines.add("Prepare to be executed!");
        say_lines.add("Time for a throw down!");
        say_lines.add("*Computer Science Major attempts to explain why Python is superior to Java. He's wrong.*");
        say_lines.add("Fine, I'll commit my all to this!");
        say_lines.add("No exceptions!");
        this.start_battle(in);
    }
}