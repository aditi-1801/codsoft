import java.util.Scanner;
public class student_grade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter no. of subjects:");
        int n = sc.nextInt();
        int[] sub = new int[n];
        int sum=0;
        System.out.println("enter marks out of 100 for each subject:");
        for(int i=0;i<n;i++)
        {
            System.out.print("Subject_"+(i+1)+":");
            sub[i] = sc.nextInt();
            sum += sub[i];
        }
        double percentage = (double)sum/n;
        char grade='a';
        if(percentage>=90)
        grade = 'A';
        else if(percentage>=80)
        grade = 'B';
        else if(percentage>=70)
        grade = 'C';
        else if(percentage>=60)
        grade = 'D';
        else if(percentage<60)
        grade = 'F';
        System.out.println("Total marks\tAvg. Percentage\t\tgrade");
        System.out.printf(sum+"\t\t%.2f%%\t\t|\t%c",percentage,grade);
        sc.close();
    }
}
