// Problem: DNA Storage
// Platform: Codechef
// Link: https://www.codechef.com/practice/course/strings/STRINGS/problems/DNASTORAGE
// Difficulty: Easy

// Approach:
// Each pair of binary digits maps to a DNA character:
// 00 → A, 01 → T, 10 → C, 11 → G
// Traverse the string in steps of 2
// Convert each pair and append to result

// Time Complexity: O(n)
// Space Complexity: O(n)
import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int t = scanner.nextInt();

    while (t-- > 0) {
      int n = scanner.nextInt(); // length of binary string
      String s = scanner.next();

      StringBuilder result = new StringBuilder();

      // Process 2 bits at a time from left to right
      for (int i = 0; i < n; i += 2) {
        String pair = s.substring(i, i + 2);

        switch (pair) {
          case "00": result.append('A'); break;
          case "01": result.append('T'); break;
          case "10": result.append('C'); break;
          case "11": result.append('G'); break;
        }
      }

        System.out.println(result.toString());
    }

    scanner.close();
  }
}