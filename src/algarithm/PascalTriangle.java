//1 
//1 1 
//1 2 1 
//1 3 3 1 
//1 4 6 4 1 
//1 5 10 10 5 1 
//1 6 15 20 15 6 1 
//1 7 21 35 35 21 7 1 
//1 8 28 56 70 56 28 8 1 
//1 9 36 84 126 126 84 36 9 1 
//http://www.mathsisfun.com/data/quincunx.html
//nCk

package algarithm;

public class PascalTriangle {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int n=10;

        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                int tmp = fun(i)/(fun(j)*fun(i-j));
                System.out.print(tmp +" ");
            }
            System.out.println(); 
        }


    }
    public static int fun(int n){
        if(n<0){
            return -1;
        }
        if(n ==1||n==0){
            return 1;
        }else{
            return n*fun(n-1);
        }
    }

}
