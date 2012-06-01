package algarithm;

public class Palindrome {
    public static String testTrue = "lit yes sey til";
    public static String testFalse = "wrong";
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(isPalindrome(testFalse));
        System.out.println(isPalindrome(testTrue));

    }
    public static boolean isPalindrome(String word){
        int i = 0;
        int j = word.length()-1;
        if(word.length()==1){
            return true;
        }
        while(i<j){
            while(!Character.isLetterOrDigit(word.charAt(i))&&i<word.length()){
                i++;
            }
            if(i>=word.length()){
                return false;
            }
            while(!Character.isLetterOrDigit(word.charAt(j))&& j>0){
                j--;
            }
            if(word.charAt(i)!=word.charAt(j)){
                return false;
            }
            i++;
            j--;
            
        }
        return true;
    }

}
