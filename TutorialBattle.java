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
        this.say_lines.add("\n\nComputer Science Major: Prepare to be executed!\n\n");
        this.say_lines.add("\n\nComputer Science Major: Time for a throw down!\n\n");
        this.say_lines.add("\n\n*Computer Science Major attempts to explain why Python is superior to Java. He's wrong.*\n\n");
        this.say_lines.add("\n\nComputer Science Major: I'll commit my all to this!\n\n");
        this.say_lines.add("\n\nComputer Science Major: No exceptions!\n\n");
        this.start_battle(in);
    }
}