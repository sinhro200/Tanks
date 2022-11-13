package com.example.tanks.Utils;

public class IntersectionService {

    public static boolean hasIntersection(
            double x1, double y1,double w1,double h1,
            double x2, double y2,double w2,double h2
    ){
        if (x1+w1 < x2 || x1 > x2+w2)
            return false;
        if (y1 + h1 < y2 || y1 > y2 + h2)
            return false;
        return true;
    }
}
