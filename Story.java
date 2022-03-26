import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Story
{
    private Battler battler;
    private Character character;
    private Scanner in;
    private Random rand_gen;

    public static void main(String[] args)
    {
        Story story = new Story();
        story.start_game();   
    }

    public Story(){
        rand_gen = new Random(100);
    }

    public void start_game(){
        int randomnumber = (int) Math.floor(Math.random()*(1000000000-900000000+1)+900000000);
        System.out.println("(To advance through text press enter to continue)");
        Continue();
        System.out.println("Greetings Student "+ randomnumber);
        System.out.println("Please enter your name");
        String name = in.nextLine();
        character = new Character(name);
        System.out.println("Hello" + name + "!");
        Continue();
        System.out.println("Are you ready to move in to campus? (Y/N)");
        String nothing = in.nextLine();
        System.out.println("Too Bad!");
        Continue();
        System.out.println("Dear name, ");
        System.out.println("You are receiving this email as you are currently on the housing Wait List.");
        System.out.println("We realize this is disappointing news and will do our best to support and guide you through the process.");
        Continue();
        System.out.println("Being wait-listed does not necessarily mean you won't be able to live on campus for the 2022-2023 academic year."); 
        System.out.println("It does mean, however, that you will be able to participate in a special Room Selection Process in the coming weeks.");
        Continue();
        System.out.println("Sadly, The College of William and Mary took in too many Students for the upcoming acedemic year.");
        System.out.println("Thus, it is necessary to 'Thin the heard' so to speak.");
        Continue();
        System.out.println("This years special Room Selection Process will be slightly different than previous years.");
        Continue();
        System.out.println("You and your fellow waitlisted students will have to fight in order to determine the best among you to get off the waitlist.");
        Continue();
        System.out.println("This fight is not mandatory. You can just rent an apartment (for $1500 a month).");
        System.out.println("Also, to those who cannot find housng in time for the next academic sestemer,");
        System.out.println("free William and Mary themed cardboard boxes will be supplied by Finacial aid.");
        Continue();
        System.out.println("Good Luck with the fight!");
        System.out.println("Your 'friends' at Residence Life");
        Continue();  
    }

    
    private void Continue() //Press Enter to continue text
    { 
        try
        {
            System.in.read();
        }  
        catch(Exception e)
        {}  
    }

    private ArrayList<Enemy> createEnemeies(int enemy_count, int difficulty){
        ArrayList<Enemy> enemy_list = new ArrayList<Enemy>();
        for(int i=0; i<enemy_count; i++){
            enemy_list.add(new Enemy(difficulty, rand_gen.nextInt()));
        }
        return enemy_list;
    }


}