import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class DogGenetics {
    static String[] dogTypes = {"St. Bernard","Chihuahua","Dramatic RedNosed Asian Pug","Common Cur","King Doberman"};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String dogName;

        System.out.print("What is your dog's name:");
        dogName = sc.nextLine();
        System.out.printf("Well then, I have this highly reliable report on %s's prestigious background right here.\n\n",dogName);
        int[] dogPercents = getRandomPercentages();
        
        int randomStartingPosition = new Random().nextInt(4);

        System.out.println(dogName + " is:\n");

        //Prints dog types from a random starting position.
        for(int i =0; i<dogTypes.length;i++){
            System.out.printf("%d%% %s\n",dogPercents[i],dogTypes[(randomStartingPosition++)%5]);
        }
        sc.close();
    }

    /**
     * Helper method to generate 5 random numbers that add up to 100
     * todo: remove hardcoded 5
     * @return percentageArray, an int array of size 5 containing 5 random numbers that sum up to 100
     */
    public static int[] getRandomPercentages(){
        int totalLeft = 100;
        int currentPercent;
        int percentageArray[] = {0,0,0,0,0};
        for (int i = 0; i < percentageArray.length;i++){
            currentPercent= new Random().nextInt(totalLeft+1) ;
            percentageArray[i] = currentPercent;
            totalLeft -= currentPercent;
        }

        //Remaining percentage is added to last instance.
        percentageArray[4]+=totalLeft;

        return percentageArray;
    }
}
