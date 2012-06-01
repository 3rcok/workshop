package algarithm;

import java.util.ArrayList;

public class SievePrimes {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("get primes before n " + getPrimes(100));

    }
    
    public static ArrayList getPrimes(int n){
        ArrayList list = new ArrayList();
        boolean flag = false;
        for(int i=3;i<n;i++){
            flag = true;
            for(int j=2;j<i;j++){
                if(i%j == 0){
                    flag = false;
                    continue;
                }
            }
           if(flag){
           list.add(i);}
        }
        
        return list;
    }

}
