/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null)
            return node;
        UndirectedGraphNode result = new UndirectedGraphNode(node.label);
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.add(node);
        HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
        map.put(node.label, result);
        while(!queue.isEmpty()){
            UndirectedGraphNode currNode = queue.poll();
            UndirectedGraphNode newResult = map.get(currNode.label);
            for(int i = 0; i < currNode.neighbors.size(); i ++){
                UndirectedGraphNode tempNode = null;
                if(map.containsKey(currNode.neighbors.get(i).label))
                    tempNode = map.get(currNode.neighbors.get(i).label);
                else{
                    tempNode = new UndirectedGraphNode(currNode.neighbors.get(i).label);
                    map.put(tempNode.label, tempNode);
                    queue.offer(currNode.neighbors.get(i));
                }
                newResult.neighbors.add(tempNode);
            }
        }
        return map.get(node.label);
    }
}