// Problem: Group Anagrams
// Platform: Leetcode
// Link: https://leetcode.com/problems/group-anagrams/
// Difficulty: Medium

// Approach:
// 1. Use a hash map to group anagrams together. The key will be the sorted version of the string, and the value will be a list of strings that are anagrams of each other.
// 2. For each string in the input array, sort the characters to create the key and add the original string to the corresponding list in the hash map.
// 3. Finally, return the values of the hash map as a list of lists.

// Time Complexity: O(n * k log k) - where n is the number of strings and k is the maximum length of a string, due to sorting each string.
// Space Complexity: O(n * k) - in the worst case, all strings are anagrams of each other, and we store all strings in the hash map.

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Map: Sorted String -> List of original strings
        Map<String, List<String>> res = new HashMap<>();

        for (String s : strs) {
            // 1. Convert string to char array so we can sort it
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            
            // 2. This sorted string is our "Group ID"
            String sortedS = new String(chars);

            // 3. If ID isn't in map, add it with an empty list
            if (!res.containsKey(sortedS)) {
                res.put(sortedS, new ArrayList<>());
            }

            // 4. Add the original word to its group
            res.get(sortedS).add(s);
        }

        // Return just the values (the lists of groups)
        return new ArrayList<>(res.values());
    }
}