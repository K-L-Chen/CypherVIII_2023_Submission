import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Battler {
    Character player; 
    ArrayList<Enemy> enemy_list = new ArrayList<Enemy>();
    Scanner in;
    ArrayList<String> say_lines = new ArrayList<String>();
    Random speech_ran = new Random();

    public Battler(Character player_to_set, ArrayList<Enemy> enemy_to_set, Scanner in){
        this.player = player_to_set;
        this.enemy_list = enemy_to_set; 
        this.start_battle(in);
        this.say_lines.add("That's gonna be my room!");
        this.say_lines.add("I'll even sleep in GGV at this point, actually nevermind...");
        this.say_lines.add("*Pushes Glasses Up*");
        this.say_lines.add("I didn't climb this far to fall off now!");
        this.say_lines.add("My room, my rules!"); 
    }
     
     /**
      * Show the stats of all non-defeated characters
      */
     private void showStats(){
        System.out.print(this.player);
        for(Enemy enemy : enemy_list){
           if(!enemy.checkDefeated()){
              System.out.println(enemy);
           }
        }
     }
     
     /**
      * Show action options
      */
     private void showMenu(){
        System.out.println("Enter 1 to attack");
        System.out.println("Enter 2 to heal (costs 10MP)");
        System.out.println("Enter 3 to perform a special attack (costs 20MP)(has a 20% chance to miss)");
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
     protected void start_battle(Scanner in){
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
           if (player.checkDefeated()){
              System.out.println("Enemies wins!");
              gamePlaying = false;
           }
           boolean switch_to_over = true;
           for(Enemy enemy : enemy_list ){
              if(!enemy.checkDefeated()){
                 switch_to_over = false;
                 break;
              }
              if(switch_to_over){
                System.out.println(player.getName() + " Wins!");
              }
           }
           gamePlaying = !switch_to_over;
           }
        }
     }
