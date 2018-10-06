import java.util.Random;

class ChromosomesModel{
    private int initKey[];
    private float initValue[];
    private float getValue[];
    private int size;
    private float point;
    private float valueTotal=0;
    private float pointSpace;

    Random random=new Random();
    private float rand;
    private float firstPointer;

    //constructor
    public ChromosomesModel(int size,float point){
        this.size=size;
        this.point=point;
        this.initValue=new float[size];
        this.initKey=new int[size];
        this.pointSpace=(1/point);
        System.out.println(pointSpace);
        this.rand=random.nextFloat(); 
        System.out.println(rand);
        this.firstPointer=rand%pointSpace;
        System.out.println(firstPointer);

    }

    //fungsi untuk menset key dan value dari user.
    public void set(int pos, float val){
        valueTotal=valueTotal+val;
        initValue[pos]=val;
        initKey[pos]=pos+1;
    }

    //get value dari suatu key
    public float get(int key){
        return getValue[key];
    }

    //merubah initvalue menjadi bentuk desimal
    public void decimalizeValue(){
        for(int i=0;i<size;i++){
            initValue[i]=initValue[i]/valueTotal;
            System.out.println("probability of Chromosome "+initKey[i]+" is: "+initValue[i]);
        }
    }

    //sorting dari nilai terbesar ke nilai terkecil beserta set array key berdasar sortingan yang terjadi. didesimalkan setelahnya.
    public void sort(){
        for(int j=0;j<size;j++){
            for(int i=0;i<size-1;i++){
                float valTemp=initValue[i];
                int keyTemp=initKey[i];
                if(initValue[i]<initValue[i+1]){
                    initValue[i]=initValue[i+1];
                    initKey[i]=initKey[i+1];
                    initValue[i+1]=valTemp;
                    initKey[i+1]=keyTemp;
                }else if(initValue[i]==initValue[i+1]){
                        if(initKey[i]<initKey[i+1]){
                            valTemp=initValue[i];
                            keyTemp=initKey[i];
                            initValue[i]=initValue[i+1];
                            initKey[i]=initKey[i+1];
                            initValue[i+1]=valTemp;
                            initKey[i+1]=keyTemp;
                    }
                }
            }
        }
        decimalizeValue();

        //array untuk fungsi get() yang return value dari suatu key
        this.getValue=new float[size+1];
        for(int i=0;i<size;i++){
            int pointer=initKey[i];
            getValue[pointer]=initValue[i];
        }
    }


    public void point(){
        int count=0;
        int pos=0;
        float currentPoint=firstPointer;
        float currentTotalValue=initValue[pos];
 
        System.out.println("\nfirst pointer: "+currentPoint);
        while(currentTotalValue<currentPoint){
            pos=pos+1;
            currentTotalValue=currentTotalValue+initValue[pos+1];
        }
        while(currentTotalValue>currentPoint){
            System.out.println("point: "+currentPoint+" cummulative value: "+currentTotalValue+" by Chromosome "+initKey[pos]);
            currentPoint=currentPoint+pointSpace;
            if(currentPoint>=1){
                currentPoint=currentPoint-1;
            }

            while(currentTotalValue<currentPoint && pos!=(size-1)){
                pos=pos+1;
                currentTotalValue=currentTotalValue+initValue[pos];
            }

            count++;
            if(count==point){
                break;
            }
        }
    }

    public void SUS(){
        System.out.println(firstPointer);
        sort();
        point();
    }
}