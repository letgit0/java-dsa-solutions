// Problem: Range Sum Query - Mutable
// Platform: Leetcode
// Link: https://leetcode.com/problems/range-sum-query-mutable/
// Difficulty: Medium

// Time Complexity: O(n) for buildTree , O(log n) for updateTree, O(log n) for query
// Space Complexity: O(n)  (array size n, segment tree ~4n)

class NumArray {
  int n; 
  int[] segTree;

  public NumArray(int[] nums) {
    n = nums.length;
    segTree = new int[n*4];
    buildTree(segTree, nums, 0 , 0, n-1);
  }
  
  public void update(int index, int val) {
    updateTree(segTree, 0 , 0 , n-1, index, val); 
  }
  
  public int sumRange(int left, int right) {
    return query(segTree, left, right, 0, 0, n-1);
  }
  static void buildTree(int[] segTree, int[] arr, int node, int left, int right){
    if(left == right ){
      segTree[node] = arr[left]; return;
    }
    int mid = left + (right-left)/2;
    buildTree(segTree, arr, 2*node+1,left , mid );
    buildTree(segTree, arr, 2*node+2, mid+1, right);
    segTree[node] = segTree[2*node+1]+segTree[2*node+2]; 
  }
  static void updateTree(int[] segTree, int node , int left, int right, int idx, int val){
    if(left == right){
      segTree[node] = val; return;
    }
    int mid = left + (right - left)/2;
    if(idx <= mid ){
      updateTree(segTree, 2*node+1, left , mid, idx, val);
    }else{
      updateTree(segTree, 2*node+2, mid+1, right, idx, val);
    }
    segTree[node] = segTree[2*node+1]+segTree[2*node+2];
  }
  static int query(int[] segTree, int qs, int qe, int node, int left, int right){
    if (qe < left || qs > right) return 0;
    if (qs <= left && right <= qe) return segTree[node];
    int mid = left + (right - left)/2;
    int lChild = query(segTree, qs, qe, 2*node+1, left, mid);
    int rChild = query(segTree, qs, qe, 2*node+2, mid+1, right);
    return lChild+ rChild;
  }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */