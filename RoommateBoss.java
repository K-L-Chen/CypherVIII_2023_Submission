import java.util.ArrayList;
import java.util.Scanner;

public class RoommateBoss extends Battler{
    public RoommateBoss(Character player_to_set, ArrayList<Enemy> enemy_to_set, Scanner in){
        super(player_to_set, enemy_to_set, in);
        this.player = player_to_set;
        this.enemy_list = enemy_to_set;
        
        say_lines = new ArrayList<String>();
        say_lines.add("If I lose, I gonna throw my self down the stairs!");
        say_lines.add("Heh, it's not personnel.");
        say_lines.add("Too easy!");
        say_lines.add("Heh.");
        say_lines.add("I won't lose here, roomie!");
        this.start_battle(in);
    }
}
