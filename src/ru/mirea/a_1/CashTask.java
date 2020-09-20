package ru.mirea.a_1;
import java.util.Scanner;

public class CashTask {



    public static void main(String[] args) {
        int n = 0;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int a =0;

        for(int i = 0; i <= n; i++)
            for(int j =0; j <=n/3;j++)
                for(int k = 0; k <= n/5; k++){
                    if (i+j*3+k*5 == n)
                        a++;
                }


        System.out.println(a);

    }
}

