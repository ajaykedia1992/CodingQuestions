package Glider.io;

public class MakePalindrome
{
    public static void main(String args[]){
        int N = 4;
        int[] arr = {11, 14, 15, 99};
        int operations = MakePalindrome.solution(N, arr);
        System.out.println(operations);
    }

    private static int solution(int N, int[] arr)
    {
        int[][] matrix = new int[N][N];
        for(int i = 0; i < N; i++){
            matrix[i][i] = 0;
        }

        int step = 1;
        while(step < N){
            int i = 0;
            int j = step;
            while(j < N){
                if(arr[i] == arr[j]){
                    matrix[i][j] = matrix[i + 1][j - 1];
                }
                else{
                    matrix[i][j] = Math.min(matrix[i][j - 1], matrix[i + 1][j]) + 1;
                }
                i++;
                j++;
            }
            step++;
        }

        return matrix[0][N - 1];
    }

    static int solution1(int N, int[] arr){
        int ans = 0;
        int i = 0;
        int j = N - 1;
        while(i < j){
            if(arr[i] == arr[j]){
                i++; j--;
            }else if(arr[i] > arr[j]){
                j--;
                arr[j] += arr[j  + 1];
                ans++;
            }else{
                i++;
                arr[i] += arr[i - 1];
                ans++;
            }
        }

        return ans;
    }
}
