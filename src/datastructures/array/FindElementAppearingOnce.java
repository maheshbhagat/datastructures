import java.util.Map;
import java.util.HashMap;
public class FindElementAppearingOnce {

    public static void main(String[] args) {
        
        int[] array = {1,1,2,3,3,4,4};
        
        System.out.println("bruteSolution :: " + bruteSolution(array));
        System.out.println("betterSolution :: " + betterSolution(array));
        System.out.println("optimalSolution :: " + optimalSolution(array));
    }

    public static int bruteSolution(int[] array){

        int count = 0;
        for(int i = 0; i < array.length ; i++){

            count = 0;
            for(int j = 0; j < array.length ; j++){

                if(array[i] == array[j]){
                    count++;
                }
            }

            if(count == 1){
                return i;
            }
        }

        return -1;
    }

    public static int betterSolution(int[] array){

        Map<Integer, Integer> map = new HashMap<>();
        for(int element : array){
            if(map.get(element) == null){
                map.put(element, 1);
            } else {
                map.put(element, map.get(element) + 1);
            }
        }


        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }

        return -1;
    }

    public static int optimalSolution(int[] array){

        int xor = 0;
        for(int element : array){

            xor = xor ^ element;
        }

        return xor;
    }
}