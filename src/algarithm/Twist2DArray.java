/*twist array 90 degree

[1][2][3][4]
[5][6][7][8]
[9][0][1][2]
[3][4][5][6]

Becomes:

[3][9][5][1]
[4][0][6][2]
[5][1][7][3]
[6][2][8][4]
*/

package algarithm;

import java.util.Arrays;

public class Twist2DArray {
    static int[][] a ={
            {1,2,3,4},
            {5,6,7,8},
            {9,0,1,2},
            {3,4,5,6}
    };
    static int n =4;
    static int[][] array2 = new int[4][4];
    /**
     * @param args
     */
    public static void main(String[] args) {

                
        array2= twoArrays();
        for(int i=0;i<array2.length;i++)
        System.out.println(Arrays.toString(array2[i]));
        
        int[][] result = inPlace();
        for(int i=0;i<result.length;i++)
            System.out.println(Arrays.toString(result[i]));        
        
        
        
    }
    //right twist 90 degrees
    public static int[][] twoArrays(){
        for(int x=0;x<a.length;x++){
            for(int y=0;y<a[0].length;y++){
                array2[y][a.length-x-1]=a[x][y];
            }
        }
        return array2;
        
    }
    //inPlace() left twist 90 degrees
    /*
      [4, 8, 2, 6]
[3, 7, 1, 5]
[2, 6, 0, 4]
[1, 5, 9, 3]
     */
    public static int[][] inPlace(){
        int tmp;
        for (int i=0; i<n/2; i++){
                for (int j=i; j<n-i-1; j++){
                        tmp=a[i][j];
                        a[i][j]=a[j][n-i-1];
                        a[j][n-i-1]=a[n-i-1][n-j-1];
                        a[n-i-1][n-j-1]=a[n-j-1][i];
                        a[n-j-1][i]=tmp;
                }
        }
        return a;
    }
    
    
    This a better version of it in Java: I've made it for a matrix with a different width and height

    h is here the height of the matrix after rotating
    w is here the width of the matrix after rotating

 

public int[][] rotateMatrixRight(int[][] matrix)
{
    /* W and H are already swapped */
    int w = matrix.length;
    int h = matrix[0].length;
    int[][] ret = new int[h][w];
    for (int i = 0; i < h; ++i) {
        for (int j = 0; j < w; ++j) {
            ret[i][j] = matrix[w - j - 1][i];
        }
    }
    return ret;
}


public int[][] rotateMatrixLeft(int[][] matrix)
{
    /* W and H are already swapped */
    int w = matrix.length;
    int h = matrix[0].length;   
    int[][] ret = new int[h][w];
    for (int i = 0; i < h; ++i) {
        for (int j = 0; j < w; ++j) {
            ret[i][j] = matrix[j][h - i - 1];
        }
    }
    return ret;
}
/* in C
 * 
 * #include <algorithm>
#include <cstddef>

// Rotates an NxN matrix of type T 90 degrees to the right.
template <typename T, size_t N>
void rotate_matrix(T (&matrix)[N][N])
{
    for(size_t i = 0; i < N; ++i)
        for(size_t j = 0; j <= (N-i); ++j)
            std::swap(matrix[i][j], matrix[j][i]);
}
 */


}
