package bStrings;

/**
 * Created by arpana on 7/17/14.
 */
public class LongestCommonPrefix {

    public static String longestCommonPrefixIterative(String[] words){
        //Assert list is not empty
        assert(words.length > 0);
        String prefix = words[0];

        //loop through all the strings updating the prefix
        for(String word : words){
            //Compare the prefix with the given string
            assert(word !=null);
            int j = 0;
            for(; j< Math.min(prefix.length(), word.length()); j++){
              //if characters do not match then end, there is match only up till that character
               if(prefix.charAt(j) != word.charAt(j)){
                   break;
               }
            }
            prefix = word.substring(0, j);
        }

        return prefix;
    }

    public static void main(String[] args){

        String[] words = {"cater","caterpillar","cat","catecow","","catyur"};
        String prefix = LongestCommonPrefix.longestCommonPrefixIterative(words);
        System.out.println("Longest common prefix:" + prefix);

    }

}
