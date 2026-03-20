// Problem: Smallest Number
// Platform: GeeksforGeeks
// Link: https://www.geeksforgeeks.org/find-the-smallest-number-with-given-sum-of-digits-and-number-of-digits/
// Difficulty: Medium  

// Approach:
// We can use a greedy approach to fill the digits from the end. We try to fill the last digit with 9 as much as possible until we exhaust the sum. If the first digit is 0, we need to borrow 1 from the next non-zero digit to make it 1 and reduce that digit by 1.

// Time Complexity: O(d) - we traverse the digits array at most twice, once to fill the digits and once to adjust the first digit if it's 0.
// Space Complexity: O(d) - we are using an array to store the digits of the result.

class Solution {
    public String smallestNumber(int s, int d) {
        
        if(s > 9*d) return "-1";
        int[] res = new int[d];
        for(int i = d-1;i>=0;i--){
            if(s >= 9){
                res[i] = 9;
                s -= 9;
            }else{
                res[i] = s;
                s = 0;
            }
        }
        if(res[0] == 0){
            for(int i = 1;i<d;i++){
                if(res[i] > 0){
                    res[i]--;
                    res[0] = 1;
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int num: res){
            sb.append(num);
        }
        return sb.toString();
    }
}
