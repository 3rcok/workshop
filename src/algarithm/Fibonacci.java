package algarithm;
/*
 * this class is implemented using two ways recursively and iteratively. 
 * Iterative method should have better performance.
 */
        
public class Fibonacci {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println( " The 10th fibonacci is " + fib(10));
        System.out.println( " The 10th fibonacci is " + fibIt(10));        
        //System.out.println( "Print out all the n fibonacci numbers: ");
        //printFib(10);
        

    }
    //recursively
    //print out the nth Fibonacci
    public static int fib(int n){
        if(n ==1 || n == 2){
            return 1;
        }else{
            int tmp = fib(n-2)+fib(n-1);
            return tmp;
        }
        
    }
    
    //print out all the n Fibonacci numbers recursively
    public static void printFib(int n){
        System.out.println(fib(n));
        
    }   
    
    //iteratively
    public static int fibIt(int n){
        if(n==1 || n==2){
            return 1;
        }
        int first = 1;
        int second = 1;
        int next = -1;
        for(int i= 3;i<=n;i++){
            next = first + second;
            first = second;
            second = next;
            
        }
        return next;
        
    }

}
