import java.util.ArrayList;
import java.util.List;


public class DFS {
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};

    public static void solve(int[][] maze, int i, int j, List<int[]> path, List<List<int[]>> allPath, int[][] v)
    {      
        if (i>=maze.length || j>=maze[0].length || i<0 || j<0) return;
        if (maze[i][j] == 1 || v[i][j] == 1) return;

        if (maze[i][j] == 9){
            path.add(new int[]{i, j});
            List<int[]> l = new ArrayList<int[]>(path);            
            allPath.add(l);
            path.remove(path.size()-1);
            return;
        }  

        if (maze[i][j] == 0){
            path.add(new int[]{i, j});
            v[i][j] = 1;            
        }

        solve(maze, i, j+1, path, allPath, v);
        solve(maze, i, j-1, path, allPath, v);
        solve(maze, i+1, j, path, allPath, v);
        solve(maze, i-1, j, path, allPath, v);

        if (path.size() > 0){
            path.remove(path.size()-1);
            v[i][j] = 0;
        }
    }

    public static List<List<int[]>> searchPath(int[][] maze)
    {	
        int[][] visited = new int[maze.length][maze[0].length-1];
        List<List<int[]>> allPath = new ArrayList<>();    
            
        List<int[]> path = new ArrayList<>();

        solve(maze, 1, 1, path, allPath, visited);
        return allPath;
    }
}
