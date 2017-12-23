/*
 * Intersection: Given two straight line segments (represented as a start point and an end
 * point), compute the point of intersection, if any.
 */

public class Pr3{
    public static void main(String[] args){
        Pr3 pr = new Pr3();
        Pr3.Line l1 = pr.new Line(1,1, 3,4);
        Pr3.Line l2 = pr.new Line(0,0, 6,7);

        if(l1.slope == l2.slope){
            if(l1.yInter == l2.yInter)
                System.out.println("None intersecting points");
            else
                System.out.println("All points are intersecting");
        }

        System.out.println(l1.slope + ", " +  l1.yInter);
        System.out.println(l2.slope + ", " +  l2.yInter);

        System.out.println("Intersecting point at " + computeIntersect(l1, l2));
    }

    private static String computeIntersect(Pr3.Line l1, Pr3.Line l2){
        double x = (l1.yInter - l2.yInter) / (l2.slope - l1.slope);
        double y = l1.slope * x + l1.yInter;

        return "(" + x + "," + y + ")";
    }

    class Line{
        int x1;
        int x2;
        int y1;
        int y2;
        double slope;
        double yInter;

        private Line(int x1, int y1, int x2, int y2){
            this.x1 = x1;
            this.x2 = x2;
            this.y1 = y1;
            this.y2 = y2;
            slope = (y2-y1)/(double)(x2-x1);
            yInter = y1 + slope*x1;
        }
    }
}
