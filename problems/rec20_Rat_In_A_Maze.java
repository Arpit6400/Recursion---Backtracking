import java.util.*;

public class rec20_Rat_In_A_Maze {
    public ArrayList<String> ratInMaze(int[][] maze) {
        if (maze[0][0] == 0 || maze[maze.length - 1][maze[0].length - 1]==0) {
            return new ArrayList<>();
        }
        ArrayList<String> ans= new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int[][] dir = { {0, -1, 'L'}, {0, 1, 'R'}, {-1, 0, 'U'}, {1, 0, 'D'}};
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        solveMaze(maze, visited, dir, 0, 0, sb, ans);
        Collections.sort(ans);
        return ans;
    }
    private void solveMaze(int[][] maze, boolean[][] visited, int[][] dir, int row, int col, StringBuilder sb,
            ArrayList<String> ans) {
        if(row == maze.length - 1 && col == maze[0].length - 1){
            ans.add(sb.toString());
            return;
        }
        visited[row][col] = true;
        for (int dirs[] : dir) {
            int nextRowDir =row + dirs[0];
            int nextColDir = col + dirs[1];
            if(nextRowDir < maze.length && nextRowDir >= 0 && nextColDir < maze[0].length && nextColDir >=0 && maze[nextRowDir][nextColDir]==1 && visited[nextRowDir][nextColDir]== false){
                // System.out.println("(" + nextRowDir + ", " + nextColDir + ")");
                sb.append((char)dirs[2]);
                solveMaze(maze, visited, dir, nextRowDir, nextColDir, sb, ans);
                sb.deleteCharAt(sb.length() -1);
            }
        }
        visited[row][col] = false;
    }
    public static void main(String[] args) {
        int[][] maze = {{1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1}};
        rec20_Rat_In_A_Maze rec20_Rat_In_A_Maze = new rec20_Rat_In_A_Maze();
        ArrayList<String> ans = rec20_Rat_In_A_Maze.ratInMaze(maze);
        for (String string : ans) {
            System.out.println(string);
        }
    }
}
