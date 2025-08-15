1. Two Sum
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        int[] a=new int[2];
        int k=0;
        Map<Integer,Integer> mp=new HashMap<>();
        /*for(int i=1;i<n;i++){
            mp.put(nums[i],i);
        }*/
        for(int i=0;i<n;i++){
            int rem=target-nums[i];
            if(mp.containsKey(rem)){
                a[k++]=i;
                a[k++]=mp.get(rem);
                return a;
            }
            else{
                mp.put(nums[i],i);
            }
    }
            
    return a;
        }

       
    }

2.Reverse Integer

class Solution {
    public int reverse(int x) {
        long rem=0;
        while(x!=0){
          rem=rem*10+(x%10);
          x=x/10;
        }
        if( rem<Integer.MIN_VALUE ||rem>Integer.MAX_VALUE  ) return 0;
        return (int) rem;
    }
}

3.Roman to Integer

class Solution {
    public int romanToInt(String s) {

        Map<Character,Integer> mp=new HashMap<>();
        mp.put('I',1);
        mp.put('V',5);
        mp.put('X',10);
        mp.put('L',50);
        mp.put('C',100);
        mp.put('D',500);  
        mp.put('M',1000); 
        int res=mp.get(s.charAt(0));
        int pre=0,cur=0;
        for(int i=1;i<s.length();i++){
            pre=mp.get(s.charAt(i-1));
            cur=mp.get(s.charAt(i));
            if(pre>=cur) res=res+cur;
            else res=res+cur-(2*pre);
        }
        return res;
    }

}

4. Remove Nth Node From End of List

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int length(ListNode head){
        int c=0;
        for(ListNode cur=head;cur!=null;cur=cur.next){
            c++;
        }
        return c;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int l=(length(head)-n)+1;
       // System.out.print(l);
        int co=1;
        if(l==co) return head=head.next;
        else{
        ListNode prev=null,curr=null;
        for(curr=head;co<l;co++,curr=curr.next){
             prev=curr;
        }
        prev.next=curr.next;

        return head;
        }
    }
}

5.Merge Two Sorted Lists


class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;
        ListNode resHead=null;
        ListNode rescur;
        if(list1.val<list2.val){
            resHead=list1;
            list1=list1.next;
        }
        else{
            resHead=list2;
            list2=list2.next;
        }
        rescur=resHead;
        while(list1!=null && list2!=null){
            if(list1.val<list2.val){
                rescur.next=list1;
                rescur=list1;
                list1=list1.next;
                
            }
            else{
                rescur.next=list2;
                rescur=list2;
                list2=list2.next;
                
            }
            
        }
        if(list1!=null) rescur.next=list1;
        if(list2!=null) rescur.next=list2;
        return resHead;
        
    }
}

6.Find First and Last Position of Element in Sorted Array

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l=nums.length;
        int[] a={-1,-1};
        //String s=new String();
        int b=0,c=0;
        for(int i=0;i<l;i++){
            if(nums[i]==target){
                a[0]=i;
                for(int j=i+1;j<l;j++){
                    if(nums[j]==target){
                        c++;
                    }
                }
                break;
        }
    }
    a[1]=a[0]+c;
    return a;
    }
}

7. Maximum Depth of Binary Tree

class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 1;
        int l=maxDepth(root.left);
        int r=maxDepth(root.right);
        if(l>r) return l+1;
        else return r+1;
    }
}

8. Reverse String
 
class Solution {
    public void reverseString(char[] s) {
        int n=s.length;
        int l=0;
        int r=n-1;
        while(l<r){
            char tem=s[l];
            s[l]=s[r];
            s[r]=tem;
            l++;
            r--;
        }
    }
}

9. Delete the Middle Node of a Linked List

class Solution {
    public int len(ListNode head){
        int c=0;
        ListNode cur;
        for(cur=head;cur!=null;c++,cur=cur.next);
        return c;
    }
    public ListNode deleteMiddle(ListNode head) {
        int l=len(head);
        int mid=l/2;
        ListNode cur=head,prev=null;
        int co=0;
        while(co<mid){
            co++;
            prev=cur;
            cur=cur.next;
        }
        if(prev== null) return null;
        prev.next=cur.next;   
        
       
        return head;
        
    
}
}

10. Design Linked List

class Node {
    int val;
    Node next;
    Node(int value) {
        val = value;
    }
}

class MyLinkedList {
    Node head;
    int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    public int get(int index) {
        Node cur;
        if (index < 0 || index >= size) { // fixed >=
            return -1;
        }
        int c = 0;
        for (cur = head; c != index && cur != null; cur = cur.next, c++);
        return cur.val;
    }

    public void addAtHead(int val) {
        Node nn = new Node(val);
        nn.next = head;
        head = nn;
        size++;
        System.out.print(size);
    }

    public void addAtTail(int val) {
        if (head == null) {
            addAtHead(val); // size increment done in addAtHead
            return;
        }
        Node tem;
        for (tem = head; tem.next != null; tem = tem.next);
        Node nn = new Node(val);
        tem.next = nn;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) { // allow index == size
            return;
        }
        if (index == 0) {
            addAtHead(val);
            return;
        }
        Node nn = new Node(val);
        int c = 0;
        Node prev = null;
        Node tem = null;
        for (Node cur = head; c < index; cur = cur.next) {
            prev = cur;
            tem = cur.next;
            c++;
        }
        nn.next = tem;
        prev.next = nn;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) { // fixed boundary check
            return;
        }

        if (index == 0) { // fixed: allow deleting head
            head = head.next;
            size--; // decrement size for head deletion
            System.out.print(size);
            return;
        }

        Node prev = null;
        Node tem = null;
        int c = 0;
        for (Node cur = head; c < index; cur = cur.next) {
            prev = cur;
            tem = cur.next;
            c++;
        }
        prev.next = tem.next;
        size--;
        System.out.print(size);
    }
}


