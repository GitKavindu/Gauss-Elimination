package com.company;
//import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        // write your code here
        double value[][] = new double[10][10];
        double el[][] = {{3, 1, 2, 0}, {2, -3, -1, 0}, {1, 2, 1, 0},};
        // 3  1  2  0
        // 2 -3 -1  0
        // 1  2  1  0
        double det =el[0][0];
        int terms ;
        int dimen=3;

        for (int i = 0; i < dimen; i++) {
            terms=i;

            if (terms == 0) {}
             else {
                for (int i1 = 0; i1 < terms+1; i1++) {
                    for (int j1 = 0; j1 < terms+1; j1++) {
                        value[i1][j1] = el[i1][j1];
                    }
                }

                 Main k=new Main();
                 double fac=k.inverse(value,terms+1);
                  det=det/fac;
                 System.out.println("det is "+det);
            }
        }
        System.out.println("det is  "+det);

    }

    public static double inverse(double inputArr[][], int terms) {
        double inverseArr[] []=new double[10][10];
         double fac;

         double valueArr[] []=new double[10][11];

        double hold[];



       for (int i6=0;i6<terms;i6++) {
            for (int j6=0;j6<terms+1;j6++){
                valueArr[i6] [j6]=inputArr[i6][j6];
            }

        }
        System.out.println();

        System.out.println("this is the values you entered");

        for (int i=0;i<terms;i++) {
            for (int j=0;j<terms;j++){
                System.out.print(/*"values  "+(i+1)+"  "+(j+1)+"    "+*/ valueArr [i] [j]+"       ");
            }
            System.out.println();
        }

        for (int j=0;j<terms;j++){
            valueArr[j][terms]=1;

            Main l=new Main();
            hold=l.h(valueArr,terms);

            for (int i=0;i<terms;i++){
                 inverseArr[i][j]=hold[i];
             }
            valueArr[j][terms]=0;

            System.out.println();
            for (int i6=0;i6<terms;i6++) {
                for (int j6=0;j6<terms+1;j6++){
                    valueArr[i6] [j6]=inputArr[i6][j6];
                }

            }
            System.out.println();




        }
        System.out.println("Inverse array");
        for (int i=0;i<terms;i++) {
            for (int j=0;j<terms;j++){
                System.out.print(/*"values  "+(i+1)+"  "+(j+1)+"    "+*/ inverseArr [i] [j]+"       ");
            }
            System.out.println();
        }

        fac=inverseArr [terms-1] [terms-1];
        System.out.println("fac is "+fac);
        return fac;

    }

    public double[] h(double value[][],int terms){
        double hold[]=new double[11];

        //int terms=3;
        double a,b;

        for (int j=0;j<terms;j++) {
            for (int i = 0; i < terms; i++) {
                if (i == j) {
                } else if (value[i][j] == 0) {
                } else {
                    for (int j1 = 0; j1 < terms + 1; j1++) {
                        hold[j1] = value[j][j1];
                    }
                    double c = lCM(value[i][j], hold[j]);


                     b=c/value [i][j];
                     a=c/hold[j];

                    /* a=value [i][j];
                    b=hold[j];*/


                    for (int j2 = 0; j2 < terms + 1; j2++) {
                        value[i][j2] = value[i][j2] * b;
                        hold[j2] = hold[j2] * a;
                        value[i][j2] = value[i][j2] - hold[j2];
                    }


                }


            }

        }
        for (int i=0;i<terms;i++) {
            for (int j=0;j<terms+1;j++){
                System.out.print(/*"values  "+(i+1)+"  "+(j+1)+"    "+*/ value [i] [j]+"       ");
            }
            System.out.println();
        }
        System.out.println();

        for(int i1=0;i1<terms;i1++){
            hold[i1]=value[i1][terms]/value[i1][i1];
        }
        for(int i1=0;i1<terms;i1++){
            System.out.println(hold[i1]);
        }
        return hold;


    }

    public static double lCM(double a, double b) {
        // body
        double large;
        double min;
        int count=2;
        if(a>b){
            large=a;
            min=b;

        }
        else{
            large=b;
            min=a;
        }
        double LCM=0;
        if(min==0){LCM=0;}
        else{
            LCM=large;
            while(LCM%min!=0){
                LCM=large*count;
                count++;
            }
        }
        return LCM;
    }



}