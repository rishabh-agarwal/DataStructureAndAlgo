package leetcode;

/**
 * LeetCode: 2586
 */
public class CountTheNumberOfVowelInRange {
    public int vowelStrings(String[] words, int left, int right) {
        int count = 0;

        //Loop from left index to right index
        for(int i = left;i <= right;i++)
        {
            String s = words[i]; //grabing one word from array
            char firstChar = s.charAt(0); //grabbing first character of the index
            char lastChar = s.charAt(s.length()-1); ////grabbing last character of the index

            if(isVowel(firstChar) && isVowel(lastChar))
            {
                count++;
            }
        }
        return count;
    }

    public boolean isVowel(char c){
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c== 'u')
            return true;
        else
            return false;
    }
}
