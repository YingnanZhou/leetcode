/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        //use a map, put a copy of every node in the map,key is the node, value is the copy
        //so we can easily connect the copy nodes using the key: the relations between copy nodes are exactly the same as them between keys
        Map<Node, Node> map = new HashMap<>();
        Node p = head;
        while(p != null) {
            map.put(p, new Node(p.val));
            p = p.next;
        }
        p = head;
        while(p != null) {
            map.get(p).next = map.get(p.next);
            map.get(p).random = map.get(p.random);
            p = p.next;
        }
        return map.get(head);
    }
}