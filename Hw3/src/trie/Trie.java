package trie;
import java.util.*;

public class Trie {
    private static final int CHARACTER_SET_SIZE = 128;
    public TrieNode root; // Acts as a sentinel node. Made public for autograder testing purposes

    /*
        Really should be a private nested class, but made public for autograder testing.
     */
    public static class TrieNode{
        private char letter;
        private boolean isKey;
        public TrieNode[] children;

        private TrieNode parent;

        private TrieNode(TrieNode parent, char k){
            this.letter = k;
            this.isKey = false;
            children = new TrieNode[CHARACTER_SET_SIZE];
            this.parent = parent;
        }

        private boolean isLeaf(){
            for(int i = 0; i < CHARACTER_SET_SIZE; i++){
                if(children[i] != null){
                    return false;
                }
            }
            return true;
        }
    }

    public Trie(){
        //Initialize root to take on any value.
        root = new TrieNode(null, 'a');
    }

    //Iteratively add String s to the trie
    public void insert(String s){
        if(s == null){
            return;
        }
        int stringLength = s.length();
        TrieNode traverser = root;

        for(int idx = 0; idx < stringLength; idx ++){
            char currentLetter = s.charAt(idx);
            if(traverser.children[currentLetter] == null){
                TrieNode childNode = new TrieNode(traverser, currentLetter);
                traverser.children[currentLetter] = childNode;
            }
            traverser = traverser.children[currentLetter];
        }
        traverser.isKey = true;
    }

    //Iterative implementation to check if trie contains s
    public boolean contains(String s){
        if(s == null){
            return false;
        }
        int stringLength = s.length();
        TrieNode parent = root;

        for(int idx = 0; idx < stringLength; idx ++){
            char currentLetter = s.charAt(idx);
            if(parent.children[currentLetter] == null){
                return false;
            }
            parent = parent.children[currentLetter];
        }
        return parent.isKey;
    }

    public void delete(String s){
        if(contains(s)){
            if(s.length() == 0){
                root.isKey = false;
            } else {
                deleteHelper(s, s.length(), 0, root);
            }
        }
    }

    private void deleteHelper(String s, int sLen, int curIdx, TrieNode curNode){
        TrieNode parent = curNode.parent;
        if(curIdx == sLen){
            char lastLetter = s.charAt(sLen - 1);
            if(curNode.isLeaf() && parent != null){
                parent.children[lastLetter] = null;
            } else {
                curNode.isKey = false;
            }
        } else {
            deleteHelper(s, sLen, curIdx + 1, curNode.children[s.charAt(curIdx)]);
            if(curNode.isLeaf()  && !curNode.isKey) {
                char letterOfInterest = s.charAt(curIdx - 1);
                parent.children[letterOfInterest] = null;
            }
        }
    }

    // Return a list of all the keys that are in the trie
    public List<String> collectKeys(){
        List<String> allKeys = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int idx = 0; idx < CHARACTER_SET_SIZE; idx ++){
            if(root.children[idx] != null){
                collectKeysHelper(root.children[idx], sb, allKeys);
            }
        }
        return allKeys;
    }

    private void collectKeysHelper(TrieNode node, StringBuilder sb, List<String> keys){
        sb.append(node.letter);
        if(node.isKey){
            keys.add(sb.toString());
        }
        for(int childIdx = 0; childIdx < CHARACTER_SET_SIZE; childIdx ++){
            if(node.children[childIdx] != null){
                collectKeysHelper(node.children[childIdx], sb, keys);
            }
        }
        sb.deleteCharAt(sb.length() - 1);
    }

    // Return a list of all the keys that are in the trie
    public List<String> keysWithPrefix(String prefix){
        List<String> prefixKeys = new ArrayList<>();
        StringBuilder pattern = new StringBuilder();

        int prefixLength = prefix.length();
        TrieNode traverser = root;
        for(int idx = 0; idx < prefixLength; idx ++) {
            if(traverser.children[prefix.charAt(idx)] == null){
                return prefixKeys;
            }
            traverser = traverser.children[prefix.charAt(idx)];
            pattern.append(traverser.letter);
        }

        if(traverser == root){
            return collectKeys();
        }

        for(int idx = 0; idx < CHARACTER_SET_SIZE; idx ++){
            if(traverser.children[idx] != null){
                collectKeysHelper(traverser.children[idx], pattern, prefixKeys);
            }
        }
        return prefixKeys;
    }
}
