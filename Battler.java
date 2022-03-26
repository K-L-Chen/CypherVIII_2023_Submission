import java.util.ArrayList;
import java.util.Scanner;

public class Battler {
    Character player; 
    ArrayList<Enemy> enemy_list = new ArrayList<Enemy>();
    Scanner in;

    public Battler(Character player_to_set, ArrayList<Enemy> enemy_to_set, Scanner in){
        this.player = player_to_set;
        this.enemy_list = enemy_to_set; 
        this.start_battle(in);
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
           for(Enemy enemy_in : enemy_list ){
              if(enemy_in.hp < 

           }
        }
        boolean chooseAttack = true;
        boolean chooseHeal = false;
        //50% chance to heal if MP high enough
        if (monster.getMP() >= 10 && Math.random() < 0.5){
           chooseAttack = false;
           chooseHeal = true;
        }
        //10% chance to erroneously heal            
        else if (Math.random() < 0.1){
           chooseAttack = false;
           chooseHeal = true;
        }
        if (chooseHeal){
           int target = (int)(Math.random() * 3) + 1;
           if (target == 1){
              monster.heal(monster1);
           }
           else if (target == 2){
              monster.heal(monster2);
           }
           else{
              monster.heal(monster3);
           }
        }
        else{
           monster.attack(hero);
        }
     }
        
    /**
     * Allows each non-defeated monster to attack or heal.
     */      
     private void monsterActionSequence(){
        boolean monster1Alive = !monster1.isDefeated();
        boolean monster2Alive = !monster2.isDefeated();
        boolean monster3Alive = !monster3.isDefeated();
        if (monster1Alive){
           singleMonsterAction(monster1);
        }
        if (monster2Alive){
           singleMonsterAction(monster2);
        }
        if (monster3Alive){
           singleMonsterAction(monster3);
        }
     }
     
     /**
      * Controls the battle sequence
      */
     private void start_battle(Scanner in){
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
                 hero.heal(hero);
                 break;
              }
              else if(choice == 3){
                 specialChoice(in, true);
                 break;
              }
           }
           monsterActionSequence();
           if (hero.isDefeated()){
              System.out.println("Monsters win!");
              gamePlaying = false;
           }
           else if (monster1.isDefeated() && monster2.isDefeated() 
                    && monster3.isDefeated()){
              System.out.println(hero.getName() + " wins!");
              gamePlaying = false;
           }
        }
     }


}
