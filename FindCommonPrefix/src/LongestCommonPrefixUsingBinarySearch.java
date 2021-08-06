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

    private static boolean AllContainsPrefix(String[] arr, String str, int start, int end){
        for(String item : arr){
            for(int j = start; j <= end; j++){
                if(item.charAt(j) != str.charAt(j))
                    return false;
            }
        }
        return true;
    }

    private static String CommonPrefix(String[] arr){
        String prefix = "";
        int minLenght = FindMinLength(arr);
        int low = 0;
        int high = minLenght - 1;
        while (low <= high) {
            int mid = low + (high - low)/2;
            boolean containsPrefix = AllContainsPrefix(arr,arr[0],low,mid);
            if(containsPrefix){
                prefix = prefix + arr[0].substring(low,mid + 1);
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return prefix;
    }
}
