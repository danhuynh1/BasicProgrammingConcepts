import java.util.Scanner;
import java.util.Random;
public class LuckySevens {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int userMoney = getIntFromUser(sc, "How many dollars do you have?");

        int rolls = 0;
        int bestRoll = 0;
        int maxMoney = userMoney;

        do{
            userMoney = rollDice(userMoney);
            rolls+=1;
            if (userMoney>maxMoney){
                maxMoney=userMoney;
                bestRoll=rolls;
            }

        
        }while(userMoney>0);

        System.out.printf("You are broke after %d rolls.\nYou should have quit after %d rolls when you had %d.",rolls,bestRoll,maxMoney);
    }

    public static int rollDice(int userMoney){
        Random dice = new Random();

        int roll = (dice.nextInt(6) + 1) + (dice.nextInt(6) + 1);

        //System.out.println("Rolled: " + roll);
        if (roll == 7){
            userMoney += 4;
        }else{
            userMoney -=1;
        }

        return userMoney;
    }

    public static int getIntFromUser(Scanner sc, String prompt){
        int value;
        do {
            System.out.printf("%s: ",prompt);
            try {
                value = Integer.parseInt(sc.nextLine());
                if (value<0){
                    throw new NumberFormatException();
                }
                break;
    
            } catch(NumberFormatException ex) {
                System.out.println("Please input a correct value.");
            }
        }while(true);
        return value;
    }
}
