/*

Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), return the maximum enemies you can kill using one bomb.
The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the wall is too strong to be destroyed.
Note that you can only put the bomb at an empty cell.

Example:
For the given grid

0 E 0 0
E 0 W E
0 E 0 0

return 3. (Placing a bomb at (1,1) kills 3 enemies)

*/

class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if(grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        
        int max = 0;
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int k = 0; k < grid[i].length; k++){
                if(grid[i][k] == '0')
                    count = maxKills(grid, i, k);
                if(count > max)
                    max = count;
            }
        }
        return max;
        
    }
    
    private int maxKills(char[][] grid, int row, int col){
        //left-right
        int count = countKillsHorz(grid, row, col);
        //up-down
        count += countKillsVert(grid, row, col);
        return count;
    }
    
    private int countKillsHorz(char[][] grid, int row, int col){
        int count = 0;
        
        // left
        for(int i = col; i >= 0; i--){
            if(grid[row][i] == 'W') break;
            if(grid[row][i] == 'E')
                count++;
        }
        //right
        for(int i = col; i < grid[row].length; i++){
            if(grid[row][i] == 'W') break;
            if(grid[row][i] == 'E')
                count++;
        }
        
        return count;
    }
    
    private int countKillsVert(char[][] grid, int row, int col){
        int count = 0;
        // up
        for(int i = row; i >= 0; i--){
            if(grid[i][col] == 'W') break;
            if(grid[i][col] == 'E')
                count++;
        }
        // down
        for(int i = row; i < grid.length; i++){
            if(grid[i][col] == 'W') break;
            if(grid[i][col] == 'E')
                count++;
        }
        return count;
    }
}
