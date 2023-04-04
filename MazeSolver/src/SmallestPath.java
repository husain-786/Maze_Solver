import java.util.ArrayList;
import java.util.List;

public class SmallestPath {
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};

    public static void solve(int[][] maze, int i, int j, List<int[]> path, int[][] v, List<List<int[]>> smallestPath)
    {      
        if (i>=maze.length || j>=maze[0].length || i<0 || j<0) return;
        if (maze[i][j] == 1 || v[i][j] == 1) return;

        if (maze[i][j] == 9){
            path.add(new int[]{i, j});
            if (smallestPath.size() == 0){
                smallestPath.add(new ArrayList<>(path));             
            }
            if (smallestPath.get(0).size() > path.size()){
                smallestPath.remove(0);
                smallestPath.add(new ArrayList<>(path));             
            }            

            // System.out.println("Smallest Path");
            // for (int[] x: smallestPath) {
            //     System.out.print("(" + x[0] + ", " + x[1] + "), ");
            // }
            // System.out.println();

            path.remove(path.size()-1);
            return;
        }  

        if (maze[i][j] == 0){
            path.add(new int[]{i, j});
            v[i][j] = 1;            
        }

        solve(maze, i, j+1, path, v, smallestPath);
        solve(maze, i, j-1, path, v, smallestPath);
        solve(maze, i+1, j, path, v, smallestPath);
        solve(maze, i-1, j, path, v, smallestPath);

        if (path.size() > 0){
            path.remove(path.size()-1);
            v[i][j] = 0;
        }
    }

    public static List<List<int[]>> findSmallest(int[][] maze)
    {
        int[][] visited = new int[maze.length][maze[0].length-1];
        List<List<int[]>> smallestPath = new ArrayList<>();
        List<int[]> path = new ArrayList<>();

        solve(maze, 1, 1, path, visited, smallestPath);
        System.out.println(smallestPath.size());      

        return smallestPath;
    }
}
