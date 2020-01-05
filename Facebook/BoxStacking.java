package Facebook;

import java.util.Arrays;

public class BoxStacking
{
    public static void main(String args[]){
        int[][] boxes = {
                {3, 2, 5},
                {1, 2, 4}
        };
        BoxStacking b = new BoxStacking();
        int maxHeight = b.getMaxHeight(boxes);
        System.out.println(maxHeight);
    }

    private int getMaxHeight(int[][] boxes)
    {
        if(boxes == null || boxes.length == 0){
            return 0;
        }
        int[][] allBoxes = getAllRotation(boxes);

        for(int[] a : allBoxes){
            System.out.println(Arrays.toString(a));
        }
        int res[] = new int[allBoxes.length];
        int index[] = new int[allBoxes.length];
        for(int i = 0; i < allBoxes.length; i++){
            res[i] = allBoxes[i][2];
            index[i] = i;
        }

        return getMaxHeight(allBoxes, res);
    }

    private int getMaxHeight(int[][] allBoxes, int[] res)
    {
        int maxValue = Integer.MIN_VALUE;
        for(int i = 1; i < allBoxes.length; i++){
            for(int j = 0; j < i; j++){
                if(allBoxes[i][0] < allBoxes[j][0] && allBoxes[i][1] < allBoxes[j][1]){
                    res[i] = Math.max(res[i], res[j] + allBoxes[i][2]);
                    maxValue = Math.max(maxValue, res[i]);
                }
            }
        }
        System.out.println(Arrays.toString(res));
        return maxValue;
    }

    private int[][] getAllRotation(int[][] boxes)
    {
        int[][] all = new int[boxes.length * 3][];
        int index = 0;
        for(int[] b : boxes){
            all[index++] = checkValues(b[2], b[1], b[0]);
            all[index++] = checkValues(b[0], b[2], b[1]);
            all[index++] = checkValues(b[1], b[0], b[2]);
        }
        Arrays.sort(all, ((a, b) -> -1 * (a[0] * a[1] - b[0] * b[1])));
        return all;
    }

    private int[] checkValues(int a, int b, int c)
    {
        int[] box = new int[3];
        box[2] = c;
        if(a > b){
            box[0] = a;
            box[1] = b;
        }else{
            box[0] = b;
            box[1] = a;
        }
        return box;
    }
}
