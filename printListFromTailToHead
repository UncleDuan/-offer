/**
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*
*/
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        //存储所有元素
        ArrayList<Integer> listTemp = new ArrayList<Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(listNode!=null){
            listTemp.add(listNode.val);
            listNode=listNode.next;
        }
        //从尾到头
        int len=listTemp.size();
        for(int i=0;i<len;i++)
            list.add(listTemp.get(len-1-i));
        return list;
    }
}
