package com.company;

import java.util.Scanner;

public class equation{

    public static void main(String[] args) {
	// write your code here
        Scanner input =new Scanner(System.in);
        long value [] []= new long[10][11] ;
        //int value [] []=new int[10][11];
      //  long value[][] = { {3, 1, 2, 3} ,{2, -3, -1, -3},{1, 2, 1, 4}} ;
        int terms=4;

        for (int i=0;i<terms;i++) {
            for (int j=0;j<terms+1;j++){
                System.out.print("Enter values  "+(i+1)+"  "+(j+1));

                value [i] [j]=input.nextInt();
            }
            System.out.println();
        }
        System.out.println("this is the values you entered");
        System.out.println("");

        for (int i=0;i<terms;i++) {
            for (int j=0;j<terms+1;j++){
                System.out.print(/*"values  "+(i+1)+"  "+(j+1)+"    "+*/ value [i] [j]+"       ");
            }
            System.out.println();
        }
        System.out.println();

        long a; //value
        long b; //hold
        long hold[]=new long[5];

        for (int j=0;j<terms;j++){
            for (int i=0;i<terms;i++){
                if (i==j){
                }
                else if (value [i][j]==0){}
                else{
                    for(int j1=0;j1<terms+1;j1++){
                        hold [j1]=value[j] [j1];
                    }
                    long c=lCM(value [i][j], hold[j]);


                    b=c/value [i][j];
                    a=c/hold[j];

                  /* a=value [i][j];
                   b=hold[j];*/


                    for(int j2=0;j2<terms+1;j2++){
                        value [i] [j2]=value [i] [j2]*b;
                        hold [j2]=hold[j2]*a;
                        value [i] [j2]=value [i] [j2]-hold[j2];
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
            System.out.println(value[i1][terms]/value[i1][i1]);
        }



    }
    public static long lCM(long a, long b) {
        // body
        long large;
        long min;
        int count=2;
        if(a>b){
            large=a;
            min=b;

        }
        else{
            large=b;
            min=a;
        }
        long LCM=0;
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



