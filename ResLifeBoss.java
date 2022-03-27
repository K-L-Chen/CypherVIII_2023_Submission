import java.util.ArrayList;
import java.util.Scanner;

public class ResLifeBoss extends Battler{
    public ResLifeBoss(Character player_to_set, int difficulty, Scanner in){
        super(player_to_set);
        this.player = player_to_set;
        this.enemy_list.add(new ResLife(difficulty));
        say_lines = new ArrayList<String>();
        say_lines.add("\n\nResidence Life: We know this has been challenging, and we understand.\n\n");
        say_lines.add("\n\nResidence Life: We'll continue to work through this process together.\n\n");
        say_lines.add("\n\nResidence Life: Cancellation of the housing contract is $1000.\n\n");
        say_lines.add("\n\nResidence Life: We're sorry to hear that you've been struggling, here, let us help!\n\n");
        say_lines.add("\n\nResidence Life: Students interested in changing their assignment may submit a 2022-23 Room Change Request form.\n\n");
        this.start_battle(in);
    }
}
