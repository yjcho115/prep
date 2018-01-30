
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author youngjucho
 */
public class RemoveDuplicates {

    public int[] removeDuplicates(final int[] values) {
        if (values == null || values.length == 0) {
            throw new InvalidParameterException("Invalid parameter");
        }

        if (values.length == 1) {
            return values;
        }

        int i = 0;
        for (int j = 1; j < values.length; j++) {
            if (values[i] != values[j]) {
                i++;
                values[i] = values[j];
            }
        }

        while (i < values.length) {
            values[i++] = 0;
        }
        return values;
    }
    
    public List<Integer> deleteDuplicates(List<Integer> values) {
        if (values == null || values.size() == 0) {
            throw new InvalidParameterException("Invalid parameter");
        }

        if (values.size() == 1) {
            return values;
        }
        List<Integer> result = new LinkedList<>();
        Iterator iterator = values.iterator();
        
        while (iterator.hasNext())
        {
            Integer value = (Integer)iterator.next();
            if(!result.contains(value)) 
                result.add(value);
        }
        return result;
    }
    
    public static void main(String[] args) {
        RemoveDuplicates r = new RemoveDuplicates();
        int[] values = {1, 2, 3, 3, 3, 4, 4, 10, 13, 15, 15, 17};
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);
        list.add(4);
        list.add(10);
        list.add(13);
        list.add(15);
        list.add(15);
        list.add(17);
        System.out.println(Arrays.toString(r.removeDuplicates(values)));
        System.out.println(r.deleteDuplicates(list));
    }

}
