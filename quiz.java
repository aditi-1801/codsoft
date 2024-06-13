import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class quiz{
    private static int limit = 30;                          //time-limit = 30 sec
    private static boolean response = false;                //'response' is used as a flag to indicate whether the question is answered or not
    private static Timer timer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nYou'll get 30 seconds to answer each question.\nIf response is not entered within time-limit quiz ends automatically\n\nQuiz starts:");
        
        //storing questions
        String[] questions = {
            "Who was the first Indian woman to win an Olympic medal?",
            "Who was the first woman to become the President of the Indian National Congress?",
            "Who is known as the 'Mother of Indian Revolution' for her role\n   in India's struggle for Independence?",
            "Who was the first woman Chief Minister of an Indian state?",
            "Who was the first Indian woman pilot to fly solo across the Atlantic Ocean?"
        };
        
        //storing choices to question
        String[][] choices = {
            {"a)  Saina Nehwal    b)  Karnam Malleswari\nc)  Mary Kom        d)  P.T.Usha"},
            {"a)  Sarojini Naidu  b)  Indira Gandhi\nc)  Annie Besant    d)  Aruna Asaf Ali"},
            {"a)  Sarojini Naidu  b)  Annie Beasant\nc)  Aruna Asaf Ali  d)  Rani Lakshmibai"},
            {"a)  Sarojini Naidu  b)  Mayawati\nc)  Sheila Dikshit  d)  Sucheta Kriplani"},
            {"a)  Kalpana Chawla      b)  Sarla Thakral\nc)  Avani Chaturvedi    d)  Bhawana Kanth"}
        };

        char[] answers = {'b','a','c','d','c'};             //'answers' stores correct answers
        char[] userAnswers = new char[questions.length];    //'userAnswers' stores answers to the corresponding question given as input by user

        for(int i=0; i<questions.length; i++)
        {                                                   //current question is displayed
            System.out.println("\n"+(i+1)+". "+questions[i]);

            for(String choice : choices[i]) 
            {                                               //choices for the current question is diaplayed
                System.out.println(choice);
            }

            response = false;                               //'response' flag is reset
            timer = new Timer();                            //new Timer object is created
            timer.schedule(new TimerTask() {                //task is scheduled to be executed after 30 seconds
                public void run(){                          
                    if(!response){                          //if user dosen't answer within time-limit, then timeout message is displayed & program exits
                        System.out.println("\nTIME'S UP!!\n");
                        System.exit(0);     
                    }
                }
            }, limit * 1000);                               //*1000 to convert seconds to milliseconds

            System.out.println("your answer:");
            userAnswers[i] = sc.nextLine().charAt(0);
            response = true;
            timer.cancel();                                 //cancel the timer if question is answered
        }

        int score = 0;
        System.out.println("\nSummary:");
        for(int i=0; i<questions.length; i++) {
            if(userAnswers[i] == answers[i]){               //checking whether user-input is correct or not
                System.out.println((i+1)+". Correct Answer");
                score++;                            
            }
            else{
                System.out.println((i+1)+". Wrong Answer; The correct option is: "+answers[i]);
            }
        }

        System.out.println("\nyou scored "+score+" out of " +questions.length);
        sc.close();
    }
}