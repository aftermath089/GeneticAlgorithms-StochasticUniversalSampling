import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        int numChromosomes;
        float numPointers;
        Scanner scanner=new Scanner(System.in);
        while(true){    
            System.out.println("\nThe Baker's Stochastic Universal Sampling");
            System.out.println("number of chromosome(s): ");
            numChromosomes=scanner.nextInt();

            System.out.println("number of pointer(s): ");
            numPointers=scanner.nextFloat();

            ChromosomesModel chromosomesModel=new ChromosomesModel(numChromosomes,numPointers);
            //double[] fitnessVal=new double[numChromosomes];
            for(int i=0;i<numChromosomes;i++){
                System.out.println("insert fitness value of C"+(i+1)+": ");
                float temp=scanner.nextFloat();
                chromosomesModel.set(i, temp);
                //fitnessVal[i]=scanner.nextFloat();
            }

            chromosomesModel.SUS();
        }
    }
}