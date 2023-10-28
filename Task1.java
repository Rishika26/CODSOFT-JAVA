import java.util.*;

public class Task1 {

    public static int numGenerator(){
        Random rand = new Random();
        int max = 100;
        int min = 1;
        int round = 1;
        int randomnum = rand.nextInt(max - min + 1) + min;
        return randomnum;
    }

    public static int numChecker(Scanner sc, int round,int randomnum){
        System.out.println("----------------Round "+round+" --------------------");
        int won=0;
        for(int i=1;i<=5;i++){
            System.out.println("Attempt " + i + " : Guess the number - ");
            int num = sc.nextInt();
            if (num < randomnum)
                System.out.println("too low");
            else if (num > randomnum)
                System.out.println("too high");
            else {
                System.out.println("Correct");
                won++;
                System.out.println("You win this round");
                break;
            }
        }
        if(won == 0)
            System.out.println("You lose this round");
        return won;
    }

    public static void result(int round, int flag){
        System.out.println();
        System.out.println("------------------Result--------------------");
        System.out.println("You played "+round+" rounds and won "+flag+" rounds");
        System.out.println("So your score is "+flag+" out of "+ round);
        System.exit(1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("-------------Welcome to Number Game------------------");
        System.out.println();
        System.out.println("A random number has been generated within the range 1-100.");
        System.out.println("You have 5 attempts to guess the correct number");
        System.out.println("Lets Begin!!!");
        System.out.println();
        int randomnum = numGenerator();
        int round=1;
        int flag=0;
        int won = numChecker(sc, round, randomnum);
        flag+=won;//used in result
        while(true){
            System.out.println("Do you want to play again?");
            System.out.println("1.Press 1 to play again");
            System.out.println("2.Press 2 to exit");
            int a= sc.nextInt();
            switch (a){
                case 1:
                    round++;
                    int rnum = numGenerator();
                    int w = numChecker(sc, round, rnum);
                    flag+=w;
                    break;
                case 2:
                    result(round,flag);
                    break;
                default:
                    System.out.println("Invalid Input");
            }
        }
    }
}
