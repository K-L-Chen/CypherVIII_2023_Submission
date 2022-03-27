import java.util.Scanner;

public class TutorialBattle extends Battler{
    //Character player; 
    //ArrayList<Enemy> enemy_list = new ArrayList<Enemy>();
    //Scanner in;

    public TutorialBattle(Character player_to_set, Scanner in){
        super(player_to_set);
        //this.player = player_to_set;
        //this.enemy_list = enemy_to_set;
        //super.say_lines = new ArrayList<String>();
        this.enemy_list.add(new TutorialBoss());
        this.say_lines.add("\nPrepare to be executed!\n");
        this.say_lines.add("\nTime for a throw down!\n");
        this.say_lines.add("\n*Computer Science Major attempts to explain why Python is superior to Java. He's wrong.*\n");
        this.say_lines.add("\nFine, I'll commit my all to this!\n");
        this.say_lines.add("\nNo exceptions!\n");
        this.start_battle(in);
    }
}