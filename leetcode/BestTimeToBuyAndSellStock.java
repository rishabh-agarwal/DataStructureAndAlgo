package leetcode;

public class BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices) {
        int buy = 0;
        int maxProfit = 0;

        for(int sell=1; sell<prices.length; sell++){
            if(prices[sell]<prices[buy]){
                prices[buy] = prices[sell];
            }else{
                maxProfit += Math.max(maxProfit,prices[sell]-prices[buy]);
            }
        }
        return maxProfit;
    }

    /*
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int currentProfit = 0;

        for(int buyDate=0; buyDate<prices.length; buyDate++){
            for(int sellDate=buyDate+1; sellDate<prices.length; sellDate++){
                currentProfit = prices[sellDate]-prices[buyDate];
                if(currentProfit>maxProfit)
                    maxProfit = currentProfit;
            }
        }
        return maxProfit;
    }*/


    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1,2}));
    }

}
