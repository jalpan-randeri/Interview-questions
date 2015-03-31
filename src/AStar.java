import java.util.*;

/**
 * Created by jalpanranderi on 12/10/14.
 */
public class AStar {

    private static final int COST_MOVE = 1;
    private static final int COST_MOVE_DIAGONAL = 1000000;



    public static void main(String[] args) {



        start();
    }



    private static  void start(){


        String[] map = {
                "    W    ",
                "    A    ",
                "S   W   E",
                "    A    ",
                "    W    ",
        };

        Node[][] state = new Node[map.length][map[0].length()];
        Node start = null, end = null;

        for(int row = 0; row < map.length; row++){
            for(int col = 0; col < map[0].length(); col++){
                state[row][col] = new Node(col, row);
                if(map[row].charAt(col) == 'W'){
                    state[row][col].isBlock = true;
                }else if(map[row].charAt(col) == 'S'){
                    start = state[row][col];
                    state[row][col].cost = 0;
                }else if(map[row].charAt(col) == 'E'){
                    end = state[row][col];
                }

                System.out.print(state[row][col]);
            }
            System.out.println();
        }



        if(start != null && end != null){
            List<Node> path = findPath(start, end, state);
            for(Node n : path){
                printNode(n);
            }
        }else{
            System.out.println("Invalid MAP");
        }
    }

    private static int pathScore(Node dest, int x, int y, int cost, int new_x, int new_y){
        int g = cost + getCost(x - new_x, y - new_y);
        int h = Math.abs(dest.x - x) + Math.abs(dest.y - y);

        return g + h;
    }

    private static int getCost(int diff_x, int diff_y) {
        return (Math.abs(diff_x) == 1 && Math.abs(diff_y) == 1) ? COST_MOVE_DIAGONAL : COST_MOVE;
    }


    private static void generateAdjacentNodes(Node[][] maze, PriorityQueue<Node> open, List<Node> close, Node current, Node dest){
        ArrayList<Node> neighbours = new ArrayList<>();
        int x = current.x;
        int y = current.y;


        int start_y = Math.max(0, y - 1);
        int end_y = Math.min(maze.length - 1, y + 1);

        int start_x = Math.max(0, x - 1);
        int end_x = Math.min(maze[0].length - 1, x + 1);


        for(int i = start_y; i <= end_y; i++){
            for (int j = start_x; j <= end_x; j++){

                Node n = new Node(j, i, pathScore(dest, x, y, maze[y][x].cost, j, i));
                neighbours.add(n);

            }
        }


        filterList(neighbours, open, close, maze, current);
    }

    private static void filterList(ArrayList<Node> neighbours, PriorityQueue<Node> open, List<Node> close, Node[][] maze, Node current) {
        for(Node neighbour : neighbours){
            // check for block
            int x = neighbour.x;
            int y = neighbour.y;
            if(isBlock(x, y, maze)){
                continue;
            }

            // check for already visited
            if(close.contains(neighbour)){
                continue;
            }

            // check for already in open then update cost
            if(!open.contains(neighbour)){
                neighbour.parent =  current;
                open.add(neighbour);
                maze[neighbour.y][neighbour.x].cost = neighbour.cost;
                maze[neighbour.y][neighbour.x].parent = maze[current.y][current.x];
            }else if(maze[neighbour.y][neighbour.x].cost > neighbour.cost){
                neighbour.parent = current;
                maze[neighbour.y][neighbour.x] = neighbour;
            }


        }
    }

    private static boolean isBlock(int x, int y, Node[][] maze) {
        assert (x >= 0 && x < maze[0].length);
        assert (y >= 0 && y < maze.length);

        return maze[y][x].isBlock;
    }


    public static List<Node> findPath(Node start, Node end, Node[][] maze){

        PriorityQueue<Node> openList = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node lhs, Node rhs) {
                return lhs.cost - rhs.cost;
            }
        });

        System.out.print("Start ");
        printNode(start);
        System.out.print("End ");
        printNode(end);
        System.out.println();

        List<Node> closeList = new ArrayList<>();



        openList.add(start);


        while(!openList.isEmpty()){
            Node step = openList.remove();

            if(step.equals(end)){
                // TODO: generate path
                closeList.add(step);
                System.out.println("Reached");
                return generatePath(step);
            }
            closeList.add(step);

            generateAdjacentNodes(maze, openList, closeList, step, end);




        }

        System.out.println("Path not found");
        return new ArrayList<Node>();
    }

    private static List<Node> generatePath(Node n) {
        Node prev = n;
        List<Node> path = new ArrayList<>();
        while(prev != null){
            path.add(prev);
            prev = prev.parent;
        }

        return path;
    }



    private static void printNode(Node n){
        System.out.printf("{%2d, %2d :: %3d } \n",n.y, n.x, n.cost);
    }

    private static class Node{
        int cost;
        int x;
        int y;
        boolean isBlock  = false;
        Node parent;


        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Node(int x, int y, int cost) {
            this.cost = cost;
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;

            Node node = (Node) o;

            if (x != node.x) return false;
            if (y != node.y) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }

        @Override
        public String toString() {
            return isBlock ? "B" : "_";
        }
    }



}
