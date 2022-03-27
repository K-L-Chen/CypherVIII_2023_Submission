import java.util.ArrayList;
import java.util.Scanner;

public class ResLifeBoss extends Battler{
    public ResLifeBoss(Character player_to_set, int difficulty, Scanner in){
        super(player_to_set);
        this.player = player_to_set;
        this.enemy_list.add(new ResLife(difficulty));
        say_lines = new ArrayList<String>();
        say_lines.add("\nWe know this has been challenging, and we understand.\n");
        say_lines.add("\nWe'll continue to work through this process together.\n");
        say_lines.add("\nCancellation of the housing contract is $1000.\n");
        say_lines.add("\nWe're sorry to hear that you've been struggling, here, let us help!\n");
        say_lines.add("\nStudents interested in changing their assignment may submit a 2022-23 Room Change Request form.\n");
        this.start_battle(in);
    }
}
