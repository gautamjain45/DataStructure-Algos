//This is the approach based on Binary Search
public class LongestCommonPrefixUsingBinarySearch {
    public static void main(String[] args){
        String arr[] = {"gautam", "gaurav", "gautham", "gauthamBatman"};
        String prefix = CommonPrefix(arr);
        if (prefix.length() > 0)
            System.out.println("The longest common"
                    + " prefix is " + prefix);
        else
            System.out.println("There is no common"
                    + " prefix");
    }

    /**
     * This method will find the length of the shortest word from the array
     * @param arr
     * @return
     */
    private static int FindMinLength(String[] arr){
        int minLength = 0;
        int min = Integer.MAX_VALUE;
        for(String item : arr){
            if(item.length()<min){
                min = item.length();
            }
        }
        minLength = min;
        return minLength;
    }

    /**
     * This method iterates on each word of the array and the checks each character
     * which is being repeated in all rest of the elements of array.
     * @param arr
     * @param str
     * @param start
     * @param end
     * @return
     */
    private static boolean AllContainsPrefix(String[] arr, String str, int start, int end){
        for(String item : arr){
            for(int j = start; j <= end; j++){
                if(item.charAt(j) != str.charAt(j))
                    return false;
            }
        }
        return true;
    }

    /**
     * This is the main function where rest of the functionalities are being called.
     * This methods check the highest length word and then does the processing accordingly.
     * @param arr
     * @return
     */
    private static String CommonPrefix(String[] arr){
        String prefix = "";
        //Finding lenght of shortest word from the array.
        int minLenght = FindMinLength(arr);
        int low = 0;
        //Making it as highest length.
        int high = minLenght - 1;
        while (low <= high) {
            //As per binary search mechanism , finding mid length of the word.
            int mid = low + (high - low)/2;
            //On the basis of array element and mid length , finding prefix.
            boolean containsPrefix = AllContainsPrefix(arr,arr[0],low,mid);

            if(containsPrefix){
                prefix = prefix + arr[0].substring(low,mid + 1);
                low = mid + 1;      //To check the prefix from the next half of the word.
            }else{
                high = mid - 1;     //Reducing mid length to find exact prefix.
            }
        }
        return prefix;
    }
}
