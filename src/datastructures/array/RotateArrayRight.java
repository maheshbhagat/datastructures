package datastructures.array;

import java.util.Arrays;

public class RotateArrayRight {

    public void rotate(int[] nums, int k) {

        int length = nums.length;

        for(int j = 0; j < k ; j++ ){
            int temp = nums[length-1];
            for(int i = length-2; i >= 0 ; i-- ){
                nums[i+1] = nums[i];
            }
            nums[0] = temp;
        }

    }

    public void rotateWithExtraArray(int[] nums, int k){

        int length = nums.length;

        int[] extra = new int[length-k];

        for (int i = 0; i < length-k; i++) {
            extra[i] = nums[i];
        }

        for (int i = length-k; i < length ; i++) {
            nums[k+i-length] = nums[i];
        }

        for (int i = k; i < length ; i++) {
            nums[i] = extra[i-k];
        }

    }

    public static void main(String[] args) {

        RotateArrayRight rotateArrayRight = new RotateArrayRight();

        int nums[] = new int[]{1,2,3,4,5,6,7};
        int k = 3;
        //rotateArrayRight.rotate(nums, k);
        rotateArrayRight.rotateWithExtraArray(nums, k);

        Arrays.stream(nums).forEach(System.out::print);
    }
}
