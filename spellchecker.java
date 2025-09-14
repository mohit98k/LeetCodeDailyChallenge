//966. Vowel Spellchecker
// 3 caseErrors
//     1.exact match: for that put word list in a set so we can look up in o(1)
//     2.caseError errors: for that map<str,str> put word from word list in lowercaseError i map 
//     and check by converting queries to lowercaseError in map 
//     3.vowel error: encode vowels in words of wordlist put in map with value as the actual word then convert the querry in the same format and look up in map and return 


import java.util.*;

class spellchecker{
    public static void main(String[] args) {
        String[] wordlist={"KiTe","kite","hare","Hare"};
        String[] queries={"kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"};
        String []s= spellchecker(wordlist, queries);
        System.out.println(Arrays.toString(s));//["kite","KiTe","KiTe","Hare","hare","","","KiTe","","KiTe"]
    }
    private static String[] spellchecker(String[] wordlist, String[] queries) {
        HashSet<String>exact=new HashSet<>();
        HashMap<String,String>caseError=new HashMap<>();
        HashMap<String,String>vowel=new HashMap<>();

        for(String s:wordlist){
            exact.add(s);

            String s1=s.toLowerCase();
            if(!caseError.containsKey(s1)) caseError.put(s1,s);

            String s2=vowelencode(s1);
            if(!vowel.containsKey(s2)) vowel.put(s2,s);
        }

        String []ans=new String[queries.length];
        int i=0;

        for(String s:queries){

            String s1=s.toLowerCase();
            String s2=vowelencode(s1);

            if(exact.contains(s))ans[i++]=s;
            else if(caseError.containsKey(s1))ans[i++]=caseError.get(s1);
            else if(vowel.containsKey(s2))ans[i++]=vowel.get(s2);
            else ans[i++]="";
        }

        return ans;
       
      
    }
    private static String vowelencode(String s){
        char[]arr=s.toCharArray();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){
                 arr[i]='*';
            }
        }
        String s1=new String(arr);
        return s1;
    }
}