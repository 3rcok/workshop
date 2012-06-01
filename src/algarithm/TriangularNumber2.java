package algarithm;
/*
 *         1
 *       2 2
 *     3 3 3
 *     4 4 4 4
 *    5 5 5 5 5
 */
public class TriangularNumber2 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        print(10);

    }
    public static void print(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(i+" ");
            }
            System.out.println();
        }
        
    }

}
