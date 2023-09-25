package longestConsecutiveSeq;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongestConsecutiveSeq {

	public static void main(String[] args) {
		
		int arr[] = { 1, 9, 3, 10, 4, 20, 2 };
		
	
		
//    	System.out.println( "Result: " + longestCommonSubSeq(arr));
			
		System.out.println( "Result: " + longestCommonSubSeqOptimal(arr));

	}
//
//
//	private static int longestCommonSubSeq(int[] arr) {
//		HashSet<Integer> seen = new HashSet<Integer>();
//		
//		int res = 0;
//		
//		for(int i=0;i<arr.length;i++) {
//			seen.add(arr[i]);
//		}
//		
//		
//		for(int i=0;i<arr.length;i++) {
//			
//			if(!seen.contains(arr[i] -1)) {
//				int num = arr[i];
//				
//				while(seen.contains(num)) {
//					seen.remove(Integer.valueOf(num));
//					num++;
//				}
//				
//				if(res < num - arr[i]) {
//					res = num - arr[i];
//				}
//				
//			}
//		}
//		
//		return res;
//		
//	}
	
	private static int longestCommonSubSeqOptimal(int[] arr) {
		
		if (arr.length <= 1) {
            return arr.length;
        }
       
        int res = 1;
        
        Map<Integer, Integer> h = new HashMap<Integer, Integer>();
        
        for (int n : arr) {
            h.put(n, null);
        }
       
        for (int i = 0; i < arr.length; i++) {
            res = Math.max(res, dfs(arr[i], h));
        }
         
        return res;
	}


	private static int dfs(int start, Map<Integer, Integer> h) {
		
		 if (!h.containsKey(start)) {
	            return 0;
	        }
	       
	        if (h.get(start) != null) {
	            return h.get(start);
	        }

	        int currentLongest = 1 + dfs(start + 1, h);
	         
	        h.put(start, currentLongest);
	         
	        return currentLongest;
	}


}
