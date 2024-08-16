package leetcode;

import java.util.Arrays;

/**
 * Leetcode: 2005
 */
public class PlatesBetweenCandles {
    public static int[] platesBetweenCandles(String s, int[][] queries) {
        int n = queries.length;
        int [] result = new int[n];
        char[] charArr = s.toCharArray();


        for(int q=0; q<queries.length; q++){
            int startIndex = queries[q][0];
            int endIndex = queries[q][1];

            int [] index = findFirstandLastPlate(startIndex, endIndex, charArr);

            if (index[0] == -1 || index[1] == -1 || index[0] >= index[1]) {
                result[q] = 0;
                continue;
            }

            int candle = 0;
            for(int i=index[0]+1; i<index[1]; i++){
                if(charArr[i]=='*'){
                    candle++;
                }
            }
            result[q] = candle;
        }

        return result;
    }

    public static int[] findFirstandLastPlate(int start, int end, char[] arr){
        int[] result = new int[2];
        Arrays.fill(result, -1);
        while(start<end){
            if(arr[start] == '|' && result[0]==-1)
                result[0]=start;
            else
                start++;

            if(arr[end] == '|' && result[1]==-1)
                result[1]=end;
            else
                end--;
        }
        return  result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(platesBetweenCandles("**|**|***|", new int[][]{{2,5},{5,9}})));
        System.out.println(Arrays.toString(platesBetweenCandles("***|**|*****|**||**|*", new int[][]{{1,17},{4,5},{14,17},{5,11},{15,16}})));
    }
}

// * * * | * * | * * *  *   *   |   *   *   |   |   *   *   |   *
// 0 1 2 3 4 5 6 7 8 9  10  11  12  13  14  15  16  17  18  19  20