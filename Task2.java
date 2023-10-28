import java.util.*;
public class Task2 {

    public static double[] marksInput(Scanner sc){
        double arr[] = new double[5];
        System.out.println("Enter marks for 5 subjects out of 100");
        for(int i=0;i<5;i++){
            System.out.println("Enter marks for subject "+(i+1)+" - ");
            int m=sc.nextInt();
            arr[i]=m;
        }
        return arr;
    }

    public static double totalMarks(double arr[]){
        double total = 0;
        for(int i=0; i<5; i++){
            total = total+arr[i];
        }
        return total;
    }

    public static double avgPercentage(double total, int c){
        double avgp = total/c;
        return avgp;
    }

    public static String gradeCalc(double avgp){
        String grade;
        if(avgp >= 85)
            grade="A";
        else if (avgp >= 65 && avgp < 85)
            grade="B";
        else if (avgp >= 45 && avgp < 65)
            grade="C";
        else if(avgp >= 30 && avgp < 45)
            grade="D";
        else
            grade="F";

        return grade;
    }

    public static void displayResult(double total, double percentage, String grade){
        System.out.println();
        System.out.println("---------------Result--------------------");
        System.out.println("Total Marks - "+total);
        System.out.println("Average Percentage - "+percentage);
        System.out.println("Grade - "+grade);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double arr[] = marksInput(sc);
        int c = arr.length;
        double total = totalMarks(arr);
        double percentage = avgPercentage(total, c);
        String grade = gradeCalc(percentage);
        displayResult(total,percentage,grade);
    }
}
