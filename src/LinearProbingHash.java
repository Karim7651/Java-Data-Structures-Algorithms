import java.util.ArrayList;

public class LinearProbingHash {
    String[] hashTable;
    int usedCells;
    public LinearProbingHash(int size){
        hashTable = new String[size];
        usedCells = 0;
    }
    public int modASCIIHashFunction(String word ){
        int sum = 0;
        for(int i = 0  ; i < word.length() ; i++){
            sum += word.charAt(i);
        }
        return sum % hashTable.length;
    }
    //load factor = number of used cells / full capacity
    //if loadFactor >= 0.75 -> create new hashTable
    public double getLoadFactor(){
        return  usedCells *1.0/hashTable.length;
    }
    public void rehashKeys(String word){
        //take all data from hashtable to arraylist
        //double size of hashtable
        //take data back from arrayList to hashtable after doubling its size
        ArrayList<String> data = new ArrayList<>();
        for(String s : hashTable){
            data.add(s);
        }
        data.add(word);
        hashTable = new String[hashTable.length * 2];
        for(String s : data){
            insert(s);
        }
    }
    public void insert(String word){
        double loadFacter = getLoadFactor();
        if(loadFacter>=0.75){
            rehashKeys(word);
        }else{
            int index = modASCIIHashFunction(word);
            for(int i = index ; i < index+hashTable.length ; i++){
                int newIndex = i % hashTable.length;
                if(hashTable[newIndex] == null){
                    hashTable[newIndex] = word;
                    break;
                }else{
                    continue;
                }
            }
            usedCells++;
        }
    }
    public boolean search(String word){
        int index = modASCIIHashFunction(word);
        for(int i = index ; i < index + hashTable.length ; i++){
            int newIndex = i %hashTable.length;
            if(hashTable[newIndex] != null && hashTable[newIndex].equals(word)){
                return true;
            }
        }
        return false;
    }
    public void deleteKey(String word){
        if(search(word)){
            int index = modASCIIHashFunction(word);
            for(int i = index ; i < hashTable.length + index ; i++){
                int newIndex = i %hashTable.length;
                if(hashTable[newIndex] != null && hashTable[newIndex].equals(word)){
                    hashTable[newIndex] = null;
                    return;
                }
            }
        }
        System.out.println("key not found");
    }
    public void displayHashTable(){
        if(hashTable == null)
            return;
        for(int i = 0 ; i < hashTable.length ; i++){
            System.out.println("index " + i + " key: " + hashTable[i]);
        }
    }


}
