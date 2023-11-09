import java.util.*;

public class Random_Number {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random n = new Random();

        int higestnumber = 100;
        int lowestnumber = 1;
        int random = n.nextInt(higestnumber-lowestnumber+1)+lowestnumber;
        int attempts = 0;
        boolean gessescorrectly = false;

        System.out.println("welcom to the number gessing game..");
        System.out.println("choose the numbers between 0 to 100");

        while(!gessescorrectly){
            System.out.println("enter the gesses number: ");
            int user =  sc.nextInt();
            if(user<random){
                System.out.println("Your gessed is low....");
                attempts++;
            }
            else if(user>random){
                System.out.println("Your gessed is high...");
                attempts++;
            }
            else{
                System.out.println("congrutulation! Your gesses is correct...");
                System.out.println("You can win this game for "+ attempts +" attempts.");
                gessescorrectly = true;
            }
            if(attempts == 60){
                System.out.println("You can't take any more attempts...");
                break;
            }
        }
    }

    
}
