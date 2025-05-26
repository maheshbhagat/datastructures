import java.util.Arrays;

public class MaximumConsecutiveOnes {

    public static void main(String[] args) {
        
        int[] array = {1,1,0,1,1,1,0,1,1};

        int count = 0, maximum = 0;

        for(int element : array){
            if(element == 1){
                count++;
                if(count > maximum){
                    maximum = count;
                }
            } else {
                count = 0;
            }
        }

        System.out.println(maximum);
    }
}