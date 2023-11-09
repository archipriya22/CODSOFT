import java.util.Scanner;
import java.util.HashMap;

public class ATM_Machine{
    public static void main(String[] args) {
        ATM obj = new ATM();
    }
}

class values{
    float balance;
}

class ATM{
    Scanner sc = new Scanner (System.in);
    HashMap<Integer, values > map = new HashMap<>();
    ATM(){
        System.out.println("****************");
        System.out.println("Welcome to our ATM Interface");
        operation();
    }

    public void operation(){
        System.out.println("********************");
        System.out.println("Enter your pin code");
        int pincode = sc.nextInt();

        if(map.containsKey(pincode) == true){
            values obj = map.get(pincode);
            keys(obj);
        }
        else{
            System.out.println("*****************");
            System.out.println("Please create account first");
            System.out.println("Set your pincode");
            int pin = sc.nextInt();
            values obj = new values();
            map.put(pin,obj);
            keys(obj);
        }

    }

    public void keys(values obj){
        
        System.out.println("Please enter vaild number");
        System.out.println("1. check balance");
        System.out.println("2. Deposit money");
        System.out.println("3. Withdraw money");
        System.out.println("4. check another account");
        System.out.println("5. Exit");

        int n = sc.nextInt();

        if(n==1){
            check_Balance(obj);
        }
        else if(n==2){
            deposit(obj);
        }
        else if(n==3){
            withdraw(obj);
        }
        else if(n==4){
            operation();
        }
        else if(n==5){
            System.out.println("Thank u!");
        }
        else{
            System.out.println("Enter vaid number:");
            keys(obj);
        }

    }

    public void check_Balance(values obj){
        System.out.println("*****************");
        System.out.println("Your balance"+ obj.balance);
        System.out.println("*****************");
        keys(obj);
    }
    public void deposit(values obj){
        System.out.println("Enter your amount:");
        float a = sc.nextFloat();

        obj.balance = obj.balance + a;

        System.out.println("Amount deposited successfully");
        System.out.println("*****************");
        keys(obj);

    }
    public void withdraw(values obj){
        System.out.println("Enter your amount");
        float a = sc.nextFloat();
        if(obj.balance>=a){
            obj.balance = obj. balance - a;
            System.out.println("Amount withdraw successfully");
        }
        else{
            System.out.println("Insufficient balance");
        }
        System.out.println("*****************");
        keys(obj);
    }  
}    

