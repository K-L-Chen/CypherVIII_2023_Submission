import java.util.ArrayList;
import java.util.Scanner;

public class RoommateBoss extends Battler{
    public RoommateBoss(Character player_to_set, int difficulty, Scanner in){
        super(player_to_set);
        this.player = player_to_set;
        this.enemy_list.add(new Roommate(difficulty));
        
        say_lines = new ArrayList<String>();
        say_lines.add("\nIf I lose, I gonna throw my self down the stairs!\n");
        say_lines.add("\nHeh, it's not personnel.\n");
        say_lines.add("\nToo easy!\n");
        say_lines.add("\nHeh.\n");
        say_lines.add("\nI won't lose here, roomie!\n");
        this.start_battle(in);
    }
}
