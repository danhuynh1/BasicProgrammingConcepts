import java.util.Scanner;
public class Factorizer {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int numberToFactor = getIntFromUser(sc, "What number would you like to factor?");
        Factorizing(numberToFactor);

    }



    public static int getIntFromUser(Scanner sc, String prompt){
        int value;
        do {
            System.out.printf("%s: ",prompt);
            try {
                value = Integer.parseInt(sc.nextLine());
                if (value<1){
                    throw new NumberFormatException();
                }
                break;
 
            } catch(NumberFormatException ex) {
                System.out.println("Please input a correct value.");
            }
        }while(true);
        return value;
    }
    
    /**
     * 
     * @param n : A number passed to determine it's factors, if it is a perfect number, and if it is a prime.
     */
    public static void Factorizing(int n){
        int count = 0;
        int sum = 0;
        System.out.printf("The factors of %d are:\n",n);

        //Prints factors of n.
        for (int i = 1; i<=n;i++){
            if (n%i==0){
                // A count is incremented to keep track of how many factors there are. 
                count++;
                System.out.print(i + " ");

                //A sum of factors (Excluding n) is kept to determine if number is perfect
                if (i !=n) {
                    sum += i;
                }
            }
        }
        System.out.printf("\n%d has %d factors.\n",n,count);

        if (sum == n) System.out.printf("%d is a perfect number.\n",n);
        else System.out.printf("%d is not a perfect number.\n",n);

        //A prime number is defined as a number that is greater than 1, and that it's only factors are 1 and itself.
        System.out.print(n);
        if (count == 2 && n%1 == 0 && n%n == 0){
            System.out.println(" is a prime number");
        }else{
            System.out.println(" is not a prime number");
        }
    
    
    }
    
}
