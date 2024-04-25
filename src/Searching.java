public class Searching {

    //O(N)
    public int linearSearch(int[] array,int value){
        for(int i = 0 ; i < array.length ; i++){
            if(array[i] == value)
                return i;
        }
        return -1;

    }
    //Because if we use mid = (low + high)/2 then it might lead to overflow,
    // as (high + low) can exceed range and will eventually lead to overflow.
    // But if we use mid = low + (high - low)/2, then the possibility of overflow becomes none
    // , as if high and low are in the range, then (high - low) will definitely be in range and will not overflow.
    //O(log(n))
    public int binarySearch(int[] array,int value){
        int low = 0;
        int high = array.length - 1 ;
        while(low <= high){
            int mid = low +(high - low)/2;
            if(array[mid] == value)
                return mid;
            else if (array[mid] > value) {
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }
}
