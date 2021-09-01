import java.util.Random;
import java.util.Scanner;

public class DogGenetics {
    static String[] dogTypes = {"St. Bernard","Chihuahua","Dramatic RedNosed Asian Pug","Common Cur","King Doberman","Labrador Retriever", "Airedale Terrier", "Shiba Inu", "West Highland White Terrier", "Boykin Spaniel", "Cardigan Welsh Corgi"};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String dogName;

        System.out.print("What is your dog's name:");
        dogName = sc.nextLine();

        int numberOfAncestors = getIntFromUser(sc, "How many ancestors do you want to see?");
        int genAncestors = getIntFromUser(sc, "How many Generations do you want to see?");
        int[] dogPercents = getRandomPercentages(numberOfAncestors, genAncestors);
        

        int randomStartingPosition = new Random().nextInt(numberOfAncestors);
        System.out.printf("Well then, I have this highly reliable report on %s's prestigious background right here.\n\n%s is: \n",dogName,dogName);

        //Prints dog types from a random starting position.
        for(int i =0; i<numberOfAncestors;i++){
            System.out.printf("%d%% %s\n",dogPercents[i],dogTypes[(randomStartingPosition++)%(dogTypes.length-1)]);
        }
        sc.close();
    }

    /**
     * Helper method to generate 5 random numbers that add up to 100
     * todo: remove hardcoded 5
     * @return percentageArray, an int array of size 5 containing 5 random numbers that sum up to 100
     */
    public static int[] getRandomPercentages(int numOfAncestors,int generations){
        int totalLeft = 100;
        int currentPercent;
        int percentageArray[] = new int[numOfAncestors];

        
        for (int i = 0; i < percentageArray.length;i++){
            currentPercent= new Random().nextInt(totalLeft-1)+1 ;
            percentageArray[i] = currentPercent;
            totalLeft -= currentPercent;
        }

        /* These lines are supposed to be a generations actual DNA status.. unsure if if this is the right calcuation.
        */
        //System.out.println(totalLeft);
        // for (int i = percentageArray.length; i >0 ;i--){
        //     percentageArray[i-1] = (totalLeft / (int) Math.pow(2,generations));
        //     totalLeft = totalLeft - (totalLeft / (int) Math.pow(2,generations));
        //     //System.out.println(totalLeft);
        //     generations--;


        // }

        //Remaining percentage is added to last instance.
        percentageArray[numOfAncestors-1]+=totalLeft;

        return percentageArray;
    }

    public static int getIntFromUser(Scanner sc, String prompt){
        int value;
        do {
            System.out.printf("%s: ",prompt);
            try {
                value = Integer.parseInt(sc.nextLine());
                break;
 
    
            } catch(NumberFormatException ex) {
                System.out.println("Please input a correct value.");
            }
        }while(true);
        return value;
    }
}
