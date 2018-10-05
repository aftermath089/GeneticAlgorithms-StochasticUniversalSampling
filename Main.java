import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        int numChromosomes;
        Scanner scanner=new Scanner(System.in);
        while(true){    
            System.out.println("\nThe Baker's Stochastic Universal Sampling");
            System.out.println("number of chromosome(s): ");
            numChromosomes=scanner.nextInt();

            ChromosomesModel chromosomesModel=new ChromosomesModel(numChromosomes);
            //double[] fitnessVal=new double[numChromosomes];
            for(int i=0;i<numChromosomes;i++){
                System.out.println("insert fitness value of C"+(i+1)+": ");
                double temp=scanner.nextDouble();
                chromosomesModel.set(i, temp);
                //fitnessVal[i]=scanner.nextFloat();
            }

            chromosomesModel.SUS();
        }
    }
}