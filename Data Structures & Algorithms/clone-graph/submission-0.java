/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Node,Node> visited = new HashMap<Node,Node>();
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Node clonedNode = new Node(node.val);
        visited.put(node, clonedNode);
        for(Node n: node.neighbors){
            if(!visited.containsKey(n)){
                clonedNode.neighbors.add(cloneGraph(n));
            }
            else{
                clonedNode.neighbors.add(visited.get(n));
            }
        }
        return clonedNode;
    }
}