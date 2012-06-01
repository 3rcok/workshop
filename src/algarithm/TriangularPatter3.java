package algarithm;
/*
 *          1
 *        1 2 1
 *      1 2 3 2 1
 *    1 2 3 4 3 2 1
 *  1 2 3 4 5 4 3 2 1
 */
public class TriangularPatter3 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        print(5);

    }
    
    public static void print(int n){
        int c = n;
        for(int i=1;i<=n;i++){
            c--;
            for( int j=2*c+1; j>0;j--){
                
                System.out.print(" ");
            }

            for( int k=1;k<=i;k++){
                
                System.out.print(k+" ");
            }
            for( int l=i-1;l>0;l--){
                
                System.out.print(l+" ");
            }
            System.out.println();
        }
    }

}
