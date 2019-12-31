package Top50FacebookQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunction
{

    public static void main(String args[]){
        List<String> logs = new ArrayList<>(Arrays.asList("0:start:0","1:start:2","1:end:5","0:end:6"));
        int n = 2;
        ExclusiveTimeOfFunction e = new ExclusiveTimeOfFunction();
        System.out.println(Arrays.toString(e.exclusiveTime(n, logs)));
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        if(logs == null || logs.size() == 0)   return new int[]{};

        Stack<Integer> process = new Stack<>();

        String[] split = logs.get(0).split(":");
        int processId = Integer.parseInt(split[0]);
        int prev = Integer.parseInt(split[2]);
        process.push(processId);
        for(int i = 1; i < logs.size(); i++){
            String[] nextSplit = logs.get(i).split(":");
            int currentProcessId = Integer.parseInt(nextSplit[0]);
            int current = Integer.parseInt(nextSplit[2]);

            if(nextSplit[1].equals("start")){
                if(!process.isEmpty()){
                    res[process.peek()] += current - prev;
                }
                prev = current;
                process.push(currentProcessId);
            }else{
                res[process.pop()] += current - prev + 1;
                prev = current + 1;
            }
        }
        return res;
    }
}
