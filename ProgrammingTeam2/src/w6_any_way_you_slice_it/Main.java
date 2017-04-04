
package w6_any_way_you_slice_it;

import java.util.ArrayList;
import java.util.Scanner;

// For the judge, this must be package-private.
class Main {
    
    // Any Way You Slice It - 6096
    // Time to solve: 150 minutes
    // Debug time: 30 minutes
    
    static class Point {
        double x, y;
        public Point(double x, double y) { this.x = x; this.y = y; }
    }
    
    static class Line {
        Point a, b;
        public Line(Point a, Point b) { this.a = a; this.b = b; }
        public boolean intersects(Line l) {
            double r1 = ((this.a.x-l.a.x)*(l.b.y-l.a.y)-(this.a.y-l.a.y)*(l.b.x-l.a.x))*((this.b.x-l.a.x)*(l.b.y-l.a.y)-(this.b.y-l.a.y)*(l.b.x-l.a.x));
            double r2 = ((l.a.x-this.a.x)*(this.b.y-this.a.y)-(l.a.y-this.a.y)*(this.b.x-this.a.x))*((l.b.x-this.a.x)*(this.b.y-this.a.y)-(l.b.y-this.a.y)*(this.b.x-this.a.x));
            return r1 < 0 && r2 < 0;
        }
    }
    
    public static boolean anyIntersect(ArrayList<Line> processed, Line newLine) {
        for(Line l: processed)
            if(l.intersects(newLine))
                return true;
        return false;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            int n = sc.nextInt();
            if(n == 0) return;
            ArrayList<Line> processed = new ArrayList();
            int currentDegree = 90;
            Point lastPoint = new Point(0,0);
            boolean intersect = false;  
            int i;
            for(i = 0; i < n; i++) {
                int rotateDegree = sc.nextInt();
                int step = sc.nextInt();
                double x = lastPoint.x+(step*Math.cos(Math.toRadians(currentDegree+rotateDegree)));
                double y = lastPoint.y+(step*Math.sin(Math.toRadians(currentDegree+rotateDegree)));
                currentDegree += rotateDegree;
                Point newPoint = new Point(x, y);
                Line line = new Line(lastPoint, newPoint);
                if(anyIntersect(processed, line)) {
                    intersect = true;
                    for(int j = i+1; j < n; j++) { sc.nextInt(); sc.nextInt();}
                    break;
                }
                processed.add(line);
                lastPoint = newPoint;
            }
            System.out.println((intersect) ? i+1 : "SAFE");
        }
    }
}

