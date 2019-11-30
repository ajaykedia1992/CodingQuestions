package Facebook;

import java.util.ArrayList;
import java.util.List;

public class AreaOfIslands
{
    public static void main(String args[]){
        int[][] island = {
                {0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,1}
        };

        AreaOfIslands i = new AreaOfIslands();
        List<Integer> areas = i.getAreas(island);
        System.out.println(areas);
    }

    private List<Integer> getAreas(int[][] island)
    {
        List<Integer> areas = new ArrayList<>();
        if(island == null){
            return areas;
        }

        for(int i = 0 ; i < island.length; i++){
            for(int j = 0; j < island[0].length; j++){
                if(island[i][j] == 1){
                    int count = getAreasUtil(island, i, j);
                    areas.add(count);
                }
            }
        }
        return areas;
    }

    private boolean checkBoundary(int[][] islands, int i, int j){
        if(i < 0 || i >= islands.length || j < 0 || j >= islands[0].length || islands[i][j] == 0){
            return false;
        }
        return true;
    }

    private int getAreasUtil(int[][] island, int i, int j)
    {
        int count = 1;
        island[i][j] = 0;
        if(checkBoundary(island, i + 1, j)){
            count += getAreasUtil(island, i + 1, j);
        }
        if(checkBoundary(island, i - 1, j)){
            count += getAreasUtil(island, i - 1, j);
        }
        if(checkBoundary(island, i, j + 1)){
            count += getAreasUtil(island, i, j + 1);
        }
        if(checkBoundary(island, i, j - 1)){
            count += getAreasUtil(island, i, j - 1);
        }
        return count;
    }
}
