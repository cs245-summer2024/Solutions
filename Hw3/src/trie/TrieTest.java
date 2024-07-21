package trie;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
class TrieTest {
    /*
        Test Cases for Q1: Trie Deletion
     */
    @Test // 1point
    public void testNoDelete(){
        Trie wordTrie = new Trie();

        wordTrie.insert("worm");
        wordTrie.delete("wor");
        assertTrue(wordTrie.contains("worm"));
    }

    @Test // 1point
    public void testSoloDelete(){
        Trie wordTrie = new Trie();

        wordTrie.insert("worm");
        wordTrie.insert("abde");
        wordTrie.insert("abcef");
        wordTrie.insert("xyz");
        wordTrie.insert("xyzb");

        wordTrie.delete("worm");
        assertFalse(wordTrie.contains("worm"));
        assertTrue(wordTrie.root.children['w'] == null);
    }
    @Test // 1 point
    public void testDeletePrefix(){
        Trie wordTrie = new Trie();
        String[] keys = {"abc", "ab"};
        for(String k: keys) {
            wordTrie.insert(k);
        }

        wordTrie.delete("ab");
        assertFalse(wordTrie.contains("ab"));
        assertTrue(wordTrie.contains("abc"));
    }

    @Test // 1 point
    public void testDeletePrefixV2(){
        Trie wordTrie = new Trie();
        String[] keys = {"abc", "ab"};
        for(String k: keys) {
            wordTrie.insert(k);
        }

        wordTrie.delete("abc");
        assertFalse(wordTrie.contains("abc"));
        assertTrue(wordTrie.contains("ab"));
    }

    @Test // 2 points Hidden test case
    public void testSharedDelete(){
        Trie wordTrie = new Trie();

        wordTrie.insert("worm");
        wordTrie.insert("abc");
        wordTrie.insert("abde");
        wordTrie.insert("xyz");
        wordTrie.insert("xyzb");

        wordTrie.delete("abde");
        wordTrie.delete("abc");
        assertFalse(wordTrie.contains("abde"));
        assertFalse(wordTrie.contains("abc"));
        assertTrue(wordTrie.root.children['a'] == null);
    }

    /*
        Test Cases for Q2: Trie Collect Keys
     */
    @Test // 1 point
    public void testCollectEmpty(){
        Trie wordTrie = new Trie();
        List<String> allWords = wordTrie.collectKeys();
        assertTrue(allWords.size() == 0);
    }

    @Test // 1 point
    public void testCollect(){
        Trie wordTrie = new Trie();
        String[] keyWords = {"hello", "hero", "apple", "sad", "same",
                "beehive", "believe", "marbles", "maple", "the lazy dog jumped."};
        Set<String> expectedSet = new HashSet<>();

        for(String s: keyWords){
            wordTrie.insert(s);
            expectedSet.add(s);
        }

        List<String> allWords = wordTrie.collectKeys();
        Set<String> outputSet = new HashSet<>();
        for(String a: allWords){
            outputSet.add(a);
        }
        assertTrue(outputSet.equals(expectedSet));
    }

    /*
       Test Cases for Q3: Trie Collect Keys with prefixes
    */
    @Test // 1 point
    public void testPrefixCollectNoMatches(){
        Trie wordTrie = new Trie();
        String[] keyWords = {"apple", "sad", "same",
                "beehive", "believe", "marbles", "maple", "the lazy dog jumped."};
        for(String s: keyWords){
            wordTrie.insert(s);
        }

        List<String> prefixWords = wordTrie.keysWithPrefix("he");
        assertTrue(prefixWords.size() == 0);
    }

    @Test // 1 point
    public void testPrefixCollectEmptyPrefix(){
        Trie wordTrie = new Trie();
        String[] keyWords = {"head", "hero", "heroes", "hello",
                "help", "helping", "heed", "heaven", "height", "helium",
                "apple", "sad", "same",
                "beehive", "believe", "marbles", "maple", "the lazy dog jumped."};
        Set<String> expectedSet = new HashSet<>();

        for(String s: keyWords){
            wordTrie.insert(s);
            expectedSet.add(s);
        }

        List<String> prefixWords = wordTrie.keysWithPrefix("");
        Set<String> outPutSet = new HashSet<>();
        for(String pw: prefixWords){
            outPutSet.add(pw);
        }
        assertTrue(outPutSet.equals(expectedSet));
    }

    @Test // 1 point
    public void testPrefixCollectAllMatches(){
        Trie wordTrie = new Trie();
        String[] keyWords = {"head", "hero", "heroes", "hello",
                "help", "helping", "heed", "heaven", "height", "helium"};
        Set<String> expectedSet = new HashSet<>();

        for(String s: keyWords){
            wordTrie.insert(s);
            if(s.substring(0, 2).equals("he")){
                expectedSet.add(s);
            }
        }

        List<String> prefixWords = wordTrie.keysWithPrefix("he");
        Set<String> outPutSet = new HashSet<>();
        for(String pw: prefixWords){
            outPutSet.add(pw);
        }
        assertTrue(outPutSet.equals(expectedSet));
    }

    @Test // 2 points
    public void testPrefixCollectSomeMatches(){
        Trie wordTrie = new Trie();
        String[] keyWords = {"head", "hero", "heroes", "hello",
                "help", "helping", "heed", "heaven", "height", "helium",
                "apple", "sad", "same",
                "beehive", "believe", "marbles", "maple", "the lazy dog jumped."};
        Set<String> expectedSet = new HashSet<>();

        for(String s: keyWords){
            wordTrie.insert(s);
            if(s.substring(0, 2).equals("he")){
                expectedSet.add(s);
            }
        }

        List<String> prefixWords = wordTrie.keysWithPrefix("he");
        Set<String> outPutSet = new HashSet<>();
        for(String pw: prefixWords){
            outPutSet.add(pw);
        }
        assertTrue(outPutSet.equals(expectedSet));
    }
}
