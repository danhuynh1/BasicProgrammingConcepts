import java.util.Scanner;

/**
 * FizzBuzz
 * Write a program that asks for an integer n, and prints the sum of all multiples of three and five up to n (inclusive).
 */
public class FizzBuzzSum{
    final static int FIZZ = 3;
    final static int BUZZ = 5;
    public static void main(String[] args){
        Scanner inputReader = new Scanner(System.in);
        System.out.print("Enter range: ");
        int range = Integer.parseInt(inputReader.nextLine());
        int sum = 0;

        for (int i =1; i <=range;i++){
            if (i%FIZZ == 0 || i%BUZZ == 0) sum+=i;
        }
        System.out.printf("%d",sum);
        inputReader.close();
    }
}