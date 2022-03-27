import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Battler {
    Character player; 
    ArrayList<Enemy> enemy_list = new ArrayList<Enemy>();
    Scanner in;
    ArrayList<String> say_lines = new ArrayList<String>();
    Random speech_ran = new Random();
    boolean winning = true;

    public Battler(Character player_to_set){//}, Scanner in){
         this.player = player_to_set;
         //this.start_battle(in);
    }

    public Battler(Character player_to_set, ArrayList<Enemy> enemy_to_set, Scanner in){
        this.player = player_to_set;
        this.enemy_list = enemy_to_set; 
        this.say_lines.add("\nThat's gonna be my room! \n");
        this.say_lines.add("\nI'll even sleep in GGV at this point, actually nevermind... \n");
        this.say_lines.add("\n*Pushes Glasses Up \n");
        this.say_lines.add("\nI didn't climb this far to fall off now! \n");
        this.say_lines.add("\nMy room, my rules! \n"); 
        this.start_battle(in);
    }
     
     /**
      * Show the stats of all non-defeated characters
      */
     private void showStats(){
        System.out.print("Your stats:\n" + player + "\n");
        for(Enemy enemy : enemy_list){
           if(!enemy.checkDefeated()){
              System.out.println("Enemy stats:\n" + enemy + "\n");
           }
        }
     }
     
     /**
      * Show action options
      */
     private void showMenu(){
        System.out.println("Enter 1 to attack");
        System.out.println("Enter 2 to heal (costs 10MP)");
        System.out.println("Enter 3 to perform a special attack (costs 20MP)");
     }
     
     /**
      * Prompts hero through attacking a monster
      */
     private void attackChoice(Scanner in, Boolean special){
         System.out.println("Which monster would you like to attack?");
         int i = 0; 
         for(Enemy enemy : enemy_list){
            if(!enemy.checkDefeated()){
               System.out.println("Enter " + i + " to attack " + enemy.getName());
            }
            i++;
         }
         int choice = 0;
         try{
            choice = in.nextInt();
         }
         catch(Exception e){
            System.out.println("Invalid input");
            in.nextLine();
         }
         Enemy enemy_to_attack = enemy_list.get(choice);
         if(choice < enemy_list.size()){
            if(enemy_to_attack.checkDefeated()){
               //ATTACK DEAD PERSON MESSAGE
            }
            else{
               if(special){
                  player.specialAttack(enemy_to_attack);
               }
               else{
                  player.attack(enemy_to_attack);
               }
            }
         }
         else{
            //ATTACK NOTHING MESSAGE
         }
     }
  
     /**
      * Runs through the action sequence for a single monster to
      * take action (attack or heal).
      */
     private void singleEnemyAction(Enemy enemy){
        if(player.hp < enemy.attack){
           enemy.attack(player);
        }
        else{
           if(enemy.mp > 10){
               for(Enemy enemy_in : enemy_list ){
                  if(enemy_in.hp < enemy_in.max_health/2){
                      enemy.heal(enemy_in);
                      break;
                  }
               }
           }
           enemy.attack(player);
        }
     }
        
    /**
     * Allows each non-defeated monster to attack or heal.
     */      
     private void enemyActionSequence(){
        for(Enemy enemy : enemy_list){
           if(!enemy.checkDefeated()){
              singleEnemyAction(enemy);
           }
        }
     }
     
     /**
      * Controls the battle sequence
      */
     protected boolean start_battle(Scanner in){
        boolean gamePlaying = true;
        while (gamePlaying){
           showStats();
           int choice = 0;
           while (true){
              try{
                 showMenu();
                 choice = in.nextInt();
              }
              catch(Exception e){
                 System.out.println("Invalid input");
                 in.nextLine();
              }
              if (choice == 1){
                 attackChoice(in, false);
                 break;
              }
              else if (choice == 2){
                 player.heal(player);
                 break;
              }
              else if(choice == 3){
                 attackChoice(in, true);
                 break;
              }
           }
           enemyActionSequence();
           int line_to_say = speech_ran.nextInt(4);

           System.out.print(say_lines.get(line_to_say));
           Continue();
           if (player.checkDefeated()){
              System.out.println("Enemies wins!");
              winning = false;
              Continue();
              gamePlaying = false;
           }
           else{
             boolean switch_to_over = true;
             for(Enemy enemy : enemy_list ){
               if(!enemy.checkDefeated()){
                 switch_to_over = false;
                 break;
               }
             }
             if(switch_to_over){
               System.out.println(player.getName() + " Wins!");
               Continue();
             }
             gamePlaying = !switch_to_over;
           }
         }
         return winning;
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
     }
