import java.util.ArrayList;
import java.util.Scanner;

public class ResLifeBoss extends Battler{
    public ResLifeBoss(Character player_to_set, ArrayList<Enemy> enemy_to_set, Scanner in){
        super(player_to_set, enemy_to_set, in);
        this.player = player_to_set;
        this.enemy_list = enemy_to_set;
        say_lines = new ArrayList<String>();
        say_lines.add("We know this has been challenging, and we understand.");
        say_lines.add("We'll continue to work through this process together.");
        say_lines.add("Cancellation of the housing contract is $1000.");
        say_lines.add("We're sorry to hear that you've been struggling, here, let us help!");
        say_lines.add("Students interested in changing their assignment may submit a 2022-23 Room Change Request form.");
        this.start_battle(in);
    }
}
