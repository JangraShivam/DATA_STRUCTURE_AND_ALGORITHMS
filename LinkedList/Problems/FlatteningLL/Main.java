// Problem : flattening a Linked List (GFG)

class Node {
    public int data;
    public Node next;
    public Node bottom;

    Node(int data)
    {
        this.data = data;
        this.next = null;
        this.bottom = null;
    }
}


class Solution {
    Node merge(Node list1, Node list2){
        // base case
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        if(list1.data <= list2.data){
            list1.bottom = merge(list1.bottom,list2);
            return list1;
        }
        else{
            list2.bottom = merge(list1,list2.bottom);
            return list2;
        }
    }
    public Node flatten(Node root) {
        if(root == null) return root;

        return merge(root,flatten(root.next));
    }
}