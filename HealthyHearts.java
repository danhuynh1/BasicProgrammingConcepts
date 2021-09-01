import java.util.Scanner;
public class HealthyHearts {
    public static void main(String[] args){
        Scanner inputReader = new Scanner(System.in);
        System.out.print("What is your age? ");
        int age = Integer.parseInt(inputReader.nextLine());
        int maximum = 220-age;
        System.out.printf("Your maximum heart rate should be %d beats per minute\n",maximum);
        
        int lowEnd = (int) Math.ceil(maximum*.5);
        int highEnd = (int) Math.ceil(maximum*.85);
    
        System.out.printf("Your target HR Zone is %d - %d.\n",lowEnd,highEnd);
        inputReader.close();
        
    }
}
