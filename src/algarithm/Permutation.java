package algarithm;

import java.util.LinkedList;

/*
 * for example, get permutations of ABC
 */
public class Permutation {
    

    public static void main(String[] args) {
        LinkedList<Character> charList = new LinkedList<Character> ();
        charList.add(new Character('a'));
        charList.add(new Character('b'));
        charList.add(new Character('c'));
        charList.add(new Character('d'));
        LinkedList<String> list = permute(charList);
        
        System.out.println( "list " + list);
        
        LinkedList<String> list2 = permute("abcd".toCharArray());
        
        System.out.println( "list2 " + list2);        

    }
    
    public static LinkedList<String> permute(LinkedList<Character> word){
        LinkedList<String> strList = new LinkedList<String>();
        if(word.size()==1){
            strList.add(""+word.getFirst());
            return strList;
        }
        for(Character tmp : word){
           LinkedList<Character> subList = (LinkedList<Character>)word.clone();
           subList.remove(tmp);
           LinkedList<String> tmpList = permute(subList);
           for(String subStr:tmpList){
               strList.add(subStr+tmp);
               
           }
        }
        
        
        return strList;
    }

    
    public static LinkedList<String> permute(char[] word){
        LinkedList<String> strList = new LinkedList<String>();
        if(word.length==1){
            strList.add(""+word[0]);
            return strList;
        }
        for(int i=0;i< word.length;i++){
           char[] newWord = new char[word.length-1];
           System.arraycopy(word, 0, newWord, 0, i);
           System.arraycopy(word, i+1, newWord, i, word.length-i-1);    
           LinkedList<String> tmpList = permute(newWord);
           for(String subStr:tmpList){
               strList.add(subStr+word[i]);
               
           }
        }
        
        
        return strList;
    }    
    
}
