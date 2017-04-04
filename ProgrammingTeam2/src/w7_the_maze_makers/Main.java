
package w7_the_maze_makers;


import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;

// For the judge, this must be package-private.
class Main {
    
    // The Maze Markers - 6817
    // Time to solve: 240 minutes
    // Debug time: 0 minutes
    
    static class Point {
        int x, y, value;
        public Point(int x, int y, int value) {this.x = x; this.y = y; this.value = value;}
        public boolean openLeft() { return value % 2 == 0; }
        public boolean openRight() { return (value > -1 && value < 4) || (value > 7 && value < 12); }
        public boolean openTop() { return value > -1 && value < 8; }
        public boolean openBottom() { return value % 4 == 0 || value % 4 == 1; }
        @Override
        public String toString() {
            return "(" + x + ","+ y + ","+value+")";
        }
        @Override
        public boolean equals(Object a) {
            Point b = (Point) a;
            return b.x == this.x && b.y == this.y;
        }
        @Override
        public int hashCode() {
            int hash = 3;
            hash = 47 * hash + this.x;
            hash = 47 * hash + this.y;
            return hash;
        }
    }
    
    static class Edge {
        Point a, b;
        public Edge(Point a, Point b) { this.a = a; this.b = b; }
        @Override
        public String toString() {
            return "[(" + a.x + ","+ a.y + ","+a.value+")" + "(" + b.x + ","+ b.y + ","+b.value+")]";
        }
        @Override
        public boolean equals(Object a) {
            Edge b = (Edge) a;
            return (b.a.equals(this.a) && b.b.equals(this.b)) ||
                    (b.a.equals(this.b) && b.b.equals(this.a));
        }
        @Override
        public int hashCode() {
            int hash = 5;
            hash = 71 * hash + Objects.hashCode(this.a);
            hash = 71 * hash + Objects.hashCode(this.b);
            return hash;
        }
    }
        
    static class Grid {
        Point[][] points;
        Point start, end;
        public Grid(char[][] in) {
            points = new Point[in.length][in[0].length];
            for(int i = 0; i < in.length; i++) {
                for(int j = 0; j < in[i].length; j++) {
                    int value = convertCharToInt(in[i][j]);
                    points[i][j] = new Point(i,j,value);
                    if(i == 0 && points[i][j].openTop()) {
                        if(start == null) 
                            start = points[i][j];
                        else 
                            end = points[i][j];
                    } else if(i == in.length-1 && points[i][j].openBottom()) {
                        if(start == null) 
                            start = points[i][j];
                        else 
                            end = points[i][j];
                    }
                } 
                if(points[i][0].openLeft()) {
                    if(start == null)
                        start = points[i][0];
                    else
                        end = points[i][0];
                }
                if(points[i][in[i].length-1].openRight()) {
                    if(start == null)
                        start = points[i][in[i].length-1];
                    else
                        end = points[i][in[i].length-1];
                }  
            }
        }
        private int convertCharToInt(char c) {
            switch (c) {
                case 'A': return 10;
                case 'B': return 11;
                case 'C': return 12; 
                case 'D': return 13; 
                case 'E': return 14;  
                case 'F': return 15;  
                default: return Integer.parseInt(c+"");
            }
        }
        public ArrayList<Point> adj(Point p) {    
            ArrayList<Point> a = new ArrayList();
            if(p.openTop() && p.x > 0) a.add(points[p.x-1][p.y]);
            if(p.openBottom() && p.x < points.length-1) { a.add(points[p.x+1][p.y]); }
            if(p.openLeft() && p.y > 0) a.add(points[p.x][p.y-1]);
            if(p.openRight() && p.y < points[0].length-1) a.add(points[p.x][p.y+1]);  
            return a;     
        }
    }
    
    static class DFT {
        Grid g;
        ArrayList<Point> markedPoints;
        ArrayList<Edge> markedEdges;
        boolean cycle = false;
        public DFT(Grid g) { this.g = g; markedPoints = new ArrayList(); markedEdges = new ArrayList(); }
        public void dft(Point p) {
            Stack<Point> s = new Stack();
            s.add(p);
            while(!s.isEmpty()) {
                Point t = s.pop();
                markedPoints.add(t);
                for(Point a : g.adj(t)) {
                    Edge e1 = new Edge(t, a);
                    Edge e2 = new Edge(a, t);
                    if(!markedPoints.contains(a)) {
                        markedEdges.add(e1);
                        markedEdges.add(e2);
                        dft(a);
                    } else if (!markedEdges.contains(e1)){
                        cycle = true;
                    }
                }
            }  
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            int height = sc.nextInt();
            int width = sc.nextInt();
            if (height == 0 && width == 0) return;
            char[][] grid = new char[height][width];
            for(int h = 0; h < height; h++) {
                grid[h] = sc.next().toCharArray();       
            }
            Grid pointGrid = new Grid(grid);
            DFT dft = new DFT(pointGrid);
            dft.dft(pointGrid.start);
            if(!dft.markedPoints.contains(pointGrid.end)) {
                System.out.println("NO SOLUTION");
            } else if ((height*width) != dft.markedPoints.size()) {
                System.out.println("UNREACHABLE CELL");
            } else if(dft.cycle) {
                System.out.println("MULTIPLE PATHS");
            } else {
                System.out.println("MAZE OK");
            }
        }  
    } 
}