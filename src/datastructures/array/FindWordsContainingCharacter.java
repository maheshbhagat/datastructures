package datastructures.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindWordsContainingCharacter {

    public List<Integer> findWordsContaining(String[] words, char x) {

        //List<Integer> count = new ArrayList();
        /*for(int i = 0; i< words.length ;i++){
            if(words[i].indexOf(x)>=0){
                count.add(i);
            }
        }*/

        int[] indexes = IntStream.range(0, words.length)
        .filter(index -> words[index].indexOf(x)>=0)
        .toArray();
        List<Integer> count = Arrays.stream(indexes).boxed().collect(Collectors.toList());

        return count;
    }

    public static void main(String[] args) {

        String[] words = {"leet","code"};
        FindWordsContainingCharacter findWordsContainingCharacter = new FindWordsContainingCharacter();
        System.out.println(findWordsContainingCharacter.findWordsContaining(words, 'l'));
    }

}
