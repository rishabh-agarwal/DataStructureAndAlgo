package leetcode.SlidingWindow;

public class BestTimeToBuyAndSellStockII {

    public static int maxProfit(int[] prices) {
        int buy = 0;
        int maxProfit = 0;

        for(int sell = 1;sell<prices.length; sell++){
            if(prices[buy] < prices[sell]){
                maxProfit += prices[sell] - prices[buy];
            }
            prices[buy] = prices[sell];
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }

}
