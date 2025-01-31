package algorithms.bigonotation;

import java.util.List;

public class BigONotationTest {

    public boolean example(List<Integer> list1, List<Integer> list2){
        int size = list1.size();
        int size2 = list2.size();

        for(int i=0; i<size; i++){
            for(int j=0; j<size2; j++){
                if(list1.get(i) == list2.get(j)){
                    return true;
                }
            }
        }
        return false;
    }
}