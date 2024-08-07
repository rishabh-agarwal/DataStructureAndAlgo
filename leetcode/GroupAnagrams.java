package leetcode;

import java.util.*;


/**
 * Leetcode 49: Group Anagrams
 */

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        //Map for sorted char, index for new list
        Map<String, Integer> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();

        for(String s: strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);

            if(map.containsKey(sortedStr)){
                res.get(map.get(sortedStr)).add(s);
            }else{
                map.put(sortedStr, res.size());
                res.add(new ArrayList<>(Arrays.asList(s)));
            }
        }

        return res;
    }
}
