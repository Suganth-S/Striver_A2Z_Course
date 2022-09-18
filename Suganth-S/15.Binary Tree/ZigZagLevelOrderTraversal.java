/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wrapList = new ArrayList();
        
        if(root == null)
            return wrapList;
        
        queue.offer(root);
        boolean flag = true;
        while(!queue.isEmpty())
        {
            int levelNum = queue.size();
            ArrayList<Integer> al = new ArrayList();
            for(int i=0; i<levelNum; i++)
            {
                if(queue.peek().left!= null)
                {
                    queue.offer(queue.peek().left);
                }
                if(queue.peek().right!=null)
                {
                    queue.offer(queue.peek().right);
                }
                if(flag==true)
                {
                    al.add(queue.poll().val);
                }
                else al.add(0, queue.poll().val);
            }
            flag= !flag;
            wrapList.add(al);    
        }
        return wrapList;
    }
}
