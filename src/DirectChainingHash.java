import java.util.LinkedList;

public class DirectChainingHash {
    LinkedList<String>[] hashTable ;
    //limiting the number that each list can store
    // so we don't get O(N) search time
    int maxChainSize = 5;
    public DirectChainingHash(int initialSize){
        hashTable = new LinkedList[initialSize];
    }
    public int modASCIIHashFunction(String word ){
        int sum = 0;
        for(int i = 0  ; i < word.length() ; i++){
            sum += word.charAt(i);
        }
        return sum % hashTable.length;
    }
    public void insert(String word){
        int index = modASCIIHashFunction(word);
        if(hashTable[index] == null){
            LinkedList<String> temp = new LinkedList<>();
            temp.add(word);
            hashTable[index] = temp;
        }else{
            hashTable[index].add(word);
        }
    }
    public void displayHashTable(){
        if(hashTable == null)
            return;
        for(int i = 0 ; i < hashTable.length ; i++){
            System.out.println("index " + i + " key: " + hashTable[i]);
        }
    }
    public boolean search(String word){
        int index = modASCIIHashFunction(word);
        if(hashTable[index] != null && hashTable[index].contains(word)){
            return true;
        }
        return false;
    }
    public void deleteKey(String word){
        int index = modASCIIHashFunction(word);
        if(search(word)){
            hashTable[index].remove(word);
        }
        System.out.println("key doesn't exist");
    }
}
