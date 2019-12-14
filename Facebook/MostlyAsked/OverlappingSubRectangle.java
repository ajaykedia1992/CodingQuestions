/*
finding the area of the overlap between two rectangles.
input : Point of the rectangle, top right and bottom left
output : Overlapping Areas
URL : https://www.youtube.com/watch?v=zGv3hOORxh0
 */

package Facebook.MostlyAsked;

class Points{
    int x;
    int y;
    Points(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class OverlappingSubRectangle
{
    public static void main(String args[]){

        Points firstBL = new Points(2, 1);
        Points firstTR = new Points(5, 5);
        Points secondBL = new Points(3, 2);
        Points secondTR = new Points(5, 7);

        OverlappingSubRectangle o = new OverlappingSubRectangle();
        int[] res = new int[1];
        boolean isOverlap = o.getDistance(firstBL, firstTR, secondBL, secondTR, res);
        if(isOverlap){
            System.out.print(res[0]);
        }else{
            System.out.print("area doesn't overlap");
        }
    }

    private boolean getDistance(Points firstBL, Points firstTR, Points secondBL, Points secondTR, int[] res)
    {
        int yDist = distance(firstBL.y, secondBL.y, firstTR.y, secondTR.y);
        if(yDist < 0) return false;
        int xDist = distance(firstBL.x, secondBL.x, firstTR.x, secondTR.x);
        if(xDist < 0) return false;

        res[0] = xDist * yDist;

        return true;
    }

    private int distance(int b1rxy, int b2rxy, int t1rxy, int t2rxy){
        int max = Math.max(b1rxy, b2rxy);
        int min = Math.min(t1rxy, t2rxy);
        return min - max;
    }
}
