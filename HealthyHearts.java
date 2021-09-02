import java.util.Scanner;
public class HealthyHearts {
    public static void main(String[] args){
        Scanner inputReader = new Scanner(System.in);
        int age = getIntFromUser(inputReader, "What is your age? ");
        int maximum = 220-age;
        System.out.printf("Your maximum heart rate should be %d beats per minute\n",maximum);
        
        int lowEnd = (int) Math.ceil(maximum*.5);
        int highEnd = (int) Math.ceil(maximum*.85);
    
        System.out.printf("Your target HR Zone is %d - %d.\n",lowEnd,highEnd);
        inputReader.close();
        
    }

        /**
     * Helper method to get an int from prompt
     * @param sc
     * @param prompt
     * @return
     */

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
