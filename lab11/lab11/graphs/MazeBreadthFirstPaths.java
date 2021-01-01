package lab11.graphs;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 *  @author Josh Hug
 */
public class MazeBreadthFirstPaths extends MazeExplorer {
    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */
    private int s;
    private int t;
    private boolean targetFound = false;
    private Maze maze;
    private Queue<Integer> fringe;

    public MazeBreadthFirstPaths(Maze m, int sourceX, int sourceY, int targetX, int targetY) {
        super(m);
        maze = m;
        s = m.xyTo1D(sourceX,sourceY);
        t = m.xyTo1D(targetX,targetY);
        fringe = new ArrayDeque<>();
        fringe.offer(s);
        distTo[s] = 0;
        edgeTo[s] = s;
        marked[s] = true;
        // Add more variables here!
    }

    /** Conducts a breadth first search of the maze starting at the source. */
    private void bfs() {
        // TODO: Your code here. Don't forget to update distTo, edgeTo, and marked, as well as call announce()
        // mark first then loop.
        while(!fringe.peek().equals(null)){
            int x = fringe.poll();
            announce();
            if (x == t){
                targetFound = true;
            }
            if (targetFound){
                return;
            }
            for (int w: maze.adj(x)){
                if(!marked[w]){
                    marked[w] = true;
                    fringe.add(w);
                    edgeTo[w] = x;
                    announce();
                    distTo[w] = distTo[x] + 1;
                }
            }
        }
    }


    @Override
    public void solve() {
         bfs();
    }
}

