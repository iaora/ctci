/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
            return null;
        
        ArrayList<MergedListNode> mLists = convert(lists);
        if(mLists.size() == 0)
            return null;
        MergedListNode minMergedNode = findMin(mLists);
        ListNode ret = minMergedNode.list;
        ListNode ptr = ret;
        if(minMergedNode.next() == false)
            mLists.remove(minMergedNode);
        
        while(mLists.size() > 1){
            minMergedNode = findMin(mLists);
            ptr.next = minMergedNode.list;
            ptr = ptr.next;
            
            if(minMergedNode.next() == false){
                mLists.remove(minMergedNode);
            }
        }
        if(mLists.size() == 1)
            ptr.next = mLists.get(0).list;
        return ret;
    }
    
    private MergedListNode findMin(ArrayList<MergedListNode> mLists){
        MergedListNode minNode = mLists.get(0);
        for(MergedListNode mNode : mLists){
            if(mNode.min < minNode.min){
                minNode = mNode;
            }
        }
        System.out.println("Find min: " + minNode.min);
        return minNode;
    }
    
    private ArrayList<MergedListNode> convert(ListNode[] lists){
        ArrayList<MergedListNode> mLists = new ArrayList<MergedListNode>();
        for(int i = 0; i < lists.length; i++){
            if(lists[i] != null)
                mLists.add(new MergedListNode(lists[i]));
        }
        return mLists;
    }
    
}

class MergedListNode{
    int min;
    ListNode list;
    
    public MergedListNode(ListNode list){
        
        this.min = list.val;
        this.list = list;
    }
    
    public boolean next(){
        if(list.next == null)
            return false;
        getNext();
        return true;
    }
    
    private void getNext(){
        this.list = list.next;
        this.min = list.val;
    }
}
