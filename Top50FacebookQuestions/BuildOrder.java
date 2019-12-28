/*
   1------
  /        \
0           ---3 --- 4
  \        /
   2------

 */

package Top50FacebookQuestions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BuildOrder
{
    public static void main(String args[]){
        int[][] build = {
                {},
                {0},
                {0},
                {1, 2},
                {3}
        };
        BuildOrder b = new BuildOrder();
        List<Integer> res = b.buildOrder(build);
        System.out.println(res);
    }

    private List<Integer> buildOrder(int[][] build)
    {
        List<Integer> res = new ArrayList<>();
        if(build == null || build.length == 0) return res;
        Set<Integer> temporary = new HashSet<>();
        Set<Integer> permanent = new HashSet<>();

        for(int i = 0; i < build.length; i++){
            if(!permanent.contains(i)){
                visit(i, permanent, temporary, res, build);
            }
        }

        return res;
    }

    private void visit(int i, Set<Integer> permanent, Set<Integer> temporary, List<Integer> res, int[][] build)
    {
        if(temporary.contains(i)){
            throw new RuntimeException();
        }
        if(!permanent.contains(i)){
            temporary.add(i);
            for(int b : build[i]){
                visit(b, permanent, temporary, res, build);
            }
            permanent.add(i);
            temporary.remove(i);
            res.add(i);
        }
    }
}
