public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	/*
    	 * nums1: 1 	|	2  	3  	4
    	 * 		  bl1       br1
    	 * 
    	 * nums2: 3  	4  	5  	6 	|	7
    	 * 	                    bl2     br2
    	 * 
    	 * i2 = (len1 + len2)/2 - i1;
    	 * 
    	 * Binary Search:
    	 * 	if(bl1 <=  br2 && bl2 <= br1)
    	 *  	FOUND
    	 *  else if(bl2 <= br1)
	     *		Too left
    	 *  else 
    	 *		Too right
    	 *
    	 * odd or even 
    	 * 
    	 */
    	
    	//corner depends
    	if (nums1.length == 0 && nums2.length == 0) {
    		return 0.0;
    	}
    	
    	//Make sure nums1.length < nums2.length
    	if (nums1.length > nums2.length) {
    		int[] cup = nums1;
    		nums1 = nums2;
    		nums2 = cup;
    	}
    	
    	//Inits
    	int len1 = nums1.length;
    	int len2 = nums2.length;

    	int b1 = 0; 				//nums1's breaker is in front of ind 0;
    	int b2 = (len1 + len2) / 2; 	//nums2's breaker is in fornt of 
    	
    	int leftMax1 = 0;
		int leftMax2 = 0;
		int rightMin1 = 0;
		int rightMin2 = 0;
    	
    	//Binary Search 
    	int l = 0, r = len1;		//Binary Search Space [0, len1]
    	while (l <= r) {
    		
    		b1 = (l + r)/2;
    		b2 = (len1 + len2)/2 - b1;
    		
    	   	leftMax1 = (b1 == 0)? Integer.MIN_VALUE : nums1[b1 - 1];
    		leftMax2 = (b2 == 0)? Integer.MIN_VALUE : nums2[b2 - 1];
    		rightMin1 = (b1 == len1)? Integer.MAX_VALUE : nums1[b1];
    		rightMin2 = (b2 == len2)? Integer.MAX_VALUE : nums2[b2];
    		
    		if (leftMax1 <= rightMin2 && leftMax2 <= rightMin1) { //found solution
    			break;
    		} else if(leftMax1 <= rightMin2) { //b1 too left
    			l = b1 + 1;
    		} else { //b1 too left
    			r = b1;
    		}
    	}
    	
		if ((len1 + len2) % 2 == 1) { //total is odd
    		return Math.min(rightMin1, rightMin2);
    	} else { //total is even 
    		return (Math.max(leftMax1, leftMax2) + Math.min(rightMin1, rightMin2)) / 2.0;
    	}
    }
}