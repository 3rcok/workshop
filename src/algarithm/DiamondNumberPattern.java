/*       2
 *     4 5 6
 *   6 7 8 9 10
 *     4 5 6
 *       2
 * 
 *pattern i+j 
 * 
 */
package algarithm;

public class DiamondNumberPattern {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a =3;
        int b =5;
        a ^= b;
        b ^= a;
        a^=b;
        System.out.println("a "+ a+"b"+b);
    }

}
