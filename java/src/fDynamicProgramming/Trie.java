package fDynamicProgramming;

import java.util.HashMap;

/**
 * Created by arpana on 7/17/14.
 */
public class Trie {

    class TrieNode{

        private char value;
        private HashMap<Character,TrieNode> children;
        private boolean isEnd = false;

        public TrieNode(char value){
            this.value = value;
        }

        public HashMap<Character, TrieNode> getChildren() {return children;}
        public char getValue() {return value;}
        public boolean isEnd(){return isEnd;};
        public  void setIsEnd(boolean val){isEnd = val;}

    }

        private TrieNode root;
        public TrieNode getRoot(){
        	return root;
        };
        
        public Trie(){
            root = new TrieNode('0');
        }

        public void insert(String word){
            assert(word!=null || word != "");
            int len = word.length();
            TrieNode crawl = root;

            //Start from the root, got down the matching characters
            //Traverse through all the characters of the word
            for(int level = 0; level < len; level++){
                HashMap<Character,TrieNode> child = crawl.getChildren();
                char ch = word.charAt(level);
                if(child!= null && child.containsKey(ch)){
                    crawl = child.get(ch);
                }else{
                    TrieNode createChild = new TrieNode(ch);
                    child.put(ch, createChild);
                    crawl = createChild;
                }

            }
            crawl.setIsEnd(true);
        }

}

