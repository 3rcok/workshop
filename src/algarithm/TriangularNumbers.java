package algarithm;
/*
 * 1, 3, 6, 10, 15, 21...  Area of triangle by dots
 * 
 */

public class TriangularNumbers {
    

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println( "the 7th triangularNumber is "+ triangularNum(7));

    }
    public static int triangularNum(int n){
        if(n ==1){
            return 1;
            
        }else if(n ==2){
            return 3;
        }else{
            return n+triangularNum(n-1);
        }
        
    }

}
