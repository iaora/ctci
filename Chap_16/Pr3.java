/*
 * Intersection: Given two straight line segments (represented as a start point and an end
 * point), compute the point of intersection, if any.
 */

public class Pr3{
    public static void main(String[] args){
        Line l1 = new Line(1,1, 3,4);
        Line l2 = new Line(0,0 6,7);
    }
}

public class Line{
    int x1;
    int x2;
    int y1;
    int y2;
    double slope;

    public Line(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        slope = 0;
    }
}
