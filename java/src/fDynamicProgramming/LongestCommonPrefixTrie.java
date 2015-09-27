package fDynamicProgramming;

/**
 * Created by arpana on 7/17/14.
 */

import java.util.HashMap;

import fDynamicProgramming.Trie.TrieNode;

public class LongestCommonPrefixTrie {

    public static String longestCommonPrefix(String input, Trie trie){
    	
    	
        String prefix = "";
        int len = input.length();
        TrieNode crawl = trie.getRoot();;
        int level, prevMatch = 0;
        for(level =0 ;level< len; level++){
            char ch = input.charAt(level);
            HashMap<Character, TrieNode> child = crawl.getChildren();
            if(child.containsKey(ch)){
                prefix += ch;
                crawl = child.get(ch);
                if(crawl.isEnd())
                    prevMatch = level+1;
            }else
                break;
        }
        if(!crawl.isEnd())
            return prefix.substring(0, prevMatch);
        else return prefix;

    }
	
    public static void main(String[] args){
        Trie trie = new Trie();
        trie.insert("cate");
        trie.insert("cat");
        trie.insert("cater");
        String input = "caterer";
        System.out.print(input + ":   ");
        System.out.println(longestCommonPrefix(input, trie));
    }

}



