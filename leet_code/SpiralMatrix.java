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

// ---------------------------------------------------------- My over the top solution that still doesn't work when there's 1 line left
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> check = checkEdgeCases(matrix);
        if(!check.isEmpty() || matrix.length == 0) 
            return check;
        
        Edge top = new Edge(0, matrix[0].length-2, 0, "top");
        Edge right = new Edge(0, matrix.length-2, matrix[0].length-1, "right");
        Edge bot = new Edge(matrix[0].length-1, 1, matrix.length-1, "bot");
        Edge left = new Edge(matrix.length-1, 1, 0, "left");
        
        List<Integer> l = new ArrayList<Integer>();
        int numIter = Math.min(matrix.length-1, matrix[0].length-1);
        
        for(int i = 0; i < numIter; i++){
            l.addAll(top.getSubArr(matrix));
            l.addAll(right.getSubArr(matrix));
            // if 3xn
            if(matrix.length == 3 && i == 1)
            l.addAll(bot.getSubArr(matrix));
            // if nx3
            l.addAll(left.getSubArr(matrix));
        }
        
        if(matrix.length == matrix[0].length && matrix[0].length%2 == 1 )
            l.add(matrix[matrix.length/2][matrix.length/2]);
        
        return l;
    }
    
    private List<Integer> checkEdgeCases(int[][] matrix){
        List<Integer> l = new ArrayList<Integer>(); 
        if(matrix.length == 0)       // []
            return l;
        
        if(matrix[0].length == 1){                          // vertical 1xn
            for(int i = 0; i < matrix.length; i++)
                l.add(matrix[i][0]);
            return l;
        }
        if(matrix.length == 1 || matrix.length == 2){       //[1,2,3,4]
            for(int i = 0; i < matrix[0].length; i++)
                l.add(matrix[0][i]);
        }if(matrix.length == 2){                            // [1,2],[3,4]
            for(int i = matrix[0].length-1; i >= 0; i--)
                l.add(matrix[1][i]);
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
        while(  (i >= end && (side.equals("bot") || side.equals("left"))) ||  (i <= end && (side.equals("top") || side.equals("right")))  ) {
            if(side.equals("top") || side.equals("bot"))
                l.add(matrix[rowOrColIndex][i]);
            else
                l.add(matrix[i][rowOrColIndex]);
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
// ---------------------------------------- ONLINE SOLUTION ---------------------------------
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
 
        if(matrix == null || matrix.length == 0) return result;
 
        int m = matrix.length;
        int n = matrix[0].length;
 
        int x=0; 
        int y=0;
 
        while(m>0 && n>0){
 
            //if one row/column left, no circle can be formed
            if(m==1){
                for(int i=0; i<n; i++){
                    result.add(matrix[x][y++]);
                }
                break;
            }else if(n==1){
                for(int i=0; i<m; i++){
                    result.add(matrix[x++][y]);
                }
                break;
            }
 
            //below, process a circle
 
            //top - move right
            for(int i=0;i<n-1;i++){
                result.add(matrix[x][y++]);
            }
 
            //right - move down
            for(int i=0;i<m-1;i++){
                result.add(matrix[x++][y]);
            }
 
            //bottom - move left
            for(int i=0;i<n-1;i++){
                result.add(matrix[x][y--]);
            }
 
            //left - move up
            for(int i=0;i<m-1;i++){
                result.add(matrix[x--][y]);
            }
 
            x++;
            y++;
            m=m-2;
            n=n-2;
        }
 
        return result;
    }
}
