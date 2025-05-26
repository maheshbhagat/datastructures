import java.util.Arrays;
import java.util.stream.*;

public class FindMissingNumberInArray{

    public static void main(String args[]){

        int n = 5;
        int[] array = {1,2,4,5};

        System.out.println("bruteSolution :: "+bruteSolution(n, array));
        System.out.println("betterSolution :: "+betterSolution(n, array));
        System.out.println("optimalSolution :: "+optimalSolution(n, array));
    }

    public static int bruteSolution(int n, int[] array){

        int flag = 0;

        for(int i = 1 ; i <= n ; i++){

            flag = 0;
            for(int element : array){
                if(element == i){
                    flag = 1;
                    break;
                }
            }

            if(flag == 0){
                return i;
            }
        }
        return -1;
    }

    public static int betterSolution(int n, int[] array){

        int totalSum = 0, actualSum = 0;

        for(int i = 1; i <= n ; i++){

            totalSum = totalSum + i;
        }

        for(int element : array){

            actualSum = actualSum + element;
        }

        return totalSum - actualSum;
    }

    public static int optimalSolution(int n, int[] array){

        int xor1 = 0, xor2 = 0;
        for(int i = 1; i <= n ; i++){
            xor1 = xor1 ^ i;
        }

        for(int element : array){
            xor2 = xor2 ^ element;
        }

        return xor1 ^ xor2;
    }
}