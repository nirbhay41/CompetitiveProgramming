package com.RocketScience.DSA.Array_ADT;

//https://www.geeksforgeeks.org/optimum-location-point-minimize-total-distance
public class Optimum_Location_Of_A_Point_To_Min_Total_Dist {
    static double sqr(double x){
        return x*x;
    }
    static int EPS = 1;
    static int N = 5; // no of points

    static class Point{
        int x,y;
        public Point(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    static class Line{
        int a,b,c;
        public Line(int a,int b,int c){
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    static double dist(double x,double y,Point p){
        return Math.sqrt(sqr(x-p.x) + sqr(y-p.y));
    }

    static double compute(Point p[], int n, Line l, double X) {
        double res = 0;

        // calculating Y of choosen point by line equation
        double Y = -1 * (l.c + l.a * X) / l.b;
        for (int i = 0; i < n; i++)
            res += dist(X, Y, p[i]);

        return res;
    }

    static double findOptimumCostUtil(Point[] p, int n, Line l) {
        double low = -1e6;
        double high = 1e6;

        // loop untill difference between low and high become less than EPS
        while ((high - low) > EPS)
        {
            // mid1 and mid2 are representative x co-ordiantes
            // of search space
            double mid1 = low + (high - low) / 3;
            double mid2 = high - (high - low) / 3;

            double dist1 = compute(p, n, l, mid1);
            double dist2 = compute(p, n, l, mid2);

            if (dist1 < dist2) // if mid2 point gives more total distance,skip third part
                high = mid2;
            else                // if mid1 point gives more total distance, skip first part
                low = mid1;
        }

        // compute optimum distance cost by sending average
        // of low and high as X
        return compute(p, n, l, (low + high) / 2);
    }

    static double findOptimumCost(int[][] points, Line l) {
        Point []p = new Point[N];

        // converting 2D array input to point array
        for (int i = 0; i < N; i++)
            p[i] = new Point(points[i][0],points[i][1]);

        return findOptimumCostUtil(p, N, l);
    }

    public static void main(String[] args) {
        Line l = new Line(1, -1, -3);
        int[][] points = {{-3, -2}, {-1, 0}, {-1, 2}, {1, 2}, {3, 4}};
        System.out.println(findOptimumCost(points, l));
    }

}
