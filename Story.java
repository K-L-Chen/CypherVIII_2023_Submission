import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Story
{
    private Battler battler;
    private Character character;
    private Scanner in;
    private Random rand_gen;
    private int floorNum;

    public static void main(String[] args)
    {
        Story story = new Story();
        story.start_game();   
    }

    public Story(){
        rand_gen = new Random(100);
    }

    public void start_game(){
        in = new Scanner(System.in);
        int randomnumber = (int) Math.floor(Math.random()*(1000000000-900000000+1)+900000000);
        System.out.println("(To advance through text press enter to continue)");
        Continue();
        System.out.println("Please enter your difficulty. (Enter 0, 1, or 2) (0 being easiest and 2 being hardest)");
        String dif = in.nextLine();
        int difficulty = Integer.parseInt(dif);
        System.out.println("Greetings Student "+ randomnumber);
        System.out.println("Please enter your name");
        String name = in.nextLine();
        character = new Character(name);
        if(name.equals("among us")){
            amogus amogus = new amogus();
            try{
                amogus.sus();
            }catch(Exception e){
                e.printStackTrace();;
            }
        }
        System.out.println("Resident Life: Hello " + name + "!");
        Continue();
        System.out.println("Resident Life: Are you ready to move in to campus? (Y/N)");
        String nothing = in.nextLine();
        System.out.println("Resident Life: Too Bad!");
        Continue();
        System.out.println("Resident Life: Dear name, ");
        System.out.println("Resident Life: You are receiving this email as you are currently on the housing Wait List.");
        System.out.println("Resident Life: We realize this is disappointing news and will do our best to support and guide you through the process.");
        Continue();
        System.out.println("Resident Life: Being wait-listed does not necessarily mean you won't be able to live on campus for the 2022-2023 academic year."); 
        System.out.println("Resident Life: It does mean, however, that you will be able to participate in a special Room Selection Process in the coming weeks.");
        Continue();
        System.out.println("Resident Life: Sadly, The College of William and Mary took in too many Students for the upcoming acedemic year.");
        System.out.println("Resident Life: Thus, it is necessary to 'Thin the heard' so to speak.");
        Continue();
        System.out.println("This years special Room Selection Process will be slightly different than previous years.");
        Continue();
        System.out.println("Resident Life: You and your fellow waitlisted students will have to fight in order to determine the best among you to get off the waitlist.");
        Continue();
        System.out.println("Resident Life: This fight is not mandatory. You can just rent an apartment (for $1500 a month).");
        System.out.println("Resident Life: Also, to those who cannot find housng in time for the next academic sestemer,");
        System.out.println("Resident Life: Free William and Mary themed cardboard boxes will be supplied by Finacial aid.");
        Continue();
        System.out.println("Resident Life: If you want to fight, go to the front of the Wren building, you'll know what to do once you get there.");
        System.out.println("Resident Life: Good Luck with the fight!");
        System.out.println("Resident Life: Your 'friends' at Residence Life");
        Continue();  
        /////////////////Tutorial Battle/////////////////
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("*As you open the doors to the Wren building, another student approaches you...*");
        System.out.println("Computer Science Major: Python is a high level programming language!");
        Continue();
        System.out.println(name + ": What?");
        Continue();
        System.out.println("Computer Science Major: Prepare to face the byte of the Python!");
        System.out.println("*The Computer Science Major lunges at you to attack!*");
        Continue();
        //Tutorial battle trigger here

        battler = new TutorialBattle(character, in);
        if(!battler.winning){
            //LOOSING MESSAGE
            System.out.println("A loss befalls you... and a cardboard box awaits.");
            return;
        }
        
        floorNum++;
        character.floorRampUp(floorNum);

        System.out.println("*With The Computer Science Major defeated, you continue on into the depths of the Wren Building...*");
        Continue();
        ///////////////Normal Battles Start here///////////////////////////////////////////
        System.out.println("*As you enter the first floor of the Wren building a strange feeling washes over you.*");
        Continue();
        System.out.println("*There is not a soul in sight and the sense of dread from hundreds of first time renters permeates the air.*");
        System.out.println("Suddenly a group of students jumps out at you!");
        Continue();

        battler = new Battler(character, createEnemies(3, difficulty), in);
        if(!battler.winning){
            //LOOSING MESSAGE
            System.out.println("A loss befalls you... and a cardboard box awaits.");
            return;
        }
        floorNum++;
        character.floorRampUp(floorNum);

        System.out.println("*With the student defeat you move on to the second floor");
        Continue();
        System.out.println("*The second floor isn't much better, but on the ground you see a student face down on the ground*");
        System.out.println("Crying Studnet: I can't afford housing off campus. *sob* ");
        Continue();
        System.out.println("*As you are distracted another Student jumps out and attacks!*");
        Continue();
        //Normal battle trigger here

        battler = new Battler(character, createEnemies(2, difficulty), in);
        if(!battler.winning){
            //LOOSING MESSAGE
            System.out.println("A loss befalls you... and a cardboard box awaits.");
            return;
        }
        floorNum++;
        character.floorRampUp(floorNum);

        System.out.println("Another student defeated! You move on to the final floor stepping over the crying student as you go.*");
        Continue();
        //////////////////Former Roommate Mid-Boss/////////////////////////
        System.out.println("*In front of you are the doors to the final boss, Residnce Life itself. However, a figure appears to block your way.*");
        Continue();
        System.out.println("Former Roommate: Heh. I knew you'd get this far. You were always my equal, that's why we are roommates...");
        Continue();
        System.out.println("Former Roommate: Or should I say were roommates!");
        Continue();
        System.out.println(name + ": Wh..What are you saying!");
        Continue();
        System.out.println("Former Roommate: What I'm saying is there is only one single left. AND IT WILL BE MINE!");
        //Roommate battle trigger here

        battler = new RoommateBoss(character, difficulty, in);
        if(!battler.winning){
            //LOOSING MESSAGE
            System.out.println("A loss befalls you... and a cardboard box awaits.");
            return;
        }
        floorNum++;
        character.floorRampUp(floorNum);
        
        System.out.println("Former Roommate: Heh. You're good. See you later, roomie.");
        Continue();
        System.out.println("* Your former roommate then throws themselves down the stairs. There fine. Probably.*");
        //////////////////////Roommate battle over///////////////////////
        /////////////////Final Boss////////////////////
        System.out.println("*You approach the monsterous Res Life. It's brain equal to size of its dorms.*");
        System.out.println("*It's power equal to awesome might given to by the Royaly chartered school of William and Mary*");
        System.out.println("*As you approach, it speaks to you...*");
        Continue();
        System.out.println("Residence Life: Hello William and Mary student!");
        Continue();
        System.out.println(name +": Residennt Life! I have come for my room!");
        Continue();
        System.out.println("Residence Life: We are very sorry. But there are currently no rooms available...");
        Continue();
        System.out.println("Residence Life: because we are demolishing every dorm on campus.");
        Continue();
        System.out.println(name +": NO! You can't do that! I won't let you!");
        Continue();
        System.out.println("Residence Life: Then prove you self and make me.");
        //Final Boss Trigger here

        battler = new ResLifeBoss(character, difficulty, in);
        if(!battler.winning){
            //LOOSING MESSAGE
            System.out.println("A loss befalls you... and a cardboard box awaits.");
            return;
        }

        System.out.println("Resident Life: You make a good point. I guess we won't make everyone homeless.");
        Continue();
        System.out.println("Resident Life: For this deed, I will grant you a room. The best room we have.");
        Continue();
        System.out.println("Resident Life: A room in the RANDOLPH COMPLEX!");
        Continue();
        System.out.println(name +": NOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO!!!");
        Continue();
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("THE END");
    }

    
    private void Continue() //Press Enter to continue text
    { 
        try
        {
            in.nextLine();
        }  
        catch(Exception e)
        {}  
    }

    private ArrayList<Enemy> createEnemies(int enemy_count, int difficulty){
        ArrayList<Enemy> enemy_list = new ArrayList<Enemy>();
        for(int i=0; i<enemy_count; i++){
            enemy_list.add(new Enemy(difficulty, rand_gen.nextInt(100)));
        }
        return enemy_list;
    }


}