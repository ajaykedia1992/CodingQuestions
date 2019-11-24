package Leetcode;

public class ImageRotation
{
    public static void main(String args[]){
        int[][] image = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        ImageRotation imageRotation = new ImageRotation();
        imageRotation.doImageRotation(image);
        for(int i = 0; i < image.length; i++){
            for(int j = 0; j < image[0].length; j++){
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
     }

    private void doImageRotation(int[][] image)
    {
        if(image == null || image.length == 0 || image[0].length == 0){
            return;
        }


    }

}
