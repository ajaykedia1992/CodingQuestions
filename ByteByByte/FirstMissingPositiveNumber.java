package ByteByByte;

public class FirstMissingPositiveNumber
{
    public static void main(String args[]){
        int[] arr = {-3, 3, 2, 4, 1};
        int number = FirstMissingPositiveNumber.findFirstMissingPositiveNumber(arr, arr.length);
        System.out.println(number);
    }

    private static int findFirstMissingPositiveNumber(int[] arr, int length)
    {
        if(arr == null || arr.length == 0){
            throw new IllegalArgumentException();
        }

        if(arr.length == 1){
            return 2;
        }
        boolean isOnePresent = false;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 1){
                isOnePresent |= true;
            }
        }

        if(!isOnePresent){
            return 1;
        }

        for(int i = 0; i< arr.length; i++){
            if(arr[i] <= 0 || arr[i] > arr.length){
                arr[i] = 1;
            }
        }

        for(int i = 0; i < arr.length; i++){
            int temp = Math.abs(arr[i]);

            if(temp >= arr.length){
                arr[0] = -1 * Math.abs(arr[0]);
            }
            else{
                arr[temp] = -1 * Math.abs(arr[temp]);
            }
        }

        for(int i = 1; i < arr.length; i++){
            if(arr[i] > 0 ){
                return i;
            }
        }

        if(arr[0] > 0){
            return arr.length;
        }

        return arr.length + 1;
    }
}
