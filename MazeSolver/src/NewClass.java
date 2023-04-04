import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class NewClass extends JFrame {
    static public List<List<int[]>> allPath = new ArrayList<>();
    int row, col;
    static public List<List<int[]>> smallestPath = new ArrayList<>();
    int[][] maze = {
        {1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,0,1,0,1,0,1,0,0,0,0,0,1},            
        {1,0,1,0,0,0,1,0,1,1,1,0,1},    
        {1,0,1,1,1,1,1,0,0,0,0,0,1},   
        {1,0,0,1,0,0,0,0,1,1,1,0,1},   
        {1,0,1,0,1,1,1,0,1,0,0,0,1},    
        {1,0,1,0,1,0,0,0,1,1,1,0,1},    
        {1,0,1,0,1,1,1,0,1,0,1,0,1},    
        {1,0,0,0,0,0,0,0,0,0,1,9,1},        
        {1,1,1,1,1,1,1,1,1,1,1,1,1}
    };  

    public NewClass(){
        setTitle("Maze Solver");
        setSize(800, 800);
        setLocation(100, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.allPath = DFS.searchPath(maze);
        this.smallestPath = SmallestPath.findSmallest(maze);
    }

    public void paint(Graphics g)
    {
        for (int i=0; i<maze.length; i++){
            for (int j=0; j<maze[0].length; j++){
                // Color is a class present in the java.awt.Color..., creating an object of it...
                // using this I can get any color....
                Color color;
                // I am filling the maze with different colors,... if grid cell is 1 then it's
                // an obstacle and fill it with black clor, if grid cell is 0 then I can move through it
                // and fill it with white color... and if grid cell is 9 then it's the destination and 
                // fill it with red color.....
                switch(maze[i][j]){
                    case 1: color = Color.BLACK; break;
                    case 9: color = Color.RED; break;
                    default: color = Color.LIGHT_GRAY; break;
                }
                // g is an object of class graphics, we can made any shape and can fill with any color...
                g.setColor(color);
                // g.fillRectangle():- will create a ractangular cell of size 50x50 at position [i,j]
                // and fill it with the current color stored in the color object........
                g.fillRect(50*(j+1), 50*(i+3), 50, 50);

                // These two statements creates a red border for each cell.....
                g.setColor(Color.RED);
                g.drawRect(50*(j+1), 50*(i+3), 50, 50);
            }
        }

        // displaying each path....
        for (List<int[]> l: allPath){    
            for (int[] grid: l)
            {
                int y = grid[1];
                int x = grid[0];
                // System.out.println(x + " " + y);
                g.setColor(Color.GREEN);
                // g.fillRect(50*(y+1), 50*(x+3), 40, 40);
                g.fillRect(50*(y+1), 50*(x+3), 50, 50);              
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            for (int[] grid: l)
            {
                int y = grid[1];
                int x = grid[0];
                // System.out.println(x + " " + y);
                g.setColor(Color.LIGHT_GRAY);
                // g.fillRect(50*(y+1), 50*(x+3), 40, 40);
                g.fillRect(50*(y+1), 50*(x+3), 50, 50);
                g.setColor(Color.RED);
                g.drawRect(50*(y+1), 50*(x+3), 50, 50);                  
            }    
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }   
        }

        // smallest path...       
        for (int[] grid: smallestPath.get(0))
        {
            int y = grid[1];
            int x = grid[0];
            g.setColor(Color.BLUE);
            g.fillRect(50*(y+1), 50*(x+3), 50, 50);
        } 
    }

    public static void main(String[] args)
    {
        NewClass frame = new NewClass();
        frame.setVisible(true);      
    }
}
