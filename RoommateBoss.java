import java.util.ArrayList;
import java.util.Scanner;

public class RoommateBoss extends Battler{
    public RoommateBoss(Character player_to_set, int difficulty, Scanner in){
        super(player_to_set);
        this.player = player_to_set;
        this.enemy_list.add(new Roommate(difficulty));
        
        say_lines = new ArrayList<String>();
        say_lines.add("\n\nRoommate: If I lose, I gonna throw my self down the stairs!\n\n");
        say_lines.add("\n\nRoommate: Heh, it's not personnel.\n\n");
        say_lines.add("\nRoommate: Too easy!\n");
        say_lines.add("\n\nRoommate: Heh.\n\n");
        say_lines.add("\n\nRoommate: I won't lose here, roomie!\n\n");
        this.start_battle(in);
    }
}
