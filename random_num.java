import java.util.Scanner;
import java.util.Random;
public class random_num{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int g,round=0,score=0;
        char x = 'Y';
        Random random = new Random();   
        do{
            System.out.println("guess the number between 1 to 100 within 5 attempts:");
            int n = random.nextInt(100)+1;
            int c=0,l=0;
            round++;
            do{
                c++;
                l++;
                g = sc.nextInt();
                if(l<5)
                {
                    if(g<n)
                    System.out.println("enter higher number");
                    else if(g>n)
                    System.out.println("enter lower number");
                    else if(g==n)
                    {
                        score++;
                        System.out.println("Congrats!!! you guessed the number "+n+" in " +c+ " attempts\n");
                    }        
                }
                else if(l==5 && (g>n || g<n))
                {
                    System.out.println("you've exceeded the limit; the no. is "+n+"\n");
                    break;
                }
                else if(l==5 && g==n)
                {
                    score++;
                    System.out.println("Congrats!!! you guessed the number "+n+" in " +c+ " attempts\n");
                }
            }while(g!=n);
            System.out.println("Do you want to play again?\tyes:'y'\tno:'n'");
            x = sc.next().charAt(0);
            x = Character.toUpperCase(x);
        }while(x == 'Y');
        if(x=='N')
        {
            System.out.println("\nRounds\tScore");
            System.out.println(round+"\t"+score);
        }
        else
            System.out.println("invalid input");
        sc.close();
    }
}
