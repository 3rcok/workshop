package algarithm;

import java.util.Arrays;
import java.util.Random;

//use collection.shuffle()

public class RandomizeArray {
    static int[] a = {1,2,3,4,5,6,7,8,9};
    /**
     * @param args
     */
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

            shuffle(a);
            System.out.println(" after shuffling, array is " + Arrays.toString(a));

    }
    
    public static void shuffle(int[] a){
        int len = a.length-1;
        Random ran = new Random();
        for(int i=0;i<=len;i++){
            int randomNum = ran.nextInt(len);
            swap(randomNum, len);
            len--;
        }        
        
    }
    
    public static void swap(int i, int j){
        int tmp = a[i];
        a[i]=a[j];
        a[j]=tmp;
        
    }

}
