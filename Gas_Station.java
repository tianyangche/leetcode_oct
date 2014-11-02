public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalRemain = 0;
        int currRemain = 0;
        int index = 0;
        
        for (int i = 0; i < n; i++) {
            currRemain += gas[i] - cost[i];
            totalRemain += gas[i] - cost[i];
            if (currRemain < 0) {
                currRemain = 0;
                index = i + 1;
            }
        }
        
        if (totalRemain >= 0) {
            return index;
        } else {
            return -1;
        }
        
    }
}