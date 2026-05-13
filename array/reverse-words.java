// Problem: Reverse Words in a String
// Platform: Codechef
// Link: https://www.codechef.com/practice/course/strings/STRINGS/problems/PALINDRCHECK?tab=statement
// Difficulty: Easy

// Approach:
// 1. Split the input string into words using whitespace as delimiter.
// 2. Iterate over the words array in reverse order.
// 3. Append each non-empty word to a StringBuilder, adding a space after each word.
// 4. Trim the final string to remove the trailing space.
// 5. Return the resulting reversed-words string.

// Time Complexity: O(n)
// Space Complexity: O(n)

public static String reverseWords(String s) {
  String[] arr = s.split("\\s+");
  StringBuilder sb = new StringBuilder();
  for(int i = arr.length-1; i>= 0; i--){
    if(!arr[i].trim().isEmpty()){
      sb.append(arr[i]);
      sb.append(" ");
    }
  }
    
  return sb.toString();
}