// Problem: N meetings in one room
// Platform: GeeksforGeeks
// Link: https://www.geeksforgeeks.org/maximum-number-of-meetings-that-can-be-organized-in-one-room/
// Difficulty: Easy

// Approach:
// Sort meetings by their end times.
// Select the meeting that ends earliest and doesn't conflict with the previously selected meeting.

// Time Complexity: O(n log n) - for sorting the meetings by their end times.
// Space Complexity: O(n) - for the array of Time objects.


class Solution {
  static class Time {
    int start;
    int end;

    Time(int s, int e) {
      start = s;
      end = e;
    }
  }

  public int maxMeetings(int start[], int end[]) {

    int n = start.length;
    Time[] all = new Time[n];
    for (int i = 0; i < n; i++) {
      all[i] = new Time(start[i], end[i]);
    }
    Arrays.sort(all, (a, b) -> a.end - b.end);
    int currEnd = all[0].end;
    int count = 1;
    for (int i = 1; i < n; i++) {
      if (all[i].start > currEnd) {
        count++;
        currEnd = all[i].end;
      }
    }
    return count;
  }
}
