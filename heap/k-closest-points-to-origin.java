// Problem: k Closest Points to Origin
// Platform: Leetcode
// Link: https://leetcode.com/problems/k-closest-points-to-origin/
// Difficulty: Medium

// Approach:
// Use a max heap (priority queue) to keep track of the k closest points by distance.
// Iterate through all points, add them to the heap, and remove the farthest when size exceeds k.
//
// Time Complexity: O(n log k), where n is number of points (heap operations)
// Space Complexity: O(k) for the heap

class Solution {
    static class Point {
        int x, y;
        double dist;

        Point(int[] p) {
            x = p[0];
            y = p[1];
            dist = Math.sqrt(x * x + y * y);
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> maxheap = new PriorityQueue<>((a, b) -> Double.compare(b.dist, a.dist));

        for (int[] curr : points) {
            maxheap.offer(new Point(curr));
            if (maxheap.size() > k) {
                maxheap.poll();
            }
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            Point p = maxheap.poll();
            result[i][0] = p.x;
            result[i][1] = p.y;
        }

        return result;
    }
}