/*
2785. Sort Vowels in a String
Input: s = "lEetcOde"
Output: "lEOtcede"
Explanation: 'E', 'O', and 'e' are the vowels in s; 'l', 't', 'c', and 'd' are all consonants. 
The vowels are sorted according to their ASCII values, and the consonants remain in the same places. 
 
 */
import java.util.*;
class sortVowels{
     public static void main(String[] args) {
        String s=solve("lEetcOde");
        System.out.println(s);
    }

    public static String solve(String s) {

        HashMap<Character,Integer>map=new HashMap<>();
        String vowel="AEIOUaeiou";

        for(int i=0;i<vowel.length();i++){
            Character c=vowel.charAt(i);
            map.put(c,(int)c);            
        }


       List<Character>a1=new ArrayList<>();
        char a2[]=new char[s.length()];//store the consonents

  
        for(int i=0;i<s.length();i++){
            Character c=s.charAt(i);
            if(map.containsKey(c)){
                //vowel
               a1.add(c);
                a2[i]='*';
            }
            else{
                //consonent
                a2[i]=c;
            }
        }

        //sort the vowels in a1 list
        Collections.sort(a1);

        //put back in a2 now in correct order
        int j=0;
        for(int i=0;i<a2.length;i++){
            if(a2[i]=='*'){
                a2[i]=a1.get(j++);
            }
        }
        String t=new String(a2);
        return t;

        
    }
}


    
