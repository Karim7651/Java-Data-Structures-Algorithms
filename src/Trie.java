import java.util.HashMap;

public class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    //O(N) O(N)
    //where n is the length string
    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char currentCharacter = word.charAt(i);
            TrieNode node = current.children.get(currentCharacter);
            //if it doesn't exist add this node
            if (node == null) {
                node = new TrieNode();
                current.children.put(currentCharacter, node);
            }
            //go to next node in the tree
            current = node;
        }
        //after inserting all characters set endOfString to true
        current.isEndOfString = true;
    }

    //O(n) where n is the length of the word to search
    //O(1) since we're not storing anything extra
    public boolean search(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char currentCharacter = word.charAt(i);
            TrieNode node = current.children.get(currentCharacter);
            if (node == null) {
                System.out.println("not found");
                return false;
            }
            current = node;
        }
        return current.isEndOfString;
    }

    public boolean delete(TrieNode parentNode, int index, String word) {
        char currentCharacter = word.charAt(index);
        TrieNode currentNode = parentNode.children.get(currentCharacter);
        boolean canThisNodeBeDeleted;
        //some other word prefix is same as this word we want to delete
        if (currentNode.children.size() > 1) {
            //can't be deleted
            delete(currentNode, index + 1, word);
            return false;
        }
        //at the last character of this word we want to delete but it is a prefix for another word
        if (index == word.length() - 1) {
            //just mark end of string to false
            if (currentNode.children.size() >= 1) {
                currentNode.isEndOfString = false;
                return false;
                //if this is the lastCharacter and this isn't a prefix of another word
            } else {
                currentNode.children.remove(currentCharacter);
                return true;
            }
        }
        //if some other word is a prefix of a word we're trying to delete
        if (currentNode.isEndOfString) {
            delete(currentNode, index + 1, word);
            return false;
        }
        //no other node is dependent on this node
        canThisNodeBeDeleted = delete(currentNode, index + 1, word);
        if (canThisNodeBeDeleted) {
            parentNode.children.remove(currentCharacter);
            return true;
        } else {
            return false;
        }
    }
    public void delete(String word){
        if(search(word)){
            delete(root,0,word);
        }
    }

    public class TrieNode {
        HashMap<Character, TrieNode> children;
        boolean isEndOfString;

        public TrieNode() {
            children = new HashMap<>();
            isEndOfString = false;
        }
    }
}
