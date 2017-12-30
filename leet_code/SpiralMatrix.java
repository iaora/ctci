/*
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

    For example,
    Given the following matrix:
        [
            [ 1, 2, 3 ],
            [ 4, 5, 6 ],
            [ 7, 8, 9 ]
        ]

    You should return [1,2,3,6,9,8,7,4,5].
 */

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        Edge top = new Edge(0, matrix[0].length-2, 0, "top");
        Edge right = new Edge(0, matrix.length-2, matrix[0].length-1, "right");
        Edge bot = new Edge(matrix[0].length-1, 1, matrix.length-1, "bot");
        Edge left = new Edge(matrix.length-1, 1, 0, "left");
        
        List<Integer> l = new ArrayList<Integer>();
        
        for(int i = 0; i < matrix.length-1; i++){
            l.addAll(top.getSubArr(matrix));
            l.addAll(right.getSubArr(matrix));
            l.addAll(bot.getSubArr(matrix));
            l.addAll(left.getSubArr(matrix));
        }
        return l;
    }
}
class Edge{
    int start;
    int end;
    int rowOrColIndex;
    String side;

    public Edge(int start, int end, int rowOrColIndex, String side){
        this.start = start;
        this.end = end;
        this.rowOrColIndex = rowOrColIndex;
        this.side = side;
    }

    public List<Integer> getSubArr(int[][] matrix){
        List<Integer> l = new ArrayList<Integer>();
        int i = start;

        // THIS IS SO UGLY
        while(  (i >= end && (side.equals("bot") || side.equals("left"))) ||
                (i <= end && (side.equals("top") || side.equals("right")))  ) {
            if(side.equals("top") || side.equals("bot"))
                l.add(matrix[rowOrColIndex][i]);
            else
                l.add(matrix[i][rowOrColIndex]);
            System.out.println(matrix[rowOrColIndex][i]);
            i = (side.equals("bot") || side.equals("left")) ? i-1 : i+1;
        }
        if(side.equals("bot") || side.equals("left")){
            start--;
            end++;
        }else{
            start++;
            end--;
        }
        rowOrColIndex = side.equals("top") || side.equals("left") ? rowOrColIndex+1 : rowOrColIndex-1;
        return l;
    }
}
